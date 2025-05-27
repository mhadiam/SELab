package facade;

import MiniJava.errorHandler.ErrorHandler;
import MiniJava.parser.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MiniJavaCompiler {
    public void compile(String sourceFilePath) {
        Parser parser = new Parser();
        try {
            parser.startParse(new Scanner(new File(sourceFilePath)));
        } catch (FileNotFoundException e) {
            ErrorHandler.printError(e.getMessage());
        }
    }
}
