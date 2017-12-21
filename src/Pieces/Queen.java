package Pieces;

import Boards.Board;

public class Queen extends Piece{
	public boolean enpassantable=false;
	public Queen(Board chess, String color, String name){
		
		super(chess,color,name); // Super points toward the abstract Piece class constructor with following parameter : Board, chessString color; String name;
	}
	
	/*
	 *A constructor for Queen that takes a String input to set the color of the piece.
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
		  int vY = iY, vX = iX;
		  if(fX!=iX) {
			  double slope = ((double)(Math.abs(fY-iY)/Math.abs(fX-iX)));
			  if(slope!=1 || slope!=0){
				  return false;
		  }
		  for(int i = 0; i<((int)(Math.abs(fX-iX)));i++){

			if((fY-iY)>0)//Adjusting variable y coordinate
				vY--;
			else
				vY++;
			if((fX-iX)>0)//Adjusting variable x coordinate
				vX++;
			else
				vX--;

			if(chess.spotValues[vY][vX].isOccupied()==true){
				return false;
			}

		  }

	  }

		  return true;

	  /*
	   *Checking every square in path to see if occupied (If Knight - No check needed)
	   */
	  }
}
