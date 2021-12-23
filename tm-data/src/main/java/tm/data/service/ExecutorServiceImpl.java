package tm.data.service;

import static tm.data.constants.Constant.CURRENT_FOLDER;
import static tm.data.util.CSVFileUtil.deleteCSVFile;
import static tm.data.util.CSVFileUtil.readCSVFile;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tm.task.model.TaskEntity;
import tm.task.model.TeamEntity;
import tm.task.model.TeamSkillEntity;
import tm.task.service.TaskService;
import tm.task.service.TeamService;
import tm.task.service.TeamSkillService;

/**
 * Here is a CallableServiceImpl
 * 
 * @author tong
 *
 */
@Service
public class ExecutorServiceImpl implements Callable<Void> {

	private TaskService taskService;

	private TeamService teamService;

	private TeamSkillService teamSkillService;

	@Autowired
	public ExecutorServiceImpl(TaskService taskService,
			TeamService teamService, TeamSkillService teamSkillService) {
		this.taskService = taskService;
		this.teamService = teamService;
		this.teamSkillService = teamSkillService;

	}

	@Override
	public synchronized Void call() throws Exception {
		watchFolder();
		return null;
	}

	private synchronized void watchFolder() {
		try {
			WatchService watchService = FileSystems.getDefault()
					.newWatchService();
			Path directory = Paths.get(System.getProperty(CURRENT_FOLDER));
			WatchKey watchKey = directory.register(watchService,
					StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_MODIFY,
					StandardWatchEventKinds.ENTRY_DELETE);

			while (true) {
				for (WatchEvent<?> event : watchKey.pollEvents()) {
					final WatchEvent<Path> pathEvent = (WatchEvent<Path>) event;
					final Path fileName = pathEvent.context();
					final WatchEvent.Kind<?> kind = event.kind();
					if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
						final String pathFile = Paths.get(fileName.toString())
								.toAbsolutePath().toString();
						final List<?> records = readCSVFile(pathFile,
								fileName.toString());
						for (Object entity : records) {
							if (entity instanceof TaskEntity) {
								taskService.insert((TaskEntity) entity);
							} else if (entity instanceof TeamEntity) {
								teamService.insert((TeamEntity) entity);
							} else if (entity instanceof TeamSkillEntity) {
								teamSkillService.insert((TeamSkillEntity) entity);
							}
						}
						Thread.sleep(1000);
						deleteCSVFile(pathFile);
					}
				}
				if (!watchKey.reset()) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
