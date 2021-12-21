package com.tm.rd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.rd.dto.RequestDto;
import com.tm.rd.mapper.MapperObject;
import com.tm.rd.model.TeamSkillEntity;
import com.tm.rd.repository.TeamSkillRepository;

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
	
	@Override
	public List<RequestDto> findAll() {
		List<RequestDto> dtoList = new ArrayList<>();
		List<TeamSkillEntity> result = repository.findAll();
		for(TeamSkillEntity entity: result) {
			dtoList.add(new MapperObject().mapperEntityToDto(entity));
		}
		return dtoList;
	}

}