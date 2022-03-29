package core;

public class Payment {
    private boolean type;
    // type true = "Платежное поручение", type false = "Банковский ордер"
    private int total;
    private int number;
    private String dogovorNumber;
    private String date;
    private int ammount;

    public Payment(boolean type){
        this.type = type;
    }

    public Payment(int total, int number, boolean type, String dogovorNumber, String date){
        this.total= total;
        this.number = number;
        this.type = type;
        this.dogovorNumber = dogovorNumber;
        this.date = date;
        ammount = 1;
    }

    public boolean GetType(){
        return type;
    }
    public int GetAmmount(){
        return ammount;
    }
    public String GetDogovorNumber(){
        return dogovorNumber;
    }
    public int GetNumber(){
        return number;
    }
    public int GetTotal(){
        return total;
    }
    public String GetDate(){
        return date;
    }
}
