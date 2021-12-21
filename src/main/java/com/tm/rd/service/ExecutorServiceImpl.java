package com.tm.rd.service;

import static com.tm.rd.constants.Constant.CURRENT_FOLDER;
import static com.tm.rd.util.CSVFileUtil.deleteCSVFile;
import static com.tm.rd.util.CSVFileUtil.readCSVFile;

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

import com.tm.rd.model.TaskEntity;
import com.tm.rd.model.TeamEntity;
import com.tm.rd.model.TeamSkillEntity;
import com.tm.rd.repository.TaskRepository;
import com.tm.rd.repository.TeamRepository;
import com.tm.rd.repository.TeamSkillRepository;

/**
 * Here is a CallableServiceImpl
 * 
 * @author tong
 *
 */
@Service
public class ExecutorServiceImpl implements Callable<Void> {

	private TaskRepository taskRepository;

	private TeamRepository teamRepository;

	private TeamSkillRepository teamSkillRepository;

	@Autowired
	public ExecutorServiceImpl(TaskRepository taskRepository, TeamRepository teamRepository,
			TeamSkillRepository teamSkillRepository) {
		this.taskRepository = taskRepository;
		this.teamRepository = teamRepository;
		this.teamSkillRepository = teamSkillRepository;

	}

	@Override
	public synchronized Void call() throws Exception {
		watchFolder();
		return null;
	}

	private synchronized void watchFolder() {
		try {
			WatchService watchService = FileSystems.getDefault().newWatchService();
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
						final String pathFile = Paths.get(fileName.toString()).toAbsolutePath().toString();
						final List<?> records = readCSVFile(pathFile, fileName.toString());
						for (Object entity : records) {
							if (entity instanceof TaskEntity) {
								taskRepository.save((TaskEntity) entity);
							} else if (entity instanceof TeamEntity) {
								teamRepository.save((TeamEntity) entity);
							} else if (entity instanceof TeamSkillEntity) {
								teamSkillRepository.save((TeamSkillEntity) entity);
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
