package praktikum;

import org.junit.Test;


public class IngredientTestException {

    @Test(expected = Exception.class)
    public void testCreateIngredientTypeNotValid() {
        Ingredient ingredient = new Ingredient(IngredientType.valueOf("type"), "Бамбук", 10f);
        System.out.println(ingredient);
    }

}
