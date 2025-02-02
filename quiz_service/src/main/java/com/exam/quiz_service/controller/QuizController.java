package com.exam.quiz_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.quiz_service.bean.QuestionWrapper;
import com.exam.quiz_service.bean.QuizBean;
import com.exam.quiz_service.bean.ResponseBean;
import com.exam.quiz_service.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@PostMapping("create/{category}")
	public ResponseEntity<QuizBean> createQuiz(@PathVariable String category){
		return quizService.createQuiz(category);
	}
	@GetMapping("get/{quizId}")
	public ResponseEntity<List<QuestionWrapper>> getByCategory(@PathVariable Integer quizId){
		return quizService.getQuiz(quizId);
	}
	@PostMapping("submit")
	public ResponseEntity<Integer> submit( @RequestBody List<ResponseBean> responses){
		return quizService.calculateResult(responses); 
	}

}
