package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void valuesIngredientType() {
        IngredientType[] values = IngredientType.values();
        assert values.length == 2;
    }

    @Test
    public void valueOfIngredientType_SAUCE() {
        String sauce = String.valueOf(IngredientType.valueOf("SAUCE"));
        assertEquals("SAUCE", sauce);
    }

    @Test
    public void valueOfIngredientType_FILLING() {
        String sauce = String.valueOf(IngredientType.valueOf("FILLING"));
        assertEquals("FILLING", sauce);
    }
}