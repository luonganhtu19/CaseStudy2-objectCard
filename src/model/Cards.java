package model;

public class Cards {
    private int     idCard;
    private String  nameCard;
    private int     pointAttack;
    private int     pointDefence;
    private String  effect;

    public Cards(){};
    public Cards(int idCard, String nameCard, int pointAttack, int pointDefence, String effect) {
        this.idCard = idCard;
        this.nameCard = nameCard;
        this.pointAttack = pointAttack;
        this.pointDefence = pointDefence;
        this.effect = effect;
    }

    public int getIdCard() {
        return idCard;
    }
    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }
    public String getNameCard() {
        return nameCard;
    }
    public void setNameCard(String nameCard) {
        this.nameCard = nameCard;
    }
    public int getPointAttack() {
        return pointAttack;
    }
    public void setPointAttack(int pointAttack) {
        this.pointAttack = pointAttack;
    }
    public int getPointDefence() {
        return pointDefence;
    }
    public void setPointDefence(int pointDefence) {
        this.pointDefence = pointDefence;
    }
    public String getEffect() {
        return effect;
    }
    public void setEffect(String effect) {
        this.effect = effect;
    }


    public String myCards() {
        return "Cards{" +
                "idCard=" + idCard +
                ", nameCard='" + nameCard + '\'' +
                ", pointAttack=" + pointAttack +
                ", pointDefence=" + pointDefence +
                ", effect='" + effect + '\'' +
                '}';
    }
    @Override
    public String toString() {
        return ""+ idCard + "," + nameCard + "," + pointAttack +"," + pointDefence;
    }
}
