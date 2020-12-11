package view;

import controller.AccountController;
import controller.IOFile;
import controller.InputConsole;
import model.Account;
import model.ENUM_STATIC;
import model.Player;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static AccountController accountController= new AccountController();
    private static DisplayConsole displayConsole=new DisplayConsole();
    public static void main(String[] args)throws IOException {
        accountController=new AccountController();
        Account account=new Account();
        while (true){
            menuMain();
            int choice=InputConsole.getIntValue("Choice program: ");
            switch (choice){
                case 0:
                    System.out.println("");
                    displayConsole.displayAfterChoice("Bye bye, see you again ^^");
                    accountController.exit(account);
                    return;
                case 1:
                    Player player=accountController.login(account);
                    if(account.getIdAccount()==1) menuAdmin( account);
                    else menuPlayer(player,account);
                    break;
                default:
                    System.out.println("please try again ");
            }
            menuMain();
        }
    }
    private static void menuMain(){
        System.out.println("");
        System.out.println("Menu :");
        System.out.println("1. Login");
        System.out.println("0. Exit");
        System.out.println("");
    }
    private static void menuAdmin(Account account) throws IOException {
        System.out.println("");
        System.out.println("Menu for Admin");
        System.out.println(ENUM_STATIC.getStringLine());
        System.out.println("1. Create Account");
        System.out.println("2. Delete Account");
        System.out.println("3. Edit Account");
        System.out.println("4. Display Account");
        System.out.println("0. Log out");
        System.out.println("");

        int choice=InputConsole.getIntValue("Choice program: ");
        switch (choice){
            case 0:
                displayConsole.displayAfterChoice("\t\t bye bye "+account.getUserName());
                return;
            case 1:
                Player player=Player.getInstance();
                accountController.createAccount(player);
                break;
            case 2:
                accountController.deleteAccount();
                break;
            case 3:
                accountController.displayAllAccount();
                int IdAccount= InputConsole.getIntValue("Id Account is change: ");
                editAccount(IdAccount);
                break;
            case 4:
                accountController.displayAllAccount();
                break;
            default:
                System.out.println("Please choice program again");
        }
        menuAdmin(account);
    }
    private static void editAccount(int IdAccount) throws IOException {
        System.out.println("Edit account: ");
        System.out.println("1. Reset nameAccount");
        System.out.println("2. Reset PassWord");
        System.out.println("3. Reset State");
        System.out.println("0. Exit ");
        int choice=InputConsole.getIntValue("Choice program: ");
        switch (choice){
            case 0:
                displayConsole.displayAfterChoice("\t\t Menu for admin ");
                return;
            case 1:
                accountController.editNameAccount(IdAccount);
                break;
            case 2:
                accountController.editPassAccount(IdAccount);
                break;
            case 3:
                accountController.editState(IdAccount);
                break;
            default:
                System.out.println(" Please choice program again");
                editAccount(IdAccount);
        }
    }

    private static void menuPlayer(Player player, Account account){
        displayConsole.displayAfterChoice(" Welcome "+ player.getNamePlayer());
        System.out.println("Menu game: ");
        System.out.println("1. Display profile");
        System.out.println("2. Edit profile");
        System.out.println("0. Exit");

        int choice=InputConsole.getIntValue(" Choice program: ");
        switch (choice){
            case 0:
                break;
            case 1:
                displayConsole.displayPlayer(player,account);
                break;
            case 2:
                break;
            default:
                System.out.println("Please choice again ");
        }
        menuPlayer(player,account);
    }
}
