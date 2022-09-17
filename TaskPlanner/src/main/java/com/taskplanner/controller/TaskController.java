package com.taskplanner.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.taskplanner.entity.Task;
import com.taskplanner.service.SequenceGeneratorService;
import com.taskplanner.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	TaskService taskService;

	@Autowired
	private SequenceGeneratorService generatorService;

	@PostMapping("/create")
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		// AutoGenerate ID
		task.setTaskId(generatorService.generateSequence(Task.SEQENCE_NAME));
		Task createdTask = taskService.saveTask(task);
		return ResponseEntity.ok().body(createdTask);
	}

	@GetMapping
	public ResponseEntity<List<Task>> findAll() {
		List<Task> list = taskService.getAllTask();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/search/{id}")
	public ResponseEntity<Task> findById(@PathVariable Long id) {
		Task taskById = taskService.findById(id);
		return ResponseEntity.ok().body(taskById);
	}

	@GetMapping("/search/title/{title}")
	public ResponseEntity<List<Task>> searchByTitle(@PathVariable String title) {
		List<Task> taskByTitle = taskService.findByTitle(title);
		return ResponseEntity.ok().body(taskByTitle);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
		task.setTaskId(id);
		Task updatedTask = taskService.updateTask(task);
		return ResponseEntity.ok().body(updatedTask);
	}

	@PutMapping("/assign/{id}")
	public ResponseEntity<Task> assignTask(@PathVariable Long id, @RequestBody Task task) {
		task.setTaskId(id);
		Task assignedTask = taskService.assignTask(task);
		return ResponseEntity.ok().body(assignedTask);
	}

}
