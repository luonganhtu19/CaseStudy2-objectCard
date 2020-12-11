package controller;

import model.Account;
import model.ENUM_STATIC;
import model.Player;
import view.DisplayConsole;

import java.io.IOException;
import java.util.ArrayList;


public class AccountController {
    private static volatile ArrayList<Object> listAccount = new ArrayList<>();
    private static volatile ArrayList<Object> listPlayer = new ArrayList<>();
    private static IOFile ioFile = new IOFile();
    private static String path = ENUM_STATIC.getPath() + ENUM_STATIC.getFileAccount();
    private static String pathPlayer = ENUM_STATIC.getPath() + ENUM_STATIC.getFilePlayer();
    private static DisplayConsole displayConsole = new DisplayConsole();

    static {
        try {
            listAccount = ioFile.readeFileAccount(path, listAccount);
            listPlayer=ioFile.readeFilePlayer(pathPlayer,listPlayer);
        } catch (IOException e) {
            System.out.println("no exist file");
        }
    }

    public AccountController() {
    }

    public Player login(Account accountUser) throws IOException {
        String accountName = InputConsole.getStringValue("UserName: ");
        String accountPassword = InputConsole.getStringValue("Password: ");
        accountUser.setUserName(accountName);
        accountUser.setPassword(accountPassword);
        boolean check = checkAccountExist(accountUser);
        if (check) {
            displayConsole.displayAfterChoice("\t\t\t Welcome " + accountName);
            Player player = new Player();
            return player;
        } else {
            displayConsole.displayAfterChoice("\t Password or Username is wrong");
        }
        return null;
    }

    private boolean checkAccountExist(Account account) throws IOException {
        for (Object object : listAccount) {
            Account objectAccount = (Account) object;
            if (objectAccount.getUserName().equals(account.getUserName())) {
                if (objectAccount.getPassword().equals(account.getPassword())) {
                    account.setIdAccount(objectAccount.getIdAccount());
                    objectAccount.setState("On");
                    account.setState("On");
                    ioFile.writerFile(path, listAccount, ENUM_STATIC.getSTRING_HEADER_Account());
                    return true;
                } else return false;
            }
        }
        return false;
    }

    public void exit(Account account) throws IOException {
        account.setState("Off");
        for (Object obj : listAccount) {
            Account objAccount = (Account) obj;
            if (account.getIdAccount() == objAccount.getIdAccount()) {
                objAccount.setState("Off");
            }
        }
        ioFile.writerFile(path, listAccount, ENUM_STATIC.getSTRING_HEADER_Account());
    }

    public void createAccount(Player player) throws IOException {
        displayConsole.displayAfterChoice("\t\t Create account: ");
        Account account = new Account();
        do {
            String nameAccount = InputConsole.getStringValue("UserName : ");
            if (checkExitAccountName(nameAccount)) {
                displayConsole.displayAfterChoice("Name Account is Exist. Please try again Create Account");
                continue;
            }
            account.setUserName(nameAccount);
            break;
        } while (true);
        account.setPassword(InputConsole.getStringValue("Password: "));
        account.setState("Off");
        account.setIdAccount(listAccount.size() + 1);
        listAccount.add(account);

        player.setNamePlayer(InputConsole.getStringValue("NamePlayer: "));
        player.setAddress(InputConsole.getStringValue("Address: "));
        player.setIdAccount(listAccount.size());
        player.setPointGame(0);
        player.setIdPlayer(listAccount.size());
        listPlayer.add(player);

        ioFile.writerFile(path, listAccount, ENUM_STATIC.getSTRING_HEADER_Account());
        ioFile.writerFile(pathPlayer, listPlayer, ENUM_STATIC.getSTRING_HEADER_Player());
        displayConsole.displayAfterChoice("Create account success");
    }

    private boolean checkExitAccountName(String nameAccount) {
        for (Object obj : listAccount) {
            Account objAccount = (Account) obj;
            if (objAccount.getUserName().equals(nameAccount)) return true;
        }
        return false;
    }

