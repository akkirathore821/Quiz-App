package com.exam.question_service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exam.question_service.entity.QuestionEntity;


@Repository
public interface QuestionDAO extends JpaRepository<QuestionEntity, Integer>{
	
	List<QuestionEntity> findByCategory(String category);
	
	@Query("SELECT k FROM question k WHERE k.category = ?1 ORDER BY RAND() LIMIT 10")
	List<QuestionEntity> findRandomQuestionForQuizByCategory(String category);

}
