package com.exam.quiz_service.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.quiz_service.bean.QuizBean;
import com.exam.quiz_service.entity.QuizEntity;


@Repository
public class QuizDAOWrapper {
	
	@Autowired
	QuizDAO dao;

	public QuizBean addQuiz(QuizBean quizBean) {

		QuizEntity entity = new QuizEntity();
		
		BeanUtils.copyProperties(quizBean, entity);
		entity = dao.save(entity);
		BeanUtils.copyProperties(entity, quizBean);
		
		return quizBean;
		
	}

	public List<Integer> getQuiz(Integer quizId) {

		Optional<QuizEntity> entity = dao.findById(quizId);
		
		return entity.get().getQuestionIds();
	}

}
