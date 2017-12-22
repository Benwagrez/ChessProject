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
	
	public void boardSetUp(Board T) {
		Bishop bishopW = new Bishop(T, "White", "Bishop");Bishop bishopB = new Bishop(T, "Black", "Bishop");
		Rook rookW = new Rook(T, "White", "Rook");Rook rookB = new Rook(T, "Black", "Rook");
		Knight knightW = new Knight(T, "White", "Knight");Knight knightB = new Knight(T, "Black", "Knight");
		Queen queenW = new Queen(T, "White", "Queen");Queen queenB = new Queen(T, "Black", "Queen");
		King kingW = new King(T, "White", "King");King kingB = new King(T, "Black", "King");
		//Instantiation of all pieces, both white and black
		Pawn pawnW1 = new Pawn(T, "White", "Pawn");Pawn pawnB1 = new Pawn(T, "Black", "Pawn");
		spotValues[1][0].occupySpot(pawnB1);spotValues[6][0].occupySpot(pawnW1);
		Pawn pawnW2 = new Pawn(T, "White", "Pawn");Pawn pawnB2 = new Pawn(T, "Black", "Pawn");
		spotValues[1][1].occupySpot(pawnB2);spotValues[6][1].occupySpot(pawnW2);
		Pawn pawnW3 = new Pawn(T, "White", "Pawn");Pawn pawnB3 = new Pawn(T, "Black", "Pawn");
		spotValues[1][2].occupySpot(pawnB3);spotValues[6][2].occupySpot(pawnW3);
		Pawn pawnW4 = new Pawn(T, "White", "Pawn");Pawn pawnB4 = new Pawn(T, "Black", "Pawn");
		spotValues[1][3].occupySpot(pawnB4);spotValues[6][3].occupySpot(pawnW4);
		Pawn pawnW5 = new Pawn(T, "White", "Pawn");Pawn pawnB5 = new Pawn(T, "Black", "Pawn");
		spotValues[1][4].occupySpot(pawnB5);spotValues[6][4].occupySpot(pawnW5);
		Pawn pawnW6 = new Pawn(T, "White", "Pawn");Pawn pawnB6 = new Pawn(T, "Black", "Pawn");
		spotValues[1][5].occupySpot(pawnB6);spotValues[6][5].occupySpot(pawnW6);
		Pawn pawnW7 = new Pawn(T, "White", "Pawn");Pawn pawnB7 = new Pawn(T, "Black", "Pawn");
		spotValues[1][6].occupySpot(pawnB7);spotValues[6][6].occupySpot(pawnW7);
		Pawn pawnW8 = new Pawn(T, "White", "Pawn");Pawn pawnB8 = new Pawn(T, "Black", "Pawn");
		spotValues[1][7].occupySpot(pawnB8);spotValues[6][7].occupySpot(pawnW8);
		
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
