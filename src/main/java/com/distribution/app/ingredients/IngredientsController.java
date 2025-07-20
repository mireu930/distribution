package com.distribution.app.ingredients;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ingredients/*")
@Slf4j
public class IngredientsController {

	private final IngredientsService ingredientsService;
	
	@GetMapping("list")
	public String getList(Model model) throws Exception {
		log.info("l:{}", ingredientsService.getList());
		model.addAttribute("list", ingredientsService.getList());
		return "ingredients/list";
	}
	
}
