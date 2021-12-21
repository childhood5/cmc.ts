package com.tm.rd.service;

import java.util.List;

import com.tm.rd.dto.RequestDto;

/**
 * Define AssignmentResultService
 * 
 * @author tong
 */
public interface AssignmentResultService {
	
	public List<RequestDto> getResults(final String taskId);
}