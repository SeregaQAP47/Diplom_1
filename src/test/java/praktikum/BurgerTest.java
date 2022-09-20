package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    Ingredient ingredient_1 = new Ingredient(IngredientType.SAUCE, "Соус", 100f);
    Ingredient ingredient_2 = new Ingredient(IngredientType.FILLING, "Мясо", 99f);


    @Test
    public void testSetBunsCheckSentValue() {
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
    }

    @Test
    public void test_SetBuns() {
        burger = new Burger();
        bun = new Bun("Лунная", 1002F);
        burger.setBuns(bun);
        assertEquals("Лунная", burger.bun.name);
    }

    @Test
    public void addIngredient_burgerIngredientsNotEmpty() {
        burger = new Burger();
        burger.addIngredient(ingredient_1);
        burger.addIngredient(ingredient_2);
        assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void testAddIngredientMethodCall() {

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Mockito.verify(burger, Mockito.times(3)).addIngredient(ingredient);
    }

    @Test
    public void removeIngredient() {
        burger = new Burger();
        burger.addIngredient(ingredient_1);
        burger.addIngredient(ingredient_2);
        int beforeQuantity = burger.ingredients.size();
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.size() < beforeQuantity);
    }

    @Test
    public void testMoveIngredient() {
        burger = new Burger();
        burger.addIngredient(ingredient_1);
        burger.addIngredient(ingredient_2);
        burger.moveIngredient(0,1);
       assertEquals(ingredient_2.name,burger.ingredients.get(0).getName());

    }

    @Test
    public void testGetPrice() {
        burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(40f);
        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn(130f);
        burger.addIngredient(ingredient);
        float sum = (bun.getPrice() * 2) + ingredient.getPrice();

        assert burger.getPrice() == sum;
    }

    @Test
    public void getReceipt() {
        burger = new Burger();
        bun = new Bun("Rocket", 1002F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient_1);
        burger.addIngredient(ingredient_2);
        System.out.println(burger.getReceipt());
        assertFalse(burger.getReceipt().isEmpty());
    }
}