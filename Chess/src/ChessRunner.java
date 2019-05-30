import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChessRunner 
{
	public static void main(String[] args) 
	{
		
		JFrame picker=new JFrame();
		picker.setTitle("Chess GUI");
        picker.setBounds(0,0,500,350);
        JPanel paneler= new JPanel();
        paneler.setBackground(Color.WHITE);
        paneler.setLayout(new GridBagLayout());
        GridBagConstraints g= new GridBagConstraints();
        ImageIcon nameTag = new ImageIcon(ChessRunner.class.getResource("/resources/nametag.png"));
        Image sized= nameTag.getImage().getScaledInstance(500, -1, 0);
        nameTag=new ImageIcon(sized);
        JLabel name= new JLabel(nameTag);
        
        JButton start = new JButton("Select");
        JLabel example=new JLabel();
        example.setIcon(new ImageIcon(ChessRunner.class.getResource("/resources/Nyehh.png")));
        String []pieceStyle={" ","Regular","Tetris"};
        JComboBox style = new JComboBox<String>(pieceStyle);
        style.setSelectedIndex(0);
        	style.addActionListener(new ActionListener(){

        	    @Override
         	    public void actionPerformed(ActionEvent e)
        	    {
        	    	String pieces="";
        	    	ImageIcon examplePic;
        	    	JComboBox clone= (JComboBox) e.getSource();
        	    	String styleName = (String)clone.getSelectedItem();
        	    	if(styleName.equals("Regular"))
        	    	{
        	    		examplePic=new ImageIcon(ChessRunner.class.getResource("/resources/kingW.png"));
        	    		pieces="Vanilla";
        	    		example.setIcon(examplePic);
        	    		example.setName("Vanilla");
            	    	start.setEnabled(true);
        	    	}
        	    	if(styleName.equals("Tetris"))
        	    	{
        	    		examplePic= new ImageIcon(ChessRunner.class.getResource("/resources/kingTetrisW.png"));
        	    		pieces="Tetris";
        	    		example.setIcon(examplePic);
        	    		example.setName("Tetris");
            	    	start.setEnabled(true);
        	    	}
        	    	if(styleName.equals(" "))
        	    	{
        	    		examplePic= new ImageIcon(ChessRunner.class.getResource("/resources/Nyehh.png"));
        	    		pieces=" ";
        	    		example.setIcon(examplePic);
        	    		example.setName("Nyehh");
        	    	}
        	    	
        	    	
        	    }
        	    });
        	
             start.setEnabled(false);
             start.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) 
				{
					picker.getContentPane().removeAll();
         			JPanel paneler= new JPanel();
         			
         			JButton AIorNo = new JButton("Select");
         			
         			paneler= new JPanel();
         			paneler.setBackground(Color.WHITE);
         			paneler.setLayout(new GridBagLayout());
         	        GridBagConstraints g= new GridBagConstraints();
         	        ImageIcon nameTag = new ImageIcon(ChessRunner.class.getResource("/resources/nametag.png"));
         	        Image sized= nameTag.getImage().getScaledInstance(500, -1, 0);
         	        nameTag=new ImageIcon(sized);
         	        JLabel name= new JLabel(nameTag);
         	        String []AI={" ","AI","2 Player"};
         	        String[] color={" ","play as white", "play as black"};
         	        JComboBox AIs = new JComboBox<String>(AI);
         	        JComboBox colors = new JComboBox<String>(color);
         	        AIs.setSelectedIndex(0);
         	        colors.setSelectedIndex(0);
         	        
         	        AIs.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) 
						{
							String isAI="";
							JComboBox clone= (JComboBox) e.getSource();
     	        	    	String AIchoice = (String)clone.getSelectedItem();
     	        	    	if(AIchoice.equals("AI"))
     	        	    	{
     	        	    		AIorNo.setEnabled(true);
     	        	    		colors.setEnabled(true);
     	        	    		isAI="AI";
     	        	    	}
     	        	    	if(AIchoice.equals("2 player"))
     	        	    	{
     	        	    		AIorNo.setEnabled(true);
     	        	    		colors.setEnabled(false);
     	        	    		//colors.setSelectedIndex(0);
     	        	    		isAI="players";
     	        	    	}
     	        	    	if(AIchoice.equals(" "))
     	        	    	{
     	        	    		AIorNo.setEnabled(false);
     	        	    		colors.setEnabled(false);
     	        	    		colors.setSelectedIndex(0);
     	        	    	}
     	        	    	
							
						}
         	        	
         	        });
         	       colors.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) 
						{
							String iscolor="";
							JComboBox clone= (JComboBox) e.getSource();
     	        	    	String AIchoice = (String)clone.getSelectedItem();
     	        	    	if(AIchoice.equals(" "))
     	        	    	{
     	        	    		iscolor="white";
     	        	    	}
     	        	    	if(AIchoice.equals("play as white"))
     	        	    	{
     	        	    		iscolor="white";
     	        	    	}
     	        	    	if(AIchoice.equals("play as black"))
     	        	    	{
     	        	    		iscolor="black";
     	        	    	}
						}
         	       });
         	       AIorNo.setEnabled(false);
         	       AIorNo.addActionListener(new ActionListener(){

                	    @Override
                	    public void actionPerformed(ActionEvent e)
                	    {
                	    
                	    	picker.getContentPane().removeAll();
                			JPanel paneler= new JPanel();
                			
                			JButton startClock = new JButton("Select");
                			
                			paneler= new JPanel();
                			paneler.setBackground(Color.WHITE);
                			paneler.setLayout(new GridBagLayout());
                	        GridBagConstraints g= new GridBagConstraints();
                	        ImageIcon nameTag = new ImageIcon(ChessRunner.class.getResource("/resources/nametag.png"));
                	        Image sized= nameTag.getImage().getScaledInstance(500, -1, 0);
                	        nameTag=new ImageIcon(sized);
                	        JLabel name= new JLabel(nameTag);
                	        String []pieceStyle={" ","Clock","No clock"};
                	        JComboBox style = new JComboBox<String>(pieceStyle);
                	        style.setSelectedIndex(0);
                	        	style.addActionListener(new ActionListener(){

                	        	    @Override
                	        	    public void actionPerformed(ActionEvent e)
                	        	    {
                	        	    	
                	        	    	JComboBox clone= (JComboBox) e.getSource();
                	        	    	String styleName = (String)clone.getSelectedItem();
                	        	    	if(styleName.equals("No clock"))
                	        	    	{
                	        	    		startClock.setEnabled(true);
                	        	    		
                	        	    	}
                	        	    	if(styleName.equals("Clock"))
                	        	    	{
                	        	    		startClock.setEnabled(true);
                	        	    	}
                	        	    	if(styleName.equals(" "))
                	        	    	{
                	        	    		startClock.setEnabled(false);
                	        	    	}
                	        	    	
                	        	    	
                	        	    }
                	        	    });
                	        	startClock.setEnabled(false);
                	           startClock.addActionListener(new ActionListener(){

                	       	    @Override
                	       	    public void actionPerformed(ActionEvent e)
                	       	    {
                	       	    	
                	       	    	if(style.getSelectedItem().equals("No clock"))
                	       	    	{
                	       	    		new Board(example.getName()," "," ");
                	       	    		picker.dispose();
                	       	    	}
                	       	    	else
                	       	    	{
                	       	    		ClockTimes();
                	       	    	}
                	       	    	
                	       	    	
                	       	    	
                	       	    }
                	       	    });
                	           
                	           g.gridwidth=2;
                	           g.gridx=1;
                	           g.gridy=1;
                	           
                	           g.insets=new Insets(0, 150, 0, -50);
                	           paneler.add(startClock,g);
                	           
                	           g.gridx=0;
                	           g.gridy=1;
                	           g.insets=new Insets(0, 165, 0, 0);
                	           paneler.add(style,g);

                	           g.gridx=0;
                	           g.gridy=1;
                	           g.insets=new Insets(0, 150, 0, 0);
                	           
                	           g.gridx=2;
                	           g.gridy=2;
                	           g.insets=new Insets(0, -230, 0, 0);
                	           paneler.add(new JLabel(new ImageIcon(ChessRunner.class.getResource("/resources/Nyehh.png"))),g);
                	           
                	           g.gridwidth=1;
                	           g.gridx=0;
                	           g.gridy=0;
                	           g.gridwidth=g.fill;
                	           g.insets=new Insets(0, 0, 0, 0);
                	           paneler.add(name,g);
                	           picker.add(paneler);
                	           picker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                	           picker.setLocationRelativeTo(null);
                	           picker.setResizable(false);
                	           picker.setVisible(true);
                	           
                	   	}
                	   protected String time="";
                	   protected String delay="";
                	   	public void ClockTimes()
                	   	{
                	   		picker.getContentPane().removeAll();
                	   		
                	           JPanel paneler= new JPanel();
                	           paneler.setBackground(Color.WHITE);
                	           paneler.setLayout(new GridBagLayout());
                	           GridBagConstraints g= new GridBagConstraints();
                	           ImageIcon nameTag = new ImageIcon(ChessRunner.class.getResource("/resources/nametag.png"));
                	           Image sized= nameTag.getImage().getScaledInstance(500, -1, 0);
                	           nameTag=new ImageIcon(sized);
                	           JLabel name= new JLabel(nameTag);
                	           
                	           String []delayStyle={" ","No delay","5s delay","10s delay"};
                	           JComboBox delaystyle = new JComboBox<String>(delayStyle);
                	           String []timeStyle={" ","3 min blitz","10 min timer","30 min timer","60 min timer","90 min timer"};
                	           JComboBox timestyle = new JComboBox<String>(timeStyle);
                	           delaystyle.setSelectedIndex(0);
                	           
                	           	delaystyle.addActionListener(new ActionListener(){

                	           	    @Override
                	           	    public void actionPerformed(ActionEvent e)
                	           	    {
                	           	    	
                	           	    	JComboBox clone= (JComboBox) e.getSource();
                	           	    	String styleName = (String)clone.getSelectedItem();
                	           	    	if(styleName.equals("5s delay"))
                	           	    	{
                	           	    		delay="05";
                	           	    	}
                	           	    	if(styleName.equals("10s delay"))
                	           	    	{
                	           	    		delay="10";
                	           	    	}
                	           	    	if(styleName.equals("No delay"))
                	           	    	{
                	           	    		delay="00";
                	           	    	}
                	           	    	if(styleName.equals(" "))
                	           	    	{
                	           	    		
                	           	    	}
                	           	    	
                	           	    	
                	           	    }
                	           	    });
                	           	
                	           	JButton startClock = new JButton("Start!");
                	           	 timestyle.setSelectedIndex(0);
                	           	 timestyle.addActionListener(new ActionListener(){

                	            	    @Override
                	            	    public void actionPerformed(ActionEvent e)
                	            	    {
                	            	    	
                	            	    	
                	            	    	
                	            	    	JComboBox clone= (JComboBox) e.getSource();
                	            	    	String styleName = (String)clone.getSelectedItem();
                	            	    	if(styleName.equals("3 min blitz"))
                	            	    	{
                	            	    		time="03";
                	            	    		startClock.setEnabled(true);
                	            	    	}
                	            	    	if(styleName.equals("10 min timer"))
                	            	    	{
                	            	    		time="10";
                	            	    		startClock.setEnabled(true);
                	            	    	}
                	            	    	if(styleName.equals(" "))
                	            	    	{
                	            	    		
                	            	    	}
                	            	    	if(styleName.equals("30 min timer"))
                	            	    	{
                	            	    		time="30";
                	            	    		startClock.setEnabled(true);
                	            	    	}
                	            	    	if(styleName.equals("60 min timer"))
                	            	    	{
                	            	    		time="60";
                	            	    		startClock.setEnabled(true);
                	            	    	}
                	            	    	if(styleName.equals("90 min timer"))
                	            	    	{
                	            	    		time="90";
                	            	    		startClock.setEnabled(true);
                	            	    	}
                	            	    }
                	            	    });
                	           	
                	           
                	           startClock.setEnabled(false);
                	           startClock.addActionListener(new ActionListener(){

                	       	    @Override
                	       	    public void actionPerformed(ActionEvent e)
                	       	    {
                	       	    	
                	       	    	new Board(example.getName(),(String)timestyle.getSelectedItem(),(String)delaystyle.getSelectedItem());
                	       	    	picker.dispose();
                	       	    	
                	       	    	
                	       	    }
                	       	    });
                	           
                	           g.gridwidth=2;
                	           g.gridx=1;
                	           g.gridy=1;
                	           
                	           g.insets=new Insets(0, 150, 0, -50);
                	           paneler.add(timestyle,g);
                	           
                	           g.gridx=0;
                	           g.gridy=1;
                	           g.insets=new Insets(0, 165, 0, 0);
                	          paneler.add(delaystyle,g);

                	           g.gridx=0;
                	           g.gridy=1;
                	           g.insets=new Insets(0, 150, 0, 0);
                	           
                	           g.gridx=2;
                	           g.gridy=2;
                	           g.insets=new Insets(10, -230, 60, 0);
                	           paneler.add(startClock,g);
                	           
                	           g.gridwidth=1;
                	           g.gridx=0;
                	           g.gridy=0;
                	           g.gridwidth=g.fill;
                	           g.insets=new Insets(0, 0, 0, 0);
                	           paneler.add(name,g);
                	           picker.add(paneler);
                	           picker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                	           picker.setLocationRelativeTo(null);
                	           picker.setResizable(false);
                	           picker.setVisible(true);
                	    }
                	    });
