package com.taskplanner.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.taskplanner.entity.Task;
import com.taskplanner.exception.ResourceNotFoundException;
import com.taskplanner.repository.TaskRepository;
import com.taskplanner.service.TaskService;

@Service
@Transactional
public class ServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;

	@Override
	public List<Task> getAllTask() {

		return taskRepository.findAll();
	}

	@Override
	public Task saveTask(Task task) {

		return taskRepository.save(task);
	}

	@Override
	public Task updateTask(Task task) {

		Optional<Task> taskUpdate = this.taskRepository.findById(task.getTaskId());

		if (taskUpdate.isPresent()) {
			Task updatedTask = taskUpdate.get();
			updatedTask.setTitle(task.getTitle());
			updatedTask.setDescription(task.getDescription());
			updatedTask.setStatus(task.getStatus());
			// updatedTask.setCompletedOn(java.time.LocalDateTime.now());
			taskRepository.save(task);
			return updatedTask;
		} else {
			throw new ResourceNotFoundException("Task Not Found with Task Id:" + task.getTaskId());
		}

	}

	@Override
	public Task assignTask(Task task) {

		Optional<Task> taskAssign = this.taskRepository.findById(task.getTaskId());
		if (taskAssign.isPresent()) {
			Task assigned = taskAssign.get();
			assigned.setAssignedTo(task.getAssignedTo());
			taskRepository.save(task);
			return assigned;
		} else {
			throw new ResourceNotFoundException("Task Not Found with Task Id:" + task.getTaskId());
		}
	}

	@Override
	public Task findById(Long id) {

		return taskRepository.findById(id).orElse(new Task());
	}

	@Override
	public List<Task> findByTitle(String title) {

		List<Task> tasks = taskRepository.findByTitle(title);
		return tasks;

	}

}
