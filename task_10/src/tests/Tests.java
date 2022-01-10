package tests;

import org.junit.*;
import  core.*;

public class Tests extends Assert {

    public void Dogovor_AddNewDogovor_DogovorAmmountEquelsOne(){
        Dogovor dogovor = new Dogovor();
        dogovor.addNewDogovor("1","20211210");
        assertEquals(1, dogovor.getDogovorAmmount());
    }
}
