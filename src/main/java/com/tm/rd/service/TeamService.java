package com.tm.rd.service;

import java.util.List;

import com.tm.rd.dto.RequestDto;

/**
 * Define TeamService
 * 
 * @author tong
 */
public interface TeamService {
	
	public List<RequestDto> findAll();
	
}