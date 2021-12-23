package tm.api.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tm.api.dto.RequestDto;
import tm.api.exception.ApiError;
import tm.api.service.ApiResultService;
import tm.api.service.ApiTaskService;
import tm.api.service.ApiTeamService;
import tm.api.service.ApiTeamSkillService;
import tm.api.util.ValidatorUtil;


/**
 * Here is MainController
 * 
 * @author tong
 *
 */

@RestController
@RequestMapping(value = "/api", produces = { "application/json", "application/xml" })
public class MainController {

	
	private ApiResultService resultService;
	
	private ApiTeamService teamService;
	
	private ApiTaskService taskService;
	
	private ApiTeamSkillService teamSkillService;
	
	@Autowired
	public MainController(ApiResultService resultService, ApiTeamService teamService,
			ApiTaskService taskService, ApiTeamSkillService teamSkillService) {
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
	
	@GetMapping("/search/task")
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
