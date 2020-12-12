package view;

import controller.InputConsole;
import model.Account;
import model.Cards;
import model.ENUM_STATIC;
import model.Player;

import java.util.ArrayList;

public class DisplayConsole {
    public DisplayConsole() {
    }

    public void displayAfterChoice(String mess) {
        System.out.println("");
        InputConsole.clearConsole();
        System.out.println(ENUM_STATIC.getStringLine());
        System.out.println(mess);
        System.out.println(ENUM_STATIC.getStringLine());
        System.out.println("");

    }

    public void displayAfterChoice(String mess, String nameDisplay) {
        System.out.println("");
        InputConsole.clearConsole();
        System.out.println(ENUM_STATIC.getStringLine());
        System.out.println(mess);
        System.out.println(nameDisplay);
        System.out.println(ENUM_STATIC.getStringLine());
        System.out.println("");
    }

    public void displayAllAccount(ArrayList<Object> list, ArrayList<Object> listPlayer) {
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
        for (int i = 0; i < list.size(); i++) {
            Account account = (Account) list.get(i);
            Player player = (Player) listPlayer.get(i);
            System.out.printf("%-11d|  ", i + 1);
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

    public void displayPlayer(Player player, Account account) {
        InputConsole.clearConsole();
        System.out.println(ENUM_STATIC.getSTRING_LINE_Player());
        System.out.printf("IDPlayer  |");
        System.out.printf("\t\tUserName         |");
        System.out.printf("\tAddress   |");
        System.out.printf("\t PointGame|");
        System.out.printf("\t Account name |");
        System.out.printf("Account password| ");
        System.out.println();
        System.out.println(ENUM_STATIC.getSTRING_LINE_Player());
        System.out.printf("%-10d|  ", player.getIdPlayer());
        System.out.printf("%-20s|  ", player.getNamePlayer());
        System.out.printf("%-10s|   ", player.getAddress());
        System.out.printf("%-8s|   ", player.getPointGame());
        System.out.printf("%-12s|   ", account.getUserName());
        System.out.printf("%-13s|   ", account.getPassword());
        System.out.println();
        System.out.println(ENUM_STATIC.getSTRING_LINE_Player());
    }

    public void displayGame() {
        System.out.println(ENUM_STATIC.getSTRING_LINE_Player());
        InputConsole.clearConsole();
        System.out.println("Game Start");
        System.out.println(ENUM_STATIC.getSTRING_LINE_Player());
        System.out.println("---------------------BroadGame----------------------");
    }

    public void displayBroadGame(int HP1,int HP2,int round) {
        System.out.println("                  Round "+ round);
        System.out.println(ENUM_STATIC.getSTRING_LINE_Player());
        System.out.println("|Player                                                            PC                 |");
        System.out.println("|1. Cards one                                                      1.Cards one        |");
        System.out.println("|                                                                                     |");
        System.out.println("|                                                                                     |");
        System.out.println("|                                                                                     |");
        System.out.println("|2. Cards two                                                      2.Cards two        |");
        System.out.println("|                                                                                     |");
        System.out.println(ENUM_STATIC.getSTRING_LINE_Player());
        System.out.println("|Info player in game                                                                  |");
        System.out.printf("|HP %d                                                           HP: %d           |", HP1, HP2);
        System.out.println("");
        System.out.println(ENUM_STATIC.getSTRING_LINE_Player());
        System.out.println("|  Choice Menu of Player:                                                             |");
        System.out.println("|1. Choice card 1                                                                     |");
        System.out.println("|2. Choice card 2                                                                     |");
        System.out.println(ENUM_STATIC.getSTRING_LINE_Player());
//        System.out.println("|   State of card:                                                                    |");
//        System.out.println("|1. Attack                                                                            |");
//        System.out.println("|2. Defence                                                                           |");
//        System.out.println(ENUM_STATIC.getSTRING_LINE_Player());
    }

    public void showListMyCard(ArrayList<Object> listData, ArrayList<String> myList) {
        for (String i : myList) {
            int idCard = Integer.parseInt(i);
            for (Object obj : listData) {
                Cards objCards=(Cards) obj;
                if (objCards.getIdCard()==idCard){
                    System.out.println(objCards.myCards());
                    continue;
                }
            }
        }
    }

    public void menuRoundGame(String mess,Cards cardsPlayer, Cards cardsPC, int HP1, int HP2){
        System.out.println(ENUM_STATIC.getSTRING_LINE_Player());
        System.out.println("     Player                                                       PC                 ");
        System.out.println("                                1. Information                                       ");
        System.out.printf("NameCard:%-20s                                   NameCard:%-20s      ",
                                            cardsPlayer.getNameCard(),cardsPC.getNameCard());
        System.out.println("");
        System.out.printf(" Point Attack:%5d                                             Point Attack:%5d ",
                                            cardsPlayer.getPointAttack(),cardsPC.getPointAttack());
        System.out.println("");
        System.out.printf(" Point Defence:%d                                            Point Defence:%d ",
                                             cardsPlayer.getPointDefence(),cardsPC.getPointDefence());
        System.out.println("");
        System.out.println(ENUM_STATIC.getSTRING_LINE_Player());
        System.out.println("|Info player in game                                                                    |");
        System.out.printf("|HP %d                                                           HP: %d             |", HP1, HP2);
        System.out.println("");
        System.out.println(ENUM_STATIC.getSTRING_LINE_Player());
    }



}
