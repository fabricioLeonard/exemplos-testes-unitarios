package br.com.developeracademy;

public class Calculadora {

    public int multiplicar(int numero1, int numero2) {
        return numero1 * numero2;
    }

    public int subtrair(int numero1, int numero2){
        return numero1 - numero2;
    }

    public int somar(int numero1, int numero2){
        if (numero1 < 0 || numero2 < 0){
            throw new RuntimeException("Não é permitido somar números negativos!");
        }
        return numero1 + numero2;
    }

    public int dividir(int numero1, int numero2) {
        if (numero2 == 0){
            throw new RuntimeException("Não é permitido divisão por zero!");
        }
        return numero1 / numero2;
    }
}
