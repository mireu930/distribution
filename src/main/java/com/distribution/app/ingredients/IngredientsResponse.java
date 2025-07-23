package com.distribution.app.ingredients;

import java.util.List;

import com.distribution.app.page.Pager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor  // 기본 생성자 추가
@AllArgsConstructor // 전체 필드를 받는 생성자
public class IngredientsResponse {
	private List<IngredientsVO> list;
	private Pager pager;

}
