package com.tejas.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejas.quizapp.entity.Question;
import com.tejas.quizapp.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository repo;
	
	public List<Question> getAllQuestions()
	{
		return repo.findAll();
	}

	public List<Question> getQuestionByCategory(String category) {
		// TODO Auto-generated method stub
		return repo.findByCategory(category);
	}

	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return repo.save(question);
		
	}
	
}
