package MiniJava.codeGenerator;

public class Immediate extends Address {
    public Immediate(int num, varType varType) {
        super(num, varType);
    }

    public String toString() {
        return "#" + num;
    }
}
