package Boards;
import Pieces.*;

public class Board {
	
	Spot[][] spotValues = new Spot[8][8]; 
			
	public Board() {
		
		for(int xfiller = 0; xfiller<8; xfiller++) {
			
			for(int yfiller = 0; yfiller<8; yfiller++) {
				Spot temp = new Spot(xfiller,yfiller);
				spotValues[xfiller][yfiller] = temp;
			}
			
		}
		
		/*
		 *Fills the board with null pieces, designating an empty board
		 */
		
	}
	
	/*
	 *A constructor that initialized a new board
	 */
	
	public void boardSetUp() {
		Bishop bishop = new Bishop();
		Pawn pawn = new Pawn();
		for(int x = 0; x < 8 ; x++) {
			spotValues[1][x].occupySpot(pawn);
			spotValues[7][x].occupySpot(pawn);
		}
		
		
		
	}
	
	/*
	 *Initializes the board array With a normal board set up
	 */
	
}
