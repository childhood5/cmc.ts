package tm.task.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tm.task.model.TeamSkillEntity;

/**
 * Here is an TeamSkillRepository interface
 * 
 * @author tong
 */
public interface TeamSkillRepository extends CrudRepository<TeamSkillEntity, Long> {

	List<TeamSkillEntity> findAll();
}
