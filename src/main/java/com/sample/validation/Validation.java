package com.sample.validation;

import com.sample.exeptions.InputException;

public class Validation {

    public static boolean validateText(String text, String type) throws InputException {
        if (text.matches("[A-ZÆØÅ][a-zæøå]*")) {
            return true;
        } else {
            throw new InputException("Ugyldig tekst", type);
        }
    }

    public static boolean validateNumber(String number, String type) throws Exception {
        if (number.matches("[0-9]*")) {
            return true;
        } else {
            throw new InputException("Ugyldig nummer", type);
        }
    }

}
