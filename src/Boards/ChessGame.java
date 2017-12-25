package Boards;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Pieces.*;

public class ChessGame extends JFrame implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;//Serial ID for unique chess games-
	private JLayeredPane layeredPane;
	private JPanel chessBoard;
	private JLabel chessPiece = null;
	private JLabel takenchessPiece = null;
	private JLabel oldchessPiece = null;
	private Point delta = null;
	private JPanel[][] JPanelGridLayout = new JPanel[8][8];
	private int iX = -1;
	private int iY = -1;
	private int fX = -1;
	private int fY = -1;
	private boolean checkmate=false;
	private boolean QSC = false;
	private int previX=0, previY=0, prevfX=0, prevfY=0;
	private Piece prevPiece=null;
	private Piece oldPiece = null;
	private String turn="White";
	private JFrame frame = new JFrame();
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
				previX=iX;
				previY=iY;
				prevfX=fX;
				prevfY=fY;
				prevPiece=newGame.spotValues[iY][iX].piece;
				if(newGame.spotValues[iY][iX].piece.color==turn) {
					//Checks if its an en passants
					if(newGame.spotValues[iY][iX].piece.doingEnPassant){
						JPanel takenpanel=JPanelGridLayout[iY][fX];
						takenchessPiece = (JLabel)(takenpanel.getComponent(0));
						JPanelGridLayout[iY][fX].remove(takenchessPiece);
						newGame.spotValues[iY][fX].piece=null;
					}	
					//Checks if the White King is King-Side Castling
					if(newGame.spotValues[iY][iX].piece.isKCastling){
						if(newGame.spotValues[iY][iX].piece.color.equals("White")) {
							JPanel takenpanel=JPanelGridLayout[7][7];
							takenchessPiece = (JLabel)(takenpanel.getComponent(0));
							JPanelGridLayout[7][5].add(takenchessPiece);
							newGame.spotValues[7][5].occupySpot(newGame.spotValues[7][7].piece);
							takenpanel.remove(takenchessPiece);
							newGame.spotValues[7][7].piece=null;
							newGame.spotValues[iY][iX].piece.isKCastling=false;
						}
						//Checks if the Black King is King-Side Castling
						else if(newGame.spotValues[iY][iX].piece.color.equals("Black")) {
							JPanel takenpanel=JPanelGridLayout[0][7];
							takenchessPiece = (JLabel)(takenpanel.getComponent(0));
							JPanelGridLayout[0][5].add(takenchessPiece);
							newGame.spotValues[0][5].occupySpot(newGame.spotValues[0][7].piece);
							takenpanel.remove(takenchessPiece);
							newGame.spotValues[0][7].piece=null;
							newGame.spotValues[iY][iX].piece.isKCastling=false;
						}
					}
					//Checks if the White King is Queen-Side Castling
					if(newGame.spotValues[iY][iX].piece.isQCastling){
						if(newGame.spotValues[iY][iX].piece.color.equals("White")) {
							JPanel takenpanel=JPanelGridLayout[7][0];
							takenchessPiece = (JLabel)(takenpanel.getComponent(0));
							JPanelGridLayout[7][3].add(takenchessPiece);
							newGame.spotValues[7][3].occupySpot(newGame.spotValues[7][0].piece);
							takenpanel.remove(takenchessPiece);
							newGame.spotValues[7][0].piece=null;
							QSC = true;
							newGame.spotValues[iY][iX].piece.isQCastling=false;
						}
						//Checks if the Black King is Queen-Side Castling
						else if(newGame.spotValues[iY][iX].piece.color.equals("Black")) {
							JPanel takenpanel=JPanelGridLayout[0][0];
							takenchessPiece = (JLabel)(takenpanel.getComponent(0));
							JPanelGridLayout[0][3].add(takenchessPiece);
							newGame.spotValues[0][3].occupySpot(newGame.spotValues[0][0].piece);
							takenpanel.remove(takenchessPiece);
							newGame.spotValues[0][0].piece=null;
							QSC = true;
							newGame.spotValues[iY][iX].piece.isQCastling=false;
						}
					}	
					//Checks if its taking another piece
					if(newGame.spotValues[fY][fX].piece!=null) {
						takenchessPiece=(JLabel)((JPanel)c).getComponent(0);
						JPanelGridLayout[fY][fX].remove(takenchessPiece);
						oldPiece = newGame.spotValues[fY][fX].piece;
						newGame.spotValues[fY][fX].piece=null;
					}
					//moves the piece
					if(QSC) {
						JPanelGridLayout[iY][2].add(chessPiece);
						newGame.spotValues[fY][2].occupySpot(newGame.spotValues[iY][iX].piece);
						newGame.spotValues[iY][iX].piece=null;
						QSC = false;
					}
					else
						((JPanel)c).add(chessPiece);
					newGame.spotValues[fY][fX].occupySpot(newGame.spotValues[iY][iX].piece);
					newGame.spotValues[iY][iX].piece=null;
					for(int tX=0; tX < 8; tX++) {//Checks piece promotion
						if(newGame.spotValues[0][tX].piece!=null && newGame.spotValues[7][tX].piece!=null) {//checking if position is null - avoid errors
							if(newGame.spotValues[0][tX].piece.name.equals("Pawn") && newGame.spotValues[0][tX].piece.color.equals("White")) {//Checks for white pawn promotion
								Object[] options = {new ImageIcon("resource/QueenW.png"),
										new ImageIcon("resource/RookW.png"),
										new ImageIcon("resource/BishopW.png"),
										new ImageIcon("resource/KnightW.png")};
								int n = JOptionPane.showOptionDialog(frame,
										"Promote "
												+ "your piece",
												"Promotion",
												JOptionPane.YES_NO_CANCEL_OPTION,
												JOptionPane.QUESTION_MESSAGE,
												null,
												options,
												options[3]);
								JLabel Vpiece = new JLabel();
								switch(n){
								case 0:
									Vpiece = new JLabel( new ImageIcon("resource/QueenW.png") );
									Queen queenW = new Queen(newGame, "White", "Queen");
									newGame.spotValues[fY][fX].occupySpot(newGame.spotValues[iY][iX].piece=queenW);
									break;

								case 1:
									Vpiece = new JLabel( new ImageIcon("resource/RookW.png") );
									Rook rookW = new Rook(newGame, "White", "Rook");
									newGame.spotValues[fY][fX].occupySpot(newGame.spotValues[iY][iX].piece=rookW);
									break;
								case 2:
									Vpiece = new JLabel( new ImageIcon("resource/BishopW.png") );
									Bishop bishopW = new Bishop(newGame, "White", "Bishop");
									newGame.spotValues[fY][fX].occupySpot(newGame.spotValues[iY][iX].piece=bishopW);
									break;
								case 3:
									Vpiece = new JLabel( new ImageIcon("resource/KnightW.png") );
									Knight knightW = new Knight(newGame, "White", "Rook");
									newGame.spotValues[fY][fX].occupySpot(newGame.spotValues[iY][iX].piece=knightW);
									break;
								}
								((JPanel)c).remove(chessPiece);
								((JPanel)c).add(Vpiece);
							}
							else if(newGame.spotValues[7][tX].piece.name.equals("Pawn") && newGame.spotValues[7][tX].piece.color.equals("Black")) {//Check black pawn promotion
								Object[] options = {new ImageIcon("resource/QueenB.png"), 
										new ImageIcon("resource/RookB.png"),
										new ImageIcon("resource/BishopB.png"),
										new ImageIcon("resource/KnightB.png")};
								int n = JOptionPane.showOptionDialog(frame,
										"Promote "
												+ "your piece",
												"Promotion",
												JOptionPane.YES_NO_CANCEL_OPTION,
												JOptionPane.QUESTION_MESSAGE,
												null,
												options,
												options[3]);
								JLabel Vpiece = new JLabel();
								switch(n){
								case 0:
									Vpiece = new JLabel( new ImageIcon("resource/QueenB.png") );
									Queen queenB = new Queen(newGame, "Black", "Queen");
									newGame.spotValues[fY][fX].occupySpot(newGame.spotValues[iY][iX].piece=queenB);
									break;
								case 1:
									Vpiece = new JLabel( new ImageIcon("resource/RookB.png") );
									Rook rookB = new Rook(newGame, "Black", "Rook");
									newGame.spotValues[fY][fX].occupySpot(newGame.spotValues[iY][iX].piece=rookB);
									break;
								case 2:
									Vpiece = new JLabel( new ImageIcon("resource/BishopB.png") );
									Bishop bishopB = new Bishop(newGame, "Black", "Bishop");
									newGame.spotValues[fY][fX].occupySpot(newGame.spotValues[iY][iX].piece=bishopB);
									break;
								case 3:
									Vpiece = new JLabel( new ImageIcon("resource/KnightB.png") );
									Knight knightB = new Knight(newGame, "Black", "Rook");
									newGame.spotValues[fY][fX].occupySpot(newGame.spotValues[iY][iX].piece=knightB);
									break;
								}
								((JPanel)c).remove(chessPiece);
								((JPanel)c).add(Vpiece);
							}
						}
					}
					if(turn=="White"){//Turn management and enpassant resetting
						for(int x = 0; x < 8; x++) {
							for(int y = 0; y < 8; y++) {
								if(newGame.spotValues[x][y].isOccupied() && newGame.spotValues[x][y].piece.enpassantable==true  && newGame.spotValues[x][y].piece.color.equals("Black")) {
									newGame.spotValues[x][y].piece.enpassantable=false;
								}
							}
						}
						turn="Black";
					} else if(turn=="Black") {
						for(int x = 0; x < 8; x++) {
							for(int y = 0; y < 8; y++) {
								if(newGame.spotValues[x][y].isOccupied() && newGame.spotValues[x][y].piece.enpassantable==true  && newGame.spotValues[x][y].piece.color.equals("White")) {
									newGame.spotValues[x][y].piece.enpassantable=false;
								}
							}
						}
						turn="White";
					}
				} else {
					JPanelGridLayout[iY][iX].add(chessPiece);
					previY=iY;
					previX=iX;
					prevfX=fX;
					prevfY=fY;
				}
				//Resets protected spots
				for(int tX=0; tX < 8; tX++) {
					for(int tY=0; tY < 8; tY++) {
						newGame.spotValues[tY][tX].isProtectedByBlack=false;
						newGame.spotValues[tY][tX].isProtectedByWhite=false;
					}
				}
				//Sets spots to protectedbyblack and/or protectedbywhite
				for(Spot[] coordY : newGame.spotValues) {
					for(Spot coordX : coordY) {
						if(coordX.piece!=null) {
							for(int tX=0; tX < 8; tX++) {
								for(int tY=0; tY < 8; tY++) {
									if(coordX.piece.name!="Pawn") {
										if(coordX.piece.pathValid(coordX.y,coordX.x,tX,tY)) {
											if(coordX.piece.color=="White") {
												newGame.spotValues[tY][tX].isProtectedByWhite=true;
												System.out.println("White: "+coordX.piece.name +" "+tX +" "+ tY);
											} else if(coordX.piece.color=="Black"){
												newGame.spotValues[tY][tX].isProtectedByBlack=true;
												System.out.println("Black: "+coordX.piece.name +" "+tX +" "+ tY);
											}
										}
									}/*else if(coordX.piece.pawnCheck(coordX.y,coordX.x,tY,tX) && coordX.piece.name=="Pawn") { 
										if(coordX.piece.color=="White") {
											newGame.spotValues[tY][tX].isProtectedByWhite=true;
										} else if(coordX.piece.color=="Black"){
											newGame.spotValues[tY][tX].isProtectedByBlack=true;
										}
									}*/
								}
							}
						}
					}
				}
				//Checks if King is in check after the move
				for(Spot[] coordY : newGame.spotValues) {
					for(Spot coordX : coordY) {
						if(coordX.piece!=null) {
							if(coordX.piece.name=="King") {
								int possibleMoves = 0;
								//Checks if king can move anywhere at all
								if(coordX.piece!=null) {
									for(int tX=0; tX < 8; tX++) {
										for(int tY=0; tY < 8; tY++) {
											//If this happens, then its not check mate since King has at least one legal move
											if(coordX.piece.color.equals("White") && turn.equals("White")) {
												if(coordX.piece.pathDraw(coordX.x,coordX.y,tX,tY) && !newGame.spotValues[tX][tY].isOccupied() && (!(coordX.isProtectedByBlack))) {
													possibleMoves++;
													System.out.println("legal move : "+tX + " " + tY + "  " +coordX.x + " " + coordX.y+" " + coordX.piece.name +" "+coordX.piece.color);
												}
												else if(coordX.piece.pathDraw(coordX.x,coordX.y,tX,tY) && (coordX.isProtectedByBlack || newGame.spotValues[tX][tY].isOccupied())) {
													System.out.println("illegal move : "+tX + " " + tY + "  " +coordX.x + " " + coordX.y+" " + coordX.piece.name +" "+coordX.piece.color);
												}
											}
											else if(coordX.piece.color.equals("Black") && turn.equals("Black")) {
												if(coordX.piece.pathDraw(coordX.x,coordX.y,tX,tY) && !newGame.spotValues[tX][tY].isOccupied() && (!(coordX.isProtectedByWhite))) {
													possibleMoves++;
													System.out.println("legal move : "+tX + " " + tY + "  " +coordX.x + " " + coordX.y+" " + coordX.piece.name +" "+coordX.piece.color);
												}
												else if(coordX.piece.pathDraw(coordX.x,coordX.y,tX,tY) && (coordX.isProtectedByWhite  || newGame.spotValues[tX][tY].isOccupied())) {
													System.out.println("illegal move : "+tX + " " + tY + "  " +coordX.x + " " + coordX.y+" " + coordX.piece.name +" "+coordX.piece.color);
												}
											}
										}
									}
									if(possibleMoves>0) {
										//insert a check to see if a piece can block check mate
									}
									//If not check mate but not legal move, then undo previous move.
									if(coordX.isProtectedByBlack && coordX.piece.color=="White" && turn!="White") {
										JPanel futurepanel=JPanelGridLayout[prevfY][prevfX];
										oldchessPiece = (JLabel)(futurepanel.getComponent(0));
										JPanelGridLayout[prevfY][prevfX].remove(oldchessPiece);
										JPanelGridLayout[previY][previX].add(oldchessPiece);
										newGame.spotValues[prevfY][prevfX].piece=null;
										newGame.spotValues[previY][previX].piece=prevPiece;
										turn="White";
										if(takenchessPiece!=null) {
											JPanelGridLayout[fY][fX].add(takenchessPiece);
											newGame.spotValues[fY][fX].piece=oldPiece;
										}
									} else if(coordX.isProtectedByWhite && coordX.piece.color=="Black" && turn!="Black") {
										JPanel futurepanel=JPanelGridLayout[prevfY][prevfX];
										oldchessPiece = (JLabel)(futurepanel.getComponent(0));
										JPanelGridLayout[prevfY][prevfX].remove(oldchessPiece);
										JPanelGridLayout[previY][previX].add(oldchessPiece);
										newGame.spotValues[prevfY][prevfX].piece=null;
										newGame.spotValues[previY][previX].piece=prevPiece;
										turn="Black";
										if(takenchessPiece!=null) {
											JPanelGridLayout[fY][fX].add(takenchessPiece);
											newGame.spotValues[fY][fX].piece=oldPiece;
										}

									}
								}
							}
						}
					}
				}
			}
			// re-initialize things
			chessPiece = null;
			delta = null;
			takenchessPiece = null;
			oldchessPiece = null;
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
