package com.tm.rd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.rd.dto.RequestDto;
import com.tm.rd.mapper.MapperObject;
import com.tm.rd.model.TeamEntity;
import com.tm.rd.repository.TeamRepository;

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
	public List<RequestDto> findAll() {
		List<RequestDto> dtoList = new ArrayList<>();
		List<TeamEntity> result = teamRepository.findAll();
		for(TeamEntity entity: result) {
			dtoList.add(new MapperObject().mapperEntityToDto(entity));
		}
		return dtoList;
	}

}