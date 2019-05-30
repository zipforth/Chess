import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class CheckAttack 
{
	protected static ArrayList<Integer> lineOfAttackx;
	protected static ArrayList<Integer> lineOfAttacky;
	public static boolean isAttacked(int rows, int columns,String side,JLabel layout[][])
	{
		String opp;
		if(side.equals("B"))
			opp="W.png";
		else
			opp="B.png";
		ImageIcon checker=new ImageIcon(ChessRunner.class.getResource("/resources/Nyehh.png"),"Nyehh.png");
		int two=1;
		int one=1;
		lineOfAttackx=new ArrayList<Integer>();
		lineOfAttacky=new ArrayList<Integer>();
		for(;rows-one>=0;one++,two++)//UP LEFT
		{
			if((columns-two)>=0)
			{
				checker=(ImageIcon)layout[rows-one][columns-two].getIcon();
				
				if(checker.getDescription().contains(Board.queen+opp)||checker.getDescription().contains(Board.bishop+opp))
				{
					lineOfAttackx.add(rows-one);
					lineOfAttacky.add(columns-two);
					return true;
				}
				
				
			}
			if(!(checker.getDescription().contains("Nyehh.png")))
				break;
		}
		two=1;
		one=1;
		lineOfAttackx=new ArrayList<Integer>();
		lineOfAttacky=new ArrayList<Integer>();
		for(;rows-one>=0;one++,two++)//UP RIGHT
		{
			if(columns+two<8)
			{
				checker=(ImageIcon) layout[rows-one][columns+two].getIcon();
				
				if(checker.getDescription().contains(Board.queen+opp)||checker.getDescription().contains(Board.bishop+opp))
					{
					lineOfAttackx.add(rows-one);
					lineOfAttacky.add(columns+two);
					return true;					
					}
				
			}
			if(!(checker.getDescription().contains("Nyehh.png")))
				break;
		}
		two=1;
		one=1;
		lineOfAttackx=new ArrayList<Integer>();
		lineOfAttacky=new ArrayList<Integer>();
		for(;rows+one<8;one++,two++)//BOTTOM LEFT
		{
			if(columns-two>=0)
			{
				checker=(ImageIcon) layout[rows+one][columns-two].getIcon();
				
				if(checker.getDescription().contains(Board.queen+opp)||checker.getDescription().contains(Board.bishop+opp))
					{lineOfAttackx.add(rows+one);
				lineOfAttacky.add(columns-two);return true;
					}
				
			}
			if(!(checker.getDescription().contains("Nyehh.png")))
				break;
		}
		two=1;
		one=1;
		lineOfAttackx=new ArrayList<Integer>();
		lineOfAttacky=new ArrayList<Integer>();
		for(;rows+one<8;one++,two++)//BOTTOM RIGHT
		{
			if(columns+two<8)
			{
				checker=(ImageIcon) layout[rows+one][columns+two].getIcon();
				
				if(checker.getDescription().contains(Board.queen+opp)||checker.getDescription().contains(Board.bishop+opp))
					{lineOfAttackx.add(rows+one);
				lineOfAttacky.add(columns+two);return true;}
				
			}
			if(!(checker.getDescription().contains("Nyehh.png")))
				break;
		}
		int x=1;
		lineOfAttackx=new ArrayList<Integer>();
		lineOfAttacky=new ArrayList<Integer>();
		for(;columns+x<8;x++)
		{
			checker=(ImageIcon)layout[rows][columns+x].getIcon();
			
			if(checker.getDescription().contains(Board.queen+opp)||checker.getDescription().contains(Board.rook+opp))
				{lineOfAttackx.add(rows);
			lineOfAttacky.add(columns+x);return true;}
			if(!(checker.getDescription().contains("Nyehh.png")))
			{
				break;
			}
		}
		x=1;
		lineOfAttackx=new ArrayList<Integer>();
		lineOfAttacky=new ArrayList<Integer>();
		for(;columns-x>=0;x++)
		{
			checker=(ImageIcon)layout[rows][columns-x].getIcon();
			
			if(checker.getDescription().contains(Board.queen+opp)||checker.getDescription().contains(Board.rook+opp))
				{lineOfAttackx.add(rows);
			lineOfAttacky.add(columns-x);return true;}
			if(!(checker.getDescription().contains("Nyehh.png")))
			{
				break;
			}
		}
		x=1;
		lineOfAttackx=new ArrayList<Integer>();
		lineOfAttacky=new ArrayList<Integer>();
		for(;rows+x<8;x++)
		{
			checker=(ImageIcon)layout[rows+x][columns].getIcon();
			
			if(checker.getDescription().contains(Board.queen+opp)||checker.getDescription().contains(Board.rook+opp))
				{lineOfAttackx.add(rows+x);
			lineOfAttacky.add(columns);return true;}
			if(!(checker.getDescription().contains("Nyehh.png")))
			{
				break;
			}
		}
		x=1;
		lineOfAttackx=new ArrayList<Integer>();
		lineOfAttacky=new ArrayList<Integer>();
		for(;rows-x>=0;x++)
		{
			checker=(ImageIcon)layout[rows-x][columns].getIcon();
			
			if(checker.getDescription().contains(Board.queen+opp)||checker.getDescription().contains(Board.rook+opp))
				{lineOfAttackx.add(rows-x);
			lineOfAttacky.add(columns);return true;}
			if(!(checker.getDescription().contains("Nyehh.png")))
			{
				break;
			}
		}
		if(rows-2>=0)
		{
			lineOfAttackx=new ArrayList<Integer>();
			lineOfAttacky=new ArrayList<Integer>();
			if(columns-1>=0)
			{
				checker=(ImageIcon)layout[rows-2][columns-1].getIcon();
				
				if(checker.getDescription().contains(Board.knight+opp))
					{lineOfAttackx.add(rows-2);
				lineOfAttacky.add(columns-1);return true;}
			}
			lineOfAttackx=new ArrayList<Integer>();
			lineOfAttacky=new ArrayList<Integer>();
			if(columns+1<8)
			{
				checker=(ImageIcon)layout[rows-2][columns+1].getIcon();
				
				if(checker.getDescription().contains(Board.knight+opp))
					{lineOfAttackx.add(rows-2);
				lineOfAttacky.add(columns+1);return true;}
			}
		}
		if(rows+2<8)
		{
			lineOfAttackx=new ArrayList<Integer>();
			lineOfAttacky=new ArrayList<Integer>();
			if(columns-1>=0)
			{
				checker=(ImageIcon)layout[rows+2][columns-1].getIcon();
				
				if(checker.getDescription().contains(Board.knight+opp))
					{lineOfAttackx.add(rows+2);
				lineOfAttacky.add(columns-1);return true;}
			}
			lineOfAttackx=new ArrayList<Integer>();
			lineOfAttacky=new ArrayList<Integer>();
			if(columns+1<8)
			{
				checker=(ImageIcon)layout[rows+2][columns+1].getIcon();
				
				if(checker.getDescription().contains(Board.knight+opp))
					{lineOfAttackx.add(rows+2);
					lineOfAttacky.add(columns+1);return true;}
			}
		}
		if(columns-2>=0)
		{
			lineOfAttackx=new ArrayList<Integer>();
			lineOfAttacky=new ArrayList<Integer>();
			if(rows-1>=0)
			{
				checker=(ImageIcon)layout[rows-1][columns-2].getIcon();
				
				if(checker.getDescription().contains(Board.knight+opp))
				{
					lineOfAttackx.add(rows-1);
					lineOfAttacky.add(columns-2);
					return true;
				}
			}
			lineOfAttackx=new ArrayList<Integer>();
			lineOfAttacky=new ArrayList<Integer>();
			if(rows+1<8)
			{
				checker=(ImageIcon)layout[rows+1][columns-2].getIcon();
				
				if(checker.getDescription().contains(Board.knight+opp))
				{
					lineOfAttackx.add(rows+1);
					lineOfAttacky.add(columns-2);
					return true;
				}
			}
		}
		if(columns+2<8)
		{
			lineOfAttackx=new ArrayList<Integer>();
			lineOfAttacky=new ArrayList<Integer>();
			if(rows-1>=0)
			{
				checker=(ImageIcon)layout[rows-1][columns+2].getIcon();
				
				if(checker.getDescription().contains(Board.knight+opp))
				{
					lineOfAttackx.add(rows-1);
					lineOfAttacky.add(columns+2);
					return true;
				}
			}
			lineOfAttackx=new ArrayList<Integer>();
			lineOfAttacky=new ArrayList<Integer>();
			if(rows+1<8)
			{
				checker=(ImageIcon)layout[rows+1][columns+2].getIcon();
				
				if(checker.getDescription().contains(Board.knight+opp))
				{
					lineOfAttackx.add(rows+1);
					lineOfAttacky.add(columns+2);
					return true;
				}
			}
		}
		if(rows+1<8)
		{
			checker=(ImageIcon)layout[rows+1][columns].getIcon();
			if(checker.getDescription().contains(Board.king+opp))
				return true;
			if(columns-1>=0)
			{
				checker=(ImageIcon)layout[rows+1][columns-1].getIcon();
				if(checker.getDescription().contains(Board.king+opp))
					return true;
			}
			if(columns+1<8)
			{
				checker=(ImageIcon)layout[rows+1][columns+1].getIcon();
				if(checker.getDescription().contains(Board.king+opp))
					return true;
			}	
		}
		if(rows-1>=0)
		{
			checker=(ImageIcon)layout[rows-1][columns].getIcon();
			if(checker.getDescription().contains(Board.king+opp))
				return true;
			if(columns-1>=0)
			{
				checker=(ImageIcon)layout[rows-1][columns-1].getIcon();
				if(checker.getDescription().contains(Board.king+opp))
					return true;
			}
			if(columns+1<8)
			{
				checker=(ImageIcon)layout[rows-1][columns+1].getIcon();
				if(checker.getDescription().contains(Board.king+opp))
					return true;
			}	
		}
		if(columns+1<8)
		{
			checker=(ImageIcon)layout[rows][columns+1].getIcon();
			if(checker.getDescription().contains(Board.king+opp))
				return true;
		}
		if(columns-1>=0)
		{
			checker=(ImageIcon)layout[rows][columns-1].getIcon();
			if(checker.getDescription().contains(Board.king+opp))
				return true;
		}
		lineOfAttackx=new ArrayList<Integer>();
		lineOfAttacky=new ArrayList<Integer>();
		if(side.contains("W"))
		{
			if(rows-1>=0)
			{
				if(columns-1>=0)
				{
					checker=(ImageIcon)layout[rows-1][columns-1].getIcon();
					
					if(checker.getDescription().contains(Board.pawn+opp)||checker.getDescription().contains(Board.queen+opp))
					{
						lineOfAttackx.add(rows-1);
						lineOfAttacky.add(columns-1);
						return true;
					}
					
				}
				lineOfAttackx=new ArrayList<Integer>();
				lineOfAttacky=new ArrayList<Integer>();
				if(columns+1<8)
				{
					checker=(ImageIcon)layout[rows-1][columns+1].getIcon();
					
					if(checker.getDescription().contains(Board.pawn+opp)||checker.getDescription().contains(Board.queen+opp))
					{
						lineOfAttackx.add(rows-1);
						lineOfAttacky.add(columns+1);
						return true;
					}
				}
			}
		}
		lineOfAttackx=new ArrayList<Integer>();
		lineOfAttacky=new ArrayList<Integer>();
		if(side.contains("B"))
		{
			if(rows+1<8)
			{
				if(columns-1>=0)
				{
					checker=(ImageIcon)layout[rows+1][columns-1].getIcon();
					
					if(checker.getDescription().contains(Board.pawn+opp)||checker.getDescription().contains(Board.queen+opp))
					{
						lineOfAttackx.add(rows+1);
						lineOfAttacky.add(columns-1);
						return true;
					}
				}
				lineOfAttackx=new ArrayList<Integer>();
				lineOfAttacky=new ArrayList<Integer>();
				if(columns+1<8)
				{
					checker=(ImageIcon)layout[rows+1][columns+1].getIcon();
					
					if(checker.getDescription().contains(Board.pawn+opp)||checker.getDescription().contains(Board.queen+opp))
					{
						lineOfAttackx.add(rows+1);
						lineOfAttacky.add(columns+1);
						return true;
					}
				}
			}
		}
		return false;
	}
	public static boolean checkMate(String sideToLose,JLabel[][] layout)
	{
		ArrayList<Integer>Xpos=new ArrayList<Integer>();
		PieceMover pc=new PieceMover();
		if(sideToLose.contains("B"))
			Xpos.addAll(PieceMover.King(Board.kingB[0],Board.kingB[1],layout,sideToLose));
		if(sideToLose.contains("W"))
			Xpos.addAll(PieceMover.King(Board.kingW[0],Board.kingW[1],layout,sideToLose));
		
			for(int rows=0;rows<8;rows++)
			{
				for(int columns=0;columns<8;columns++)
				{
					ImageIcon checker= (ImageIcon) layout[rows][columns].getIcon();
					if(checker.getDescription().contains(sideToLose))
					{
						if(checker.getDescription().contains("knight"))
						{
							Xpos.addAll(PieceMover.Knight(rows, columns,layout,sideToLose));
						}
						if(checker.getDescription().contains("bishop"))
						{
							Xpos.addAll(PieceMover.Bishop(rows, columns,layout,sideToLose));
						}
						if(checker.getDescription().contains("pawn"))
						{
							Xpos.addAll(PieceMover.Pawn(rows, columns,layout,sideToLose));
						}
						if(checker.getDescription().contains("rook"))
						{
							Xpos.addAll(PieceMover.Rook(rows, columns,layout,sideToLose));
						}
						if(checker.getDescription().contains("queen"))
						{
							Xpos.addAll(PieceMover.Queen(rows, columns,layout,sideToLose));
						}
						for(int i=0;i<Xpos.size();i+=2)
						{
							ImageIcon originalToMove=(ImageIcon) layout[Xpos.get(i)][Xpos.get(i+1)].getIcon();
							layout[rows][columns].setIcon(new ImageIcon(ChessRunner.class.getResource("/resources/Nyehh.png"),"Nyehh.png"));
							if(sideToLose.contains("B"))
							{
								if(!isAttacked(Board.kingB[0],Board.kingB[1],sideToLose,layout))
								{
									layout[rows][columns].setIcon(checker);
									layout[Xpos.get(i)][Xpos.get(i+1)].setIcon(originalToMove);
									return false;
								}
						
							}
							if(sideToLose.contains("W"))
							{
								
								if(!isAttacked(Board.kingW[0],Board.kingW[1],sideToLose,layout))
								{
									layout[rows][columns].setIcon(checker);
									layout[Xpos.get(i)][Xpos.get(i+1)].setIcon(originalToMove);
									return false;
								}
							}
							layout[rows][columns].setIcon(checker);
							layout[Xpos.get(i)][Xpos.get(i+1)].setIcon(originalToMove);
							
						}
						
					}
				}
			}
			
			return true;
		
	}
	public static boolean checkDrawPlayed(int row,int col,String wouldveLost,JLabel[][] layout)
	{
		ArrayList<Integer>Xpos=new ArrayList<Integer>();
		PieceMover pc=new PieceMover();
		Xpos.addAll(PieceMover.King(row, col, layout, wouldveLost));	
		
			for(int rows=0;rows<8;rows++)
			{
				for(int columns=0;columns<8;columns++)
				{
					ImageIcon checker= (ImageIcon) layout[rows][columns].getIcon();
					if(checker.getDescription().contains(wouldveLost))
					{
						if(checker.getDescription().contains("knight"))
						{
							Xpos.addAll(PieceMover.Knight(rows, columns,layout,wouldveLost));
						}
						if(checker.getDescription().contains("bishop"))
						{
							Xpos.addAll(PieceMover.Bishop(rows, columns,layout,wouldveLost));
						}
						if(checker.getDescription().contains("pawn"))
						{
							Xpos.addAll(PieceMover.Pawn(rows, columns,layout,wouldveLost));
						}
						if(checker.getDescription().contains("rook"))
						{
							Xpos.addAll(PieceMover.Rook(rows, columns,layout,wouldveLost));
						}
						if(checker.getDescription().contains("queen"))
						{
							Xpos.addAll(PieceMover.Queen(rows, columns,layout,wouldveLost));
						}
						if(!Xpos.isEmpty())
						{
							return false;
						}
					}
				}
			}
			return true;
		
	}
	public static boolean CheckForMate(JLabel[][] layout,String color)
	{
		ArrayList<Integer> moves=new ArrayList<Integer>();
		JLabel [][] tester=new JLabel[8][8];
		for(int r=0;r<8;r++)
		{
			for(int c=0;c<8;c++)
			{
				JLabel j=new JLabel();
				j=layout[r][c];
				tester[r][c]=new JLabel();
				tester[r][c].setName((j.getName()));
				tester[r][c].setIcon(j.getIcon());
			}
		}
		for(int r=0;r<8;r++)
		{
			for(int c=0;c<8;c++)
			{
				if(tester[r][c].getName().contains("queen"))
				{
					moves.addAll(PieceMover.Queen(r, c, tester, color));
				}
				if(tester[r][c].getName().contains("knight"))
				{
					moves.addAll(PieceMover.Knight(r, c, tester, color));
				}
				if(tester[r][c].getName().contains("bishop"))
				{
					moves.addAll(PieceMover.Bishop(r, c, tester, color));
				}
				if(tester[r][c].getName().contains("rook"))
				{
					moves.addAll(PieceMover.Rook(r, c, tester, color));
				}
				if(tester[r][c].getName().contains("pawn"))
				{
					moves.addAll(PieceMover.Pawn(r, c, tester, color));
				}
					for(int x=0;x<moves.size()-1;x+=2)
					{
						tester[moves.get(x)][moves.get(x+1)].setName(tester[r][c].getName());
						tester[moves.get(x)][moves.get(x+1)].setIcon(tester[r][c].getIcon());
						tester[r][c].setName("Nyehh");
						tester[r][c].setIcon(new ImageIcon(ChessRunner.class.getResource("/resources/"+"Nyehh.png")));
						if(color.contains("B"))
						{
							if(!isAttacked(Board.kingB[0],Board.kingB[1],"B",tester))
							{
								return false;
							}
						}
						else
						{
							if(!isAttacked(Board.kingW[0],Board.kingW[1],"W",tester))
							{
								return false;
							}
						}
						tester[r][c].setName(tester[moves.get(x)][moves.get(x+1)].getName());
						tester[r][c].setIcon(tester[moves.get(x)][moves.get(x+1)].getIcon());
						tester[moves.get(x)][moves.get(x+1)].setName("Nyehh");
						tester[moves.get(x)][moves.get(x+1)].setIcon(new ImageIcon(ChessRunner.class.getResource("/resources/"+"Nyehh.png")));
					}
			}
		}
		return true;
	}
}
