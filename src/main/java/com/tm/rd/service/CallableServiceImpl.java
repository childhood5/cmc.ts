package com.tm.rd.service;

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
import com.tm.rd.util.ReadCSVUtil;

/**
 * Here is a CallableServiceImpl
 * 
 * @author tong
 *
 */
@Service
public class CallableServiceImpl implements Callable<Void> {

	private TaskRepository taskRepository;

	private TeamRepository teamRepository;

	private TeamSkillRepository teamSkillRepository;

	@Autowired
	public CallableServiceImpl(TaskRepository taskRepository, TeamRepository teamRepository,
			TeamSkillRepository teamSkillRepository) {
		this.taskRepository = taskRepository;
		this.teamRepository = teamRepository;
		this.teamSkillRepository = teamSkillRepository;

	}

	@Override
	public Void call() throws Exception {
		watchFolder();
		return null;
	}

	private void watchFolder() {
		try {
			WatchService watchService = FileSystems.getDefault().newWatchService();
			Path directory = Paths.get(System.getProperty("user.dir"));
			WatchKey watchKey = directory.register(watchService,
					StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_MODIFY,
					StandardWatchEventKinds.ENTRY_DELETE);

			while (true) {
				for (WatchEvent<?> event : watchKey.pollEvents()) {
					WatchEvent<Path> pathEvent = (WatchEvent<Path>) event;
					Path fileName = pathEvent.context();
					fileName.getFileSystem().getRootDirectories();
					WatchEvent.Kind<?> kind = event.kind();
					if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
						List<?> records = ReadCSVUtil.readCSVFile(Paths.get(fileName.toString()).toAbsolutePath()
										.toString(), fileName.toString());
						for (Object entity : records) {
							if (entity instanceof TaskEntity) {
								taskRepository.save((TaskEntity) entity);
							} else if (entity instanceof TeamEntity) {
								teamRepository.save((TeamEntity) entity);
							} else if (entity instanceof TeamSkillEntity) {
								teamSkillRepository.save((TeamSkillEntity) entity);
							}
						}
					}
				}
				boolean valid = watchKey.reset();
				if (!valid) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
