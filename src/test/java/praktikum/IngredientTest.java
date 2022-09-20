package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class IngredientTest {
    private final String name;
    private final float price;
    private final String type;
    Ingredient ingredient;


    public IngredientTest(String type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;

    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"FILLING", "Котлета", 1390f},
                {"SAUCE", "Кетчуп", 120f},
        };
    }

    @Test
    public void testGetPrice() {
        ingredient = new Ingredient(IngredientType.valueOf(type), name, price);
        assert (price == ingredient.getPrice());
    }

    @Test
    public void testGetName() {
        ingredient = new Ingredient(IngredientType.valueOf(type), name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetType() {
        ingredient = new Ingredient(IngredientType.valueOf(type), name, price);
        assertEquals(IngredientType.valueOf(type), ingredient.getType());
    }

}