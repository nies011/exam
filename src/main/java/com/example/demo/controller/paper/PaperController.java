package com.example.demo.controller.paper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.answerstu.Answerstu;
import com.example.demo.entity.blank.Blank;
import com.example.demo.entity.paper.Paper;
import com.example.demo.entity.question.Question;
import com.example.demo.entity.tests.Tests;
import com.example.demo.service.answerstu.AnswerstuService;
import com.example.demo.service.blank.BlankService;
import com.example.demo.service.paper.PaperService;
import com.example.demo.service.question.QuestionService;
import com.example.demo.service.tests.TestsService;

//import org.apache.log4j.Logger;
import com.example.demo.util.file.TxtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LiuXj
 * @Description: 试卷与考试记录
 * @Date: 15:46 2020/4/26
 */
@CrossOrigin
@RestController
@RequestMapping("paper")
public class PaperController {

    private static Logger logger = LoggerFactory.getLogger(PaperController.class);

    final
    QuestionService questionService;

    final
    BlankService blankService;

    final
    PaperService paperService;

    final
    TestsService testsService;

    final
    AnswerstuService answerstuService;

    public PaperController(QuestionService questionService, BlankService blankService, PaperService paperService, TestsService testsService, AnswerstuService answerstuService) {
        this.questionService = questionService;
        this.blankService = blankService;
        this.paperService = paperService;
        this.testsService = testsService;
        this.answerstuService = answerstuService;
    }

    @RequestMapping("getTest")
    public Tests getTest(Integer getTestId) throws  Exception{
        List<Tests> tests = testsService.listTests();
        for (Tests test:tests
             ) {
            if(test.getTeId().equals(getTestId)){
                return test;
            }
        }
        return null;
    }

    @RequestMapping("getTests")
    public List getTests(Integer getTestsId) throws Exception{
        List<Tests> tests = testsService.listTests();
        List<Tests> testsList = new ArrayList<>();
        for (Tests test:tests
        ) {
            if(test.getPid().equals(getTestsId)){
                testsList.add(test);
            }
        }
        return testsList;
    }
    @RequestMapping("getPaperId")
    public String randomId() throws Exception{
        int id = 0;
        List<Paper> papers = paperService.listPaper();
        for (Paper paper:papers
             ) {
            if (id == 0 || id == paper.getPid()){
                id = (int)(Math.random()*600000+100000);
            }
        }
        return Integer.toString(id);
    }

    @RequestMapping("getPaper")
    public Paper getPaper(Integer getPId) throws Exception{
         List<Paper> paperList = paperService.listPaper();
        for (Paper paper:paperList
             ) {
            if(paper.getPid().equals(getPId))
            {
                paper.setBlankNum(getBlanks(getPId).size());
                paper.setQueNum(getQuestions(getPId).size());
                paper.setSubNum(paper.getBlankNum()+paper.getQueNum());
                return paper;
            }
        }
        return null;
    }

    @RequestMapping("getQuestions")
    public List<Question> getQuestions(Integer getQId) throws Exception{
        List<Question> questionList = questionService.listQuestion();
        List<Question> questions = new ArrayList<>();
        for (Question question:questionList
             ) {
            if(question.getPid().equals(getQId)){
                questions.add(question);
            }
        }
        return questions;
    }

    @RequestMapping("getBlanks")
    public List<Blank> getBlanks(Integer getBId) throws Exception{
        List<Blank> blankList = blankService.listBlank();
        List<Blank> blanks = new ArrayList<>();
        for (Blank blank:blankList
        ) {
            if(blank.getPid().equals(getBId)){
                blanks.add(blank);
            }
        }
        return blanks;
    }

    @RequestMapping("getScore")
    public int getScore(@RequestBody String answerList) throws Exception{
        final String fal = "false";
        final String corr = "true";
        int score = 0;
        List<Answerstu> answers = new ArrayList<>();
        answerList = answerList.split("\\[")[1];
        answerList = answerList.split("]")[0];
        String[] strings = answerList.split("},");
        for (int i = 0; i < strings.length-1; i++) {
            strings[i] = strings[i] + "}";
            answers.add(JSON.parseObject(strings[i],Answerstu.class));
        }
        answers.add(JSON.parseObject(strings[strings.length-1],Answerstu.class));
        List<Question> questions = getQuestions(answers.get(1).getPid());
        List<Blank> blanks = getBlanks(answers.get(1).getPid());
        for (int i = 0;i < answers.size();i++) {
            out:{
            for (int j = 0; j < questions.size(); j++) {
                if (answers.get(i).getQuid().equals(questions.get(j).getQid())) {
                    answers.get(i).setCorrAns(questions.get(j).getAnswer());
                    if (answers.get(i).getSanswer().equals(questions.get(j).getAnswer())) {
                        answers.get(i).setStatement(corr);
                        score += 2;
                        break out;
                    } else {
                        answers.get(i).setStatement(fal);
                    }
                }
            }
            for (int k = 0; k < blanks.size(); k++) {
                if (answers.get(i).getQuid().equals(blanks.get(k).getBid())) {
                    answers.get(i).setCorrAns(blanks.get(k).getAnswer());
                    if (answers.get(i).getSanswer().equals(blanks.get(k).getAnswer())) {
                        answers.get(i).setStatement(corr);
                        score += 5;
                        break out;
                    } else {
                        answers.get(i).setStatement(fal);
                    }

                }
            }
        }
          answerstuService.addAnswerstu(answers.get(i));
        }

        return score;
    }
    @RequestMapping("listPaper")
    public List<Paper> listPaper() throws Exception{
        return paperService.listPaper();

    }

