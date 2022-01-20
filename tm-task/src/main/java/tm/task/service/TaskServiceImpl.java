package tm.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tm.task.model.TaskEntity;
import tm.task.repository.TaskRepository;


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
	
	public void insert(TaskEntity entity) {
		taskRepository.save(entity);
	}

	public List<TaskEntity> findAll() {
		return taskRepository.findAll();
	}

}