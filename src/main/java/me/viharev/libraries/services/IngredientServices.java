package me.viharev.libraries.services;

import me.viharev.libraries.models.Ingredient;
import org.springframework.http.ResponseEntity;

public interface IngredientServices {
    public void addIngredient(Ingredient ingredient);

    public Ingredient getIngredient(Integer id);

    Ingredient editIngredient(Integer id, Ingredient ingredient);

    boolean removeIngredient(Integer id);

    ResponseEntity<Ingredient> getIngredientById(Integer id);

    Ingredient getAllIngredients();
}
