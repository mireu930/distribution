package com.distribution.app.ingredients;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.distribution.app.page.Pager;

@SpringBootTest
class IngredientsTest {
	@Autowired
	private IngredientsRepository ingredientsRepository;
	
	@Test
	void list() throws Exception {
		IngredientsService ingredientsService = new IngredientsService(ingredientsRepository);
//		Pager pager = new Pager();
//		List<IngredientsVO> list = ingredientsService.getList(pager);
//		int count = list.size();
//		assertEquals(1, count);
	}

}