//                    
         	   g.gridwidth=2;
   	           g.gridx=1;
   	           g.gridy=1;
   	           
   	           g.insets=new Insets(0, -50, 0, -100);
   	           paneler.add(AIs,g);
   	           
   	           g.gridx=0;
   	           g.gridy=1;
   	           g.insets=new Insets(0, 205, 0, -50);
   	           paneler.add(colors,g);

   	           g.gridx=2;
   	           g.gridy=1;
   	           g.insets=new Insets(0, -45, 0, 0);
   	           paneler.add(AIorNo,g);
   	           
   	           g.gridx=2;
   	           g.gridy=2;
   	           g.insets=new Insets(0, -230, 0, 0);
   	           paneler.add(new JLabel(new ImageIcon(ChessRunner.class.getResource("/resources/Nyehh.png"))),g);
   	           
   	           g.gridwidth=1;
   	           g.gridx=0;
   	           g.gridy=0;
   	           g.gridwidth=g.fill;
   	           g.insets=new Insets(0, 0, 0, 0);
   	           paneler.add(name,g);
   	           picker.add(paneler);
   	           picker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	           picker.setLocationRelativeTo(null);
   	           picker.setResizable(false);
   	           picker.setVisible(true);
                   
				}
             
             });
             g.gridwidth=2;
             g.gridx=1;
             g.gridy=1;
             
             g.insets=new Insets(0, 150, 0, -50);
             paneler.add(start,g);
             
             g.gridx=0;
             g.gridy=1;
             g.insets=new Insets(0, 165, 0, 0);
            paneler.add(style,g);

             g.gridx=0;
             g.gridy=1;
             g.insets=new Insets(0, 150, 0, 0);
             
             g.gridx=2;
             g.gridy=2;
             g.insets=new Insets(0, -230, 0, 0);
             paneler.add(example,g);
             
             g.gridwidth=1;
             g.gridx=0;
             g.gridy=0;
             g.gridwidth=g.fill;
             g.insets=new Insets(0, 0, 0, 0);
             paneler.add(name,g);
             picker.add(paneler);
             picker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             picker.setLocationRelativeTo(null);
             picker.setResizable(false);
             picker.setVisible(true);
	}

}
