package tests;

import org.junit.*;
import  core.*;

public class Tests extends Assert {

    @Test
    public void Dogovor_AddNewDogovor_DogovorAmmountEqualsOne(){
        Dogovor dogovor = new Dogovor("1","20211114");
        assertEquals(1, dogovor.getDogovorAmmount());
    }

    @Test
    public void Payment_ChosePaymentGetType_PaymentTypeEqualsOne(){
        Payment payment = new Payment(true);
        assertEquals(true, payment.GetType());
    }
}
