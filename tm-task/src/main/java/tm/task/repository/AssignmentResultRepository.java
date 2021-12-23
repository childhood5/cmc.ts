package tm.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tm.task.model.AssignmentResultEntity;


/**
 * Here is an AssignmentResultRepository interface
 * 
 * @author tong
 */
public interface AssignmentResultRepository extends CrudRepository<AssignmentResultEntity, Long> {

	@Query(nativeQuery = true, value = "SELECT team_skill.id, team_skill.team_id, task.skill, task.task_id FROM task, team_skill WHERE task.task_id = :taskId and task.skill = team_skill.skill")
	List<AssignmentResultEntity> getResults(@Param("taskId") final String taskId);

}
