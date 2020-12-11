package model;

public class Player {
    private int idPlayer;
    private String namePlayer;
    private String address;
    private int pointGame;
    private int idAccount;

    public Player(){};
    public Player(int idPlayer,String namePlayer,String address,int pointGame,int idAccount){
        this.idPlayer=idPlayer;
        this.namePlayer=namePlayer;
        this.address=address;
        this.pointGame=pointGame;
        this.idAccount=idAccount;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPointGame() {
        return pointGame;
    }

    public void setPointGame(int pointGame) {
        this.pointGame = pointGame;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    @Override
    public String toString() {
        return ""+ idPlayer + "," + namePlayer  + "," + address + "," + pointGame + "," + idAccount ;
    }
}
