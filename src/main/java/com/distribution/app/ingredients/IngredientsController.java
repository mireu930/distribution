package com.distribution.app.ingredients;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.distribution.app.page.Pager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ingredients")
@Slf4j
public class IngredientsController {

	private final IngredientsService ingredientsService;
	
	@GetMapping("/api/list")
	public  List<IngredientsVO> getList(@RequestParam(name = "nowPage", defaultValue = "1") Long nowPage,
								        @RequestParam(name = "pageSize",defaultValue = "10") Long pageSize,
								        @RequestParam(name = "search",required = false) String search,
								        @RequestParam(name = "kind",required = false) String kind
								        ) throws Exception {
		log.info("react 요청들어옴");
		Pager pager = new Pager();
	    pager.setNowPage(nowPage);
	    pager.setPage(pageSize);
	    pager.setSearch(search);
	    pager.setKind(kind);
	    
	    
	    List<IngredientsVO> list = ingredientsService.getList(pager);
	    
	    log.info("l:{}",list);
	    
		return list;
	}
	
}
