package com.tm.rd.service;

import java.util.List;

import com.tm.rd.dto.RequestDto;
import com.tm.rd.model.TaskEntity;

/**
 * Define TaskService
 * 
 * @author tong
 */
public interface TaskService {
	
	public void insert(TaskEntity entity);
	
	public List<RequestDto> findAll();
}