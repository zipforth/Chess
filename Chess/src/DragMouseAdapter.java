import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;


public class DragMouseAdapter extends MouseAdapter 
{
	private  boolean selectOrMove=true;
	private  boolean WhiteTorBlackF=true;
	public static int count=0;
	private boolean begintime=true;
	private boolean checkforClock=false;
	private Thread a3;
	public static int movesSincePawnorC=0; //make this useful
		public void mouseClicked(MouseEvent e)
		{
			if(Board.getclock1().contains("min"))
			{
				checkforClock=true;
			}
			
			if(selectOrMove)
			{
				
				if(!((JLabel) e.getSource()).getName().contains("Nyehh"))
				{
					if(WhiteTorBlackF)
					{
						if(((JLabel) e.getSource()).getName().contains("W"))
						{
							Board.Selector((JLabel) e.getSource());
							selectOrMove=!selectOrMove;
						}
					}
					else
					{
						
						if(((JLabel) e.getSource()).getName().contains("B"))
						{
							Board.Selector((JLabel) e.getSource());
							selectOrMove=!selectOrMove;
						}
					}
					
				}
			}
			else
			{
				selectOrMove=!selectOrMove;
				if(Board.Movement((JLabel) e.getSource()))
				{
					WhiteTorBlackF=!WhiteTorBlackF;
					count++;
					if(checkforClock)
					{
						if(count%2==0)
						{
							ChessClock.runner1();
							ChessClock.a2.stop();
						}
						if(count%2==1)
						{
							ChessClock.runner2();
							try{ChessClock.a1.stop();}catch(NullPointerException e1){System.out.println();}
						}
					}
				}
				
				
			}
		}
	}
