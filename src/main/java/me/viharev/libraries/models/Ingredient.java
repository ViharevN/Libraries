package me.viharev.libraries.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
@NonNull
public class Ingredient {
    private String nameIngredient;
    private Integer quantityOfIngredients;
    private String unit;
}
