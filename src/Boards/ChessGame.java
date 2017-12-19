package Boards;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChessGame extends JFrame implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;//Serial ID for unique chess games
	JLayeredPane layeredPane;
  JPanel chessBoard;
  JLabel chessPiece;
  int xAdjustment;
  int yAdjustment;
  int iX = 0;
  int iY = 0;
  JComponent[][] spotPanel = new JComponent[8][8];
  Board newGame = new Board();//Instantiate Board object w/ spots
  public ChessGame(){
	  
	  newGame.boardSetUp();
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
	  
      for (int i = 0; i < 64; i++) {
      JPanel square = new JPanel( new BorderLayout() );
      chessBoard.add( square );
      int row = (i / 8);
      spotPanel[row][i-(row*8)] = square;
      if (row%2 == 0)
      square.setBackground( i % 2 == 0 ? Color.darkGray : Color.white );//Adjusting for First square
      else
      square.setBackground( i % 2 == 0 ? Color.white : Color.darkGray );//Setting colored boxes for chess board

      if(newGame.spotValues[row][i-(row*8)].piece!=null)
      {
        switch(newGame.spotValues[row][i-(row*8)].piece.name){
          case "Bishop":
        	  if(newGame.spotValues[row][i-(row*8)].piece.color.equals("White"))
        		  Vpiece = new JLabel( new ImageIcon("resource/BishopW.png") );
        	  else
        		  Vpiece = new JLabel( new ImageIcon("resource/BishopB.png") );
          break;
          
          case "King":
        	  if(newGame.spotValues[row][i-(row*8)].piece.color.equals("White"))
        		  Vpiece = new JLabel( new ImageIcon("resource/KingW.png" ));
        	  else
        		  Vpiece = new JLabel( new ImageIcon("resource/KingB.png" ));
          break;
          
          case "Queen":
        	  if(newGame.spotValues[row][i-(row*8)].piece.color.equals("White"))
        		  Vpiece = new JLabel( new ImageIcon("resource/QueenW.png") );
        	  else
        		  Vpiece = new JLabel( new ImageIcon("resource/QueenB.png") );
          break;

          case "Pawn":
        	  if(newGame.spotValues[row][i-(row*8)].piece.color.equals("White"))
        		  Vpiece = new JLabel( new ImageIcon("resource/PawnW.png") );
        	  else
        		  Vpiece = new JLabel( new ImageIcon("resource/PawnB.png") );
          break;

          case "Rook":
        	  if(newGame.spotValues[row][i-(row*8)].piece.color.equals("White"))
        		  Vpiece = new JLabel( new ImageIcon("resource/RookW.png") );
        	  else
        		  Vpiece = new JLabel( new ImageIcon("resource/RookB.png") );
          break;

          case "Knight":
        	  if(newGame.spotValues[row][i-(row*8)].piece.color.equals("White"))
        		  Vpiece = new JLabel( new ImageIcon("resource/KnightW.png") );
        	  else
        		  Vpiece = new JLabel( new ImageIcon("resource/KnightB.png") );
          break;
        }
        JPanel panel = (JPanel)chessBoard.getComponent(i);
        panel.add(Vpiece);
      }
    }
 
  }
 
	  public void mousePressed(MouseEvent e){
		  chessPiece = null;
		  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
//		  for(int x =0;x<8;x++) {
//				 for(int y =0; y<8;y++) {
//					 if(spotPanel[x][y]==c) {
//						 iX = x;
//						 iY = y;
//					 }
//				 }
//			 }
		  if (c instanceof JPanel) 
		  return; //makes sure no errors are given when pressed on a blank square
		 
		  Point parentLocation = c.getParent().getLocation(); //parentLocation is mouse pointer
		  xAdjustment = parentLocation.x - e.getX();
		  yAdjustment = parentLocation.y - e.getY();
		  chessPiece = (JLabel)c;
		  chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		  chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		  layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
		  }
	 
	  //Move the chess piece around
	  public void mouseDragged(MouseEvent me) {
		  if (chessPiece == null) { //checks if square is blank or not
			  return;
		  }
		  chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
	  }
		 
		  //Drop the chess piece back onto the chess board
	  public void mouseReleased(MouseEvent e) {
		  if(chessPiece == null) { //checks if square is blank or not
			  return;
		  }
		  
		  /*
		   * 
		   * 
		   * 
		   */
		  Component c =  chessBoard.findComponentAt(e.getX(), e.getY()); //checks to see if there's a new piece at the new location
		  boolean pathValid = true;
		  
		  //for(int x =0;x<8;x++) {
//				 for(int y =0; y<8;y++) {
//					 if(spotPanel[x][y]==c) {
//						 pathValid = newGame.spotValues[iX][iY].piece.pathValid(iX,iY,x,y);
//						 
//					 }
//				 }
			 //}
		  if(pathValid){
			  chessPiece.setVisible(false);
		  if (c instanceof JLabel){
			  Container parent = c.getParent();
			  parent.remove(0);
			  parent.add( chessPiece );
		  }
		  else {
			  Container parent = (Container)c;
			  parent.add( chessPiece );
		  }
		  
		  chessPiece.setVisible(true);
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
 