package com.distribution.app.ingredients;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.distribution.app.page.Pager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IngredientsService {
	
	private final IngredientsRepository ingredientsRepository;
	
	private String bucketName;
	
	public IngredientsService(IngredientsRepository ingredientsRepository) {
		this.ingredientsRepository = ingredientsRepository;
		
	}
	
	//@Cacheable(cacheNames = "getIngredients", key = "'ingredients:page:' + #p0 + ':size:' + #p1", cacheManager = "ingredientCacheManager")
	public IngredientsResponse getList(int page, int size) {
		Pageable pageable = PageRequest.of(page-1, size);
		Page<IngredientsVO> pageResult = ingredientsRepository.findAllByOrderByIngredientsDateDesc(pageable);
		
		List<IngredientsVO> list = pageResult.getContent();
		int totalCount = (int) pageResult.getTotalElements();
		
		Pager pager = new Pager(page, totalCount, size);
		return new IngredientsResponse(list, pager);
	}
	
	@Transactional
	public IngredientsVO input(String ingredeintsName, Integer ingredientsStock, Integer ingredientsPrice, LocalDateTime ingredientsDate) {
		
	    String saveName = null;
	    String originName = null;
		
		IngredientsVO ingredientsVO = new IngredientsVO();
		ingredientsVO.setIngredientsName(ingredeintsName);
		ingredientsVO.setIngredientsStock(ingredientsStock);
		ingredientsVO.setIngredientsPrice(ingredientsPrice);
		ingredientsVO.setIngredientsDate(ingredientsDate);
	    ingredientsVO.setSaveName(saveName);
	    ingredientsVO.setOriginName(originName);
		
		return ingredientsRepository.save(ingredientsVO);

	}

}
