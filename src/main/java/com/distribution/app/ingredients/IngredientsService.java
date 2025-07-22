package com.distribution.app.ingredients;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.distribution.app.page.Pager;

import lombok.RequiredArgsConstructor;

@Service
public class IngredientsService {
	
	private final IngredientsRepository ingredientsRepository;
	
	public IngredientsService(IngredientsRepository ingredientsRepository) {
		this.ingredientsRepository = ingredientsRepository;
	}
	
	public List<IngredientsVO> getList(Pager pager) {
		pager.make();
		Pageable pageable = PageRequest.of(pager.getNowPage().intValue()-1, pager.getPage().intValue());
		Page<IngredientsVO> pageResult = ingredientsRepository.findAll(pageable);
		pager.makeNum(pageResult.getTotalElements());
		return pageResult.getContent();
	}

}
