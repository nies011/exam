package com.example.demo.util.excel;


import com.example.demo.util.enums.ExcelEnum;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;

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
        return "success";
    }

    public static String exportExcel(HashMap<String,HashMap> hashMap,String name,int width){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet ;
        HSSFRow row;
        HSSFCell cell;
//        String path = ExcelEnum.EXCEL_PATH_WEB.getMsg();
        String path = ExcelEnum.PATH_LOCAL.getMsg();
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
            FileOutputStream outputStream = new FileOutputStream(path+"/"+name);
            workbook.write(outputStream);
            outputStream.flush();
            return "success";
        }catch (NullPointerException e){
            e.printStackTrace();
            return "NullPointerException";
        }catch (IOException e){
            e.printStackTrace();
            return "IOException";
        }catch (Exception e){
            e.printStackTrace();
            return "otherException";
        }


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
}