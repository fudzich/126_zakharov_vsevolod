package core;

import java.util.HashMap;

public class Dogovor {

    private String number;
    private String date;
    private int ammount;

    public Dogovor(String number, String date){
        this.number = number;
        this.date = date;
        ammount=1;
    }

    public int getDogovorAmmount(){
        return ammount;
    }
    public String GetNumber(){
        return number;
    }
    public String GetDate(){
        return date;
    }
}
