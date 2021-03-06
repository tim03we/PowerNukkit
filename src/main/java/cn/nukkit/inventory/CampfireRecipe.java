package cn.nukkit.inventory;

import cn.nukkit.item.Item;

public class CampfireRecipe implements SmeltingRecipe {

    private final Item output;

    private Item ingredient;

    private double experience;

    public CampfireRecipe(Item result, Item ingredient) {
        this(result, ingredient, 0);
    }

    public CampfireRecipe(Item result, Item ingredient, double experience) {
        this.output = result.clone();
        this.ingredient = ingredient.clone();
        this.experience = experience;
    }

    public void setInput(Item item) {
        this.ingredient = item.clone();
    }

    @Override
    public Item getInput() {
        return this.ingredient.clone();
    }

    @Override
    public double getExperience() {
        return experience;
    }

    @Override
    public Item getResult() {
        return this.output.clone();
    }

    @Override
    public void registerToCraftingManager(CraftingManager manager) {
        manager.registerCampfireRecipe(this);
    }

    @Override
    public RecipeType getType() {
        return this.ingredient.hasMeta() ? RecipeType.CAMPFIRE_DATA : RecipeType.CAMPFIRE;
    }
}
