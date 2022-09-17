package com.taskplanner.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.taskplanner.entity.Task;

public interface TaskRepository extends MongoRepository<Task, Long>{
	
	List<Task> findByTitle(String title);
	

	
	
	
}
