package tm.task.service;

import java.util.List;

import tm.task.model.TeamEntity;

/**
 * Define TeamService
 * 
 * @author tong
 */
public interface TeamService {
	
	public void insert(TeamEntity entity);
	
	public List<TeamEntity> findAll();
	
}