package org.gaurav.rps_game.player;
public abstract class Player {


    private String name;
    private int gamesPlayed;
    private int gamesWon;
    private String move;

    public Player() {
        this.gamesPlayed = 0;
        this.gamesWon = 0;
    }

    public abstract String makeMove();


    public void play(){
        gamesPlayed++;
    }
    public void win(){
        gamesWon++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getGamesLost() {
        return gamesPlayed - gamesWon;
    }
}