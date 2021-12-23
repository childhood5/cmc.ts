package tm.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import static tm.api.constants.RegexConstant.TASK_ID_PATTERN;


/**
 * This is Request dto
 * 
 * @author tong
 *
 */
public class RequestDto {

	private Long id;
	
	@Pattern(regexp = TASK_ID_PATTERN)
	@NotEmpty
	private String taskId;
	
	private String skill;
	
	private String teamId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
