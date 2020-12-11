package model;

public class Player {
    private int idPlayer;
    private String namePlayer;
    private String address;
    private int pointGame;
    private int idAccount;

    private Player(){};
    public static Player getInstance(){
        return PlayerHelper.INSTANCE;
    }
    private static class PlayerHelper{
        private static  final Player INSTANCE=new Player();
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
}
