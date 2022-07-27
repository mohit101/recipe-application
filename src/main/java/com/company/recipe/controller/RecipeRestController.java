package com.company.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.company.recipe.model.Recipe;
import com.company.recipe.services.RecipeService;
import com.company.recipe.services.RecipeServiceImpl;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeRestController {

	@Autowired
    private RecipeService recipeService;

    
    @PostMapping(value = "/addRecipe")
    public ResponseEntity<Recipe> newRecipe(@RequestBody Recipe recipe) {
    	 recipeService.addRecipe(recipe);
        return  (ResponseEntity) ResponseEntity.status(HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id) {
    	Recipe recipe=recipeService.getRecipe(id);
          ResponseEntity.ok(recipe);
         return ResponseEntity.ok(recipe);

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteRecipe(@PathVariable long id) {
        recipeService.deleteRecipe(id);
        return  (ResponseEntity<String>) ResponseEntity.status(HttpStatus.OK);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Recipe> updateRecipe(@Valid @RequestBody Recipe recipe) {
    	Recipe recipe1=recipeService.updateRecipe(recipe);
        return ResponseEntity.ok(recipe1);

    }

    @GetMapping("/searchRecipe")
    public ResponseEntity<List<Recipe>> searchRecipe(
    		@RequestParam(required = true) boolean isVeg,
    		@RequestParam(required = true) int servingCount,
    		@RequestParam(required = false) String discription,
            @RequestParam(required = false) String ingredients,boolean isIngredientInclude) {
        if (servingCount == 0) {
            return ResponseEntity.badRequest().build();
        }
         List<Recipe> result;
         result = recipeService.searchRecipeBasedOnCriteria(isVeg, servingCount,ingredients,isIngredientInclude,discription);
         return ResponseEntity.ok(result);
    }
}
