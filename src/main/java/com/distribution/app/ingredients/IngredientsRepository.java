package com.distribution.app.ingredients;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends JpaRepository<IngredientsVO, Integer> {
	Page<IngredientsVO> findAllByOrderByIngredientsDateDesc(Pageable pageable);

}
