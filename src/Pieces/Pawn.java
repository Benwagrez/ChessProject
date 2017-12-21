package Pieces;
import Boards.*;
public class Pawn extends Piece{
	public boolean enpassantable=false;
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
		 if(chess.spotValues[fY][fX].isOccupied()==false && (pathDraw(tempiX,tempiY,tempfX,tempfY)==true)) {
			 enpassantable=true;
			 return true;
		 } else if(chess.spotValues[fY][fX].isOccupied()==true && pathDraw(tempiX,tempiY,tempfX,tempfY)==true){

			        if(iX + 1 == fX || iX - 1 == fX ){
			            //one spot to the right or left
			            if(color == "White"){
			                if(iY + 1 == fY){
			                    return true;
			                }
			            }else{
			                if(iY - 1 == fY ){
			                    return true;
			                }
			            }
			        }
		 }
		 return false;
}

	  public boolean pathDraw(int iX, int iY,int fX, int fY){
		  	  boolean occ;
			  if(color=="White") {
				  occ=chess.spotValues[5][fX].isOccupied();
				  if(iY==2 && fY-iY==2 && iX==fX && !occ) {
					  return true;
				  } else if(iX==fX && fY-iY==1) {
					  return true;
				  }
			  }
			  if(color=="Black") {
				  occ=chess.spotValues[2][fX].isOccupied();
				  if(iY==7 && iY-fY==2 && iX==fX && !occ) {
					  return true;
				  } else if(iX==fX && iY-fY==1) {
					  return true;
				  }
		  }
		  return false;
	  }
	
}
