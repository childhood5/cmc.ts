package com.tm.rd.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tm.rd.dto.RequestDto;


/**
 * This is MapperObject class to mapper object
 * 
 * @author tong
 *
 */
public class MapperObject {

	public RequestDto mapperEntityToDto(Object entity) {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(entity, RequestDto.class);
	}
}