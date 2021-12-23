package tm.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tm.api.dto.RequestDto;
import tm.api.mapper.MapperObject;
import tm.task.model.TaskEntity;
import tm.task.service.TaskService;


/**
 * Here is a TaskServiceImpl class
 * 
 * @author tong
 */
@Service
public class ApiTaskServiceImpl implements ApiTaskService {

	private TaskService taskService;
	
	@Autowired
	public ApiTaskServiceImpl(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@Override
	public List<RequestDto> findAll() {
		List<RequestDto> dtoList = new ArrayList<>();
		List<TaskEntity> result = taskService.findAll();
		for(TaskEntity entity: result) {
			dtoList.add(new MapperObject().mapperEntityToDto(entity));
		}
		return dtoList;
	}

}