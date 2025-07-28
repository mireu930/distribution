package com.distribution.app.ingredients;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.distribution.app.page.Pager;

@SpringBootTest
class IngredientsTest {
	@Autowired
	private IngredientsRepository ingredientsRepository;
	
//	@Test
//	void list() throws Exception {
//		IngredientsService ingredientsService = new IngredientsService(ingredientsRepository);
//		
//		LocalDateTime dateTime = LocalDateTime.parse("2025-07-25T15:45:00");
//		
//		ingredientsService.input("설탕", 5, 200, dateTime);
//	}

}
