package tm.api.service;

import java.util.List;

import tm.api.dto.RequestDto;


/**
 * Define TaskService
 * 
 * @author tong
 */
public interface ApiTaskService {
	
	public List<RequestDto> findAll();
}