package com.exam.quiz_service.bean;

import java.util.List;

public class QuizBean {
	
	Integer quizId;
	String category;
	List<Integer> questionIds;
	
	@Override
	public String toString() {
		return "QuizBean [quizId=" + quizId + ", category=" + category + ", questionIds=" + questionIds + "]";
	}
	public Integer getQuizId() {
		return quizId;
	}
	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Integer> getQuestionIds() {
		return questionIds;
	}
	public void setQuestionIds(List<Integer> questionIds) {
		this.questionIds = questionIds;
	}
	
	
}
