package tm.api.service;

import java.util.List;

import tm.api.dto.RequestDto;

/**
 * Define TeamService
 * 
 * @author tong
 */
public interface ApiTeamService {
	
	public List<RequestDto> findAll();
	
}