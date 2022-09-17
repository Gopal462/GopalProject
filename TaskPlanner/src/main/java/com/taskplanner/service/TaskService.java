package com.taskplanner.service;

import java.util.List;

import com.taskplanner.entity.Task;

public interface TaskService {

	List<Task> getAllTask();

	Task saveTask(Task task);

	Task updateTask(Task task);

	Task assignTask(Task task);

	Task findById(Long id);

	List<Task> findByTitle(String title);

}
