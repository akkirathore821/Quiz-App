package com.exam.quiz_service.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exam.quiz_service.bean.QuestionWrapper;
import com.exam.quiz_service.bean.QuizBean;
import com.exam.quiz_service.bean.ResponseBean;
import com.exam.quiz_service.dao.QuizDAOWrapper;
import com.exam.quiz_service.feign.QuizFeignInteface;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	QuizDAOWrapper quizDAOWrapper;
	
	@Autowired
	QuizFeignInteface feignInteface;

	@Override
	public ResponseEntity<QuizBean> createQuiz(String category) {
		try {
			
			List<Integer> questionIds = feignInteface.getQustionToGenerateQuiz(category).getBody();
			
			QuizBean quizBean = new QuizBean();
			quizBean.setCategory(category);
			quizBean.setQuestionIds(questionIds);
			quizBean = quizDAOWrapper.addQuiz(quizBean);
					
			return new ResponseEntity<>(quizBean,HttpStatus.CREATED);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new QuizBean(),HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer quizId) {

		try {
			
			List<Integer> questionIds = quizDAOWrapper.getQuiz(quizId);
			
			List<QuestionWrapper> questionWrappers = feignInteface.getQustionForQuiz(questionIds).getBody();
					
			return new ResponseEntity<>(questionWrappers,HttpStatus.CREATED);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Integer> calculateResult(List<ResponseBean> responses) {

		try {
			Integer score = feignInteface.calculateScore(responses).getBody();
			System.out.println(score+"====================================================================================" );
			
				
			return new ResponseEntity<>(score,HttpStatus.CREATED);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(-1,HttpStatus.BAD_REQUEST);
	}
	
	
}
