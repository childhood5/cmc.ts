package tm.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tm.task.model.TeamSkillEntity;
import tm.task.repository.TeamSkillRepository;

/**
 * Here is a TeamSkillServiceImpl class
 * 
 * @author tong
 */
@Service
public class TeamSkillServiceImpl implements TeamSkillService {

	private TeamSkillRepository repository;
	
	@Autowired
	public TeamSkillServiceImpl(TeamSkillRepository repository) {
		this.repository = repository;
	}
	
	public List<TeamSkillEntity> findAll() {
		return repository.findAll();
	}

	public void insert(TeamSkillEntity entity) {
		repository.save(entity);
	}

}