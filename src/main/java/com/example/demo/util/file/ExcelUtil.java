package com.example.demo.util.file;


import com.example.demo.entity.student.Student;
import com.example.demo.util.enums.FileEnum;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: nie
 * @Description:
 * @Date: 15:14 2020/5/20
 */
public class ExcelUtil {
    public static String downloadExcel(HttpServletResponse response, String fileName, HSSFWorkbook data) {
        // 告诉浏览器用什么软件可以打开此文件
//        try{
//            response.setHeader("content-Type", "application/vnd.ms-excel");
//            // 下载文件的默认名称
//            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
//            OutputStream out = response.getOutputStream();
//            data.write(out);
//        }catch (Exception e){
//            e.printStackTrace();
//            return "fail";
//        }
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        OutputStream out = null;
        try {

            //封装响应的输出流，用于向客户端输出Excel文件
            out = response.getOutputStream();
            data.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    public static String exportExcel(HashMap<String, HashMap> hashMap, String name, int width) {
        HSSFWorkbook workbook = getHSSFWork(hashMap, name, width);
        //        String path = FileEnum.PATH_WEB.getMsg();
        String path = FileEnum.PATH_LOCAL.getMsg();
        try{
            FileOutputStream outputStream = new FileOutputStream(path + name);
            workbook.write(outputStream);
            outputStream.flush();
            return "success";
        }catch(NullPointerException e){
            e.printStackTrace();
            return "NullPointerException";
        }catch(
                IOException e)

        {
            e.printStackTrace();
            return "IOException";
        }catch(
                Exception e)

        {
            e.printStackTrace();
            return "otherException";
        }

    }
    public static HSSFWorkbook getHSSFWork(HashMap<String,HashMap> hashMap,String name,int width){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet ;
        HSSFRow row;
        HSSFCell cell;
//        String path = FileEnum.PATH_WEB.getMsg();
        String path = FileEnum.PATH_LOCAL.getMsg();
        HashMap<Integer,String> nameHash = hashMap.get("name");
        HashMap<Integer,HashMap> sheetHash = hashMap.get("sheet");
        HashMap<Integer,HashMap> rowHash;
        HashMap cellHash;
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setFontName("黑体");
        cellStyle.setAlignment(HorizontalAlignment.JUSTIFY);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setFont(font);
        try{
            for (int i = 0; i < nameHash.size(); i++) {
                sheet = workbook.createSheet(nameHash.get(i));
                rowHash = sheetHash.get(i);
                for (int j = 0; j < rowHash.size(); j++) {
                    row = sheet.createRow(j);
                    row.setHeightInPoints(12);
                    cellHash = rowHash.get(j);
//                    if (j == 1) {
//                        font.setBold(false);
//                        cellStyle.setFont(font);
//                    }
                    for (int k = 0; k < cellHash.size(); k++) {
                        sheet.setColumnWidth(k,width*256);
                        cell = row.createCell(k);
                        cell.setCellValue(cellHash.get(k).toString());
                        cell.setCellStyle(cellStyle);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();

    }
        return workbook;
//        for (int i = 0; i < ((HashMap)hashMap.get("sheetName")).size(); i++) {
//            sheets.add(workbook.createSheet((String)((HashMap)hashMap.get("sheetName")).get(i)));
//            for (int j = 0; j < ((HashMap)hashMap.get("sheet")).size(); j++) {
//                rows.add(sheets.get(i).createRow(j));
//                for (int k = 0; k <((HashMap)((HashMap)hashMap.get("sheet")).get(j)).size(); k++) {
//                    cells.add(rows.get(j).createCell(k));
//                    cells.get(k).setCellValue((String)((HashMap)((HashMap)hashMap.get("sheet")).get(j)).get(k));
//                }
//
//            }
//        }
//
//        HSSFSheet sheet = workbook.createSheet((String)hashMap.get("name_1"));
//        HSSFRow row = sheet.createRow(1);
//        HSSFCell cell = row.createCell(1);
//        cell.setCellValue("test1");
    }

    public static List<Student> readExcel(String inputFilePath) throws IOException {
        FileInputStream fileInput = new FileInputStream(inputFilePath);//创建文件输入流
        HSSFWorkbook wb = new HSSFWorkbook(fileInput);//由输入流文件得到工作簿对象
        HSSFSheet sheet = wb.getSheetAt(0);//获取第一个sheet
        int lastRowNum = sheet.getLastRowNum(); //获取表格内容的最后一行的行数
        List<Student> students = new ArrayList<>();
        Student student  ;
        //rowBegin代表要开始读取的行号，下面这个循环的作用是读取每一行内容
        for (int i = 1; i <= lastRowNum; ++i) {
            student = new Student();
            HSSFRow row = sheet.getRow(i);//获取每一行
            int columnNum = row.getLastCellNum();//获取每一行的最后一列的列号，即总列数
            for (int j=0; j<columnNum; ++j) {
//                //获取每个单元格
//                switch(j){
//                    case 0:
//                        student.setUid(Integer.parseInt(row.getCell(j).toString()));
//                        break;
//                    case 1:
//                        student.setUname(row.getCell(j).toString());
//                        break;
//                    case 2:
//                        student.setPhone(row.getCell(j).toString());
//                        break;
//                    case 3:
//                        student.setEmail(row.getCell(j).toString());
//                        break;
//                    case 4:
//                        student.setUclass(row.getCell(j).toString());
//                        break;
//                }
                System.out.println(row.getCell(j).toString());
//                if (j == 0) {
//                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                    System.out.printf("%s\t", format.format(cell.getDateCellValue()));
//                } else if (CellType.NUMERIC.equals(cell.getCellTypeEnum())) {
//                    System.out.printf("%.0f\t", cell.getNumericCellValue());
//                } else {
//                    System.out.printf("%s\t", cell.getStringCellValue());
//                }
                students.add(student);
            }
        }
        wb.close();
        fileInput.close();
        return students;
    }

}