package Boards;

public class Board {
	
	Spot[][] boardValues = new Spot[8][8]; 
			
	public Board() {
		
		for(int yfiller = 0; yfiller<8; yfiller++) {
			
			for(int xfiller = 0; xfiller<8; xfiller++) {
				boardValues[yfiller][xfiller] = 0;
			}
			
		}
		
		/*
		 *Fills the board with 0, designating an empty board
		 */
		
	}
	
	/*
	 *A constructor that initialized a new board
	 */
	
	public void boardSetUp() {
		
		boardValues[][] = {2,3,4,5,6,4,3,2};
		
	}
	
	/*
	 *Initializes the board array With a normal board set up
	 */
	
}
