package Pieces;
public class Knight extends Piece{

	public Knight(String color){
		
		super(color); // Super points toward the abstract Piece class constructor with following parameter : String color;
		
	}
	
	/*
	 *A constructor for Knight that takes a String input to set the color of the piece.
	 */
	
	 public boolean pathValid(int fX, int fY) {
		 
		 return true;
	 }
	  
	  public int[] pathDraw(int iX, int iY,int fX, int fY){
		  int[] dest;
		  if(chess.spotValues[fY][fX].isOccupied()) {
			  dest= new int[]{iX,iY};
		  } else {
			  dest= new int[]{fX,fY};
		  }
		  return dest;
	  }
}
