package br.com.alura.tdd;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculadoraTest {

    @Test
    public void shouldSumTwoPositiveNumbers() {
        Calculadora calc = new Calculadora();
        int soma = calc.somar(1, 1);

        Assert.assertEquals(2, soma);
    }

}
