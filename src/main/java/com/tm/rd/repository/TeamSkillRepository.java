package com.tm.rd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tm.rd.model.TeamSkillEntity;

/**
 * Here is an TeamSkillRepository interface
 * 
 * @author tong
 */
public interface TeamSkillRepository extends CrudRepository<TeamSkillEntity, Long> {

	List<TeamSkillEntity> findAll();
}
