package com.taskplanner.entity;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Task {
	
	@Transient
	public static final String SEQENCE_NAME="users_sequence";
	
	@Id
	private Long taskId;
	
	private String title;
	
	private String createdBy;
	
	private String description;
	
	private String assignedTo;
	
	private Date completedOn;
	
	private Status status;
	
	
	
}
