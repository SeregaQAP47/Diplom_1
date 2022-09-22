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

    @Mock
    private Ingredient ingredient2;

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
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
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
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        int beforeQuantity = burger.ingredients.size();
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.size() < beforeQuantity);
    }

    @Test
    public void testMoveIngredient() {
        burger = new Burger();
        Mockito.when(ingredient.getName()).thenReturn("Кратерная");
        Mockito.when(ingredient2.getName()).thenReturn("Лунная");
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient2.getName(), burger.ingredients.get(0).getName());

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
        Mockito.when(bun.getName()).thenReturn("Rocket");
        Mockito.when(bun.getPrice()).thenReturn(1002F);
        burger.setBuns(bun);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Котлета");
        Mockito.when(ingredient2.getName()).thenReturn("Кетчуп");
        Mockito.when(ingredient.getPrice()).thenReturn(1300F);
        Mockito.when(ingredient2.getPrice()).thenReturn(247F);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        System.out.println(burger.getReceipt());
        assertFalse(burger.getReceipt().isEmpty());
    }
}