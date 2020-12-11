package controller;

import model.ENUM_STATIC;

import java.util.Scanner;

public class InputConsole {
    private Scanner input=new Scanner(System.in);
    public static String getStringValue(String mess){
        System.out.print(mess);
        String valueInput=ENUM_STATIC.getINPUT().nextLine();
        return valueInput;
    }
    public static int getIntValue(String mess){
        int number=-1;
        boolean check=true;
        while (check){
            try {
                System.out.print(mess);
                number=Integer.parseInt(ENUM_STATIC.getINPUT().nextLine());
                check=false;
            }catch (Exception e){
                System.out.println("Please try again "+mess);
            }
        }
        return number;
    }
    public static void clearConsole(){
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }
}
