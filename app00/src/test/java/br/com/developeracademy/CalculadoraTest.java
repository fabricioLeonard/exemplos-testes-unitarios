package br.com.developeracademy;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {

    Calculadora calculadora;

    @Before
    public void setUp(){
        //Cenário
        calculadora = new Calculadora();
    }

    @Test(expected = RuntimeException.class)
    public void deveRetornarUmaExceptionDoTipoRuntimeExceptionCasoSejamInformadoOSegundoNumeroIgualAZeroEmUmaOperacaoDeDivisao() {
        int numero1 = -10;
        int numero2 = 0;
        //execução
        int result = calculadora.dividir(numero1, numero2);
        //verificação
    }

    @Test
    public void deveRetornarADivisaoDeDoisNumerosInteiros(){
        int numero1 = 10;
        int numero2 =  5;
        //execução
        int result = calculadora.dividir(numero1, numero2);
        //verificações
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    public void deveRetornarAMultiplicacaoDeDoisNumerosInteiros(){
        int numero1 = 10;
        int numero2 =  5;
        //execução
        int result = calculadora.multiplicar(numero1, numero2);
        //verificações
        Assertions.assertThat(result).isEqualTo(50);
    }

    @Test
    public void deveRetornarASubtracaoDeDoisNumerosInteiros(){
        int numero1 = 10;
        int numero2 =  5;
        //execução
        int result = calculadora.subtrair(numero1, numero2);
        //verificações
        Assertions.assertThat(result).isEqualTo(5);
    }


    @Test(expected = RuntimeException.class)
    public void deveRetornarUmaExceptionDoTipoRuntimeExceptionCasoSejamInformadosNumerosNegativosEmUmaOperacaoDeSoma() {
        int numero1 = -10;
        int numero2 = 5;
        //execução
        int result = calculadora.somar(numero1, numero2);
        //verificação
    }

    @Test
    public void deveRetornarASomaDeDoisNumerosInteiros(){
        int numero1 = 10;
        int numero2 =  5;
        //execução
        int result = calculadora.somar(numero1, numero2);
        //verificações
        Assertions.assertThat(result).isEqualTo(15);
    }

}