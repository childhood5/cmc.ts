package com.tm.rd.mapper;

import com.tm.rd.dto.RequestDto;
import com.tm.rd.model.AssignmentResultEntity;


/**
 * This is MapperObject class to mapper object
 * 
 * @author tong
 *
 */
public class MapperObject {

	public AssignmentResultEntity mapperDtoToEntity(RequestDto dto) {
		AssignmentResultEntity entity = new AssignmentResultEntity();
		entity.setTaskId(dto.getTaskId());
		return entity;
	}

	public RequestDto mapperEntityToDto(AssignmentResultEntity entity) {
		RequestDto dto = new RequestDto();
		dto.setTaskId(entity.getTaskId());
		dto.setSkill(entity.getSkill());
		dto.setTeamId(entity.getTeamId());
		return dto;
	}
}