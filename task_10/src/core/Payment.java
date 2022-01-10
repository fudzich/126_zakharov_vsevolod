package core;

public class Payment {
    private boolean type;
    // type true = "Платежное поручение", type false = "Банковский ордер"

    public Payment(boolean type){
        this.type = type;
    }

    public boolean GetType(){
        return type;
    }
}
