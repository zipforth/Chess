import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board 
{
	private  int countTimes;
	protected static  JLabel [][] layout;
	protected static  String rook;
	protected static String knight;
	protected static String pawn;
	protected static String bishop;
	protected static String king;
	protected static String queen;
	protected static  JFrame frame;
	protected  MouseListener listener;
	protected static  int moveR;
	protected static int moveC;
	protected static int locR;
	protected static int locC;
	protected static ArrayList<Integer> moveChoices=new ArrayList<Integer>();
	protected static Color lighter,darker,lighterB,darkerB;
	protected static ChessClock abc;
	protected static String clock1,clock2;
	protected static int[] kingW={0,0}; 
	protected static int[] kingB={0,0};
	protected static int[] enpassant={9,9};
	protected static boolean rookWLMo=false;
	protected static boolean rookWRMo=false;
	protected static boolean rookBLMo=false;
	protected static boolean rookBRMo=false;
	protected static boolean kingWMo=false;
	protected static boolean kingBMo=false;
	
	public Board(String pieces, String clock1, String clock2)
	{
		kingB[0]=0;
		kingB[1]=4;
		kingW[0]=7;
		kingW[1]=4;
		rookWLMo=false;
		rookWRMo=false;
		rookBLMo=false;
		rookBRMo=false;
		kingWMo=false;
		kingBMo=false;
		
		this.clock1=clock1;
		this.clock2=clock2;
		GridLayout g = new GridLayout(8,8);
		frame = new JFrame();
    	frame.addKeyListener(new KeyListener(){
    	
    		public void keyPressed(KeyEvent e)
    	{
    		countTimes=0;
    		char mander= e.getKeyChar();
    		if(mander=='d')
    		{
    			MessagePages.DrawChoice("drawChoice.png");
    		}
    		if(mander=='r')
    		{
    			MessagePages.ResignChoice();
    		}
    		
    	}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

    	});
        frame.setTitle("Chessboard 1.0: Ultimate Gold Platinum Deluxe Collector's Preorder of the Year Edition, May include Dragons");
        frame.setBounds(0,0,798,800);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(g);
        listener = new DragMouseAdapter();
        DragMouseAdapter.count=0;
        
        if(pieces.contains("Tetris"))
        {
        	 rook="rookTetris";knight="knightTetris";pawn="pawnTetris";bishop="bishopTetris";king="kingTetris";queen="queenTetris";
        }
        else
        {
        	 rook="rook";knight="knight";pawn="pawn";bishop="bishop";king="king";queen="queen";
        }
        
        String[] pieceNamesW={rook+"B.png",knight+"B.png",bishop+"B.png",queen+"B.png",king+"B.png",bishop+"B.png",knight+"B.png",rook+"B.png",
        		pawn+"B.png" ,pawn+"B.png" ,pawn+"B.png" ,pawn+"B.png" ,pawn+"B.png" ,pawn+"B.png" ,pawn+"B.png" ,pawn+"B.png",
        		"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,
        		"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,
        		"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,
        		"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png" ,"Nyehh.png","Nyehh.png","Nyehh.png","Nyehh.png","Nyehh.png",
        		pawn+"W.png",pawn+"W.png",pawn+"W.png",pawn+"W.png",pawn+"W.png",pawn+"W.png",pawn+"W.png",pawn+"W.png",
        		rook+"W.png",knight+"W.png",bishop+"W.png",queen+"W.png",king+"W.png",bishop+"W.png",knight+"W.png",rook+"W.png" };
        String[] pieceLocation={
        		"/resources/"+rook+"B.png","/resources/"+knight+"B.png","/resources/"+bishop+"B.png","/resources/"+queen+"B.png","/resources/"+king+"B.png","/resources/"+bishop+"B.png","/resources/"+knight+"B.png","/resources/"+rook+"B.png",
        		"/resources/"+pawn+"B.png" ,"/resources/"+pawn+"B.png" ,"/resources/"+pawn+"B.png" ,"/resources/"+pawn+"B.png" ,"/resources/"+pawn+"B.png" ,"/resources/"+pawn+"B.png","/resources/"+pawn+"B.png" ,"/resources/"+pawn+"B.png" ,
        		"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,
        		"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,
        		"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,
        		"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png" ,"/resources/"+"Nyehh.png","/resources/"+"Nyehh.png","/resources/"+"Nyehh.png","/resources/"+"Nyehh.png","/resources/"+"Nyehh.png",
        		"/resources/"+pawn+"W.png","/resources/"+pawn+"W.png","/resources/"+pawn+"W.png","/resources/"+pawn+"W.png","/resources/"+pawn+"W.png","/resources/"+pawn+"W.png","/resources/"+pawn+"W.png","/resources/"+pawn+"W.png",
        		"/resources/"+rook+"W.png","/resources/"+knight+"W.png","/resources/"+bishop+"W.png","/resources/"+queen+"W.png","/resources/"+king+"W.png","/resources/"+bishop+"W.png","/resources/"+knight+"W.png","/resources/"+rook+"W.png" };
        int pieceNum=0;
        int isOdd=1;
        int modulo=0;
        int count=0;
        darker= new Color(122,79,41);
        lighter= new Color(186,122,63);
        lighterB= new Color(186-50,122,63+70);
    	darkerB= new Color(122-50,79,41+70);
        
        layout=new JLabel [8][8];
        for(int i=0;i<8;i++)
        	for(int j=0;j<8;j++)
        	{
        		JLabel apple = new JLabel(new ImageIcon(ChessRunner.class.getResource(pieceLocation[count]), pieceNamesW[count]));
        		apple.setName(pieceNamesW[count]);
        		apple.setOpaque(true);
            	apple.setFocusable(false);
            	apple.addMouseListener(listener);
        		layout[i][j]= apple;
        		count++;
        	}
        boolean colorer=true;
        for(int Q=0;Q<8;Q++)
        {
        	if(colorer)
        	layout[0][Q].setBackground(lighter);
        	else
        		layout[0][Q].setBackground(darker);
        	colorer=!colorer;
        }
        for(int i=0;i<8;i++)
        	for(int j=1;j<8;j++)
        	{
        		if(layout[j-1][i].getBackground().equals(lighter))
        			layout[j][i].setBackground(darker);
        		else
        			layout[j][i].setBackground(lighter);
        	}
        for(int i=0;i<8;i++)
        	for(int j=0;j<8;j++)
        		panel.add(layout[i][j]);
        frame.add(panel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        if(clock1.contains("min"))
        {
        	
			try {
				abc = new ChessClock(this.clock1,this.clock2);
				
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        }
        frame.setEnabled(true);
        frame.setVisible(true);
       
        
	}
	public static String getPieceType()
	{
		return rook;
		
	}
	public static String getclock1()
	{
		return clock1;
	}
	public static int getWidth()
	{
		return frame.getWidth();
		
	}
	public static int getHeight()
	{
		return frame.getHeight();
		
	}
	public static int getX()
	{
		return frame.getX();
		
	}
	public static void Selector(JLabel pieceMoving)
	{
		if(!pieceMoving.getName().contains("Nyehh"))
		for(int r=0;r<8;r++)
		{
			for(int c=0;c<8;c++)
			{
				if(pieceMoving==layout[r][c])
				{
					moveR=r;
					moveC=c;
					if(layout[r][c].getBackground().equals(darker))
					layout[r][c].setBackground(darkerB);
					if(layout[r][c].getBackground().equals(lighter))
						layout[r][c].setBackground(lighterB);
					if(layout[r][c].getName().contains("king"))
					{
						if(layout[r][c].getName().contains("B"))
							moveChoices.addAll(PieceMover.King(r,c,layout,"B"));
						else
							moveChoices.addAll(PieceMover.King(r,c,layout,"W"));
						if(layout[r][c].getName().contains("B"))
						{
							System.out.println(moveChoices.toString());
						}
					}
					if(layout[r][c].getName().contains("queen"))
					{
						if(layout[r][c].getName().contains("B"))
							moveChoices.addAll(PieceMover.Queen(r,c,layout,"B"));
						else
							moveChoices.addAll(PieceMover.Queen(r,c,layout,"W"));
					}
					if(layout[r][c].getName().contains("bishop"))
					{
						if(layout[r][c].getName().contains("B"))
							moveChoices.addAll(PieceMover.Bishop(r,c,layout,"B"));
						else
							moveChoices.addAll(PieceMover.Bishop(r,c,layout,"W"));
					}
					if(layout[r][c].getName().contains("knight"))
					{
						if(layout[r][c].getName().contains("B"))
							moveChoices.addAll(PieceMover.Knight(r,c,layout,"B"));
						else
							moveChoices.addAll(PieceMover.Knight(r,c,layout,"W"));
					}
					if(layout[r][c].getName().contains("rook"))
					{
						if(layout[r][c].getName().contains("B"))
							moveChoices.addAll(PieceMover.Rook(r,c,layout,"B"));
						else
							moveChoices.addAll(PieceMover.Rook(r,c,layout,"W"));
					}
					if(layout[r][c].getName().contains("pawn"))
					{
						if(layout[r][c].getName().contains("B"))
							moveChoices.addAll(PieceMover.Pawn(r,c,layout,"B"));
						else
							moveChoices.addAll(PieceMover.Pawn(r,c,layout,"W"));
					}
				}
			}
		}
		
	}
	public static Boolean Movement(JLabel location)
	{
		
		for(int r=0;r<8;r++)
		{
			for(int c=0;c<8;c++)
			{
				if(location==layout[r][c])
				{
					locR=r;
					locC=c;
					
				}
			}
		}
		if(layout[moveR][moveC].getBackground().equals(darkerB))
			layout[moveR][moveC].setBackground(darker);
		if(layout[moveR][moveC].getBackground().equals(lighterB))
			layout[moveR][moveC].setBackground(lighter);
		for(int x=0;x<moveChoices.size();x+=2)
		{
			if(moveChoices.get(x)==locR && moveChoices.get(x+1)==locC)
			{
				
				moveChoices.clear();
				layout[locR][locC].setName(layout[moveR][moveC].getName());
				layout[locR][locC].setIcon(layout[moveR][moveC].getIcon());
				layout[moveR][moveC].setName("Nyehh");
				layout[moveR][moveC].setIcon(new ImageIcon(ChessRunner.class.getResource("/resources/"+"Nyehh.png")));
				if(layout[locR][locC].getName().contains("B"))
				{
					if(CheckAttack.isAttacked(kingB[0], kingB[1], "B", layout))
					{
						layout[moveR][moveC].setName(layout[locR][locC].getName());
						layout[moveR][moveC].setIcon(layout[locR][locC].getIcon());
						layout[locR][locC].setName("Nyehh");
						layout[locR][locC].setIcon(new ImageIcon(ChessRunner.class.getResource("/resources/"+"Nyehh.png")));
						return false;
					}
				}
				else
				{
					if(CheckAttack.isAttacked(kingW[0], kingW[1], "W", layout))
					{
						layout[moveR][moveC].setName(layout[locR][locC].getName());
						layout[moveR][moveC].setIcon(layout[locR][locC].getIcon());
						layout[locR][locC].setName("Nyehh");
						layout[locR][locC].setIcon(new ImageIcon(ChessRunner.class.getResource("/resources/"+"Nyehh.png")));
						return false;
					}
				}
				if(layout[locR][locC].getName().contains("rook"))
				{
					if(moveR==0&&moveC==0)
					{
						rookBLMo=true;
					}
					if(moveR==0&&moveC==7)
					{
						rookBRMo=true;
					}
					if(moveR==7&&moveC==0)
					{
						rookWLMo=true;
					}
					if(moveR==7&&moveC==7)
					{
						rookWRMo=true;
					}
				}
				if(layout[locR][locC].getName().contains("king"))
				{
					if(moveR==0&&moveC==4)
					{
						kingBMo=true;
						if(moveC-locC==-2)
						{
							layout[0][5].setName(rook);
							layout[0][5].setIcon(
								new ImageIcon(ChessRunner.class.getResource(
										"/resources/"+rook+"B.png")));
							layout[0][7].setName("Nyehh");
							layout[0][7].setIcon(
									new ImageIcon(ChessRunner.class.getResource(
											"/resources/"+"Nyehh.png")));
						}
						if(moveC-locC==2)
						{
							layout[0][3].setName(rook);
							layout[0][3].setIcon(
								new ImageIcon(ChessRunner.class.getResource(
										"/resources/"+rook+"B.png")));
							layout[0][0].setName("Nyehh");
							layout[0][0].setIcon(
									new ImageIcon(ChessRunner.class.getResource(
											"/resources/"+"Nyehh.png")));
						}
					}
					if(moveR==7&&moveC==4)
					{
						kingWMo=true;
						if(moveC-locC==-2)
						{
							layout[7][5].setName(rook);
							layout[7][5].setIcon(
								new ImageIcon(ChessRunner.class.getResource(
										"/resources/"+rook+"W.png")));
							layout[7][7].setName("Nyehh");
							layout[7][7].setIcon(
									new ImageIcon(ChessRunner.class.getResource(
											"/resources/"+"Nyehh.png")));
						}
						if(moveC-locC==2)
						{
							layout[7][3].setName(rook);
							layout[7][3].setIcon(
								new ImageIcon(ChessRunner.class.getResource(
										"/resources/"+rook+"W.png")));
							layout[7][0].setName("Nyehh");
							layout[7][0].setIcon(
									new ImageIcon(ChessRunner.class.getResource(
											"/resources/"+"Nyehh.png")));
						}
					
					}		
				}
				if(layout[locR][locC].getName().contains("pawn"))
				{
					if(Math.abs(moveC-locC)==1&&layout[locR][locC].getName().contains("Nyehh"))
					{
						if(layout[locR][locC].getName().contains("W"))
						{
							layout[locR+1][locC].setName("Nyehh");
							layout[locR+1][locC].setIcon(new ImageIcon(ChessRunner.class.getResource("/resources/"+"Nyehh.png")));
						}
						if(layout[locR][locC].getName().contains("B"))
						{
							layout[locR-1][locC].setName("Nyehh");
							layout[locR-1][locC].setIcon(new ImageIcon(ChessRunner.class.getResource("/resources/"+"Nyehh.png")));
						}
						
					}
					if(Math.abs(locR-moveR)==2)
					{
						enpassant[0]=locR;
						enpassant[1]=locC;
					}
					if(layout[locR][locC].getName().contains("B"))
					{
						if(locR==7)
						{
							MessagePages.Promoter(locR, locC, "B", layout);
						}
					}
					if(layout[locR][locC].getName().contains("W"))
					{
						if(locR==0)
						{
							MessagePages.Promoter(locR, locC, "W", layout);
						}
					}
				}
				ArrayList<Integer> kingmoves=new ArrayList<Integer>();
				if(layout[locR][locC].getName().contains("B"))
				{
					kingmoves.addAll(PieceMover.King(kingW[0], kingW[1], layout, "W"));
					if(kingmoves.isEmpty())
					{
						if(CheckAttack.CheckForMate(layout, "W"))
						{
							MessagePages.Match();
							return false;
						}
						if(CheckAttack.checkDrawPlayed(kingW[0], kingW[1], "W", layout))
						{
							MessagePages.Draw("drawCard.png");
							return false;
						}
					}
				}
				if(layout[locR][locC].getName().contains("W"))
				{
					kingmoves.addAll(PieceMover.King(kingB[0], kingB[1], layout, "B"));
					if(kingmoves.isEmpty())
					{
						if(CheckAttack.CheckForMate(layout, "B"))
						{
							MessagePages.Match();
							return false;
						}
						if(CheckAttack.checkDrawPlayed(kingB[0], kingB[1], "B", layout))
						{
							MessagePages.Draw("drawCard.png");
							return false;
						}
					}
				}
				enpassant[0]=9;
				enpassant[1]=9;
				return true;
				
			}
		}
		moveChoices.clear();
		return false;
	}
	
}
