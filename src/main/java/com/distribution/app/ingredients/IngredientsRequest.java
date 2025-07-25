package com.distribution.app.ingredients;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class IngredientsRequest {

    private String ingredientsName;
    private Integer ingredientsStock;
    private Integer ingredientsPrice;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") // 예: 2025-07-25T15:30:00
    private LocalDateTime ingredientsDate;
    private Integer historyId;
    private String saveName;
    private String originName;
}
