package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    private String nameBun = "Лунная";
    private float priceBun = 303.5F;
    private Bun bun;


    @Test
    public void testGetName() {
        bun = new Bun(nameBun, priceBun);
        assertEquals(nameBun, bun.getName());
    }

    @Test
    public void getPrice() {
        bun = new Bun(nameBun, priceBun);
        assert priceBun == bun.getPrice();
    }

}