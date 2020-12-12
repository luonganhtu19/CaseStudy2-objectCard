package model;

public class HistoryGame {
    private int idGame;
    private String player;
    private int step;
    private int idCard;
    private int idPCCard;
    private int resultStep;
    private String sumResult;

    public HistoryGame(){}
    public HistoryGame(int idGame, String player, int step, int idCard, int idPCCard, int resultStep, String sumResult) {
        this.idGame = idGame;
        this.player = player;
        this.step = step;
        this.idCard = idCard;
        this.idPCCard = idPCCard;
        this.resultStep = resultStep;
        this.sumResult = sumResult;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getIdPCCard() {
        return idPCCard;
    }

    public void setIdPCCard(int idPCCard) {
        this.idPCCard = idPCCard;
    }

    public int getResultStep() {
        return resultStep;
    }

    public void setResultStep(int resultStep) {
        this.resultStep = resultStep;
    }

    public String getSumResult() {
        return sumResult;
    }

    public void setSumResult(String sumResult) {
        this.sumResult = sumResult;
    }


    @Override
    public String toString() {
        return   ""+idGame + "," + player+ ","+ step +
                "," + idCard + "," + idPCCard +
                "," + resultStep + "," + sumResult ;
    }
}
