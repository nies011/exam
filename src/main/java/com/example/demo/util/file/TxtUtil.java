package com.example.demo.util.file;

import com.example.demo.entity.blank.Blank;
import com.example.demo.entity.question.Question;
import com.example.demo.util.enums.FileEnum;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: nie
 * @Description:
 * @Date: 16:50 2020/5/29
 */
public class TxtUtil {
        public static List importQuestion(MultipartFile multipartFile, int pid) throws Exception{
        int i = 1;
        List<Question> questions = new ArrayList<>();
        Question question = null;
//        File file =
//            File file = new File(FileEnum.PATH_LOCAL.getMsg()+"questions.txt");
        Scanner in = new Scanner(transport(multipartFile));
//            Scanner in = new Scanner(file);
        while(in.hasNextLine()){
            switch (i%6){
                case 0:
                    question.setAnswer(in.next());
                    question.setPid(pid);
                    questions.add(question);
                    break;
                case 1:
                    question = new Question();
                    question.setContent(in.next());
                    break;
                case 2:
                    question.setAoption(in.next());
                    break;
                case 3:
                    question.setBoption(in.next());
                    break;
                case 4:
                    question.setCoption(in.next());
                    break;
                case 5:
                    question.setDoption(in.next());
                    break;
            }
            i++;
        }

        return questions;
    }
    public static List importBlank(MultipartFile multipartFile, int pid) throws Exception{
        int i = 1;
       List<Blank > blanks = new ArrayList<>();
       Blank blank= null;
//       File file = transport(multipartFile);
//            File file = new File(FileEnum.PATH_LOCAL.getMsg()+"questions.txt");
        Scanner in = new Scanner(transport(multipartFile));
//            Scanner in = new Scanner(file);
        while(in.hasNextLine()){
            switch (i%2){
                case 0:
                    blank.setAnswer(in.next());
                    blank.setPid(pid);
                    blanks.add(blank);
                    break;
                case 1:
                   blank = new Blank();
                    blank.setContent(in.next());
                    break;
            }
            i++;
        }
//        file.delete();
        return blanks;
    }
        public static File transport( MultipartFile multipartFile) throws Exception{
            int n;
            File f;
            // 输出文件的新name
//            System.out.println("getName:"+multiartFile.getName());
            // 输出源文件名称
//            System.out.println("Oriname:"+multipartFile.getOriginalFilename());
            // 创建文件
//            f = new File(FileEnum.PATH_LOCAL.getMsg()+"questions.txt");
            f = new File(FileEnum.PATH_WEB.getMsg()+"questions.txt");
            try (InputStream in  = multipartFile.getInputStream(); OutputStream os = new FileOutputStream(f)){
                // 得到文件流。以文件流的方式输出到新文件
                // 可以使用byte[] ss = multipartFile.getBytes();代替while
                byte[] buffer = new byte[4096];
                while ((n = in.read(buffer,0,4096)) != -1){
//                    System.out.println("8888888888");
                    os.write(buffer,0,n);
                }
//                // 读取文件第一行
//                BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
//                System.out.println(bufferedReader.readLine());
//                // 输出路径
//                bufferedReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            // 输出file的URL
            System.out.println(f.toURI().toURL().toString());
            // 输出文件的绝对路径
            System.out.println(f.getAbsolutePath());
            // 操作完上的文件 需要删除在根目录下生成的文件
            File file = new File(f.toURI());
//            if (file.delete()){
//                System.out.println("删除成功");
//            }else {
//                System.out.println("删除失败");
//
//            }
            return file;
        }
}
