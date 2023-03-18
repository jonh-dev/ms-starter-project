package com.jonhdev.person.utils;

public class SimpleMath {

    /* Soma */

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    /* Subtração */

    public Double subtraction(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    /* Multiplicação */

    public Double multiplication(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    /* Divisão */

    public Double division(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    /* Média */

    public Double average(Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo) / 2;
    }

    /* Raiz Quadrada */

    public Double squareRoot(Double number) {
        return (Double) Math.sqrt(number);
    }

}
