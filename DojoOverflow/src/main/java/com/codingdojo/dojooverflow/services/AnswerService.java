package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.repositories.AnswerRepository;



@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepo;
	
	public List<Answer> allAnswersByQuestion(Long id) {
        return answerRepo.findAnswerByQuestion_Id(id);
    }
   
    public Answer createAnswer(Answer b) {
        return answerRepo.save(b);
    }
    
    public Answer updateAnswer(Answer b) {
        return answerRepo.save(b);
    }
    
    public Answer findAnswer(Long id) {
        Optional<Answer> optionalAnswer = answerRepo.findById(id);
        if(optionalAnswer.isPresent()) {
            return optionalAnswer.get();
        } else {
            return null;
        }
    } 
	
}
