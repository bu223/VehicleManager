/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * * https://github.com/fangyun/tictactoe/tree/master/src/main/java/com/github/fangyun/tictactoe
 */
package tictactoe;

import java.util.Scanner;

/**
 *
 * @author bernardudu
 */
public class Tictactoe {
	private static Referee ref;
	    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner(System.in);
    	ref = new Referee();
        char firstPlayer = 'O',secondPlayer = 'X';
        int moveCount = 1;
        
        System.out.println("Welcome to Tic-Tac-Toe!");
        ref.initBoard();
        ref.printBoard();
        
        char stillPlaying = '-';
        boolean finishedRound = false;
        do{
        	if(moveCount % 2 == 0){
        		
        		ref.flipPlayer(secondPlayer);
        		moveCount++;
        	}
        	else{
        		
        		ref.flipPlayer(firstPlayer);
        		moveCount++;
        	}
        	ref.printBoard();
        	if(ref.lookupWinning(firstPlayer)){
        		
        		System.out.println("Player: "+ firstPlayer+ " wins!");
        		finishedRound = true;
        	}
        	else if(ref.lookupWinning(secondPlayer)){
        		
        		System.out.println("Congrats! Player "+ secondPlayer+ " is the winner!");
        		finishedRound = true;
        	}
        	else if(moveCount > 9){
        		
        		System.out.println("Game is a draw!");
        		finishedRound = true;
        		}
        	if(finishedRound){
        		
        		System.out.println("Do you want to play again? (y/n)");
        		stillPlaying = scan.next().charAt(0);
        		if(stillPlaying != 'y'){
        			System.out.println("Game Over! Thanks for playing!");
        			System.exit(0);
        			}
        		else{
        			
        			finishedRound = false;
        			moveCount = 1;
        			ref.initBoard();
        	        ref.printBoard();
        	        }
        		}
        	}while(true);
        }
    }

