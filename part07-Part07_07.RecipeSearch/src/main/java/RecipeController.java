import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class RecipeController {
    private ArrayList<Recipe> receipes;

    public RecipeController() {
        this.receipes = new ArrayList<>();
    }

    public void addRecipe(String name, int time, ArrayList<String> ingredients) {
        this.receipes.add(new Recipe(name, time, ingredients));
    }

    public ArrayList<Recipe> getRecipes() {
        return receipes;
    }

    public ArrayList<Recipe> findRecipesByName(String name) {
        ArrayList<Recipe> foundReceipes = new ArrayList<>();

        for (Recipe receipe : this.receipes) {
            if (receipe.getName().contains(name)) {
                foundReceipes.add(receipe);
            }
        }

        return foundReceipes;
    }

    public ArrayList<Recipe> findRecipesByTime(int maxTime) {
        ArrayList<Recipe> foundReceipes = new ArrayList<>();

        for (Recipe receipe : this.receipes) {
            if (receipe.getTime() <= maxTime) {
                foundReceipes.add(receipe);
            }
        }

        return foundReceipes;
    }

    public ArrayList<Recipe> findRecipesByIngredient(String ingredient) {
        ArrayList<Recipe> foundReceipes = new ArrayList<>();

        for (Recipe receipe : this.receipes) {
            if (receipe.getIngredients().contains(ingredient)) {
                foundReceipes.add(receipe);
            }
        }

        return foundReceipes;
    }

}
