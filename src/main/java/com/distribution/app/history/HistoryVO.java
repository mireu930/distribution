package com.distribution.app.history;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "HISTORY")
@Data
public class HistoryVO {

	@Id
	private Integer historyId;
	private boolean receive;
	private Integer number;
	private String userId;
	private Integer ingredientsID;
	private Timestamp registrationDate;
}
