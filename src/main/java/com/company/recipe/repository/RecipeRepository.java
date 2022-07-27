package com.company.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.company.recipe.model.Recipe;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {


	@Query(value = "select * from recipe where is_veg=:isVeg and serving_count=:servingCount",nativeQuery=true)
	List<Recipe> findAllByIsVegAndServingCount(@Param("isVeg") boolean isVeg, @Param("servingCount") int servingCount);
	
	
	@Query(value = "select * from recipe where is_veg=:isVeg and serving_count=:servingCount and ingredients=:ingredients and is_ingredient_include=:isIngredientInclude",nativeQuery=true)
	List<Recipe> findAllByIsVegAndServingCountAndIngredient(@Param("isVeg") boolean isVeg, @Param("servingCount") int servingCount,
			@Param("ingredients") String ingredients, @Param("isIngredientInclude") boolean isIngredientInclude);
	
	
	@Query(value = "select * from recipe where is_veg=:isVeg and serving_count=:servingCount and ingredients=:ingredients and is_ingredient_include=:isIngredientInclude and discription=:discription",nativeQuery=true)
	List<Recipe> findAllByIsVegAndServingCountAndIngredientAndDiscription(@Param("isVeg") boolean isVeg, @Param("servingCount") int servingCount,
			@Param("ingredients") String ingredients, @Param("isIngredientInclude") boolean isIngredientInclude,@Param("discription") String discription);
	
}
