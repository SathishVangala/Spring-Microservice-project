package com.project.quizapp.controller;

import com.project.quizapp.model.Question;
import com.project.quizapp.service.QuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class quizController {
    @Autowired
    private QuizQuestionService quizQuestionService;
    @GetMapping("/")
    public List<Question> getQuestions(){
        return quizQuestionService.getAllQuestions();

    }
//    @GetMapping("/{id}")
//    public List<Question> getQuestion(@PathVariable int id){
//        return quizQuestionService.getQuestionById(id);
//    }
    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){
        System.out.println("Received question title: " + question.getQuestionTitle());
        System.out.println(question.getOption1());
        if (question.getQuestionTitle() == null || question.getQuestionTitle().isEmpty()) {
            return "Error: questiontitle cannot be null or empty";
        }

        quizQuestionService.addQuestion(question);
        return "Question added successfully!";

    }
}
