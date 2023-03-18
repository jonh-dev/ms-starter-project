package com.jonhdev.calculator.controller;

import com.jonhdev.calculator.exception.MathOperationException;
import com.jonhdev.calculator.utils.Converter;
import com.jonhdev.calculator.utils.SimpleMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    private SimpleMath math;

    @Autowired
    private Converter converter;

    @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        validateInput(numberOne, numberTwo);
        return math.sum(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
    }

    @GetMapping(value = "/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        validateInput(numberOne, numberTwo);
        return math.subtraction(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
    }

    @GetMapping(value = "/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        validateInput(numberOne, numberTwo);
        return math.multiplication(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
    }

    @GetMapping(value = "/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        validateInput(numberOne, numberTwo);
        return math.division(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
    }

    @GetMapping(value = "/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        validateInput(numberOne, numberTwo);
        return math.average(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
    }

    @GetMapping(value = "/squareRoot/{number}")
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        validateInput(number);
        return math.squareRoot(converter.convertToDouble(number));
    }

    private void validateInput(String number) {
        if (!converter.isNumeric(number)) {
            throw new MathOperationException("Please set a numeric value!");
        }
    }

    private void validateInput(String numberOne, String numberTwo) {
        if (!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
            throw new MathOperationException("Please set a numeric value!");
        }
    }
}
