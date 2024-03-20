package com.tejas.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.quizapp.entity.Question;
import com.tejas.quizapp.service.QuestionService;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/questions")
	public List<Question> getAllQuestions()//this is a service
	{
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/questions	/{category}")
	public List<Question> getQuestionByCategory(@PathVariable String category){
		return questionService.getQuestionByCategory(category);
	}
	
	@PostMapping("/questions")
	public String addQuestion(Question question) {
		System.out.println("In addQuestions");
		questionService.addQuestion(question);
		return "Updated DB";
	}

	
}
