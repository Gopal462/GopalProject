package com.taskplanner.entity;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "task_history")
public class TaskHistory {
	
	private Long id;

	private String title;
	
	private String description;
	
	private Status status;
	
	

}
