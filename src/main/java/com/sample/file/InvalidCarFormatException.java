package com.sample.file;

import java.io.IOException;

public class InvalidCarFormatException extends IOException {

    public InvalidCarFormatException(String message) {super(message);}
}