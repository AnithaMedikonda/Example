package com.cts.training.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.bean.Skill;
import com.cts.training.exception.SkillNotFoundException;
import com.cts.training.repository.SkillRepository;

@RestController
@RequestMapping("/api")
public class SkillResource {
	@Autowired
	private SkillRepository skillRepository;
	
	@GetMapping("/skills")
	public List<Skill> getAllSkills(){
		return skillRepository.findAll();
	}
	
	@GetMapping("/skills/{id}")
	public ResponseEntity<Optional<Skill>> getSkillById(@PathVariable Long id) {
		Optional<Skill> skill = skillRepository.findById(id);
		if(!skill.isPresent())
		{
			throw new SkillNotFoundException("The skill with id - "+id+ " does not exists");
		}
		return new ResponseEntity<>(skill, HttpStatus.FOUND);
	}
	
	@DeleteMapping("/skills/{id}")
	public void deleteSkill(@PathVariable Long id) {
		 skillRepository.deleteById(id);
		
	}
	
	@PostMapping("/skills")
	public Skill createSkill(@Valid @RequestBody Skill skill) {
	Skill savedSkill = skillRepository.save(skill);
	return savedSkill;
	}
	
	@PutMapping("/skills/{id}")
	public ResponseEntity<Object> updateSkill(@Valid @RequestBody Skill skill, @PathVariable Long id){
		skillRepository.save(skill);
		return  ResponseEntity.noContent().build();
	}
}
