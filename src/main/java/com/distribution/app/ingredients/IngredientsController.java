package com.distribution.app.ingredients;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.distribution.app.page.Pager;

import io.awspring.cloud.s3.S3Operations;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ingredients")
@Slf4j
public class IngredientsController {

	private final IngredientsService ingredientsService;
	
	@GetMapping
	public  IngredientsResponse getList( @RequestParam(name = "page",defaultValue = "1")int page, @RequestParam(name = "size",defaultValue = "10")int size
								        ) throws Exception {
		log.info("react 요청들어옴");
		log.info("page={}, size={}", page, size);
	    	    
		return ingredientsService.getList(page, size);
	}
	
	@PostMapping
	public ResponseEntity<IngredientsVO>  add(@RequestBody IngredientsRequest request) throws Exception {
		 IngredientsVO board = ingredientsService.input(
			        request.getIngredientsName(),
			        request.getIngredientsStock(),
			        request.getIngredientsPrice(),
			        request.getIngredientsDate(),
			        request.getImage()
			    );
			    
			    return ResponseEntity.ok().body(board);
	};
	
}
