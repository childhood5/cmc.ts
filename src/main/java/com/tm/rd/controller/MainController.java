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
import com.tm.rd.service.TaskService;
import com.tm.rd.service.TeamService;
import com.tm.rd.service.TeamSkillService;
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
	
	private TeamService teamService;
	
	private TaskService taskService;
	
	private TeamSkillService teamSkillService;
	
	@Autowired
	public MainController(AssignmentResultService resultService, TeamService teamService,
			TaskService taskService, TeamSkillService teamSkillService) {
		this.resultService = resultService;
		this.teamService = teamService;
		this.taskService = taskService;
		this.teamSkillService = teamSkillService;
	}
	
	@GetMapping("/team")
	public ResponseEntity<?> getTeams() {
		try {
			return new ResponseEntity<>(teamService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			ApiError apiError = new ApiError(HttpStatus.FORBIDDEN, e.getLocalizedMessage());
			return new ResponseEntity<>(apiError, apiError.getStatus());
		}
	}
	
	@GetMapping("/task")
	public ResponseEntity<?> getTasks() {
		try {
			return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			ApiError apiError = new ApiError(HttpStatus.FORBIDDEN, e.getLocalizedMessage());
			return new ResponseEntity<>(apiError, apiError.getStatus());
		}
	}
	
	@GetMapping("/team-skill")
	public ResponseEntity<?> getTeamSkill() {
		try {
			return new ResponseEntity<>(teamSkillService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			ApiError apiError = new ApiError(HttpStatus.FORBIDDEN, e.getLocalizedMessage());
			return new ResponseEntity<>(apiError, apiError.getStatus());
		}
	}
	
	@GetMapping("/search/team-skill")
	public ResponseEntity<?> searchTeamSkill(@Valid RequestDto request, BindingResult result) {
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
