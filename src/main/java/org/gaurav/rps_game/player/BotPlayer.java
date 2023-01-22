package org.gaurav.rps_game.player;

import java.util.Random;

public class BotPlayer extends Player {

    /**
     * create_instance of Bot Player
     */
    public BotPlayer() {
        super();
//        String name = EmojiParser.parseToUnicode(str);

        this.setName("Bot");
    }

    /**
     * Makes a Random move for the bot
     * @return the Move chosen at random
     */
    @Override
    public String makeMove() {
        int randomInt = new Random().nextInt(3);

        String move;
        if(randomInt == 1)  move= "rock";
        if(randomInt == 2)  move= "paper";
        move = "scissor";

        this.setMove(move);
        return move;
    }
}
