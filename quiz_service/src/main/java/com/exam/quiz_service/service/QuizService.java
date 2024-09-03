package com.exam.quiz_service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.exam.quiz_service.bean.QuestionWrapper;
import com.exam.quiz_service.bean.QuizBean;
import com.exam.quiz_service.bean.ResponseBean;

public interface QuizService {
	
	ResponseEntity<QuizBean> createQuiz(String category);

	ResponseEntity<List<QuestionWrapper>> getQuiz(Integer quizId);

	ResponseEntity<Integer> calculateResult(List<ResponseBean> responses);
}
