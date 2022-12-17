package me.viharev.libraries.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import me.viharev.libraries.models.Ingredient;
import me.viharev.libraries.services.IngredientServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")
@AllArgsConstructor
@Data
@Tag(name = "Ингредиент контроллер", description = "CRUD-операции с ингредиентами")
public class IngredientController {
    private IngredientServices ingredientServices;

    @GetMapping("/add")
    @Operation(
            summary = "добавляем ингредиент",
            description = "добавляем ингредиент через get-запрос"
    )
    public void addIngredient(@RequestParam Ingredient ingredient) {
        this.ingredientServices.addIngredient(ingredient);
    }

    @GetMapping("/get/{id}")
    @Operation(
            summary = "получаем ингредиент",
            description = "получаем ингредиент по его id"
    )
    public Ingredient getIngredient(@PathVariable Integer id) {
        return this.ingredientServices.getIngredient(id);
    }

    @PostMapping("/ingredient/add")
    @Operation(
            summary = "метод добавления ингредиента",
            description = "добавляем через Post запрос"
    )
    public Ingredient addIngredientInMap(@RequestBody Ingredient ingredient) {
        this.ingredientServices.addIngredient(ingredient);
        return ingredient;
    }

    @PutMapping("/ingredient/edit/{id}")
    @Operation(
            summary = "метод изменения ингредиента",
            description = "изменяем ингредиент через Put метод по его id"
    )
    public Ingredient editIngredient(@PathVariable Integer id, @RequestBody Ingredient ingredient) {
        this.ingredientServices.editIngredient(id, ingredient);
        return ingredient;
    }

    @DeleteMapping("/ingredient/delete/{id}")
    @Operation(
            summary = "удаление ингредиента",
            description = "удаляем ингредиент по его id"
    )
    public boolean deleteIngredient(@PathVariable Integer id) {
        if (this.ingredientServices.removeIngredient(id)) {
            return true;
        }
        return false;
    }

    @GetMapping("/get/all")
    @Operation(
            summary = "получаем ингредиенты",
            description = "получаем все ингредиенты"
    )
    public Ingredient getAllIngredients() {
        return this.ingredientServices.getAllIngredients();
    }
}
