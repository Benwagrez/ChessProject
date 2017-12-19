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
		Bishop bishopW = new Bishop("White", "Bishop");Bishop bishopB = new Bishop("Black", "Bishop");
		Pawn pawnW = new Pawn("White", "Pawn");Pawn pawnB = new Pawn("Black", "Pawn");
		Rook rookW = new Rook("White", "Rook");Rook rookB = new Rook("Black", "Rook");
		Knight knightW = new Knight("White", "Knight");Knight knightB = new Knight("Black", "Knight");
		Queen queenW = new Queen("White", "Queen");Queen queenB = new Queen("Black", "Queen");
		King kingW = new King("White", "King");King kingB = new King("Black", "King");
		//Instantiation of all pieces, both white and black
		
		for(int x = 0; x < 8 ; x++) {
			spotValues[1][x].occupySpot(pawnB);//Setting up the black pawns
			spotValues[6][x].occupySpot(pawnW);//Setting up the white pawns
		}
		
		spotValues[0][0].occupySpot(rookB);spotValues[0][7].occupySpot(rookB);
		spotValues[0][1].occupySpot(knightB);spotValues[0][6].occupySpot(knightB);
		spotValues[0][2].occupySpot(bishopB);spotValues[0][5].occupySpot(bishopB);
		spotValues[0][3].occupySpot(queenB);spotValues[0][4].occupySpot(kingB);
		//Setting up the black side of board
		
		spotValues[7][0].occupySpot(rookW);spotValues[7][7].occupySpot(rookW);
		spotValues[7][1].occupySpot(knightW);spotValues[7][6].occupySpot(knightW);
		spotValues[7][2].occupySpot(bishopW);spotValues[7][5].occupySpot(bishopW);
		spotValues[7][3].occupySpot(queenW);spotValues[7][4].occupySpot(kingW);
		//Setting up the white side of board
	}
	
	/*
	 *Initializes the board array With a normal board set up
	 */
	
}
