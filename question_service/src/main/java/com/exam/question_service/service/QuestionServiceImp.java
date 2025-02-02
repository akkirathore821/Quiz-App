package com.exam.question_service.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exam.question_service.bean.QuestionBean;
import com.exam.question_service.bean.QuestionWrapper;
import com.exam.question_service.bean.ResponseBean;
import com.exam.question_service.dao.QuestionDAOWrapper;
import com.exam.question_service.entity.QuestionEntity;


@Service
public class QuestionServiceImp implements QuestionService {
	
	@Autowired
	QuestionDAOWrapper daoWrapper;

	@Override
	public ResponseEntity<List<QuestionBean>> getAllQuestions() {
		try {
			return new ResponseEntity<>(daoWrapper.getAllQuestions(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}
	
	@Override
	public ResponseEntity<List<QuestionBean>> getByCategory(String category) {
		try {
			return new ResponseEntity<>(daoWrapper.getByCategory(category),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<QuestionBean> addQuestion(QuestionBean bean) {
		try {
			return new ResponseEntity<>(daoWrapper.addQuestion(bean),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<Integer>> getQustionToGenerateQuiz(String category) {
		try {
			return new ResponseEntity<>(daoWrapper.getRandomQuestionForQuizByCategory(category),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<QuestionWrapper>> getQustionForQuiz(List<Integer> quesIds) {
		try {
			List<QuestionBean> beans = daoWrapper.getQuestionsForQuizByIds(quesIds);
			List<QuestionWrapper> wrapper = new ArrayList<>();
			
			for(QuestionBean bean : beans)
				wrapper.add(convertQuestionBeanToWrapper(bean));
			
			return new ResponseEntity<>(wrapper,HttpStatus.OK);				
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Integer> calculateScore(List<ResponseBean> responses) {
		try {
			List<Integer> ids = new ArrayList<>();
			HashMap<Integer,String> map = new HashMap<>();
			for(ResponseBean resp : responses) {
				map.put(resp.getQuestionId(), resp.getResponse());
				ids.add(resp.getQuestionId());
			}
			
			List<QuestionBean> beans = daoWrapper.getQuestionsForQuizByIds(ids);
			
			int score = 0;
			
			for(QuestionBean bean : beans)
				if(bean.getCorrect().equals(map.get(bean.getQuestionId())))
					score++;
			
			return new ResponseEntity<>(score,HttpStatus.OK);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}

	
	
	
	
	
	
	private QuestionWrapper convertQuestionBeanToWrapper(QuestionBean bean) {
		// TODO Auto-generated method stub
		QuestionWrapper wrapper = new QuestionWrapper();
		try {
			BeanUtils.copyProperties(bean, wrapper);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return wrapper;
	}
	

}
