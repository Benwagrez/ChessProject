package Pieces;

public class Bishop extends Piece{
	public Bishop(String color, String name){
		super(color,name); // Super points toward the abstract Piece class constructor with following parameter : String color; String name;
	}

	/*
	 *A constructor for Bishop that takes a String input to set the color of the piece.
	 */
	
	 public boolean pathValid(int iX, int iY, int fX, int fY) {
		 if((chess.spotValues[fY][fX].isOccupied()==false) && (pathDraw(iX,iY,fX,fY)==true)) {
			 return true;
		 }
			 return false;
		 }
	 /*
	  *Checking if the path is valid, using two boolean methods isOccupied and pathDraw
	  */
	  
	  public boolean pathDraw(int iX, int iY,int fX, int fY){
		  double slope = ((double)(Math.abs(fY-iY)/Math.abs(fX-iX)));
		  int vY = iY, vX = iX;

		  if(slope!=1){return false;}//Checking if path taken is possible (Bishop - diagonal slope of 1)

		  for(int i = 0; i<((int)(Math.abs(fX-iX)));i++){//Checking path of Bishop

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

		  return true;
	  }

	  /*
	   *Checking every square in path to see if occupied
	   */
	
}
