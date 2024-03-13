package com.tejas.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.quizapp.entity.Question;
import com.tejas.quizapp.service.QuestionService;

@RestController
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/questions")
	public List<Question> getAllQuestions()//this is a service
	{
		return questionService.getAllQuestions();
	}
	
}
