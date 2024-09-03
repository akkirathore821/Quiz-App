package com.exam.question_service.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.question_service.bean.QuestionBean;
import com.exam.question_service.entity.QuestionEntity;

@Repository
public class QuestionDAOWrapper {
	
	@Autowired
	QuestionDAO dao;
	
	public List<QuestionBean> getAllQuestions() {

		List<QuestionEntity> list = dao.findAll();
		List<QuestionBean> bean = new ArrayList<>();
		
		for(QuestionEntity entity : list) {
			QuestionBean b = new QuestionBean();
			BeanUtils.copyProperties(entity, b);
			bean.add(b);
		}
//		BeanUtils.copyProperties(list, bean);
		return bean;

	}
	
	public List<QuestionBean> getByCategory(String category) {

		List<QuestionEntity> list = dao.findByCategory(category);
		List<QuestionBean> bean = new ArrayList<>();
		
		for(QuestionEntity entity : list) {
			QuestionBean b = new QuestionBean();
			BeanUtils.copyProperties(entity, b);
			bean.add(b);
		}
		return bean;
	}
	
	public QuestionBean addQuestion(QuestionBean bean) {

		QuestionEntity entity = new QuestionEntity();
		BeanUtils.copyProperties(bean, entity);

		entity = dao.save(entity);
		
		BeanUtils.copyProperties(entity, bean);
			
		return bean;
	}

	public List<Integer> getRandomQuestionForQuizByCategory(String category) {

		List<QuestionEntity> entities = dao.findRandomQuestionForQuizByCategory(category);
		List<Integer> list = new ArrayList<>();
		
		for(QuestionEntity entity : entities) {
			list.add(entity.getQuestionId());
		}
		return list;
	}
	
	public List<QuestionBean> getQuestionsForQuizByIds(List<Integer> ids) {
		
		List<QuestionEntity> entities = dao.findAllById(ids);
		List<QuestionBean> beans = new ArrayList<>();
		
		for(QuestionEntity entity : entities) {
			beans.add(convertQuestionEntityToBean(entity));
		}
		return beans;
	}

	private QuestionBean convertQuestionEntityToBean(QuestionEntity questionEntity) {
		// TODO Auto-generated method stub
		QuestionBean bean = new QuestionBean();
		try {
			BeanUtils.copyProperties(questionEntity, bean);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	

}
