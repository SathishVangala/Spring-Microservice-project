package com.project.quizapp.service;

import com.project.quizapp.model.Question;
import com.project.quizapp.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuizQuestionService {

    @Autowired
     private QuestionsRepository questionsRepository;
    public List<Question> getAllQuestions() {
      return  questionsRepository.findAll();

    }



    public void addQuestion(Question question) {
        questionsRepository.save(question);
    }
}
