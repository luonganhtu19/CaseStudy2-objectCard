package model;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public final class   ENUM_STATIC {
    private final static Scanner INPUT = new Scanner(System.in);
    private final static String path = "dataBase/";
    private final static String fileAccount="ListAccount.csv";
    private final static String filePlayer="ListPlayer.csv";
    private final static String fileHistory="HistoryGame.csv";
    private final static String fileMyCard="ListMyCard.csv";
    private final static String fileBroadCard="ListBroadCards.csv";

    private final static String fileCards="ListCardData.csv";

    private final static String COMMA_DELIMITER=",";
    private final static String NEW_LINE_SEPARATOR="\n";
    private final static String STRING_HEADER_Account="IDAccount,UserName,Password,State";
    private final static String STRING_HEADER_Player="IdPlayer,NamePlayer,Address,PointGame,IdAccount";
    private final static String STRING_HEADER_History="idGame,player,step,idCards,idCardPC,resultStep,SumResult";
    private final static String STRING_HEADER_BroadCard="idGame,idPlayer,listIDCardsUse,....";
    private final static String STRING_HEADER_MyCard="idPlayer,idCard,idCard,.......";
    private final static String STRING_HEADER_Card="idCard,nameCard,pointAttack,pointDefence,state";

    private final static String STRING_LINE_Account="--------------------------------------------------------------------------------------------------------";
    private final static String STRING_LINE= "---------------------------------------------";
    private final static String STRING_LINE_Player="--------------------------------------------------------------------------------------------";


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

    public static String getSTRING_LINE_Account() {
        return STRING_LINE_Account;
    }

    public static String getSTRING_LINE_Player() {
        return STRING_LINE_Player;
    }
    public static String getFileCards() {
        return fileCards;
    }

    public static String getSTRING_HEADER_History() {
        return STRING_HEADER_History;
    }

    public static String getSTRING_HEADER_BroadCard() {
        return STRING_HEADER_BroadCard;
    }

    public static String getSTRING_HEADER_MyCard() {
        return STRING_HEADER_MyCard;
    }

    public static String getFileHistory() {
        return fileHistory;
    }

    public static String getFileMyCard() {
        return fileMyCard;
    }

    public static String getFileBroadCard() {
        return fileBroadCard;
    }
}

