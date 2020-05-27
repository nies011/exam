package com.example.demo.controller.subject;

import com.alibaba.fastjson.JSON;
import com.example.demo.controller.Controller;
import com.example.demo.entity.answerstu.Answer;
import com.example.demo.entity.answerstu.Answerstu;
import com.example.demo.entity.blank.Blank;
import com.example.demo.entity.question.Question;
import com.example.demo.service.answerstu.AnswerstuService;
import com.example.demo.service.blank.BlankService;
import com.example.demo.service.question.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: nie
 * @Description: 题目与答题情况
 * @Date: 13:22 2020/5/10
 */
@CrossOrigin
@RestController
@RequestMapping("subject")
public class SubjectController {

    private static Logger logger = LoggerFactory.getLogger(SubjectController.class);
    final
    QuestionService questionService;

    final
    AnswerstuService answerstuService;

    final
    BlankService blankService;

    public SubjectController(QuestionService questionService, BlankService blankService, AnswerstuService answerstuService) {
        this.questionService = questionService;
        this.blankService = blankService;
        this.answerstuService = answerstuService;
    }

    @RequestMapping("getAnswerStu")
    public List getAnswerStu(Integer getAnsId) throws Exception{
        List<Answerstu> answerstuList = answerstuService.listAnswerstu();
        List<Question> questions = questionService.listQuestion();
        List<Blank> blanks = blankService.listBlank();
        List<Answerstu> answerstus = new ArrayList<>();
        for (Answerstu answerstu:answerstuList
             ) {
            if (answerstu.getPid().equals(getAnsId)){
                for (Question question:questions
                ) {
                    if (answerstu.getQuid().equals(question.getQid())){
                        answerstus.add(answerstu);
                    }
                }
            }
        }
        for (Answerstu answerstu:answerstuList
        ) {
            if (answerstu.getPid().equals(getAnsId)){
                for (Blank blank:blanks
                ) {
                    if (answerstu.getQuid().equals(blank.getBid())){
                        answerstus.add(answerstu);
                    }
                }
            }
        }

        return answerstus;
    }
    @RequestMapping("listAnswerStu")
    public List<Answerstu> listAnswerStu() throws Exception{
        return answerstuService.listAnswerstu();
    }

    @RequestMapping("addAnswerStu")
    public boolean addAnswerStu(Answerstu answerstu) throws Exception{
        return answerstuService.addAnswerstu(answerstu);
    }

    @RequestMapping("deleteAnswer")
    public boolean delAnswerStu(Integer id) throws Exception{
        return answerstuService.delAnswerstu(id);
    }
    @RequestMapping(value = "listBlank")
    public List<Blank> listBlank() throws Exception{
        return blankService.listBlank();
    }

    @RequestMapping("addBlank")
    public boolean addBlank(@RequestBody String aBlank) throws Exception{
        return blankService.addBlank(JSON.parseObject(aBlank, Blank.class));
    }

    @RequestMapping("updateBlank")
    public boolean updateBlank(Integer uBid, @RequestBody String uBlank) throws Exception{
        return blankService.delBlank(uBid)&&blankService.addBlank(JSON.parseObject(uBlank,Blank.class));
    }

    @RequestMapping("searchBlank")
    public List<Blank> searchBlank(String bContain) throws Exception{
        List<Blank> blanks = blankService.listBlank();
        List<Blank> blankList = new ArrayList<>();
        for (Blank blank:blanks
             ) {
            if(Integer.toString(blank.getBid()).contains(bContain)||Integer.toString(blank.getPid()).contains(bContain)){
                blankList.add(blank);
            }else if(blank.getAnswer().contains(bContain)||blank.getContent().contains(bContain)){
                blankList.add(blank);
            }
        }
        return blankList;
    }

    @RequestMapping("delBlank")
    public boolean delBlank(Integer dBid) throws Exception{
        return blankService.delBlank(dBid);

    }

    @RequestMapping("listQues")
    public List<Question> listQuestion() throws Exception{
        return questionService.listQuestion();
    }


    @RequestMapping("addQues")
    public boolean addQuestion(@RequestBody String aQuestion)throws Exception{
        return questionService.addQuestion(JSON.parseObject(aQuestion,Question.class));
    }


    @RequestMapping("deleteQues")
    public boolean delQuestion(Integer dQid) throws Exception{
        return questionService.delQuestion(dQid);
    }


    @RequestMapping("updateQues")
    public boolean updateQuestion(Integer uQid,@RequestBody String uQuestion)throws Exception{
        return questionService.delQuestion(uQid)&&questionService.addQuestion(JSON.parseObject(uQuestion,Question.class));
    }

    @RequestMapping("searchQues")
    public List<Question> searchQuestion(String qContain) throws Exception{
        List<Question> questions = questionService.listQuestion();
        List<Question> questionList = new ArrayList<>();
        for (Question question:questions
             ) {
            if(Integer.toString(question.getPid()).contains(qContain)||Integer.toString(question.getQid()).contains(qContain)){
                questionList.add(question);
            }else if(question.getAnswer().contains(qContain)||question.getContent().contains(qContain)){
                questionList.add(question);
            }else if(question.getAoption().contains(qContain)||question.getBoption().contains(qContain)||question.getCoption().contains(qContain)||question.getDoption().contains(qContain)){
                questionList.add(question);
            }
        }
        return questionList;
    }
}
