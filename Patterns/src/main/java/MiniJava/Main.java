package MiniJava;

import MiniJava.facade.ParserFacade;

public class Main {
    public static void main(String[] args) {
        new ParserFacade().compile("src/main/resources/code");
    }
}
