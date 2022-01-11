package ProgramRun;
import core.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedMap;

public class Run {


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
                    "7 - Получение списка всех платежей\n");
            i = sc.nextInt();
            switch (i) {
                case 1-> addDogovor(ListOfDogovors);
                case 2 -> addPayment(ListOfPayments);
            }
        }
    }
    public static void addDogovor(ArrayList <Dogovor> ListOfDogovors){
        String number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номера договора");
        number = sc.nextLine();
        String date;
        System.out.println("Введите дату договора");
        date = sc.nextLine();
        Dogovor dogovor = new Dogovor(number, date);
        ListOfDogovors.add(dogovor);
    }

    public static void addPayment(ArrayList <Payment> ListOfPayments){
        int total=1, number=1;
        boolean type=true;
        String dogovorNumber="", date="";
        VvodPayment(total,number,type,dogovorNumber,date);
        Payment payment = new Payment(total, number, type, dogovorNumber, date);
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
