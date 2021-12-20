package com.tm.rd.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static com.tm.rd.constants.Constant.TASK_CSV;
import static com.tm.rd.constants.Constant.TEAM_CSV;
import static com.tm.rd.constants.Constant.TEAM_SKILL_CSV;
import com.tm.rd.model.TaskEntity;
import com.tm.rd.model.TeamEntity;
import com.tm.rd.model.TeamSkillEntity;


/**
 * ReadCSVUtil class
 * 
 *
 */
public final class ReadCSVUtil {

	public static synchronized List<?> readCSVFile(final String pathFile, final String fileName) throws FileNotFoundException, IOException {
		
		List<Object> records = new ArrayList<>();
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        if(TASK_CSV.equals(fileName)) {
		        	TaskEntity entity = new TaskEntity();
			        entity.setTaskId(values[0]);
			        entity.setSkill(values[1]);
			        records.add(entity);
		        } else if(TEAM_CSV.equals(fileName)) {
		        	TeamEntity entity = new TeamEntity();
			        entity.setTeamId(values[0]);
			        records.add(entity);
		        } else if(TEAM_SKILL_CSV.equals(fileName)) {
		        	TeamSkillEntity entity = new TeamSkillEntity();
			        entity.setTeamId(values[0]);
			        entity.setSkill(values[1]);
			        records.add(entity);
		        }
		    }
		}
		return records;
	}

}
