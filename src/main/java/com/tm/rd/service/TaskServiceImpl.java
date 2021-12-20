package com.tm.rd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tm.rd.repository.TaskRepository;
import com.tm.rd.model.TaskEntity;

/**
 * Here is a TaskServiceImpl class
 * 
 * @author tong
 */
@Service
public class TaskServiceImpl implements TaskService {

	private TaskRepository taskRepository;
	
	@Autowired
	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	@Override
	public void insert(TaskEntity entity) {
		taskRepository.save(entity);
	}

}