    @RequestMapping("addPaper")
    public boolean addPaper(@RequestBody String aPaper)throws Exception{
        return paperService.addPaper(JSON.parseObject(aPaper,Paper.class));

    }

    @RequestMapping("deletePaper")
    public boolean delPaper(Integer dPid)throws Exception{
        return paperService.delPaper(dPid);
    }


    /**更改试卷名称
     *
     * @param uPid id
     * @param uPaper String
     * @return b
     * @throws Exception null
     */
    @RequestMapping("updatePaper")
    public boolean updatePaName(Integer uPid, @RequestBody String uPaper) throws Exception{
        return paperService.delPaper(uPid)&&paperService.addPaper(JSON.parseObject(uPaper,Paper.class));
    }

    @RequestMapping("searchPaper")
    public List<Paper> searchPaper(String pContain) throws Exception{
        List<Paper> papers = paperService.listPaper();
        List<Paper> paperList = new ArrayList<>();
        for (Paper paper:papers
             ) {
            if(Integer.toString(paper.getPid()).contains(pContain)||Integer.toString(paper.getTid()).contains(pContain)){
                paperList.add(paper);
            }else if(paper.getPname().contains(pContain)||Integer.toString(paper.getPtime()).contains(pContain)){
                paperList.add(paper);
            }else if(paper.getDeadline().toString().contains(pContain)){
                paperList.add(paper);
            }
        }
        return paperList;
    }

    @RequestMapping("listTests")
    public List<Tests> listTests() throws Exception{
        return testsService.listTests();
    }

    /**添加考试记录
     *
     * @param test test
     * @return boolean
     * @throws Exception null
     */
    @RequestMapping("addTests")
    public boolean addTests(@RequestBody String test) throws Exception{
//        System.out.println(test);
//        test = test.split("data:")[1];
//        System.out.println(test);
        Tests tests = JSONObject.parseObject(test,Tests.class);
//        System.out.println(11111);
        //当开始时间和结束时间不为空时，计算考试所用总时长(秒为单位)
//        if(tests.getEndTime()!=null && tests.getStartTime()!=null){
//            Date start = tests.getStartTime();
//            Date end = tests.getEndTime();
//            long time = end.getTime()/1000-start.getTime()/1000;
//            tests.setTime(String.valueOf(time));
//        }
//        System.out.println(tests.getEndTime()+"\\"+tests.getStartTime());

        String start = tests.getStartTime().split(" ")[1];
        System.out.println(start);
        String end = tests.getEndTime().split(" ")[1];
        System.out.println(end);
        String[] starts = start.split(":");
        String[] ends = end.split(":");
        tests.setTime((Integer.parseInt(ends[0])-Integer.parseInt(starts[0]))*60+(Integer.parseInt(ends[1])-Integer.parseInt(starts[1])));
//        System.out.println(Integer.parseInt(ends[0]));
//        System.out.println(Integer.parseInt(ends[1]));
//        System.out.println(Integer.parseInt(starts[0]));
//        System.out.println(Integer.parseInt(starts[1]));
//        System.out.println((Integer.parseInt(ends[0])-Integer.parseInt(starts[1]))*60);
//        System.out.println((Integer.parseInt(ends[0])-Integer.parseInt(starts[1])));
//        System.out.println(tests.getTime());
        return testsService.addTests(tests);


    }

    @RequestMapping("importBlanks")
    public String importBlank(@RequestParam("file") MultipartFile bfile, int pid){
        List<Blank> blanks ;
        try{
            blanks = TxtUtil.importBlank(bfile, pid);
//            System.out.println("1111111111");
            for (Blank blank:blanks
            ) {
//                System.out.println("-----------");
                blankService.addBlank(blank);
            }
        }catch (IOException e){
            e.printStackTrace();
            return "IoException";
        }catch (NullPointerException e){
            e.printStackTrace();
            return "NullPointerException";
        }catch(Exception e){
            e.printStackTrace();
            return "Exception";
        }
        return "success";
    }

    @RequestMapping("importQues")
    public String importQuestion(@RequestParam("file") MultipartFile file, int pid){
        List<Question> questions;
        try{
            questions = TxtUtil.importQuestion(file, pid);
//            System.out.println(questions.get(0));
//            System.out.println("1111111111");
            for (Question question:questions
                 ) {
//                System.out.println("-----------");
                questionService.addQuestion(question);
            }
        }catch (IOException e){
            e.printStackTrace();
            return "IoException";
        }catch (NullPointerException e){
            e.printStackTrace();
            return "NullPointerException";
        }catch(Exception e){
            e.printStackTrace();
            return "Exception";
        }
        return "success";
    }
    /**通过id删除考试记录
     *
     * @param teId id
     * @return boolean
     * @throws Exception null
     */
    @RequestMapping("delTests")
    public boolean delTests(Integer teId) throws Exception{
        return testsService.delTests(teId);

    }

    /**通过id修改考试成绩
     *
     * @param teId id
     * @param score fen
     * @return boolean
     * @throws Exception null
     */
    @RequestMapping("updateScore")
    public boolean updateScore(Integer teId,Integer score) throws Exception{
        return testsService.updateScore(teId,score);
    }
}
