package com.tm.rd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.rd.dto.RequestDto;
import com.tm.rd.mapper.MapperObject;
import com.tm.rd.model.TaskEntity;
import com.tm.rd.repository.TaskRepository;

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

	@Override
	public List<RequestDto> findAll() {
		List<RequestDto> dtoList = new ArrayList<>();
		List<TaskEntity> result = taskRepository.findAll();
		for(TaskEntity entity: result) {
			dtoList.add(new MapperObject().mapperEntityToDto(entity));
		}
		return dtoList;
	}

}