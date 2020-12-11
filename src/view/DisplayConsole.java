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
    public void displayAllAccount(ArrayList<Object> list,ArrayList<Object> listPlayer){
        System.out.println(ENUM_STATIC.getSTRING_LINE_Account());
        System.out.printf("IDAccount  |");
        System.out.printf("\t\tUserName      |");
        System.out.printf("\tState  |");
        System.out.printf("IDPlayer     |");
        System.out.printf("\t\tUserName        |");
        System.out.printf("\tAddress | ");
        System.out.printf(" PointGame |");
        System.out.println();
        System.out.println(ENUM_STATIC.getSTRING_LINE_Account());
        for (int i=0;i<list.size();i++){
            Account account=(Account) list.get(i);
            Player player=(Player) listPlayer.get(i);
            System.out.printf("%-11d|  ", i+1);
            System.out.printf("%-20s|  ", account.getUserName());
            System.out.printf("%-6s|  ", account.getState());
            System.out.printf("%-11d|  ", player.getIdPlayer());
            System.out.printf("%-20s|  ", player.getNamePlayer());
            System.out.printf("%-9s|   ", player.getAddress());
            System.out.printf("%-9s|   ", player.getPointGame());
            System.out.println();
            System.out.println();
        }
        System.out.println(ENUM_STATIC.getSTRING_LINE_Account());
    }
    public void displayPlayer(Player player,Account account){
        System.out.println(ENUM_STATIC.getSTRING_LINE_Player());
        System.out.printf("IDPlayer  |");
        System.out.printf("\t\tUserName         |");
        System.out.printf("\tAddress   |");
        System.out.printf("\t PointGame|");
        System.out.println();
        System.out.println(ENUM_STATIC.getSTRING_LINE_Player());
            System.out.printf("%-10d|  ", player.getIdPlayer());
            System.out.printf("%-20s|  ", player.getNamePlayer());
            System.out.printf("%-10s|   ", player.getAddress());
            System.out.printf("%-8s|   ", player.getPointGame());
            System.out.println();

        System.out.println(ENUM_STATIC.getSTRING_LINE_Player());
    }
}
