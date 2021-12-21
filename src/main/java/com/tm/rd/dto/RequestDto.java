package com.tm.rd.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import static com.tm.rd.constants.RegexConstant.TASK_ID_PATTERN;


/**
 * This is Request dto
 * 
 * @author tong
 *
 */
public class RequestDto {

	@Pattern(regexp = TASK_ID_PATTERN)
	@NotEmpty
	private String taskId;
	
	private String skill;
	
	private String teamId;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
}
