package model;
public
 class PlayerBroadGame extends Player {
    private int idPlayer;
    private static int HP=3000;
    private static int amountCards=5;
    public PlayerBroadGame(){}
    public PlayerBroadGame(int idPlayer){
        this.idPlayer=idPlayer;
    }
    @Override
    public int getIdPlayer() {
        return idPlayer;
    }
    @Override
    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }
    public int getHP() {
        return HP;
    }
    public void updateHP(int point){
        if (point<0) this.HP-=point;
    }
    public void countCard(){
        amountCards-=1;
    }

    public static int getAmountCards() {
        return amountCards;
    }
}
