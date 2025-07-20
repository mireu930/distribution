package com.distribution.app.ingredients;

import java.util.List;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
public class IngredientsService {
	
	private final IngredientsRepository ingredientsRepository;
	
	public IngredientsService(IngredientsRepository ingredientsRepository) {
		this.ingredientsRepository = ingredientsRepository;
	}
	
	public List<IngredientsVO> getList() {
		return ingredientsRepository.findAll();
	}

}
