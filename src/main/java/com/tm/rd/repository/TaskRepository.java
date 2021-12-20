package com.tm.rd.repository;

import org.springframework.data.repository.CrudRepository;

import com.tm.rd.model.TaskEntity;

/**
 * Here is an TaskRepository interface
 * 
 * @author tong
 */
public interface TaskRepository extends CrudRepository<TaskEntity, Long> {

	
}
