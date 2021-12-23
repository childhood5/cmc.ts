package tm.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tm.api.dto.RequestDto;
import tm.api.mapper.MapperObject;
import tm.task.model.TeamSkillEntity;
import tm.task.service.TeamSkillService;

/**
 * Here is a TeamSkillServiceImpl class
 * 
 * @author tong
 */
@Service
public class ApiTeamSkillServiceImpl implements ApiTeamSkillService {

	private TeamSkillService teamSkillService;
	
	@Autowired
	public ApiTeamSkillServiceImpl(TeamSkillService teamSkillService) {
		this.teamSkillService = teamSkillService;
	}
	
	@Override
	public List<RequestDto> findAll() {
		List<RequestDto> dtoList = new ArrayList<>();
		List<TeamSkillEntity> result = teamSkillService.findAll();
		for(TeamSkillEntity entity: result) {
			dtoList.add(new MapperObject().mapperEntityToDto(entity));
		}
		return dtoList;
	}

}