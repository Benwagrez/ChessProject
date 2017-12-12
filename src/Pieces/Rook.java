package Pieces;

public class Rook extends Piece{

	public Rook(String color){
		
		super(color); // Super points toward the abstract Piece class constructor with following parameter : String color;
		
	}
	
	/*
	 *A constructor for Rook that takes a String input to set the color of the piece.
	 */
	
	 public boolean pathValid(int fX, int fY) {
		 
		 return true;
	 }
	  
	  public int[] pathDraw(int iX, int iY,int fX, int fY){
		  int[] Path = new int[1];//Instantiated with purpose of resolving errors - TBD
		  return Path;
	  }
	
}
