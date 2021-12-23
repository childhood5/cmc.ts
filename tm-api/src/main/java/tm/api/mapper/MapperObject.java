package tm.api.mapper;

import tm.api.dto.RequestDto;

import com.fasterxml.jackson.databind.ObjectMapper;


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