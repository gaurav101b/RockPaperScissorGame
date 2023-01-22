package org.gaurav.rps_game.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BotPlayerTest {
    @Test
    void test(){
        BotPlayer botPlayer = new BotPlayer();

        assertEquals(botPlayer.getGamesPlayed(), 0);
        assertEquals(botPlayer.getGamesWon(), 0);


        botPlayer.play();
        assertEquals(botPlayer.getGamesPlayed(), 1);

        botPlayer.win();
        assertEquals(botPlayer.getGamesWon(), 1);
    }
}