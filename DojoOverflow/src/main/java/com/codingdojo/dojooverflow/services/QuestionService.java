package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.QuestionRepository;
import com.codingdojo.dojooverflow.repositories.TagRepository;



@Service
public class QuestionService {
	
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private TagRepository tagRepo;
	
	public List<Question> allQuestions() {
        return questionRepo.findAll();
    }
   
    public Question createQuestion(Question b) {
        return questionRepo.save(b);
    }
    
    public Question updateQuestion(Question b) {
        return questionRepo.save(b);
    }
    
    public Question findQuestion(Long id) {
        Optional<Question> optionalQuestion = questionRepo.findById(id);
        if(optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
    } 
	
	public Question addTagToQuestion(Long questionId, Long tagId) {
		Question thisQuestion = questionRepo.findQuestionById(questionId);
		Tag thisTag = tagRepo.findTagById(tagId);
		thisQuestion.getTags().add(thisTag);		
		return questionRepo.save(thisQuestion);
    }

}
