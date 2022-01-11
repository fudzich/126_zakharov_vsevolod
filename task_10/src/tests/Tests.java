package tests;

import org.junit.*;
import  core.*;
import ProgramRun.Run;

import java.util.ArrayList;

public class Tests extends Assert {

    @Test
    public void Dogovor_AddNewDogovor_DogovorAmmountEqualsOne(){
        Dogovor dogovor = new Dogovor("1","20211114");
        assertEquals(1, dogovor.getDogovorAmmount());
    }

    @Test
    public void Payment_ChosePaymentType_PaymentTypeEqualsOne(){
        Payment payment = new Payment(true);
        assertEquals(true, payment.GetType());
    }
    @Test
    public void Payment_ChosePaymentType_PaymentTypeEqualsZero(){
        Payment payment = new Payment(false);
        assertEquals(false, payment.GetType());
    }

    @Test
    public void Payment_CreatePaymentWithTotalPlusNumberPlusTypePlusDogovorNumberPlusDate_PaymentAmmountEqualsOne(){
        Payment payment = new Payment(100, 1, true, "1", "20211030");
        assertEquals(1, payment.GetAmmount());
    }
}
