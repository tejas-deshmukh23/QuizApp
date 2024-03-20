package com.tejas.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.quizapp.wrapper.QuestionWrapper;
import com.tejas.quizapp.Response;
import com.tejas.quizapp.entity.Question;
import com.tejas.quizapp.entity.Quiz;
import com.tejas.quizapp.repository.QuestionRepository;
import com.tejas.quizapp.repository.QuizRepository;

@Service
public class QuizService {
	
	@Autowired
	QuizRepository quizDao;
	
	@Autowired
	QuestionRepository questionDao;
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title)
	{
		//We have our all the questions in QuestionDao hence we will need to write the method in QuestionDao and use it using Reference of QuestionDao
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
		//Here we will create a quiz and set the questions into it which we got from QuestionDao
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		//Now we will need to save the quiz into Database
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Created",HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		
			Optional<Quiz> quiz = quizDao.findById(id);//here if we give the correct id then findById will return the 
			//quiz which has that id but if we give wrong id then quizDao will return null to avoid which we use optional
			
			List<Question> questionFromDb = quiz.get().getQuestions();
			
			List<QuestionWrapper> questionForUser = new ArrayList<>();
			
			for(Question question : questionFromDb) {
				QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(),question.getCategory(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4());
				questionForUser.add(questionWrapper);
			}
			
			return new ResponseEntity<>(questionForUser,HttpStatus.OK);
			
			
		
	}

	//Here when use will click on Submit Quiz button then the user answer will be stored in a variable named as 'response' with 'id' will be the id of the quiz and the id and response variable belongs to developer made Response class
	//We will store that multiple Response in a List of Response and supply it to the API in QuizController from where we will call this calculateResult Method
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		Quiz quiz = quizDao.findById(id).get();//we can use get() here instead of optional
		List<Question> questions = quiz.getQuestions();
		
		int right=0;//This will increase when we get right answer
		int i=0;//i represents the number of questions from a List<Question>
		
		for(Response response : responses)
		{
			if(response.getResponse().equals(questions.get(i).getRightAnswer())) {
				right++;
			}
			i++;
		}
		
		return new ResponseEntity<Integer>(right,HttpStatus.OK);
	}

}
