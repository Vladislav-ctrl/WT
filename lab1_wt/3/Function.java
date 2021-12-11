

public class Function {
    private double numberA;
    private double numberB;
    private double numberH;

    public Function() {
        installFields();
    }

    private void installFields() {
        while (true) {
            numberA = InputDouble.getInputDouble("a");
            numberB = InputDouble.getInputDouble("b");
            if (numberB > numberA) {
                break;
            } else {
                System.out.println("b SHOULD BE MORE THAN a");
            }
        }
        numberH = InputDouble.getInputDouble("h");
    }

    public void printTable() {
        System.out.println("----------------------------------");
        System.out.printf("|%s|--------|%s|\n", "Arg", "Value");
        while (numberA <= numberB) {
            System.out.printf("|%s|--------|%s|\n", numberA, calcFunc(numberA));
            numberA = numberA + numberH;
        }
        System.out.println("----------------------------------");
    }

    private double calcFunc(Double arg) {
        return Math.tan(arg);
    }

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    public double getNumberH() {
        return numberH;
    }

    public void setNumberH(double numberH) {
        this.numberH = numberH;
    }
}
