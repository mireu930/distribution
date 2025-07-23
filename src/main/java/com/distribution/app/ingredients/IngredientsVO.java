package com.distribution.app.ingredients;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ingredients")
@Data
public class IngredientsVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ingredientsId;

	private String ingredientsName;

	private Integer ingredientsStock;

	private Integer ingredientsPrice;

	@CreatedDate
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime ingredientsDate;

	private Integer historyId;

	private String saveName;

	private String originName;
}
