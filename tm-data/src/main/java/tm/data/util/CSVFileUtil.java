package tm.data.util;

import static tm.data.constants.Constant.TASK_CSV;
import static tm.data.constants.Constant.TEAM_CSV;
import static tm.data.constants.Constant.TEAM_SKILL_CSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tm.task.model.TaskEntity;
import tm.task.model.TeamEntity;
import tm.task.model.TeamSkillEntity;


/**
 * ReadCSVUtil class
 * 
 *
 */
public final class CSVFileUtil {

	public static synchronized List<?> readCSVFile(final String pathFile, final String fileName) throws FileNotFoundException, IOException {
		
		List<Object> records = new ArrayList<>();
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        if(TASK_CSV.equals(fileName)) {
		        	TaskEntity entity = new TaskEntity();
			        entity.setTaskId(replaceString(values[0]));
			        entity.setSkill(replaceString(values[1]));
			        records.add(entity);
		        } else if(TEAM_CSV.equals(fileName)) {
		        	TeamEntity entity = new TeamEntity();
			        entity.setTeamId(replaceString(values[0]));
			        records.add(entity);
		        } else if(TEAM_SKILL_CSV.equals(fileName)) {
		        	TeamSkillEntity entity = new TeamSkillEntity();
			        entity.setTeamId(replaceString(values[0]));
			        entity.setSkill(replaceString(values[1]));
			        records.add(entity);
		        }
		    }
		}
		return records;
	}
	
	public static void deleteCSVFile(final String pathFile) {
		final File file= new File(pathFile);
		if(file.exists()) {
			file.delete();
		}
	}
	
	public static String replaceString(final String data) {
		return data.replace("\"", "");
	}

}
