package com.company.recipe.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.recipe.model.Recipe;
import com.company.recipe.repository.RecipeRepository;
import com.company.recipe.util.RecipeNotFoundException;

import java.util.List;
import java.util.Optional;


@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipes;

    @Override
    public Recipe addRecipe(Recipe recipe) {
        return recipes.save(recipe);
    }

    @Override
    public Recipe getRecipe(long id) {
    	Optional<Recipe> recipe= recipes.findById(id);
    	if(recipe.isPresent()==false) {
            throw new RecipeNotFoundException();
    	}
		return recipe.get();
    }

    @Override
    public void deleteRecipe(long id) {
        if (!recipes.existsById(id)) {
            throw new RecipeNotFoundException();
        }
        recipes.deleteById(id);
    }

    @Transactional
    @Override
    public Recipe updateRecipe(Recipe recipe) {
    	if(recipe.getId()!=0) {
        Recipe toUpdate = getRecipe(recipe.getId());
        toUpdate.setName(recipe.getName());
        toUpdate.setVeg(recipe.isVeg());
        toUpdate.setIngredients(recipe.getIngredients());
        toUpdate.setDiscription(recipe.getDiscription());
        Recipe recipe2=recipes.save(toUpdate);
        return recipe2;

    }else{
        throw new RecipeNotFoundException();
    }}
    
    public List<Recipe> searchRecipeBasedOnCriteria(boolean isVeg,int servingCount,String ingredients,boolean isIngredientInclude,String discription) {
    	if(ingredients== null && discription==null) {
        return recipes.findAllByIsVegAndServingCount(isVeg,servingCount);
    	}else if(ingredients!= null && discription==null) {
    		return recipes.findAllByIsVegAndServingCountAndIngredient(isVeg, servingCount,ingredients,isIngredientInclude);
    	}else {
    		return recipes.findAllByIsVegAndServingCountAndIngredientAndDiscription(isVeg, servingCount,ingredients,isIngredientInclude,discription);
    	}
    }
}
