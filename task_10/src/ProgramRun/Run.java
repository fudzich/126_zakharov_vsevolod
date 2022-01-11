package ProgramRun;
import core.*;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedMap;

public class Run {

//    static int pNumber, total;
//    static boolean type;
//    static String dNumber, date, dogovorNumber;

    public static void main(String[] args){
        ArrayList<Dogovor> ListOfDogovors = new ArrayList<>();
        ArrayList<Payment> ListOfPayments = new ArrayList<>();
        int pNumber, total;
        boolean type;
        String dNumber, date;
        menu(ListOfDogovors, ListOfPayments, pNumber, total, type, dNumber,date);
    }

    public static void menu (ArrayList<Dogovor> ListOfDogovors, ArrayList<Payment> ListOfPayments, int pNumber, int total, boolean type, String dNumber, String date){
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
                    "8 - Показать список договоров\n" +
                    "9 - Показать список платежей\n");
            i = sc.nextInt();
            switch (i) {
                case 1-> addDogovor(ListOfDogovors);
                case 2 -> addPayment(ListOfPayments);
                case 3 -> searchPaymentsViaDogovor(ListOfPayments);
                case 8 -> showListOfDogovors(ListOfDogovors);
                case 9 -> showListOfPayments(ListOfPayments);
            }
        }
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
        //String dNumber="";
        AddDogovorNumber(dNumber);
        System.out.println("Номера всех платежей по договору:\n");
        for(int i=0;i<ListOfPayments.size();i++){
            if(ListOfPayments.get(i).GetDogovorNumber().contains(dNumber)){
                System.out.println(ListOfPayments.get(i).GetNumber() + "\n");
            }
        }
    }

    public static void addDogovor(ArrayList <Dogovor> ListOfDogovors){
        //String dNumber="";
        AddDogovorNumber(dNumber);
        //String date="";
        AddDogovorDate(date);
        Dogovor dogovor = new Dogovor(dNumber, date);
        ListOfDogovors.add(dogovor);
    }

    private static void AddDogovorNumber(String number){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номера договора");
        number = sc.nextLine();
    }
    private static void AddDogovorDate(String date){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату договора");
        date = sc.nextLine();
    }

    public static void addPayment(ArrayList <Payment> ListOfPayments){
        //int total=1, pNumber=2; boolean type=true; String dogovorNumber="", date="";
        VvodPayment(total,pNumber,type,dogovorNumber,date);
        Payment payment = new Payment(total, pNumber, type, dogovorNumber, date);
        ListOfPayments.add(payment);
    }

    private static void VvodPayment(int total, int number, boolean type, String dogovorNumber, String date){
        VvodPaymentTotal(total);
        VvodPaymentNumber(number);
        VvodPaymentType(type);
        VvodPaymentDogovorNumber(dogovorNumber);
        VvodPaymentdate(date);
    }

    private static void VvodPaymentdate(String date) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату платежа");
        date = sc.nextLine();
    }
    private static void VvodPaymentDogovorNumber(String dogovorNumber) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер договора платежа");
        dogovorNumber = sc.nextLine();
    }
    private static void VvodPaymentType(boolean type) {
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
    }
    private static void VvodPaymentTotal(int total){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите сумму платежа");
        total = sc.nextInt();
    }
    private static void VvodPaymentNumber(int number){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер платежа");
        number = sc.nextInt();
    }


}
