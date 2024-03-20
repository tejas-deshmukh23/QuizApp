package com.tejas.quizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.tejas.quizapp.entity.Question;
import com.tejas.quizapp.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer>{

	

}
