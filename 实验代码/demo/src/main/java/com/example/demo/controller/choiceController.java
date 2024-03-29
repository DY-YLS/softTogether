package com.example.demo.controller;

import com.example.demo.entity.answerChoice;
import com.example.demo.entity.choicequestion;
import com.example.demo.entity.course;
import com.example.demo.service.choiceAnswerService;
import com.example.demo.service.choiceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/choice")
public class choiceController {
    @Autowired
    @Qualifier("choiceQuestion")
    private com.example.demo.service.choiceQuestionService choiceQuestionService;

    @Autowired
    @Qualifier("choiceAnswer")
    private choiceAnswerService choiceAnswerService;

    @RequestMapping("/add")
    public int add(choicequestion choicequestion){
       int i=choiceQuestionService.insert(choicequestion);
        return i;
    }
    @RequestMapping("/queryQuestion")
    public Map<String,Object> queryQuestion(choicequestion choicequestion){
        Map map=new HashMap<String,Object>();
        List<answerChoice> questionList= choiceQuestionService.queryByClass(choicequestion);
        map.put("questionList",questionList);
        return map;
    }

    @RequestMapping("/queryAnswer")
    public Map<String,Object> queryAnswer(answerChoice answerChoice){
        Map map=new HashMap<String,Object>();
        List<answerChoice> answerList= choiceAnswerService.queryByStudent(answerChoice);
        map.put("answerList",answerList);
        return map;
    }


}
