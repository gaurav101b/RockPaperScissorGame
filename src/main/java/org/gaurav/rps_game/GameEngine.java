package org.gaurav.rps_game;

import org.gaurav.rps_game.constants.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Scanner;

public class GameEngine {


    private static final Logger logger = LoggerFactory.getLogger(GameEngine.class);

    /**
     * Keeps running new session until the user asks to stop
     */
    public static void main(String[] args) {

        System.out.println(Message.rules);

        Scanner scanner=new Scanner(System.in);

        while(true){
            System.out.println("============================================================");

            GameSession session = new GameSession();

            //Keep playing game until the user wants
            while (true) {
                System.out.println("============================================================");
                session.playGame();

                System.out.print("\nPlay another game? (y/n)  ");
                String input = scanner.nextLine().toLowerCase().trim();

                if (input.equals("n") || input.equals("no"))
                    break;

            }
            session.endSession();

            System.out.print("Start a new session? 'No' will exit the programme (y/n)  ");
            String input = scanner.nextLine().toLowerCase().trim();

            if (input.equals("n") || input.equals("no"))
                break;
        }

//        TODO exit message
    }
}