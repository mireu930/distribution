package com.distribution.app.ingredients;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IngredientsTest {
	@Autowired
	private IngredientsRepository ingredientsRepository;
	
	@Test
	void list() throws Exception {
		IngredientsService ingredientsService = new IngredientsService(ingredientsRepository);
		List<IngredientsVO> list = ingredientsService.getList();
		int count = list.size();
		assertEquals(1, count);
	}

}
