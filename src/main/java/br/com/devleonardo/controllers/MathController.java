package br.com.devleonardo.controllers;

import org.springframework.web.bind.annotation.*;

import static br.com.devleonardo.exception.UnsupportedMathOperationException.NUMERIC_VALUE;

@RestController
@RequestMapping("/math")
public class MathController {


    @RequestMapping(path = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedOperationException(NUMERIC_VALUE);
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @GetMapping("/sub/{numberOne}/{numberTwo}")
    public Double subtract(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedOperationException(NUMERIC_VALUE);
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(path = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiply(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedOperationException(NUMERIC_VALUE);
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping(path = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedOperationException(NUMERIC_VALUE);
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping(path = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedOperationException(NUMERIC_VALUE);
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @RequestMapping(path = "/squa/{numberOne}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable String numberOne) throws Exception {
        if (!isNumeric(numberOne)) throw new UnsupportedOperationException(NUMERIC_VALUE);
        Double number = convertToDouble(numberOne);
        return Math.sqrt(number);
    }

    private boolean isNumeric(String strNumber) throws Exception {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedOperationException(NUMERIC_VALUE);
        String number = strNumber.replace(",", ".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }

    private Double convertToDouble(String strNumber) throws Exception {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedOperationException(NUMERIC_VALUE);
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

}
