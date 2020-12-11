package model;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public final class   ENUM_STATIC {
    private final static Scanner INPUT = new Scanner(System.in);
    private final static String path = "dataBase/";
    private final static String fileAccount="ListAccount.csv";
    private final static String filePlayer="ListPlayer.csv";
    private final static String COMMA_DELIMITER=",";
    private final static String NEW_LINE_SEPARATOR="\n";
    private final static String STRING_HEADER_Account="IDAccount,UserName,Password,State";
    private final static String STRING_HEADER_Player="IdPlayer,NamePlayer,Address,PointGame,IdAccount";
    private final static String STRING_LINE="----------------------------------------------------";


    public static Scanner getINPUT() {
        return INPUT;
    }
    public static String getPath() {
        return path;
    }
    public static String getFileAccount() {
        return fileAccount;
    }
    public static String getNewLineSeparator() {
        return NEW_LINE_SEPARATOR;
    }
    public static String getCommaDelimiter() {
        return COMMA_DELIMITER;
    }
    public static String getSTRING_HEADER_Account() {
        return STRING_HEADER_Account;
    }
    enum State{
        ON,OFF,DEL,SYS;
    }
    public static String getStringLine() {
        return STRING_LINE;
    }

    public static String getFilePlayer() {
        return filePlayer;
    }

    public static String getSTRING_HEADER_Player() {
        return STRING_HEADER_Player;
    }
}

