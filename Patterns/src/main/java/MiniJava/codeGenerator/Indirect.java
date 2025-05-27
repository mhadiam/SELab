package MiniJava.codeGenerator;

public class Indirect extends Address {
    public Indirect(int num, varType varType) {
        super(num, varType);
    }

    public String toString() {
        return "@" + num;
    }
}
