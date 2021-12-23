package tm.task.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tm.task.model.TaskEntity;

/**
 * Here is an TaskRepository interface
 * 
 * @author tong
 */
public interface TaskRepository extends CrudRepository<TaskEntity, Long> {

	List<TaskEntity> findAll();
}
