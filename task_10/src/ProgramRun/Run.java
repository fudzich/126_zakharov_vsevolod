package ProgramRun;
import core.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Run {


    public static void main(String[] args){
        ArrayList<Dogovor> ListOfDogovors = new ArrayList<>();
        ArrayList<Payment> ListOfPayments = new ArrayList<>();
        menu();
    }

    public static void menu (){
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
//            switch (i) {
//            }
        }
    }
    public void addDogovor(){

    }
}
