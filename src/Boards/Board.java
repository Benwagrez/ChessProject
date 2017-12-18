package Boards;
import Pieces.*;
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
		Bishop bishopW = new Bishop("white", "Bishop");Bishop bishopB = new Bishop("black", "Bishop");
		Pawn pawnW = new Pawn("white", "Pawn");Pawn pawnB = new Pawn("black", "Pawn");
		Rook rookW = new Rook("white", "Rook");Rook rookB = new Rook("black", "Rook");
		Knight knightW = new Knight("white", "Knight");Knight knightB = new Knight("black", "Knight");
		Queen queenW = new Queen("white", "Queen");Queen queenB = new Queen("black", "Queen");
		King kingW = new King("white", "King");King kingB = new King("black", "King");
		//Instantiation of all pieces, both white and black
		
		for(int x = 0; x < 8 ; x++) {
			spotValues[1][x].occupySpot(pawnB);//Setting up the black pawns
			spotValues[7][x].occupySpot(pawnW);//Setting up the white pawns
		}
		
		spotValues[0][0].occupySpot(rookB);spotValues[0][8].occupySpot(rookB);
		spotValues[0][1].occupySpot(knightB);spotValues[0][7].occupySpot(knightB);
		spotValues[0][2].occupySpot(bishopB);spotValues[0][6].occupySpot(bishopB);
		spotValues[0][3].occupySpot(queenB);spotValues[0][4].occupySpot(kingB);
		//Setting up the black side of board
		
		spotValues[8][0].occupySpot(rookW);spotValues[8][8].occupySpot(rookW);
		spotValues[8][1].occupySpot(knightW);spotValues[8][7].occupySpot(knightW);
		spotValues[8][2].occupySpot(bishopW);spotValues[8][6].occupySpot(bishopW);
		spotValues[8][3].occupySpot(queenW);spotValues[8][4].occupySpot(kingW);
		//Setting up the white side of board
	}
	
	/*
	 *Initializes the board array With a normal board set up
	 */
	
}
