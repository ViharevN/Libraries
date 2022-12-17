package me.viharev.libraries.services;

import me.viharev.libraries.models.Recipe;
import org.springframework.http.ResponseEntity;

public interface RecipeServices {
    public Integer addRecipe(Recipe recipe);

    public void getRecipe();

    ResponseEntity<Recipe> getRecipeById(Integer idRecipe);

    Recipe editRecipe(Integer idRecipe, Recipe recipe);

    boolean removeRecipe(Integer idRecipe);
}
