package com.distribution.app.ingredients;

import java.util.List;

import com.distribution.app.page.Pager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class IngredientsResponse {
	private List<IngredientsVO> list;
	private Pager pager;

}
