package Pieces;

public class Bishop extends Piece{

	Public Bishop(String color){
		super(color);	
	}

	/*
	 *A constructor for Bishop that takes a String input to set the color of the piece.
	 */
	
	 public boolean pathValid(int fX, int fY) {
		 
		 return true;
	 }
	  
	  public int[] pathDraw(int iX, int iY,int fX, int fY){
		  int[] Path = new int[1];//Instantiated with purpose of resolving errors - TBD
		  return Path;
	  }
	
}
