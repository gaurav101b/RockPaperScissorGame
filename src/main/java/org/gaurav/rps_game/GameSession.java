package org.gaurav.rps_game;

import org.gaurav.rps_game.player.BotPlayer;
import org.gaurav.rps_game.player.HumanPlayer;
import org.gaurav.rps_game.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameSession {
    private Player botPlayer, humanPlayer;

    private static final Logger logger = LoggerFactory.getLogger(GameSession.class);
    public GameSession() {
        this.botPlayer = new BotPlayer();
        this.humanPlayer = new HumanPlayer();
    }

    public void playGame(){

        try{
            botPlayer.makeMove();
            humanPlayer.makeMove();

            botPlayer.play();
            humanPlayer.play();

            System.out.println("\nBot played " + botPlayer.getMove());
            System.out.println(humanPlayer.getName() + " played " + humanPlayer.getMove() + "\n");

            Rule rule = new Rule();
            Player winner = rule.findWinner(botPlayer, humanPlayer);

            if(winner == null)  tieGame();
            else                winGame(winner, rule);
        }
        catch (Exception e){
            logger.error("Error while playing game ", e);
        }
    }

    private void winGame(Player winner, Rule rule) {
        winner.win();

        System.out.println( rule.msg + "  ; " + winner.getName() + " Won !!!\n");
    }

    private void tieGame() {
        System.out.println( " Game Tied !!!\n");
    }

    public void endSession() {
        System.out.println("You played " + humanPlayer.getGamesPlayed()
                + " games, and won " + humanPlayer.getGamesWon() + " games " +
                "\n Thanks for playing.\n");
    }
}
