package com.exam.question_service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.exam.question_service.bean.QuestionBean;
import com.exam.question_service.bean.QuestionWrapper;
import com.exam.question_service.bean.ResponseBean;

public interface QuestionService {

	ResponseEntity<List<QuestionBean>> getAllQuestions();
	ResponseEntity<List<QuestionBean>> getByCategory(String category);
	ResponseEntity<QuestionBean> addQuestion(QuestionBean bean);
	ResponseEntity<List<Integer>> getQustionToGenerateQuiz(String category);
	ResponseEntity<List<QuestionWrapper>> getQustionForQuiz(List<Integer> quesIds);
	ResponseEntity<Integer> calculateScore(List<ResponseBean> responses);

	

}
