package com.tm.rd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tm.rd.model.AssignmentResultEntity;

/**
 * Here is an TaskRepository interface
 * 
 * @author tong
 */
public interface AssignmentResultRepository extends CrudRepository<AssignmentResultEntity, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM task, team_skill where task.task_id = :taskId and task.skill = team_skill.skill")
	List<AssignmentResultEntity> getResults(@Param("taskId") final String taskId);
}
