package controller;

import model.*;
import view.DisplayConsole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class ControllerGame {

    private static ArrayList<Object> listCardsData = new ArrayList<>();
    private static ArrayList<Object> listHistory=new ArrayList<>();
    private ArrayList<String> listMyCards = new ArrayList<>();
    private ArrayList<String> listBroadCards = new ArrayList<>();
    private static IOFile ioFile = new IOFile();
    private static String pathCardsData = ENUM_STATIC.getPath() + ENUM_STATIC.getFileCards();
    private static String pathMyData = ENUM_STATIC.getPath() + ENUM_STATIC.getFilePlayer();
    private static String pathHistory = ENUM_STATIC.getPath() + ENUM_STATIC.getFileHistory();
    private static DisplayConsole displayConsole = new DisplayConsole();
    private  HistoryGame historyGame=new HistoryGame();


    static {
        try {
            listCardsData = ioFile.readerListDataCard(ENUM_STATIC.getPath() + ENUM_STATIC.getFileCards(), listCardsData);
            listHistory=ioFile.readerHistory(pathHistory,listHistory);
        } catch (IOException e) {
            System.out.println("Not read file");
        }
    }

    public void prepareGame(int IDPlayer) throws IOException {
        listMyCards = ioFile.readerListMyCard(ENUM_STATIC.getPath() + ENUM_STATIC.getFileMyCard(), listMyCards, IDPlayer);
        displayConsole.showListMyCard(listCardsData, listMyCards);
        choiceCardPlay();
    }

    private void choiceCardPlay() {
        System.out.println("Choice card by id card");
        for (int i = 0; i < 5; i++) {
            System.out.println("");
            int idCard = isExistCardInList("Card " + i + ": ");
            listBroadCards.add(idCard + "");
            System.out.println("List cards choice in play game");
            displayConsole.showListMyCard(listCardsData, listBroadCards);
        }
        displayConsole.showListMyCard(listCardsData, listBroadCards);
    }

    private int isExistCardInList(String mess) {
        boolean check = true;
        int number=-1;
        while (check) {
             number = InputConsole.getIntValue(mess);
            if (listMyCards.indexOf(number+"")==-1){
                System.out.println("Please choice again, you not have card");
                continue;
            }
            if (listBroadCards.indexOf(number+"")!=-1){
                System.out.println("you have chosen, not chosen twice");
                continue;
            }
            check=false;
        }
        return number;
    }
// need add logic more more
    public int playGame(Account account) {
        int HP1=3000;
        int HP2=3000;
        InputConsole.clearConsole();
        int idGame=1;
        if (listHistory.size()!=0) idGame+=1 ;
        for (int i = 0; i < 5; i++) {
            System.out.println("");
            displayConsole.displayBroadGame(HP1,HP2,i+1);
            InputConsole.getIntValue("Choice card: ");
            Cards cards=searchInfoCard(i,listMyCards);
            Cards cardsPC=searchInfoCard(i+20);

            int number=calculatorHPPlayer(cards.getPointAttack(),cardsPC.getPointAttack());
            //not history

            noteHistoryMatch(cards,cardsPC,idGame,i+1,account.getIdAccount(),"");

            //check win
            if (number>0) HP2=HP2-number;
            else HP1=HP1+number;
            displayConsole.menuRoundGame("Round "+i+": ",cards,cardsPC,HP1,HP2 );
            if (HP1<=0) return 0;
            if (HP2<=0) return 1;
        }
        if (HP1>HP2) return 0;
        else if (HP1<HP2) return 1;
        else return -1;
    }

    private int randomCard(int IDPlay){
        Random rc=new Random();
        int indexCardInList=-1;
        if(IDPlay==1){
            indexCardInList=rc.nextInt(5);
            return indexCardInList;
        }else{
            indexCardInList=rc.nextInt(34)+1;
            return indexCardInList;
        }
    }
    public int calculatorHPPlayer(int attackPoint1,int attackPoint2) {
        int resultSubtract=attackPoint1-attackPoint2;
        return resultSubtract;
    }

    public void checkWin(int idWin) {
        if (idWin==1){
            displayConsole.displayAfterChoice("You win");
        }else if (idWin==-1) {
            displayConsole.displayAfterChoice("The results were mixed");
        }else
            displayConsole.displayAfterChoice("You lose");
    }



    private void noteHistoryMatch(Cards playerCard, Cards PC,int IDGame,int indexRound,int IDPlayer,String sumResult) {
        historyGame.setIdGame(IDGame);
        historyGame.setPlayer(IDPlayer+"");
        historyGame.setStep(indexRound);
        historyGame.setIdCard(playerCard.getIdCard());
        historyGame.setIdPCCard(PC.getIdCard());
        historyGame.setSumResult(sumResult);
        listHistory.add(historyGame);
    }
    public void saveHistoryMatch(int idWin) throws IOException {
        int size=listHistory.size();
        HistoryGame his=(HistoryGame) listHistory.get(size-1);
        int idGame=1;
        if (size!=1) idGame=his.getIdGame();
        for (int i = listHistory.size()-1; i >0; i++) {
            HistoryGame historyGame=(HistoryGame) listHistory.get(i);
            if (historyGame.getIdGame()==idGame){
                historyGame.setSumResult(idWin+"");
            }else break;
        }
        ioFile.writerFile(pathHistory,listHistory,ENUM_STATIC.getSTRING_HEADER_History());
    }
    private Cards searchInfoCard(int IDCard){
        Cards cards=new Cards();
        for (Object obj:listCardsData){
            Cards objCard=(Cards) obj;
            if (objCard.getIdCard()==IDCard){
                cards=objCard;
                return  objCard;
            }
        }
        System.out.println(" not exit cards with ID");
        return  null;
    }
    private Cards searchInfoCard(int indexIDCard,ArrayList<String> list){
        int idCards=Integer.parseInt(list.get(indexIDCard));
        Cards cards=new Cards();
        for (Object obj:listCardsData){
            Cards objCard=(Cards) obj;
            if (objCard.getIdCard()==idCards){
                cards=objCard;
                return  objCard;
            }
        }
        System.out.println(" not exit cards with ID");
        return  null;
    }
}
