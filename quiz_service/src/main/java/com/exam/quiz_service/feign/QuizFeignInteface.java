package com.exam.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.exam.quiz_service.bean.QuestionWrapper;
import com.exam.quiz_service.bean.ResponseBean;

@FeignClient("QUESTION-SERVICE")
public interface QuizFeignInteface {
	
	@GetMapping("question/getQustionToGenerateQuiz/{category}")
	public ResponseEntity<List<Integer>> getQustionToGenerateQuiz(@PathVariable String category);
	
	@PostMapping("question/getQustionForQuiz")
	public ResponseEntity<List<QuestionWrapper>> getQustionForQuiz(@RequestBody List<Integer> quesIds);
	
	@PostMapping("question/getScore")
	public ResponseEntity<Integer> calculateScore( @RequestBody List<ResponseBean> responses);

}
