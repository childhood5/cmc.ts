package tm.task.service;

import java.util.List;

import tm.task.model.TeamSkillEntity;

/**
 * Define TeamSkillService
 * 
 * @author tong
 */
public interface TeamSkillService {
	
	public void insert(TeamSkillEntity entity);
	
	public List<TeamSkillEntity> findAll();
}