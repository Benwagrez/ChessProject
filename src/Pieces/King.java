package Pieces;

public class King extends Piece{

	public King(String color){
		
		super(color); // Super points toward the abstract Piece class constructor with following parameter : String color;
			
	}
	
	/*
	 *A constructor for King that takes a String input to set the color of the piece.
	 */
	
	
	 public boolean pathValid(int fX, int fY) {
		 
		 if(chess.spotValues[fY][fX].isOccupied()==false) && (pathDraw()==true)
		 return true;
		 else
		 return false;
	 }

	 /*
	  *Checking if the path is valid, using two boolean methods isOccupied and pathDraw
	  */
	  
	  public int[] pathDraw(int iX, int iY,int fX, int fY){
		  int[] Path = new int[1];//Instantiated with purpose of resolving errors - TBD
		  return Path;
	  }
	
}
