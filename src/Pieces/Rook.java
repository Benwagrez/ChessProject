package Pieces;

public class Rook extends Piece{
	public Rook(String color, String name){
		
		super(color,name); // Super points toward the abstract Piece class constructor with following parameter : String color; String name;
	}
	
	/*
	 *A constructor for Rook that takes a String input to set the color of the piece.
	 */
	
	 public boolean pathValid(int iX, int iY, int fX, int fY) {
		 
		 if(chess.spotValues[fY][fX].isOccupied()==false && (pathDraw(iX,iY,fX,fY)==true))
		 return true;
		 else
		 return false;
	 }

	 /*
	  *Checking if the path is valid, using two boolean methods isOccupied and pathDraw
	  */
	  
	  public boolean pathDraw(int iX, int iY,int fX, int fY){
		 
		 return true;
	  }

	  /*
	   *Checking every square in path to see if occupied (Is Knight - No check needed)
	   */
	
}
