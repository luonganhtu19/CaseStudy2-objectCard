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

        boolean check =true;
        while (check){
            menuMain();
            accountController=new AccountController();
            Account account=new Account();
            int choice=InputConsole.getIntValue("Choice program: ");
            switch (choice){
                case 0:
                    System.out.println("");
                    displayConsole.displayAfterChoice("Bye bye, see you again ^^");
                    accountController.exit(account);
                    return;
                case 1:
                    Player player=accountController.login(account);
                    if(account.getIdAccount()==1) menuAdmin(account);
                    else if (player.getIdAccount()==-1){
                        break;
                    }else menuPlayer(player,account);
                    break;
                default:
                    System.out.println("");
                    System.out.println(" Please try again ");
                    System.out.println("");
            }
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
                account=new Account();
                return;
            case 1:
                Player player=new Player();
                accountController.createAccount(player);
                break;
            case 2:
                accountController.deleteAccount();
                break;
            case 3:
                accountController.displayAllAccount();
                boolean check=true;
                int IdAccount=0;
                while (check) {
                    IdAccount = InputConsole.getIntValue("Id Account is change: ")-1;
                    if (IdAccount<-1|| IdAccount>=accountController.sizeList()) {
                        InputConsole.clearConsole();
                        displayConsole.displayAfterChoice("Error, because not exist id");
                    }
                    check=false;
                }
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
        System.out.println("4. Edit name of player");
        System.out.println("5. Edit address of player");
        System.out.println("6. Edit point of player");
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
            case 4:
                accountController.editNamePlayer(IdAccount);
                break;
            case 5:
                accountController.editAddressPlayer(IdAccount);
                break;
            case 6:
                accountController.editPointPlayer(IdAccount);
                break;
            default:
                System.out.println(" Please choice program again");
                editAccount(IdAccount);
        }
        editAccount(IdAccount);
    }

    private static void menuPlayer(Player player, Account account) throws IOException {
        System.out.println("Menu game: ");
        System.out.println("1. Display profile");
        System.out.println("2. Edit profile");
        System.out.println("0. Logout");

        int choice=InputConsole.getIntValue(" Choice program: ");
        switch (choice){
            case 0:
                displayConsole.displayAfterChoice("bye bye ");
                return;
            case 1:
                accountController.infoPlayer(account);
                break;
            case 2:
                editPlayer(player,account);
                break;
            default:
                System.out.println("");
                System.out.println(" Please choice again ");
                System.out.println("");
        }
        menuPlayer(player,account);
    }
    private static void editPlayer( Player player, Account account) throws IOException {
        displayConsole.displayAfterChoice("Menu edit player");
        System.out.println("1. Edit Name");
        System.out.println("2. Edit Address");
        System.out.println("3. Edit Name Account");
        System.out.println("4. Edit password");
        System.out.println("0. Exit edit program");
        int choice=InputConsole.getIntValue("Choice menu: ");
        int indexAccount=account.getIdAccount()-1;
        switch (choice){
            case 0:
                displayConsole.displayAfterChoice("Menu player");
                return;
            case 1:
                accountController.editNamePlayer(indexAccount);
                break;
            case 2:
                accountController.editAddressPlayer(indexAccount);
                break;
            case 3:
                accountController.editNameAccount(indexAccount);
                displayConsole.displayAfterChoice("Please try again login");
                return;
            case 4:
                accountController.editPassAccount(indexAccount);
                displayConsole.displayAfterChoice("Please try again login");
                break;
            default:
                System.out.println("Please try again.");
        }
        editPlayer(player,account);
    }
}
