package cashregister;

public class FakePurchase extends Purchase {

    private String printAsString ;

    public FakePurchase() {
    }

    public FakePurchase(Item[] items) {
        super(items);
    }

    @Override
    public String asString() {
        return printAsString;
    }

    public void setStringIWant(String test) {
        this.printAsString = test;
    }
}
