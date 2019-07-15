package cashregister;

public class FakePrinter extends Printer {

    private boolean isCalled = false;

    private String printMessage;

    @Override
    public void print(String printThis) {
        isCalled = true;
        printMessage = printThis;
        System.out.println(printThis);
    }

    public boolean getCalled() {
        return this.isCalled;
    }

    public String getPrintMessage() {
        return printMessage;
    }
}
