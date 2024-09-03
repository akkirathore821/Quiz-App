package com.exam.quiz_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.quiz_service.entity.QuizEntity;

@Repository
public interface QuizDAO extends JpaRepository<QuizEntity, Integer> {

}
