package model;

import java.util.ArrayList;

public class BroadGame {
    private  PlayerBroadGame player=new PlayerBroadGame();
    private  ArrayList<Object>   listBroadsCard =new ArrayList<>();

    public BroadGame(){}
    public BroadGame(ArrayList<Object> listCards, PlayerBroadGame playerBroadGame){
        this.listBroadsCard=listCards;
        this.player=playerBroadGame;
    }
    public PlayerBroadGame getPlayer() {
        return player;
    }

    public ArrayList<Object> getCards() {
        return listBroadsCard;
    }


}
