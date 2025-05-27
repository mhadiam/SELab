package MiniJava.facade;

import MiniJava.errorHandler.ErrorHandler;
import MiniJava.parser.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParserFacade {
    private final Parser parser;

    public ParserFacade() {
        this.parser = new Parser();
    }

    public void compile(String source) {
        try {
            parser.startParse(new Scanner(new File(source)));
        } catch (FileNotFoundException e) {
            ErrorHandler.printError(e.getMessage());
        }
    }
}
