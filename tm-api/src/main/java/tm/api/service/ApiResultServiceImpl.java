package tm.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tm.api.dto.RequestDto;
import tm.api.mapper.MapperObject;
import tm.task.model.AssignmentResultEntity;
import tm.task.service.AssignmentResultService;

/**
 * Here is a TaskServiceImpl class
 * 
 * @author tong
 */
@Service
public class ApiResultServiceImpl implements ApiResultService {

	
	private AssignmentResultService assignmentResultService;
	
	@Autowired
	public ApiResultServiceImpl(AssignmentResultService assignmentResultService) {
		this.assignmentResultService = assignmentResultService;
	}

	@Override
	public List<RequestDto> getResults(final String taskId) {
		
		List<RequestDto> dtoList = new ArrayList<>();
		List<AssignmentResultEntity> result = assignmentResultService.getResults(taskId);
		for(AssignmentResultEntity entity: result) {
			dtoList.add(new MapperObject().mapperEntityToDto(entity));
		}
		return dtoList;
	}
}