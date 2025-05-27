package MiniJava.facade;

import MiniJava.parser.Rule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RuleFacade {
    private final ArrayList<Rule> rules;

    public RuleFacade(String source) {
        rules = new ArrayList<>();
        try {
            for (String stringRule : Files.readAllLines(Paths.get(source))) {
                rules.add(new Rule(stringRule));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Rule> getRules() {
        return rules;
    }
}
