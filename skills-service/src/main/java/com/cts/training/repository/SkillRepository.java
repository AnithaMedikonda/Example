package com.cts.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.cts.training.bean.Skill;

@Component
public interface SkillRepository extends JpaRepository<Skill, Long> {

}
