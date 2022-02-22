package com.codingdojo.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojooverflow.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

	List<Answer> findAll();

	Answer findAnswerById(Long id);
	
	List<Answer> findAnswerByQuestion_Id(Long id);

}
