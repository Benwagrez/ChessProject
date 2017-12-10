package Boards;

public class Board {
	
	int[][] boardValues = new int[8][8]; 
			
	public Board() {
		
		for(int yfiller = 0; yfiller<8; yfiller++) {
			for(int xfiller = 0; xfiller<8; xfiller++) {
				boardValues[y][x] = 0;
			}
		}
		//ben is hawt
		
	}
	
}
