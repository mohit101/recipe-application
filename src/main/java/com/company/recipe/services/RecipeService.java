package com.company.recipe.services;

import java.util.List;
import java.util.Optional;


import com.company.recipe.model.Recipe;

public interface RecipeService {

    public Recipe addRecipe(Recipe recipe);
    
    public Recipe getRecipe(long id);

    public void deleteRecipe(long id);

    public Recipe updateRecipe(Recipe recipe);
    
    public List<Recipe> searchRecipeBasedOnCriteria(boolean isVeg,int servingCount,String ingredients,boolean isIngredientInclude,String discription);
    	
}
