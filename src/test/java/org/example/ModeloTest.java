package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ModeloTest {

    private Modelo modelo;

    @Before
    public void setUp() {
        modelo = new Modelo();
    }

    @Test
    public void testSumar() {
        assertEquals(5.0, modelo.sumar(2, 3), 0.001);
    }

    @Test
    public void testRestar() {
        assertEquals(1.0, modelo.restar(3, 2), 0.001);
    }

    @Test
    public void testMultiplicar() {
        assertEquals(6.0, modelo.multiplicar(2, 3), 0.001);
    }

    @Test
    public void testDividir() {
        assertEquals(2.0, modelo.dividir(6, 3), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDividirPorCero() {
        modelo.dividir(5, 0);
    }
}
