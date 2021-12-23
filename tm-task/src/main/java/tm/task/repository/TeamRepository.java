package tm.task.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tm.task.model.TeamEntity;

/**
 * Here is an TeamRepository interface
 * 
 * @author tong
 */
public interface TeamRepository extends CrudRepository<TeamEntity, Long> {

	List<TeamEntity> findAll();
}
