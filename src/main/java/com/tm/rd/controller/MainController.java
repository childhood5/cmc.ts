package com.tm.rd.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tm.rd.dto.RequestDto;
import com.tm.rd.exception.ApiError;
import com.tm.rd.service.AssignmentResultService;
import com.tm.rd.util.ValidatorUtil;

/**
 * Here is MainController
 * 
 * @author tong
 *
 */

@RestController
@RequestMapping(value = "/api", produces = { "application/json", "application/xml" })
public class MainController {

	
	private AssignmentResultService resultService;
	
	@Autowired
	public MainController(AssignmentResultService resultService) {
		this.resultService = resultService;
	}
	
	@GetMapping("/team/skill")
	public ResponseEntity<?> getTeamSkill(@Valid RequestDto request, BindingResult result) {
		try {
			ValidatorUtil.validateRequest(result);
			List<RequestDto> list = resultService.getResults(request.getTaskId());
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			ApiError apiError = new ApiError(HttpStatus.FORBIDDEN, e.getLocalizedMessage());
			return new ResponseEntity<>(apiError, apiError.getStatus());
		}
	}
}
