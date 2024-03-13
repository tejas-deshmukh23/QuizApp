package com.tejas.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tejas.quizapp.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

}
