package tests;

import org.junit.*;
import  core.*;

public class Tests extends Assert {

    public void DogovorVault_AddNewDogovor_DogovorAmmountEquelsOne(){
        Dogovor dogovor = new Dogovor("1","20211114");
        assertEquals(1, dogovor.getDogovorAmmount());
    }
}
