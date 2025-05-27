package MiniJava.facade;

import MiniJava.parser.ParseTable;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ParseTableFacade {
    private ParseTable parseTable;

    public ParseTableFacade(String source) {
        try {
            parseTable = new ParseTable(Files.readAllLines(Paths.get(source)).get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ParseTable getParseTable() {
        return parseTable;
    }
}
