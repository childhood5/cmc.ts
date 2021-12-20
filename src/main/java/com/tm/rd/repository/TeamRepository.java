package com.tm.rd.repository;

import org.springframework.data.repository.CrudRepository;

import com.tm.rd.model.TeamEntity;

/**
 * Here is an TeamRepository interface
 * 
 * @author tong
 */
public interface TeamRepository extends CrudRepository<TeamEntity, Long> {

	
}
