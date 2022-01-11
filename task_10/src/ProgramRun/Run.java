package ProgramRun;
import core.*;


import java.util.ArrayList;
import java.util.Scanner;

public class Run {

//    static int pNumber, total;
//    static boolean type;
//    static String dNumber, date, dogovorNumber;

    public static void main(String[] args){
        ArrayList<Dogovor> ListOfDogovors = new ArrayList<>();
        ArrayList<Payment> ListOfPayments = new ArrayList<>();
        menu(ListOfDogovors, ListOfPayments);
    }

    public static void menu (ArrayList<Dogovor> ListOfDogovors, ArrayList<Payment> ListOfPayments){
        int i = 1;
        Scanner sc = new Scanner(System.in);
        while(i!= 0) {
            System.out.println("Добро пожаловать в систему учета платежей по договорам\n" +
                    "0 - Выход\n" +
                    "1 - Добавить Договор\n" +
                    "2 - Добавить Платеж\n" +
                    "3 - Поиск всех платежей по договору\n" +
                    "4 - Вычисление суммы всех платежей по договору\n" +
                    "5 - Удаление платежей с заданным номером, номером договора и датой\n" +
                    "6 - Получение списка всех договоров с их суммарными суммами платежей\n" +
                    "7 - Получение списка всех платежей\n" +
                    "8 - Получение списка всех договоров\n");
            i = sc.nextInt();
            switch (i) {
                case 1 -> ListOfDogovors = addDogovor(ListOfDogovors);
                case 2 -> ListOfPayments = addPayment(ListOfPayments);
                case 3 -> searchPaymentsViaDogovor(ListOfPayments);
                case 4 -> findTotalPaymentViaDogovor(ListOfPayments);
                case 5 -> ListOfPayments = deletePaymentViaNumberDNumberAndDate(ListOfPayments);
                case 6 -> showListOfDogovorsWithTotalPayments(ListOfDogovors, ListOfPayments);
                case 8 -> showListOfDogovors(ListOfDogovors);
                case 7 -> showListOfPayments(ListOfPayments);
            }
        }
    }

    private static void showListOfDogovorsWithTotalPayments(ArrayList<Dogovor> listOfDogovors, ArrayList<Payment> listOfPayments) {
        for(int i =0; i < listOfDogovors.size(); i++){
            System.out.println("Договор "+listOfDogovors.get(i).GetNumber()+" : ");
            findTotalPaymentViaDogovorWithoutConsole(listOfDogovors.get(i).GetNumber(), listOfPayments);
        }
    }

    private static ArrayList<Payment> deletePaymentViaNumberDNumberAndDate(ArrayList<Payment> listOfPayments) {
        int paymentNumber = VvodPaymentNumber();
        String dogovorNumber = AddDogovorNumber();
        String date = VvodPaymentdate();
        for(int i=0;i<listOfPayments.size();i++){
            //Payment pay = listOfPayments.get(i);
            if((listOfPayments.get(i).GetDogovorNumber().equals(dogovorNumber)) && (listOfPayments.get(i).GetNumber() == paymentNumber) &&
                    (listOfPayments.get(i).GetDate().equals(date))){
                listOfPayments.remove(i);
            }
        }
        return listOfPayments;
    }

    private static void findTotalPaymentViaDogovorWithoutConsole(String dNumber, ArrayList<Payment> listOfPayments){
        int sum = 0;
        for(int i=0;i<listOfPayments.size();i++){
            if(listOfPayments.get(i).GetDogovorNumber().equals(dNumber)){
                sum = sum + listOfPayments.get(i).GetTotal();
            }
        }
        System.out.println("Сумма платежей по этому договору = "+sum+"\n");

    }

    private static void findTotalPaymentViaDogovor(ArrayList<Payment> listOfPayments) {
        String dNumber = AddDogovorNumber();
        findTotalPaymentViaDogovorWithoutConsole(dNumber, listOfPayments);
    }

    private static void showListOfPayments(ArrayList<Payment> listOfPayments) {
        for(int i =0; i < listOfPayments.size(); i++){
            System.out.println(i + ": " + listOfPayments.get(i).GetNumber()+"\n"+
                    listOfPayments.get(i).GetTotal()+"\n" +
                    listOfPayments.get(i).GetDate()+"\n" +
                    listOfPayments.get(i).GetType()+"\n" +
                    listOfPayments.get(i).GetDogovorNumber()+"\n");
        }
    }

    private static void showListOfDogovors(ArrayList<Dogovor> listOfDogovors) {
        for(int i =0; i < listOfDogovors.size(); i++){
            System.out.println(i + ": " + listOfDogovors.get(i).GetNumber()+"\n"+
                                listOfDogovors.get(i).GetDate()+"\n");
        }
    }

    public static void searchPaymentsViaDogovor(ArrayList <Payment> ListOfPayments){
        String dNumber = AddDogovorNumber();
        System.out.println("Номера всех платежей по договору:\n");
        for(int i=0;i<ListOfPayments.size();i++){
            if(ListOfPayments.get(i).GetDogovorNumber().equals(dNumber)){
                System.out.println(ListOfPayments.get(i).GetNumber() + "\n");
            }
        }
    }

    public static ArrayList addDogovor(ArrayList <Dogovor> ListOfDogovors){
        String dNumber = AddDogovorNumber();
        String date = AddDogovorDate();
        Dogovor dogovor = new Dogovor(dNumber, date);
        ListOfDogovors.add(dogovor);
        return ListOfDogovors;
    }

    private static String AddDogovorNumber(){
        String number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер договора");
        number = sc.nextLine();
        return number;
    }
    private static String AddDogovorDate(){
        String date;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату договора");
        date = sc.nextLine();
        return date;
    }

    public static ArrayList addPayment(ArrayList <Payment> ListOfPayments){
        int total = VvodPaymentTotal();
        int pNumber = VvodPaymentNumber();
        boolean type = VvodPaymentType();
        String dogovorNumber = VvodPaymentDogovorNumber();
        String date = VvodPaymentdate();
        //VvodPayment(total,pNumber,type,dogovorNumber,date);
        Payment payment = new Payment(total, pNumber, type, dogovorNumber, date);
        ListOfPayments.add(payment);
        return ListOfPayments;
    }

    private static String VvodPaymentdate() {
        String date;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату платежа");
        date = sc.nextLine();
        return date;
    }
    private static String VvodPaymentDogovorNumber() {
        String dogovorNumber;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер договора платежа");
        dogovorNumber = sc.nextLine();
        return dogovorNumber;
    }
    private static boolean VvodPaymentType() {
        boolean type = true;
        Scanner sc = new Scanner(System.in);
        boolean oneOrTwo = false;
        while(oneOrTwo == false) {
            System.out.println("Выберите тип платежа:\n" +
                    "1 - Платежное поручение\n" +
                    "2 - Банковский ордер\n");
            int i = sc.nextInt();
            if (i == 1) {
                type = true;
                oneOrTwo = true;
            } else if (i == 2) {
                type = false;
                oneOrTwo = true;
            }
        }
        return type;
    }
    private static int VvodPaymentTotal(){
        int total;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите сумму платежа");
        total = sc.nextInt();
        return total;
    }
    private static int VvodPaymentNumber(){
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер платежа");
        number = sc.nextInt();
        return number;
    }


}
