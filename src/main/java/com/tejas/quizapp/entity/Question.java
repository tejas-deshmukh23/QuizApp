package com.tejas.quizapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="question")
public class Question {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="questiontitle")
	private String questionTitle;
	@Column(name="category")
	private String Category;
	@Column(name="option1")
	private String option1;
	@Column(name="option2")
	private String option2;
	@Column(name="option3")
	private String option3;
	@Column(name="option4")
	private String option4;
	@Column(name="rightAnswer")
	private String rightAnswer;
	@Column(name="difficultylevel")
	private String difficultyLevel;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}

	public Question(int id, String questionType, String category, String difficultyLevel, String option1,
			String option2, String option3, String option4) {
		super();
		this.id = id;
		this.questionTitle = questionType;
		Category = category;
		this.difficultyLevel = difficultyLevel;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionType() {
		return questionTitle;
	}

	public void setQuestionType(String questionType) {
		this.questionTitle = questionType;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}  

}
