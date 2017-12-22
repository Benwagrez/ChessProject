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
		 if(color=="White") {
			  if(canCastle=true && fX==6 && fY==7 && !chess.spotValues[7][6].isOccupied() && !chess.spotValues[7][5].isOccupied()) {
				  isKCastling=true;//King side castling
				  return true;
			  } else if(canCastle=true && fX==6 && (fY==1||fY==2) && !chess.spotValues[7][3].isOccupied() && !chess.spotValues[7][2].isOccupied() && !chess.spotValues[7][1].isOccupied()) {
				  isQCastling=true;//Queen side castling
				  return true;
			  }
		  }
		  if(color=="Black") {
			  if(canCastle=true && fX==6 && fY==7 && !chess.spotValues[7][6].isOccupied() && !chess.spotValues[7][5].isOccupied()) {
				  isKCastling=true;//King side castling
				  return true;
			  } else if(canCastle=true && fY==0 && (fX==1||fX==2) && !chess.spotValues[0][3].isOccupied() && !chess.spotValues[0][2].isOccupied() && !chess.spotValues[0][1].isOccupied()) {
				  isQCastling=true;//Queen side castling
				  return true;
			  }
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
