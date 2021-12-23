package tm.task.service;

import java.util.List;

import tm.task.model.TaskEntity;

/**
 * Define TaskService
 * 
 * @author tong
 */
public interface TaskService {
	
	public void insert(TaskEntity entity);
	
	public List<TaskEntity> findAll();
}