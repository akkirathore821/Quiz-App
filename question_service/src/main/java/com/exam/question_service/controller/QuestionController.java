package com.exam.question_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.question_service.bean.QuestionBean;
import com.exam.question_service.bean.QuestionWrapper;
import com.exam.question_service.bean.ResponseBean;
import com.exam.question_service.service.QuestionService;


@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<QuestionBean>> allQuestions(){
		return questionService.getAllQuestions();
	}
	@GetMapping("getByCategory/{category}")
	public ResponseEntity<List<QuestionBean>> getByCategory(@PathVariable String category){
		return questionService.getByCategory(category);
	}
	@PostMapping("addQuestion")
	public ResponseEntity<QuestionBean> addQuestion(@RequestBody QuestionBean bean){
		return questionService.addQuestion(bean); 
	}
	
	@GetMapping("getQustionToGenerateQuiz/{category}")
	public ResponseEntity<List<Integer>> getQustionToGenerateQuiz(@PathVariable String category){
		return questionService.getQustionToGenerateQuiz(category);
	}
	
	@PostMapping("getQustionForQuiz")
	public ResponseEntity<List<QuestionWrapper>> getQustionForQuiz(@RequestBody List<Integer> quesIds){
		return questionService.getQustionForQuiz(quesIds);
	}
	
	@PostMapping("getScore")
	public ResponseEntity<Integer> calculateScore(@RequestBody List<ResponseBean> responses){
		return questionService.calculateScore(responses);
	}
}
