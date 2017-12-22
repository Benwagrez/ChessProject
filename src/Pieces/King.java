package Pieces;

import Boards.Board;

public class King extends Piece{
	public boolean enpassantable=false;
	public boolean canCastle=true;
	public boolean doingEnPassant=false;
	public King(Board chess, String color, String name){
		
		super(chess,color,name); // Super points toward the abstract Piece class constructor with following parameter : Board, chessString color; String name;
	}
	
	/*
	 *A constructor for King that takes a String input to set the color of the piece.
	 */
	
	
	 public boolean pathValid(int iX, int iY, int fX, int fY) {
		 if(chess.spotValues[fY][fX].isOccupied()==false && pathDraw(iX,iY,fX,fY)) {
			 canCastle=false;
			 return true;
		 }	 
		 if(chess.spotValues[fY][fX].isOccupied()==true && !chess.spotValues[iY][iX].piece.color.equals(chess.spotValues[fY][fX].piece.color) && pathDraw(iX,iY,fX,fY)) {
			 canCastle=false;
			 return true;
		 }
		 return false;
	 }

	 /*
	  *Checking if the path is valid, using two boolean methods isOccupied and pathDraw
	  */
	  
	  public boolean pathDraw(int iX, int iY,int fX, int fY){
		  if((Math.abs(fX-iX))>1||(Math.abs(fY-iY)>1)){
			  return false;
		  }//Checking if change in x and y are over 1 - if so - impossible
		  return true;
	  }

	  /*
	   *Checking every square in path to see if occupied (If King - limited checks)
	   */
	
}
