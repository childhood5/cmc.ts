package tm.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tm.api.dto.RequestDto;
import tm.api.mapper.MapperObject;
import tm.task.model.TeamEntity;
import tm.task.service.TeamService;


/**
 * Here is a TeamServiceImpl class
 * 
 * @author tong
 */
@Service
public class ApiTeamServiceImpl implements ApiTeamService {

	private TeamService teamService;
	
	@Autowired
	public ApiTeamServiceImpl(TeamService teamService) {
		this.teamService = teamService;
	}
	
	@Override
	public List<RequestDto> findAll() {
		List<RequestDto> dtoList = new ArrayList<>();
		List<TeamEntity> result = teamService.findAll();
		for(TeamEntity entity: result) {
			dtoList.add(new MapperObject().mapperEntityToDto(entity));
		}
		return dtoList;
	}

}