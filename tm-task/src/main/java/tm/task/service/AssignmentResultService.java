package tm.task.service;

import java.util.List;

import tm.task.model.AssignmentResultEntity;

/**
 * Define AssignmentResultService
 * 
 * @author tong
 */
public interface AssignmentResultService {
	
	public List<AssignmentResultEntity> getResults(final String taskId);
}