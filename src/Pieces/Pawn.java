package Pieces;
import Boards.*;
public class Pawn extends Piece{
	public boolean enpassantable=false;
	public boolean doingEnPassant=false;
	public Pawn(Board chess, String color, String name){
		
		super(chess,color,name); // Super points toward the abstract Piece class constructor with following parameter : Board, chessString color; String name;
	}
	
	/*
	 *A constructor for Pawn that takes a String input to set the color of the piece.
	 */
	
	 public boolean pathValid(int iX, int iY, int fX, int fY) {
		 int tempiX = iX;
		 int tempiY = 8-iY;
		 int tempfX = fX;
		 int tempfY = 8-fY;
		 //Checks if pawn can move there
		 if(chess.spotValues[fY][fX].isOccupied()==false && pathDraw(tempiX,tempiY,tempfX,tempfY)) {
			 return true;
		 } /*Checks if pawn can take the piece*/
		 else if(chess.spotValues[fY][fX].isOccupied()==true && !chess.spotValues[iY][iX].piece.color.equals(chess.spotValues[fY][fX].piece.color) && pathDraw(tempiX,tempiY,tempfX,tempfY)){
			 return true;
		 } //Checks if pawn can take the piece via en passant
		 else if(chess.spotValues[iY][fX].isOccupied()==true && chess.spotValues[fY][fX].isOccupied()==false && !chess.spotValues[iY][iX].piece.color.equals(chess.spotValues[iY][fX].piece.color) && pathTake(tempiX,tempiY,tempfX,tempfY)){
			 doingEnPassant=true;
			 return true;
		 }
		 return false;
}
	 //Checks if moving there is legal
	  public boolean pathDraw(int iX, int iY,int fX, int fY){
		  	  boolean occ;
			  if(color=="White") {
				  occ=chess.spotValues[5][fX].isOccupied();
				  if(iY==2 && fY-iY==2 && iX==fX && !occ) {
					  enpassantable=true;
					  return true;
				  } else if(iX==fX && fY-iY==1) {
					  return true;
				  }
			  }
			  if(color=="Black") {
				  occ=chess.spotValues[2][fX].isOccupied();
				  if(iY==7 && iY-fY==2 && iX==fX && !occ) {
					  enpassantable=true;
					  return true;
				  } else if(iX==fX && iY-fY==1) {
					  return true;
				  }
		  }
		  return false;
	  }
	  //Checks if taking is legal
	  public boolean pathTake(int iX, int iY,int fX, int fY){
	  	  boolean occ;
		  if(color=="White") {
			  //Checks if taking piece as normally is legal
			  if((iX-fX==1 || fX-iX==1) && iX!=fX) {
				  return true;
			  } //Checks if taking piece as en passant is legal
			  else if((iX-fX==1 || fX-iX==1) && chess.spotValues[iY][fX].piece.enpassantable) {
				  return true;
			  }
		  }
		  if(color=="Black") {
			  //Checks if taking piece as normally is legal
			  if((iX-fX==1 || fX-iX==1) && iY-fY==1 && iX!=fX) {
				  enpassantable=true;
				  return true;
			  } //Checks if taking piece as en passant is legal
			  else if((iX-fX==1 || fX-iX==1) && chess.spotValues[iY][fX].piece.enpassantable) {
				  return true;
			  }
	  }
	  return false;
  }
	
}
