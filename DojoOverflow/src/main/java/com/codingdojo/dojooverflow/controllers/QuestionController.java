package com.codingdojo.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.services.AnswerService;
import com.codingdojo.dojooverflow.services.QuestionService;
import com.codingdojo.dojooverflow.services.TagService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionServ;
	
	@Autowired
	private TagService tagServ;
	
	@Autowired
	private AnswerService answerServ;

	@GetMapping("/")
	public String index(Model model) {
		return "redirect:/questions";
	}
	
	@GetMapping("/questions")
	public String questions(Model model) {
		List<Question> questions = questionServ.allQuestions();
		model.addAttribute("questions", questions);
		return "/questions/index.jsp";
	}
	
	@RequestMapping("/questions/new")
	 public String newBook(@ModelAttribute("questionAux") Question questionAux) {
      return "/questions/new.jsp";
  }
	
	@RequestMapping(value = "/questions", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("questionAux") Question question, BindingResult result, Model model, HttpSession session) {
		
		String listTags = question.getListTags().toLowerCase();
		String[] tagsArr = listTags.split(",");
		
		if(tagsArr.length > 3) {
		    result.rejectValue("listTags", "Matches", "You can put 3 tags per question max");
		}
		
		if(result.hasErrors()) {			
			return "/questions/new.jsp";
		}
		
		Question newQuestion = questionServ.createQuestion(question);
		
		List<Tag> listTagsAux = new ArrayList<Tag>();		
		
		for (String string : tagsArr) {
			if (tagServ.existByName(string)) {
				Tag tag = tagServ.findTag(string);
				listTagsAux.add(tag);
			}else {
				Tag tag = tagServ.createTag(new Tag(string));
				listTagsAux.add(tag);
			}
		}
		
		newQuestion.setTags(listTagsAux);
		questionServ.createQuestion(newQuestion);
		return "redirect:/questions";
	}
	
	@RequestMapping("/questions/{id}")
	public String showQuestion(Model model, @PathVariable("id") Long id, @ModelAttribute("answerAux") Answer answerAux) {
		Question question = questionServ.findQuestion(id);
		model.addAttribute("question", question);
		return "/questions/show.jsp";
	}
	
	@RequestMapping(value = "/questions/addAnswer", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("answerAux") Answer answer, BindingResult result, Model model, HttpSession session) {
		
		Answer newAnswer = answerServ.createAnswer(answer);
		
		return "redirect:/questions/"+newAnswer.getQuestion().getId();
	}
	
}
