package Boards;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChessGame extends JFrame implements MouseListener, MouseMotionListener {
	  private static final long serialVersionUID = 1L;//Serial ID for unique chess games-
	  private JLayeredPane layeredPane;
	  private JPanel chessBoard;
	  private JLabel chessPiece = null;
	  private JLabel takenchessPiece = null;
	  private Point delta = null;
	  private JPanel[][] JPanelGridLayout = new JPanel[8][8];
	  private int iX = -1;
	  private int iY = -1;
	  private int fX = -1;
	  private int fY = -1;
	  private String turn="White";
	  public Board newGame = new Board();//Instantiate Board object w/ spots
	  
	  public ChessGame(){
	  newGame.boardSetUp(newGame);
	  Dimension boardSize = new Dimension(600, 600);//Instantiate Visual representation of Board.
	  //  Use a Layered Pane for this this application
	  layeredPane = new JLayeredPane();
	  getContentPane().add(layeredPane);
	  layeredPane.setPreferredSize(boardSize);
	  layeredPane.addMouseListener(this);
	  layeredPane.addMouseMotionListener(this);
	 
	  //Add a chess board to the Layered Pane 
	 
	  chessBoard = new JPanel();
	  layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
	  chessBoard.setLayout( new GridLayout(8, 8) );
	  chessBoard.setPreferredSize( boardSize );
	  chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
	  JLabel Vpiece = new JLabel();
	  boolean flag=false;
      for (int j = 0; j < 8; j++) {
			if(j%2==0)
			flag=false;
			else if(j%2==1)
			flag=true;
			for(int i=0;i<8;i++){
			          JPanel square = new JPanel( new BorderLayout() );
			          chessBoard.add( square );
			          JPanelGridLayout[j][i] = square;
			if(flag==true)
			          square.setBackground( i % 2 == 0 ? Color.darkGray : Color.white );
			          else
			              square.setBackground( i % 2 == 0 ? Color.white : Color.darkGray );
			          
		      if(newGame.spotValues[j][i].piece!=null)
		      {
		        switch(newGame.spotValues[j][i].piece.name){
		          case "Bishop":
		        	  if(newGame.spotValues[j][i].piece.color.equals("White"))
		        		  Vpiece = new JLabel( new ImageIcon("resource/BishopW.png") );
		        	  else
		        		  Vpiece = new JLabel( new ImageIcon("resource/BishopB.png") );
		          break;
		          
		          case "King":
		        	  if(newGame.spotValues[j][i].piece.color.equals("White"))
		        		  Vpiece = new JLabel( new ImageIcon("resource/KingW.png" ));
		        	  else
		        		  Vpiece = new JLabel( new ImageIcon("resource/KingB.png" ));
		          break;
		          
		          case "Queen":
		        	  if(newGame.spotValues[j][i].piece.color.equals("White"))
		        		  Vpiece = new JLabel( new ImageIcon("resource/QueenW.png") );
		        	  else
		        		  Vpiece = new JLabel( new ImageIcon("resource/QueenB.png") );
		          break;
		
		          case "Pawn":
		        	  if(newGame.spotValues[j][i].piece.color.equals("White"))
		        		  Vpiece = new JLabel( new ImageIcon("resource/PawnW.png") );
		        	  else
		        		  Vpiece = new JLabel( new ImageIcon("resource/PawnB.png") );
		          break;
		
		          case "Rook":
		        	  if(newGame.spotValues[j][i].piece.color.equals("White"))
		        		  Vpiece = new JLabel( new ImageIcon("resource/RookW.png") );
		        	  else
		        		  Vpiece = new JLabel( new ImageIcon("resource/RookB.png") );
		          break;
		
		          case "Knight":
		        	  if(newGame.spotValues[j][i].piece.color.equals("White"))
		        		  Vpiece = new JLabel( new ImageIcon("resource/KnightW.png") );
		        	  else
		        		  Vpiece = new JLabel( new ImageIcon("resource/KnightB.png") );
		          break;
		        }
		        square.add(Vpiece);
		      }
	      }
      }
    }
 
  
 
	  public void mousePressed(MouseEvent e){
		  Point p = e.getPoint();
	      Component c = chessBoard.getComponentAt(p);
	      // find out which square was clicked
	      for (int rank = 0; rank < newGame.spotValues.length; rank++) {
	         for (int file = 0; file < newGame.spotValues[rank].length; file++) {
	            if (JPanelGridLayout[rank][file] == c) {
	 
	               // the jPanelSquares are derived from JPanel but have a 
	               // few of their own methods.  This checks to see if it holds a piece
	               if (newGame.spotValues[rank][file].piece != null) {
	                  chessPiece = (JLabel)((JPanel)c).getComponent(0);
	                  iY = rank;
	                  iX = file;
	 
	                  // remove piece from square and add to layered pane's drag layer
	                  JPanelGridLayout[rank][file].remove(chessPiece);
	                  layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
	 
	                  // center piece over mouse
	                  int x = p.x - chessPiece.getWidth()/2;
	                  int y = p.y - chessPiece.getHeight()/2;
	                  chessPiece.setLocation(x, y);
	                   
	                  delta = new Point(p.x - x, p.y - y);
	                  chessBoard.revalidate();
	                  layeredPane.repaint();
	                  return;
	               }
	            }
	         }
	      }
	       
	      // no piece found
	      iY = -1;
	      iX = -1;
		  }
	 
	  //Move the chess piece around
	  public void mouseDragged(MouseEvent me) {
		  if (chessPiece == null) { //checks if square is blank or not
			  return;
		  }
		  Point p = me.getPoint();
	         int x = p.x - delta.x;
	         int y = p.y - delta.y;
	         chessPiece.setLocation(x, y);
	         layeredPane.revalidate();
	         layeredPane.repaint();	
	         }
		 
		  //Drop the chess piece back onto the chess board
	  public void mouseReleased(MouseEvent e) {
		  if (chessPiece != null) {
		         // find the square that we've released over
		         Component c = chessBoard.getComponentAt(e.getPoint());
		         for (int rank = 0; rank < newGame.spotValues.length; rank++) {
			         for (int file = 0; file < newGame.spotValues[rank].length; file++) {
			            if (JPanelGridLayout[rank][file] == c) {
			 
			               // the jPanelSquares are derived from JPanel but have a 
			               // few of their own methods.  This checks to see if it holds a piece
			                  fY = rank;
			                  fX = file;
			 
			                  // remove piece from square and add to layered pane's drag layer
			               }
			            }
			         }
		         
		         // no matter what happens, the layered pane loses the piece
		         layeredPane.remove(chessPiece);  
		 
		         // if released off of board grid or move is not valid
		         boolean canMove=newGame.spotValues[iY][iX].piece.pathValid(iX,iY,fX,fY);
		         if (c == null || !canMove) {
		            // return piece to original square
		        	 JPanelGridLayout[iY][iX].add(chessPiece);
		         } else {
		            // otherwise add to new square
		   		  if(newGame.spotValues[iY][iX].piece.color==turn) {
		   			  if(newGame.spotValues[fY][fX].piece!=null) {
			   			  	takenchessPiece = (JLabel)((JPanel)c).getComponent(0);
			   			  	JPanelGridLayout[fY][fX].remove(takenchessPiece);
		   			  }
		            	((JPanel)c).add(chessPiece);
		            	newGame.spotValues[fY][fX].occupySpot(newGame.spotValues[iY][iX].piece);
		            	newGame.spotValues[iY][iX].piece=null;
		            	if(turn=="White"){
		            		turn="Black";
		            	} else if(turn=="Black") {
		            		turn="White";
		            	}
		            	if(/*newGame.spotValues[iY][iX].piece.doingEnPassant &&*/ newGame.spotValues[iY][iX].piece.name=="Pawn"){
		            		takenchessPiece=(JLabel)((JPanel)c).getComponent(0);
		            		JPanelGridLayout[iY][fX].remove(takenchessPiece);
			            	newGame.spotValues[iY][fX].piece=null;
		            	}
		   		  } else {
		   			  JPanelGridLayout[iY][iX].add(chessPiece);
		   			  }
		   		  for(int x = 0; x < 8; x++) {
		   			  for(int y = 0; y < 8; y++) {
		   				  if(newGame.spotValues[x][y].isOccupied() && newGame.spotValues[x][y].piece.enpassantable==true) {
		   					  newGame.spotValues[x][y].piece.enpassantable=false;
		   				  }
		   			  }
		   		  }
		   		  }
		         // re-initialize things
		         chessPiece = null;
		         delta = null;
		          
		         iY = -1;
		         iX = -1;
		          
		         chessBoard.revalidate();
		         layeredPane.repaint();
		  
		  }
	  }
	  		/*
	  		 * 
	  		 * 
	  		 * 
	  		 */
	  
	  
	  public void mouseClicked(MouseEvent e) {
	  
	  }
	  public void mouseMoved(MouseEvent e) {
	  }
	  public void mouseEntered(MouseEvent e){
	  
	  }
	  public void mouseExited(MouseEvent e) {
	  
	  }
	 
	  public static void main(String[] args) {
	  JFrame frame = new ChessGame();
	  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
	  frame.pack();
	  frame.setResizable(true);
	  frame.setLocationRelativeTo( null );
	  frame.setVisible(true);
	 }
}
 