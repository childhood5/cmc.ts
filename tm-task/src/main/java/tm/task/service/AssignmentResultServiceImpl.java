package tm.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tm.task.model.AssignmentResultEntity;
import tm.task.repository.AssignmentResultRepository;
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

	public List<AssignmentResultEntity> getResults(final String taskId) {
		return assignmentResultRepository.getResults(taskId);
	}
}