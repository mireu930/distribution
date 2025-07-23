package com.distribution.app.ingredients;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.distribution.app.page.Pager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IngredientsService {
	
	private final IngredientsRepository ingredientsRepository;
	
	public IngredientsService(IngredientsRepository ingredientsRepository) {
		this.ingredientsRepository = ingredientsRepository;
	}
	
	@Cacheable(cacheNames = "getIngredients",  key = "'ingredients:page:' + (#pager != null ? #pager.nowPage : 1) + ':size:' + (#pager != null ? #pager.page : 10)", cacheManager = "boardCacheManager")
	public List<IngredientsVO> getList(Pager pager) {
		if (pager == null) {
	        throw new IllegalArgumentException("Pager must not be null");
	    }
		log.info("Pager in service: {}", pager);
		pager.make();
		Pageable pageable = PageRequest.of(pager.getNowPage().intValue()-1, pager.getPage().intValue());
		Page<IngredientsVO> pageResult = ingredientsRepository.findAll(pageable);
		pager.makeNum(pageResult.getTotalElements());
		return pageResult.getContent();
	}

}
