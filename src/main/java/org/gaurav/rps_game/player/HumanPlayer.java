package org.gaurav.rps_game.player;

import org.gaurav.rps_game.GameSession;
import org.gaurav.rps_game.constants.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player{

    private static final Logger logger = LoggerFactory.getLogger(HumanPlayer.class);
    /**
     * create_instance Human Player, taking name as a Inout form the user
     * Default name is "Human"
     */
    public HumanPlayer() {
        super();

        Scanner scanner=new Scanner(System.in);
        System.out.print("\n\nHey there, Please enter your name : ");

        String name = scanner.nextLine().trim();

        if(name.equals("")){
            System.out.println("\nFine, I'll call you 'Human' ");
            name = "Human";
        }

        this.setName(name);
    }

    /**
     * Implementation for Human Player
     * Takes the input form user, and parses it to the corresponding move
     * @return The move chosen by the User
     */
    @Override
    public String makeMove() {
        Scanner scanner=new Scanner(System.in);
        String move;

        while(true){

            try{
                System.out.print("Enter you move : ");

                move = scanner.nextLine()
                        .toLowerCase()
                        .trim();

                move = parseMove(move);

                if (!isValidMove(move)) {
                    System.out.println("Not a valid move !! \n"
                            + Message.rules);
                } else {
                    break;
                }
            }
            catch (Exception e){
                logger.error("Error while getting move form the user", e);
            }
        }

        this.setMove(move);
        return move;
    }

    private String parseMove(String move) {
        if(move.equals("1") || move.equals("r"))  return "rock";
        if(move.equals("2") || move.equals("p"))  return "paper";
        if(move.equals("3") || move.equals("s"))  return "scissor";

        return move;
    };

    private boolean isValidMove(String move) {
        List<String> validMoves = Arrays.asList(
            "rock", "paper", "scissor"
        );

        return validMoves.contains(move);
    }
}
