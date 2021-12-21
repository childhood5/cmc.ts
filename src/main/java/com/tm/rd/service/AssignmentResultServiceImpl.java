package com.tm.rd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.rd.dto.RequestDto;
import com.tm.rd.mapper.MapperObject;
import com.tm.rd.model.AssignmentResultEntity;
import com.tm.rd.repository.AssignmentResultRepository;
/**
 * Here is a TaskServiceImpl class
 * 
 * @author tong
 */
@Service
public class AssignmentResultServiceImpl implements AssignmentResultService {

	
	private AssignmentResultRepository assignmentResultRepository;
	
	@Autowired
	public AssignmentResultServiceImpl(AssignmentResultRepository assignmentResultRepository) {
		this.assignmentResultRepository = assignmentResultRepository;
	}

	@Override
	public List<RequestDto> getResults(final String taskId) {
		
		List<RequestDto> dtoList = new ArrayList<>();
		List<AssignmentResultEntity> result = assignmentResultRepository.getResults(taskId);
		for(AssignmentResultEntity entity: result) {
			dtoList.add(new MapperObject().mapperEntityToDto(entity));
		}
		return dtoList;
	}
}