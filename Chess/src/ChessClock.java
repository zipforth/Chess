import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

public class ChessClock 
{
	public static Thread a1,a2;
	protected static String Fdelay;
	protected static String Ftime;
	private int count=0;
	protected static JTextField field = new JTextField();
	protected static JTextField field2 = new JTextField();
	protected static JTextField field3 = new JTextField();
	protected static JTextField field4 = new JTextField();
	protected static JFrame frame= new JFrame();
	public ChessClock(String time,String delay)throws InterruptedException
	{
		Ftime= time.substring(0, 2);
		Ftime.trim();
		if(Ftime.charAt(0)=='3')
			Ftime="03";
		
		Fdelay="";
		if(delay.charAt(0)=='1')
			Fdelay="10";
		if(delay.charAt(0)=='5')
			Fdelay="05";
		if(delay.charAt(0)=='N'||delay.charAt(0)==' ')
			Fdelay="00";
			
		
		JFrame frame= new JFrame();
		field.setBackground(Color.WHITE);
		field2.setBackground(Color.WHITE);
		JLayeredPane panel = new JLayeredPane();
		panel.setPreferredSize(new Dimension(275,83));
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		JLabel clock=new JLabel(new ImageIcon(ChessRunner.class.getResource("/resources/"+"clock.png")));
		JLabel bound= new JLabel();
		ImageIcon abc= new ImageIcon("");
		Image sized= abc.getImage().getScaledInstance(15,100, 0);
		bound.setIcon(new ImageIcon(sized));
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setLocation(Board.getX() + Board.getWidth(), Board.getHeight()/2);
		panel.setBackground(Color.BLACK);
		panel.setOpaque(true);
		frame.setSize(275,83);
		if(Ftime.length()==2)
		{
			field.setText(Ftime+":00");
			field.setFont(new Font("serif",Font.PLAIN,36));
			field2.setText(Ftime+":00");
			field2.setFont(new Font("serif",Font.PLAIN,36));
		}
		if(Ftime.length()==1)
		{
			field.setText("0"+Ftime+":00");
			field.setFont(new Font("serif",Font.PLAIN,36));
			field2.setText("0"+Ftime+":00");
			field2.setFont(new Font("serif",Font.PLAIN,36));
		}
		field3.setText(":"+Fdelay);
		field3.setFont(new Font("serif",Font.PLAIN,12));
		field4.setText(":"+Fdelay);
		field4.setFont(new Font("serif",Font.PLAIN,12));
		
		field3.setLocation(16, 44);
		field3.setSize(new Dimension(19,21));
		panel.add(field3,(Integer)2);
		
		field.setLocation(40, 29);
		field.setSize(new Dimension(85,51));
		panel.add(field,(Integer)2);
		

		field4.setLocation(150, 44);
		field4.setSize(new Dimension(19,21));
		panel.add(field4,(Integer)2);
		
		field2.setLocation(174, 29);
		field2.setSize(new Dimension(85,51));
		panel.add(field2,(Integer)2);
		
		clock.setSize(panel.getPreferredSize());
	    clock.setLocation(0, 0);
		panel.add(clock,(Integer)1);
		
		frame.add(panel);
		frame.setVisible(true);
		field.setEditable(false);
		field2.setEditable(false);
		field3.setEditable(false);
		field4.setEditable(false);
	}
		public static void runner1()
		{
			field4.setText(":"+Fdelay);
			Runnable r1=new Runnable()
			{
				public void run()
				{
					for(int i=0;i<(int)Integer.parseInt(Fdelay);i++)
					{
						int del=Integer.parseInt(field3.getText().substring(1));
						del--;
						if(del>9)
							field3.setText(":"+del);
						else
							field3.setText(":0"+del);
						
						try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
							field3.repaint();
					}
				
					while(true)
					{
							int min=Integer.parseInt(field.getText().substring(0,2));
					int sec=Integer.parseInt(field.getText().substring(3));
						if(sec>0)
						{
							sec--;
							if(min>9)
							{
								if(sec>9)
								{
									field.setText(min+":"+sec);
								}
								else
								{
									field.setText(min+":0"+sec);
								}
							}
							else
							{
								if(sec>9)
								{
									field.setText("0"+min+":"+sec);
								}
								else
								{
									field.setText("0"+min+":0"+sec);
								}
							}
							
						}
						else
						{
							if(min>0)
							{
								min--;
								sec=59;
								if(min>9)
								{
									field.setText(min+":"+sec);
								}
								else
								{
									field.setText("0"+min+":"+sec);
								}
							}
						}
						if(min==0&&sec==0)
						{
							field.setText("Time!");
							field.setBackground(Color.RED);
//							MessagePages abc= new MessagePages();
//							abc.Match();
							a1.stop();
						}
						if((min*60+sec)/((double)Integer.parseInt(Ftime)*60)<.25)
							field.setBackground(Color.YELLOW);
						try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
						field.repaint();
					}
					
				}
			};
			a1=new Thread(r1);
			a1.start();
		}
		
		public static void runner2()
		{
			field3.setText(":"+Fdelay);
			Runnable r2=new Runnable()
			{
				public void run()
				{
					for(int i=0;i<(int)Integer.parseInt(Fdelay);i++)
					{
						int del=Integer.parseInt(field4.getText().substring(1));
						del--;
						if(del>9)
							field4.setText(":"+del);
						else
							field4.setText(":0"+del);
						
						try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
						field4.repaint();
					}
					
					while(true)
					{
						int min=Integer.parseInt(field2.getText().substring(0,2));
					int sec=Integer.parseInt(field2.getText().substring(3));
						if(sec>0)
						{
							sec--;
							if(min>9)
							{
								if(sec>9)
								{
									field2.setText(min+":"+sec);
								}
								else
								{
									field2.setText(min+":0"+sec);
								}
							}
							else
							{
								if(sec>9)
								{
									field2.setText("0"+min+":"+sec);
								}
								else
								{
									field2.setText("0"+min+":0"+sec);
								}
							}
							
						}
						else
						{
							if(min>0)
							{
								min--;
								sec=59;
								if(min>9)
								{
									field2.setText(min+":"+sec);
								}
								else
								{
									field2.setText("0"+min+":"+sec);
								}
							}
						}
						if(min==0&&sec==0)
						{
							MessagePages abc= new MessagePages();
							abc.Match();
							field2.setText("Time!");
							field2.setBackground(Color.RED);
							
							try{ChessClock.a1.stop();}catch(NullPointerException e1){System.out.println();}
							try{ChessClock.a2.stop();}catch(NullPointerException e1){System.out.println();}
							
						}
						if((min*60+sec)/((double)Integer.parseInt(Ftime)*60)<.25)
							field2.setBackground(Color.YELLOW);
						try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
						field2.repaint();
					}
				}
			};
			
			a2=new Thread(r2);
			a2.start();
		
	}
	
}
