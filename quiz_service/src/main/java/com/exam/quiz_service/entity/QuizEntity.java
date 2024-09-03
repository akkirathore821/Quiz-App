package com.exam.quiz_service.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "quiz")
public class QuizEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "quiz_id")
	Integer quizId;
	
	@Column(name = "category")
	String category;
	
	@ElementCollection
	List<Integer> questionIds;

	@Override
	public String toString() {
		return "QuizEntity [quizId=" + quizId + ", category=" + category + ", questionIds=" + questionIds + "]";
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
