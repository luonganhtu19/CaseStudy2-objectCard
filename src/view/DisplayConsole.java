package view;

import controller.InputConsole;
import model.Account;
import model.ENUM_STATIC;
import model.Player;

import java.util.ArrayList;

public class DisplayConsole {
    public DisplayConsole(){}
    public void displayAfterChoice(String mess){
        System.out.println("");
        InputConsole.clearConsole();
        System.out.println(ENUM_STATIC.getStringLine());
        System.out.println(mess);
        System.out.println(ENUM_STATIC.getStringLine());
        System.out.println("");

    }
    public  void displayAfterChoice(String mess,String nameDisplay){
        System.out.println("");
        InputConsole.clearConsole();
        System.out.println(ENUM_STATIC.getStringLine());
        System.out.println(mess);
        System.out.println(nameDisplay);
        System.out.println(ENUM_STATIC.getStringLine());
        System.out.println("");
    }
    public void displayAllAccount(ArrayList<Object> list){
        System.out.println(ENUM_STATIC.getStringLine());
        System.out.printf("IDAccount  |");
        System.out.printf("\t\tUserName      |");
        System.out.printf("\tState  |");
        System.out.println();
        System.out.println(ENUM_STATIC.getStringLine());
        for (int i=0;i<list.size();i++){
            Account account=(Account) list.get(i);
            System.out.printf("%-11d|  ", i+1);
            System.out.printf("%-20s|  ", account.getUserName());
            System.out.printf("%-6s|  ", account.getState());
            System.out.println();
        }
        System.out.println(ENUM_STATIC.getStringLine());
    }
    public void displayPlayer(Player player,Account account){
        System.out.println(ENUM_STATIC.getStringLine());
        System.out.printf("IDPlayer  |");
        System.out.printf("\t\tUserName      |");
        System.out.printf("\tAddress  |");
        System.out.printf("\t PointGame |");
        System.out.println();
        System.out.println(ENUM_STATIC.getStringLine());
            System.out.printf("%-11d|  ", player.getIdPlayer());
            System.out.printf("%-20s|  ", player.getNamePlayer());
            System.out.printf("%-6s|   ", player.getAddress());
            System.out.printf("%-5s|   ", player.getPointGame());
            System.out.println();

        System.out.println(ENUM_STATIC.getStringLine());
    }
}