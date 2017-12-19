package Pieces;

public class Pawn extends Piece{
	public Pawn(String color, String name){
		
		super(color,name); // Super points toward the abstract Piece class constructor with following parameter : String color; String name;
	}
	
	/*
	 *A constructor for Pawn that takes a String input to set the color of the piece.
	 */
	
	 public boolean pathValid(int iX, int iY, int fX, int fY) {
		 
		 if(chess.spotValues[fY][fX].isOccupied()==false && (pathDraw(iX,iY,fX,fY)==true)) {
			 return true;
		 } else if(chess.spotValues[fY][fX].isOccupied()==true && pathDraw(iX,iY,fX,fY)==true){

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
			  if(color=="White") {
				  if(iY==1 && (fY==2 || fY==3) && iX==fX) {
					  return true;
				  } else if(iX==fX && fY-iY==1) {
					  return true;
				  }
			  }
			  if(color=="Black") {
				  if(iY==7 && (fY==6 || fY==5) && iX==fX) {
					  return true;
				  } else if(iX==fX && iY-fY==1) {
					  return true;
				  }
		  }
		  return false;
	  }
	
}