    public void deleteAccount() throws IOException {
        int idAccount = InputConsole.getIntValue(" Input IDAccount: ");
        if (idAccount<0||idAccount>listPlayer.size()){
            InputConsole.clearConsole();
            displayConsole.displayAfterChoice("Error, id not exist ");
            deleteAccount();
        }
        if (idAccount == 1) displayConsole.displayAfterChoice("Error", "Fail " +
                "because you cannot delete account admin ");
        else {
            int length = listAccount.size();
            listAccount.remove(idAccount - 1);
            listPlayer.remove(idAccount-1);
            for (int i = idAccount - 1; i < length - 1; i++) {
                Account objAccount = (Account) listAccount.get(i);
                Player objPlayer=(Player) listPlayer.get(i);
                objAccount.setIdAccount(i+1);
                objPlayer.setIdAccount(i+1);
                objPlayer.setIdPlayer(i+1);
            }
            ioFile.writerFile(pathPlayer,listPlayer,ENUM_STATIC.getSTRING_HEADER_Player());
            ioFile.writerFile(path, listAccount, ENUM_STATIC.getSTRING_HEADER_Account());
            displayConsole.displayAfterChoice(" \t Delete account is success! ");
        }
    }

    public void editNameAccount(int indexAccount) throws IOException {
        String nameAccount = "";
        boolean check = true;
        do {
            nameAccount = InputConsole.getStringValue("Name Account : ");
            if (checkExitAccountName(nameAccount)) {
                System.out.println("Please try again, name account is exist");
                continue;
            }
            check = false;
        } while (check);
        Account objAccount = (Account) listAccount.get(indexAccount);
        objAccount.setUserName(nameAccount);
        ioFile.writerFile(path, listAccount, ENUM_STATIC.getSTRING_HEADER_Account());
        displayConsole.displayAfterChoice("Change name account success");
    }

    public void editPassAccount(int indexAccount) throws IOException {
        String passwordNew = InputConsole.getStringValue("Input new password: ");
        Account objAccount = (Account) listAccount.get(indexAccount);
        objAccount.setPassword(passwordNew);
        ioFile.writerFile(path, listAccount, ENUM_STATIC.getSTRING_HEADER_Account());
        displayConsole.displayAfterChoice("Reset password account success");
    }

    public void editState(int indexAccount) throws IOException {
        String passwordNew = InputConsole.getStringValue(" Edit state password: ");
        Account objAccount = (Account) listAccount.get(indexAccount);
        objAccount.setPassword(passwordNew);
        ioFile.writerFile(path, listAccount, ENUM_STATIC.getSTRING_HEADER_Account());
        displayConsole.displayAfterChoice("Reset state account success");
    }

    public void editNamePlayer(int indexAccount) throws IOException {
        InputConsole.clearConsole();
        String namePlayer=InputConsole.getStringValue("Name player: ");
        Player player=(Player) listPlayer.get(indexAccount);
        player.setNamePlayer(namePlayer);
        ioFile.writerFile(pathPlayer,listPlayer,ENUM_STATIC.getSTRING_HEADER_Player());
        displayConsole.displayAfterChoice("Change name success");
    }

    public void editAddressPlayer(int indexAccount) throws IOException{
        InputConsole.clearConsole();
        String addressPlayer=InputConsole.getStringValue("Address player: ");
        Player player=(Player) listPlayer.get(indexAccount);
        player.setAddress(addressPlayer);
        ioFile.writerFile(pathPlayer,listPlayer,ENUM_STATIC.getSTRING_HEADER_Player());
        displayConsole.displayAfterChoice("Change name success");
    }

    public void editPointPlayer(int indexAccount) throws IOException {
        InputConsole.clearConsole();
        int point=InputConsole.getIntValue("Point of player: ");
        Player player=(Player) listPlayer.get(indexAccount);
        player.setPointGame(point);
        ioFile.writerFile(pathPlayer,listPlayer,ENUM_STATIC.getSTRING_HEADER_Player());
        displayConsole.displayAfterChoice("Change name success");
    }

    public void displayAllAccount() throws IOException {
        displayConsole.displayAllAccount(listAccount,listPlayer);
    }

    public void infoPlayer(Account account){
        for(Object obj: listPlayer){
            Player player=(Player) obj;
            if(player.getIdAccount()==account.getIdAccount()){
                displayConsole.displayPlayer(player,account);
                return;
            }
        }
    }

    public  static boolean checkIDAccountIsExist(int idAccount){
        if (idAccount>=0&&idAccount<listPlayer.size()+1) return true;
        else return false;
    }
    public int sizeList(){
        return listPlayer.size();
    }
}
