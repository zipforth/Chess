import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MessagePages 
{
	private static JLabel pieceShower;
	private static JButton promote;
	private static ImageIcon a;
	public static void Promoter(int row,int col,String color,JLabel[][] layout)
	{
		
		JFrame picker=new JFrame();
        picker.setBounds(0,0,300,107);
        JPanel paneler= new JPanel();
        paneler.setBackground(Color.WHITE);
        String [] pickPiece={" ","Knight","Bishop","Rook","Queen"};
        JComboBox promoter= new JComboBox(pickPiece);
        promoter.addActionListener(new ActionListener(){

    	    @Override
    	    public void actionPerformed(ActionEvent e)
    	    {
    	    	
    	    	
    	    	JComboBox clone= (JComboBox) e.getSource();
    	    	String styleName = (String)clone.getSelectedItem();
    	    	a =new ImageIcon(ChessRunner.class.getResource("/resources/Nyehh.png"));
    	    	promote.setEnabled(true);
    	    	String Piecetype="";
    	    	if(Board.getPieceType().contains("Tetris"))
    	    	{
    	    		Piecetype="Tetris";
    	    	}
    	    		if(styleName.equals("Knight"))
    	    		{
    	    			a =new ImageIcon(ChessRunner.class.getResource("/resources/knight"+Piecetype+color+".png"));
    	    			pieceShower.setIcon(a);
    	    			
    	    		}
    	    		if(styleName.equals("Bishop"))
    	    		{
    	    			a =new ImageIcon(ChessRunner.class.getResource("/resources/bishop"+Piecetype+color+".png"));
    	    			pieceShower.setIcon(a);
    	    		}
    	    		if(styleName.equals("Rook"))
    	    		{
    	    			a =new ImageIcon(ChessRunner.class.getResource("/resources/rook"+Piecetype+color+".png"));
    	    			pieceShower.setIcon(a);
    	    		}
    	    		if(styleName.equals("Queen"))
    	    		{
    	    			a =new ImageIcon(ChessRunner.class.getResource("/resources/queen"+Piecetype+color+".png"));
    	    			pieceShower.setIcon(a);
    	    		}
    	    			
    	    	
    	    	if(styleName.equals(" "))
    	    	{
    	    		a= new ImageIcon(ChessRunner.class.getResource("/resources/"+"Nyehh.png"));
    	    		promote.setEnabled(false);
    	    		pieceShower.setIcon(a);
    	    	}
    	    }
    	    });
        promote = new JButton("Promote");
        promote.setEnabled(false);
        promote.addActionListener(new ActionListener(){

    	    @Override
    	    public void actionPerformed(ActionEvent e)
    	    {
    	    	layout[row][col].setIcon(a);
    	    	layout[row][col].setName(a.getDescription());
    	    	Board.frame.enable();
    	    	picker.dispose();
    	    }
    	    });
        pieceShower= new JLabel(new ImageIcon(ChessRunner.class.getResource("/resources/"+"Nyehh.png")));
        pieceShower.setOpaque(true);
        if(layout[row][col].getBackground().equals(Board.lighter))
        	pieceShower.setBackground(Board.lighter);
        else
        	 pieceShower.setBackground(Board.darker);
        picker.add(paneler);
        paneler.add(promoter);
        paneler.add(pieceShower);
        paneler.add(promote);
        picker.setDefaultCloseOperation(JFrame.NORMAL);
        Board.frame.disable();
        picker.setResizable(false);
        picker.setUndecorated(true);
        picker.setLocationRelativeTo(null);
        picker.setVisible(true);
	}
	
	public static void Match()
	{EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		JLabel winner;
		JFrame picker=new JFrame();
        picker.setBounds(0,0,200,85);
        JPanel paneler= new JPanel();
        paneler.setBackground(Color.WHITE);
        if(DragMouseAdapter.count%2==0)
        	winner= new JLabel(new ImageIcon(ChessRunner.class.getResource("/resources/"+"winnerCardW.png")));
        else
        	winner= new JLabel(new ImageIcon(ChessRunner.class.getResource("/resources/"+"winnerCardB.png")));
        if(Board.getclock1().contains("min"))
		{
    		ChessClock.a1.stop();
    		ChessClock.a2.stop();
		}
        Board.frame.disable();
        picker.setResizable(false);
        picker.setUndecorated(true);
        picker.setLocationRelativeTo(null);
        picker.setVisible(true);
        JButton newGame=new JButton("New Game");
       newGame.addActionListener(new ActionListener(){

    	    @Override
    	    public void actionPerformed(ActionEvent e)
    	    {
    	    	if(Board.getclock1().contains("min"))
				{
    	    		ChessClock.frame.dispose();
    	    		
				}
    	    	Board.frame.dispose();
    	    	
    	    	Board B=new Board(Board.getPieceType(), Board.clock1,Board.clock2);
    	    	picker.dispose();
    	    }
    	    });
        JButton exit=new JButton("Exit");
        exit.addActionListener(new ActionListener(){

    	    @Override
    	    public void actionPerformed(ActionEvent e)
    	    {
    	    	if(Board.getclock1().contains("min"))
				{
    	    		ChessClock.frame.dispose();
    	    		
				}
    	    	Board.frame.dispose();
    	    	
    	    	picker.dispose();
    	    }
    	    });
        paneler.add(winner);
        paneler.add(newGame);
        paneler.add(exit);
        picker.add(paneler);
	    }
	  });
	}
	public static void Draw(String png)
	{
		JLabel winner;
		JFrame picker=new JFrame();
        picker.setBounds(0,0,200,85);
        JPanel paneler= new JPanel();
        paneler.setBackground(Color.WHITE);
        	winner= new JLabel(new ImageIcon(ChessRunner.class.getResource("/resources/"+png)));
        Board.frame.disable();
        if(Board.getclock1().contains("min"))
		{
    		ChessClock.a1.stop();
		}
        picker.setResizable(false);
        picker.setUndecorated(true);
        picker.setLocationRelativeTo(null);
        picker.setVisible(true);
        JButton newGame=new JButton("New Game");
       newGame.addActionListener(new ActionListener(){

    	    @Override
    	    public void actionPerformed(ActionEvent e)
    	    {
    	    	Board.frame.dispose();
    	    	if(Board.getclock1().contains("min"))
				{
    	    		ChessClock.frame.dispose();
    	    		
				}
    	    	Board B=new Board(Board.getPieceType(), Board.clock1,Board.clock2);
    	    	picker.dispose();
    	    }
    	    });
        JButton exit=new JButton("Exit");
        exit.addActionListener(new ActionListener(){

    	    @Override
    	    public void actionPerformed(ActionEvent e)
    	    {
    	    	Board.frame.dispose();
    	    	if(Board.getclock1().contains("min"))
				{
    	    		ChessClock.frame.dispose();
    	    		
				}
    	    	picker.dispose();
    	    }
    	    });
        paneler.add(winner);
        paneler.add(newGame);
        paneler.add(exit);
        picker.add(paneler);
	}
	public static void DrawChoice(String png)
	{
		JLabel winner;
		JFrame picker=new JFrame();
        picker.setBounds(0,0,200,85);
        JPanel paneler= new JPanel();
        paneler.setBackground(Color.WHITE);
        	winner= new JLabel(new ImageIcon(ChessRunner.class.getResource("/resources/"+png)));
        Board.frame.disable();
        picker.setResizable(false);
        picker.setUndecorated(true);
        picker.setLocationRelativeTo(null);
        picker.setVisible(true);
        JButton yes=new JButton("Yes");
        JButton no =new JButton("No");
        yes.addActionListener(new ActionListener(){

    	    @Override
    	    public void actionPerformed(ActionEvent e)
    	    {
    	    	if(DragMouseAdapter.movesSincePawnorC>=150)
				{
					Draw("70MoveRule.png");
				}
    	    	else
    	    	Draw("drawCard.png");
    	    	picker.dispose();
    	    }
    	    });
        no.addActionListener(new ActionListener(){

    	    @Override
    	    public void actionPerformed(ActionEvent e)
    	    {
    	    	Board.frame.enable();
    	    	picker.dispose();
    	    }
    	    });
        paneler.add(winner);
        paneler.add(yes);
        paneler.add(no);
        picker.add(paneler);
	}
	public static void ResignChoice()
	{
		JLabel winner;
		JFrame picker=new JFrame();
        picker.setBounds(0,0,200,85);
        JPanel paneler= new JPanel();
        paneler.setBackground(Color.WHITE);
        	winner= new JLabel(new ImageIcon(ChessRunner.class.getResource("/resources/"+"resignChoice.png")));
        Board.frame.disable();
        picker.setResizable(false);
        picker.setUndecorated(true);
        picker.setLocationRelativeTo(null);
        picker.setVisible(true);
        JButton yes=new JButton("Yes");
        JButton no =new JButton("No");
        yes.addActionListener(new ActionListener(){

    	    @Override
    	    public void actionPerformed(ActionEvent e)
    	    {
    	    	Resign();
    	    	picker.dispose();
    	    }
    	    });
        no.addActionListener(new ActionListener(){

    	    @Override
    	    public void actionPerformed(ActionEvent e)
    	    {
    	    	Board.frame.enable();
    	    	picker.dispose();
    	    }
    	    });
        paneler.add(winner);
        paneler.add(yes);
        paneler.add(no);
        picker.add(paneler);
	}
	public static void Resign()
	{
		JLabel winner;
		JFrame picker=new JFrame();
        picker.setBounds(0,0,200,85);
        JPanel paneler= new JPanel();
        paneler.setBackground(Color.WHITE);
        if(DragMouseAdapter.count%2==0)
        	winner= new JLabel(new ImageIcon(ChessRunner.class.getResource("/resources/"+"resignW.png")));
        else
        	winner= new JLabel(new ImageIcon(ChessRunner.class.getResource("/resources/"+"resignB.png")));
        if(Board.getclock1().contains("min"))
		{
    		ChessClock.a1.stop();
		}
        Board.frame.disable();
        picker.setResizable(false);
        picker.setUndecorated(true);
        picker.setLocationRelativeTo(null);
        picker.setVisible(true);
        JButton newGame=new JButton("New Game");
       newGame.addActionListener(new ActionListener(){

    	    @Override
    	    public void actionPerformed(ActionEvent e)
    	    {
    	    	Board.frame.dispose();
    	    	if(Board.getclock1().contains("min"))
				{
    	    		ChessClock.frame.dispose();
				}
    	    	Board B=new Board(Board.getPieceType(), Board.clock1,Board.clock2);
    	    	picker.dispose();
    	    }
    	    });
        JButton exit=new JButton("Exit");
        exit.addActionListener(new ActionListener(){

    	    @Override
    	    public void actionPerformed(ActionEvent e)
    	    {
    	    	Board.frame.dispose();
    	    	if(Board.getclock1().contains("min"))
				{
    	    		ChessClock.frame.dispose();
				}
    	    	picker.dispose();
    	    }
    	    });
        paneler.add(winner);
        paneler.add(newGame);
        paneler.add(exit);
        picker.add(paneler);
	}
}


