package com.distribution.app.ingredients;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ingredients")
@Data
public class IngredientsVO {

	@Id
	@Column(name = "INGREDIENTS_ID")
	private Integer ingredientsId;

	@Column(name = "INGREDIENTS_NAME")
	private String ingredientsName;

	@Column(name = "INGREDIENTS_STOCK")
	private Integer ingredientsStock;

	@Column(name = "INGREDIENTS_PRICE")
	private Integer ingredientsPrice;

	@Column(name = "INGREDIENTS_DATE")
	private Date ingredientsDate;

	@Column(name = "HISTORY_ID")
	private Integer historyId;

	@Column(name = "SAVE_NAME")
	private String saveName;

	@Column(name = "ORIGIN_NAME")
	private String originName;
}
