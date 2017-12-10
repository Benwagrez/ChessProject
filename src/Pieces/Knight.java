package Pieces;
public class Knight extends Piece{

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