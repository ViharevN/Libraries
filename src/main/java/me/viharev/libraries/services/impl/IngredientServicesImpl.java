package me.viharev.libraries.services.impl;

import me.viharev.libraries.models.Ingredient;
import me.viharev.libraries.services.IngredientServices;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
@Service
public class IngredientServicesImpl implements IngredientServices {
    public static Integer id = 0;
    public static Integer counter = 0;
    private final Map<Integer, Ingredient> ingredientMap = new LinkedHashMap<>();
    @Override
    public void addIngredient(Ingredient ingredient) {
        this.ingredientMap.put(id, ingredient);
        id=counter++;
    }

    @Override
    public Ingredient getIngredient(Integer id) {
        for (Ingredient value : ingredientMap.values()) {
            if (value != null) {
                return value;
            }
        }
        return null;
    }
    @Override
    public Ingredient editIngredient(Integer id, Ingredient ingredient) {
        for (Integer integer : ingredientMap.keySet()) {
            if (integer.equals(id)) {
                ingredientMap.put(id, ingredient);
            }
        }
        return null;
    }

    @Override
    public boolean removeIngredient(Integer id) {
        for (Integer integer : ingredientMap.keySet()) {
            if (integer.equals(id)) {
                ingredientMap.remove(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public Ingredient getIngredientById(Integer id) {
        for (Integer integer : ingredientMap.keySet()) {
            if (integer.equals(id)) {
                return ingredientMap.get(id);
            }
        }
        return null;
    }

    @Override
    public Ingredient getAllIngredients() {
        Iterator<Ingredient> iterator = ingredientMap.values().iterator();
        return iterator.next();
    }

}
