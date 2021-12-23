package tm.api.service;

import java.util.List;

import tm.api.dto.RequestDto;

/**
 * Define TeamSkillService
 * 
 * @author tong
 */
public interface ApiTeamSkillService {
	
	public List<RequestDto> findAll();
}