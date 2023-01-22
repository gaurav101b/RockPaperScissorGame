package org.gaurav.rps_game;

import org.gaurav.rps_game.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rule {

    public String msg;
    private static final Logger logger = LoggerFactory.getLogger(Rule.class);

    public Player findWinner(Player p1, Player p2) {
        Player winner = whoWon(p1, p2);

        if(winner == null)  return null;

        if(winner.equals(p1)){
            msg = p1.getMove() + " beats " + p2.getMove();
        }
        if(winner.equals(p2)){
            msg = p2.getMove() + " beats " + p1.getMove();
        }

        return winner;
    }

    private Player whoWon(Player p1, Player p2){

        try{
            String move1 = p1.getMove();
            String move2 = p2.getMove();

            if (move1.equals(move2)) {
                return null;
            }

            if (move1.equals("rock")) {
                if (move2.equals("paper")) return p2;
                else return p1;
            }
            if (move1.equals("paper")) {
                if (move2.equals("scissor")) return p2;
                else return p1;
            }
            if (move1.equals("scissor")) {
                if (move2.equals("rock")) return p2;
                else return p1;
            }

            return null;
        }
        catch (Exception e){
            logger.error("Error while finding the winner", e);
            return null;
        }
    }
}
