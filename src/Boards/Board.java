package Boards;
import Pieces.*;
//test LPHs eclipse juno
public class Board {
	
	public Spot[][] spotValues = new Spot[8][8]; 
			
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
		Rook rook = new Rook();
		Knight knight = new Knight();
		Queen queen = new Queen();
		King king = new King();
		for(int x = 0; x < 8 ; x++) {
			spotValues[1][x].occupySpot(pawn, "black");
			spotValues[7][x].occupySpot(pawn, "white");
		}
		spotValues[0][0].occupySpot(rook, "black");spotValues[0][8].occupySpot(rook, "black");
		spotValues[0][1].occupySpot(knight, "black");spotValues[0][7].occupySpot(knight, "black");
		spotValues[0][2].occupySpot(bishop, "black");spotValues[0][6].occupySpot(bishop, "black");
		spotValues[0][3].occupySpot(queen, "black");spotValues[0][4].occupySpot(king, "black");
		
		spotValues[8][0].occupySpot(rook, "white");spotValues[8][8].occupySpot(rook, "white");
		spotValues[8][1].occupySpot(knight, "white");spotValues[8][7].occupySpot(knight, "white");
		spotValues[8][2].occupySpot(bishop, "white");spotValues[8][6].occupySpot(bishop, "white");
		spotValues[8][3].occupySpot(queen, "white");spotValues[8][4].occupySpot(king, "white");
		
	}
	
	/*
	 *Initializes the board array With a normal board set up
	 */
	
}
