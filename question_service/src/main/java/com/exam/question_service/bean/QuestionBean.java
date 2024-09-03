package com.exam.question_service.bean;

public class QuestionBean {
	
	Integer questionId;
	String question;
	String optionA;
	String optionB;
	String optionC;
	String optionD;
	String correct;
	String category;
	
	
	public Integer getQuestionId() {
		return questionId;
	}


	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getOptionA() {
		return optionA;
	}


	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}


	public String getOptionB() {
		return optionB;
	}


	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}


	public String getOptionC() {
		return optionC;
	}


	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}


	public String getOptionD() {
		return optionD;
	}


	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}


	public String getCorrect() {
		return correct;
	}


	public void setCorrect(String correct) {
		this.correct = correct;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "QuestionBean [questionId=" + questionId + ", question=" + question + ", optionA=" + optionA
				+ ", optionB=" + optionB + ", optionC=" + optionC + ", optionD=" + optionD + ", correct=" + correct
				+ ", category=" + category + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
