package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Referee {
	
    private static char[][] gameBoard = new char[3][3];
 
	public void initBoard(){
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
            	gameBoard[i][j] = '-';
            }
        }
    }
    
	public boolean lookupWinning(char p){
    	
        return findHorizantalWin(p) || findVerticalWin(p) || findDiagonalWin(p);
    }

    public static boolean findHorizantalWin(char p){
    	
    	for (int r = 0; r < 3; r++){
    		if (compareColRows(gameBoard[r][0], gameBoard[r][1], gameBoard[r][2])){
    		return true;
    		}
    	}
    	return false;	
    }
    public static boolean findVerticalWin(char p){
    	
    	for (int c = 0; c < 3; c++){
    		if (compareColRows(gameBoard[0][c], gameBoard[1][c], gameBoard[2][c])){
    		return true;
    		}
    	}
    	return false;
    }
    
    public static boolean findDiagonalWin(char p){
    	
    	return p==gameBoard[0][0]&&gameBoard[0][0]==gameBoard[1][1]&&gameBoard[1][1]==gameBoard[2][2]?true:
    		   p==gameBoard[0][2]&&gameBoard[0][2]==gameBoard[1][1]&&gameBoard[1][1]==gameBoard[2][0];

    }
    public static boolean compareColRows(char c1, char c2, char c3){
		return ((c1!='-')&&(c1==c2)&&(c2==c3));
		}
public void printBoard(){
    	
        System.out.println();
		System.out.println("         0   1   2\n");
		System.out.println("  row0:  " + gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2]);
		System.out.println("       ----|---|---");
		System.out.println("  row1:  " + gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2]);
		System.out.println("       ----|---|---");
		System.out.println("  row2:  " + gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2]);
		System.out.println("         0   1   2\n");
    }
    
    public void flipPlayer(char p){
    	
    	System.out.print("Current Player: " + p + "', enter  a digit for row and press enter, and a digit for column and press enter: " );
    	int i = 0;
    	int j = 0;
    	Scanner scan = new Scanner(System.in);
    	try{
    		i = scan.nextInt();
        	j = scan.nextInt();
    	}catch(InputMismatchException ex){
    		System.out.println("Invalid input::"+ex.getLocalizedMessage());
    	}
		
    	try{

    		gameBoard[i][j] = p;
    		
    	}catch(ArrayIndexOutOfBoundsException exception){
    		System.out.println("Invalid character! Please, enter a digit for row and press enter, and a digit for column and press enter!");
    	}
    }
}
