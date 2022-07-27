package com.company.recipe;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.recipe.model.Recipe;
import com.company.recipe.services.RecipeServiceImpl;

@SpringBootTest
class RecipeApplicationTests {

	@Autowired
	private RecipeServiceImpl recipeService;
	
	private int recipeId=1;
	
	@Test
	public void saveRecipeTest() {
		Recipe recipe = getRecipeMock();
		Recipe recipeNew = recipeService.addRecipe(recipe);
		Assertions.assertThat(recipeNew.getId()).isGreaterThan(0);
	}

	@Test
	public void getRecipeTest() {
		Recipe recipe = getRecipeMock();
		Recipe recipeNew = recipeService.getRecipe(recipeId);
		Assertions.assertThat(recipeNew.getId()).isEqualTo(1L);
	}

	@Test
	public void updateRecipeTest() {

		Recipe recipe = recipeService.getRecipe(recipeId);
		recipe.setIngredients("Onion");
		recipeService.updateRecipe(recipe);
		Recipe recipeNew = recipeService.getRecipe(recipeId);
		Assertions.assertThat(recipeNew.getIngredients()).isEqualTo("Onion");

	}

	@Test
	public void deleteRecipeTest() {
		
		Recipe recipe = recipeService.getRecipe(recipeId);
		recipeService.deleteRecipe(recipe.getId());
		Assertions.assertThat(recipe).isNull();
	}

	public Recipe getRecipeMock() {

		Recipe recipe = new Recipe();
		recipe.setName("Pizza");
		recipe.setVeg(true);
		recipe.setServingCount(5);
		recipe.setIngredients("Patato");
		recipe.setIgredientsInclude(true);
		recipe.setDiscription("Oven");
		return recipe;
	}

}
