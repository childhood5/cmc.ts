package tm.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tm.task.model.TeamEntity;
import tm.task.repository.TeamRepository;

/**
 * Here is a TeamServiceImpl class
 * 
 * @author tong
 */
@Service
public class TeamServiceImpl implements TeamService {

	private TeamRepository teamRepository;
	
	@Autowired
	public TeamServiceImpl(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}
	
	@Override
	public List<TeamEntity> findAll() {
		return teamRepository.findAll();
	}

	@Override
	public void insert(TeamEntity entity) {
		teamRepository.save(entity);
	}

}