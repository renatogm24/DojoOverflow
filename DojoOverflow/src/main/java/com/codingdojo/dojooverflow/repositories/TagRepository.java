package com.codingdojo.dojooverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojooverflow.models.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

	List<Tag> findAll();

	Tag findTagById(Long id);
	
	Optional<Tag> findTagBySubject(String subject);
	
	List<Tag> findAllByQuestions_Id(Long id);
	
	List<Tag> findAllByQuestions_Question(String question);
	
	boolean existsBySubject(String subject);

}
