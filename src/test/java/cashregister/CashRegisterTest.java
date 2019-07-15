package cashregister;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CashRegisterTest {

    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
        FakePrinter printer = new FakePrinter();

        CashRegister cashRegister = new CashRegister(printer);

        Item[] items = {new Item("Coffee", 8.0), new Item("egg", 10), new Item("rice", 10)};

        Purchase purchase = new Purchase(items);
        //when
        cashRegister.process(purchase);

        //then
        Assertions.assertTrue(printer.getCalled());
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        FakePrinter printer = new FakePrinter();

        FakePurchase fakePurchase = new FakePurchase();
        fakePurchase.setStringIWant("TEST");

        CashRegister cashRegister = new CashRegister(printer);

        //when
        cashRegister.process(fakePurchase);

        //then
        Assertions.assertEquals("TEST", printer.getPrintMessage());
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        // mock objects
        Printer mockPrinter = mock(Printer.class);
        Purchase mockPurchase = mock(Purchase.class);
        // mock method
        when(mockPurchase.asString()).thenReturn("TEST");

        CashRegister cashRegister = new CashRegister(mockPrinter);
        cashRegister.process(mockPurchase);

        // when & then
        verify(mockPrinter, times(1)).print("TEST");

    }

}
