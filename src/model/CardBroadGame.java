package model;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class CardBroadGame {
    private static ArrayList<Object> listCardBroad=new ArrayList<>();
    private static String stateCards="";


    public ArrayList<Object> getListCardBroad() {
        return listCardBroad;
    }

    public void setListCardBroad(Card card) {
        listCardBroad.add(card);
    }

    public String getStateCards() {
        return stateCards;
    }

    public void setStateCards(String stateCards) {
        this.stateCards = stateCards;
    }
}
