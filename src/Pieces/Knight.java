package Pieces;

import Boards.Board;

public class Knight extends Piece{
	public boolean enpassantable=false;
	public Knight(Board chess, String color, String name){
		
		super(chess,color,name); // Super points toward the abstract Piece class constructor with following parameter : Board, chessString color; String name;
	}
	
	/*
	 *A constructor for Knight that takes a String input to set the color of the piece.
	 */
	
	 public boolean pathValid(int iX, int iY, int fX, int fY) {
		 if(chess.spotValues[fY][fX].isOccupied()==false && (pathDraw(iX,iY,fX,fY)==true)) {
			 return true;
		 }
			 return false;
		 }
	 /*
	  *Checking if the path is valid, using two boolean methods isOccupied and pathDraw
	  */
	  
	  public boolean pathDraw(int iX, int iY,int fX, int fY){
		  if(fX-iX==0){
			  return false;
		  }
		 double slope = ((double)(Math.abs(fY-iY)/Math.abs(fX-iX)));
		 if(slope!=2||slope!=.5){
			 return false;
		 }//Checking if path taken is possible (Knight - diagonal slope of 2 or .5)
		 if((Math.abs(fX-iX))>2||(Math.abs(fY-iY)>2)){
			 return false;
		 }//Checking if change in x and y are over 2 - if so - impossible
	     return true;
	  }

	  /*
	   *Checking every square in path to see if occupied (If Knight - only one checks needed)
	   */
}
