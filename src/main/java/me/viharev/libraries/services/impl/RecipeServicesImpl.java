package me.viharev.libraries.services.impl;

import me.viharev.libraries.models.Recipe;
import me.viharev.libraries.services.RecipeServices;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RecipeServicesImpl implements RecipeServices {
    public static Integer idRecipe = 0;
    private static Map<Integer, Recipe> recipeMap = new LinkedHashMap<>();

    @Override
    public Integer addRecipe(Recipe recipe) {
        this.recipeMap.put(idRecipe, recipe);
        idRecipe++;
        return idRecipe;
    }

    @Override
    public void getRecipe() {
        for (Recipe recipe : recipeMap.values()) {
            System.out.println(recipe.toString());
        }
    }

    @Override
    public ResponseEntity<Recipe> getRecipeById(Integer idRecipe) {
        for (Recipe value : recipeMap.values()) {
            if (recipeMap.containsKey(idRecipe)) {
                return ResponseEntity.ok(value);
            }
        }
        return null;
    }

    @Override
    public Recipe editRecipe(Integer idRecipe, Recipe recipe) {
        for (Recipe value : recipeMap.values()) {
            if (recipeMap.containsKey(idRecipe)) {
                recipeMap.put(idRecipe, recipe);
                return recipe;
            }
        }
        return null;
    }
    @Override
    public boolean removeRecipe(Integer idRecipe) {
        for (Recipe value : recipeMap.values()) {
            if (recipeMap.containsKey(idRecipe)) {
                recipeMap.remove(idRecipe);
                return true;
            }
        }
        return false;
    }
}
