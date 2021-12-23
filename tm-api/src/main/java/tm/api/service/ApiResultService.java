package tm.api.service;

import java.util.List;

import tm.api.dto.RequestDto;

/**
 * Define AssignmentResultService
 * 
 * @author tong
 */
public interface ApiResultService {
	
	public List<RequestDto> getResults(final String taskId);
}