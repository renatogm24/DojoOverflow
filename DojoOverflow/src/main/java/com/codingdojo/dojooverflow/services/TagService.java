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
public class TagService {

	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private TagRepository tagRepo;
	
	public List<Tag> allTagsByQuestion(Long id) {
        return tagRepo.findAllByQuestions_Id(id);
    }
	
	public List<Tag> allTagsByQuestion(String question) {
        return tagRepo.findAllByQuestions_Question(question);
    }
	
	public boolean existByName(String subject) {
        return tagRepo.existsBySubject(subject);
    }
   
    public Tag createTag(Tag b) {
        return tagRepo.save(b);
    }
    
    public Tag updateTag(Tag b) {
        return tagRepo.save(b);
    }
    
    public Tag findTag(Long id) {
        Optional<Tag> optionalTag = tagRepo.findById(id);
        if(optionalTag.isPresent()) {
            return optionalTag.get();
        } else {
            return null;
        }
    } 
    
    public Tag findTag(String subject) {
        Optional<Tag> optionalTag = tagRepo.findTagBySubject(subject);
        if(optionalTag.isPresent()) {
            return optionalTag.get();
        } else {
            return null;
        }
    } 
	
	public Tag addQuestionToTag(Long questionId, Long tagId) {
		Question thisQuestion = questionRepo.findQuestionById(questionId);
		Tag thisTag = tagRepo.findTagById(tagId);
		thisTag.getQuestions().add(thisQuestion);
		return tagRepo.save(thisTag);
    }
	
}
