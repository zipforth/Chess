import java.util.ArrayList;

import javax.swing.JLabel;

public class PieceMover 
{
	private static boolean kingMovedB = false;
	private static boolean kingMovedW = false;
	private static boolean rookMovedWL = false;
	private static boolean rookMovedWR = false;
	private static boolean rookMovedBL = false;
	private static boolean rookMovedBR = false;
	public static ArrayList Bishop(int row, int col, JLabel [][] layout, String color)
	{
		ArrayList<Integer> moves= new ArrayList<Integer>();
		for(int x=col+1,y=row+1;x<8 &&y<8;x++,y++)
		{
			if(layout[y][x].getName().contains("Nyehh"))
			{
				moves.add(y);
				moves.add(x);
			}
			else
			{
				if(!layout[y][x].getName().contains(color))
				{
					moves.add(y);
					moves.add(x);
				}
				x=9;
			}
			
		}
		for(int x=col+1,y=row-1;x<8 && y>=0;x++,y--)
		{
			if(layout[y][x].getName().contains("Nyehh"))
			{
				moves.add(y);
				moves.add(x);
			}
			else
			{
				if(!layout[y][x].getName().contains(color))
				{
					moves.add(y);
					moves.add(x);
				}
				x=9;
			}
		}
		for(int x=col-1,y=row-1;x>=0 && y>=0;x--,y--)
		{
			if(layout[y][x].getName().contains("Nyehh"))
			{
				moves.add(y);
				moves.add(x);
			}
			else
			{
				if(!layout[y][x].getName().contains(color))
				{
					moves.add(y);
					moves.add(x);
				}
				x=-2;
			}
		}
		for(int x=col-1,y=row+1;x>=0 && y<8;x--,y++)
		{
			if(layout[y][x].getName().contains("Nyehh"))
			{
				moves.add(y);
				moves.add(x);
			}
			else
			{
				if(!layout[y][x].getName().contains(color))
				{
					moves.add(y);
					moves.add(x);
				}
				y=9;
			}
		}
		return moves;
		
	}
	public static ArrayList Rook(int row, int col, JLabel[][] layout, String color)
	{
		ArrayList<Integer> moves= new ArrayList<Integer>();
		for(int y=row+1;y<8;y++)
		{
			if(layout[y][col].getName().contains("Nyehh"))
			{
				moves.add(y);
				moves.add(col);
			}
			else
			{
				if(!layout[y][col].getName().contains(color))
				{
					moves.add(y);
					moves.add(col);
				}
				y=9;
			}
			
		}
		for(int y=row-1;y>=0;y--)
		{
			if(layout[y][col].getName().contains("Nyehh"))
			{
				moves.add(y);
				moves.add(col);
			}
			else
			{
				if(!layout[y][col].getName().contains(color))
				{
					moves.add(y);
					moves.add(col);
				}
				y=-2;
			}
			
		}
		for(int x=col-1;x>=0;x--)
		{
			if(layout[row][x].getName().contains("Nyehh"))
			{
				moves.add(row);
				moves.add(x);
			}
			else
			{
				if(!layout[row][x].getName().contains(color))
				{
					moves.add(row);
					moves.add(x);
				}
				x=-2;
			}
			
		}
		for(int x=col+1;x<8;x++)
		{
			if(layout[row][x].getName().contains("Nyehh"))
			{
				moves.add(row);
				moves.add(x);
			}
			else
			{
				if(!layout[row][x].getName().contains(color))
				{
					moves.add(row);
					moves.add(x);
				}
				x=9;
			}
			
		}
		return moves;
		
	}
	public static ArrayList Queen(int row, int col, JLabel [][] layout, String color)
	{
		ArrayList<Integer> moves= new ArrayList<Integer>();
		moves.addAll(Bishop(row,col,layout, color));
		moves.addAll(Rook(row,col,layout, color));
		
		return moves;
		
	}
	public static ArrayList Pawn(int row, int col, JLabel [][] layout, String color)
	{
		ArrayList<Integer> moves= new ArrayList<Integer>();
		if(color.equals("W"))
		{
			if(col+1<8)
			{
				if(col+1==Board.enpassant[1]&&row==Board.enpassant[0]&&layout[row][col+1].getName().contains("B"))
				{
					moves.add(row-1);
					moves.add(col+1);
				}
			}
			if(col-1>=0)
			{
				if(col-1==Board.enpassant[1]&&row==Board.enpassant[0]&&layout[row][col-1].getName().contains("B"))
				{
					moves.add(row-1);
					moves.add(col-1);
				}
			}
			if(row-1>=0&&layout[row-1][col].getName().contains("Nyehh"))
			{
				moves.add(row-1);
				moves.add(col);
				if(row==6)
				{
					if(layout[row-2][col].getName().contains("Nyehh"))
					{
						moves.add(row-2);
						moves.add(col);
					}
				}
			}
			if(col-1>=0 && row-1>=0 && !layout[row-1][col-1].getName().contains("Nyehh")&&!layout[row-1][col-1].getName().contains("W"))
			{
				moves.add(row-1);
				moves.add(col-1);
			}
			if(col+1<8 && row-1>=0 && !layout[row-1][col+1].getName().contains("Nyehh")&&!layout[row-1][col+1].getName().contains("W"))
			{
				moves.add(row-1);
				moves.add(col+1);
			}
			
			
		}
		if(color.equals("B"))
		{
			if(col+1<8)
			{
				if(col+1==Board.enpassant[1]&&row==Board.enpassant[0]&&layout[row][col+1].getName().contains("W"))
				{
					moves.add(row+1);
					moves.add(col+1);
				}
			}
			if(col-1>=0)
			{
				if(col-1==Board.enpassant[1]&&row==Board.enpassant[0]&&layout[row][col-1].getName().contains("W"))
				{
					moves.add(row+1);
					moves.add(col-1);
				}
			}
			if(row+1<8&&layout[row+1][col].getName().contains("Nyehh"))
			{
				moves.add(row+1);
				moves.add(col);
				if(row==1)
				{
					if(layout[row+2][col].getName().contains("Nyehh"))
					{
						moves.add(row+2);
						moves.add(col);
					}
				}
			}
			if(col-1>=0 && row+1<8 && !layout[row+1][col-1].getName().contains("Nyehh")&&!layout[row+1][col-1].getName().contains("B"))
			{
				moves.add(row+1);
				moves.add(col-1);
			}
			if(col+1<8 && row+1<8 && !layout[row+1][col+1].getName().contains("Nyehh")&&!layout[row+1][col+1].getName().contains("B"))
			{
				moves.add(row+1);
				moves.add(col+1);
			}
		}
		
		return moves;
	}
	public static ArrayList King(int row, int col, JLabel [][] layout, String color)
	{
		ArrayList<Integer> moves= new ArrayList<Integer>();
		if(col-1>=0 && row+1<8 && !layout[row+1][col-1].getName().contains(color))
		{
			moves.add(row+1);
			moves.add(col-1);
		}
		if(col+1<8 && row+1<8 && !layout[row+1][col+1].getName().contains(color))
		{
			moves.add(row+1);
			moves.add(col+1);
		}
		if(col-1>=0 && row-1>=0 && !layout[row-1][col-1].getName().contains(color))
		{
			moves.add(row-1);
			moves.add(col-1);
		}
		if(col+1<8 && row-1>=0 &&!layout[row-1][col+1].getName().contains(color))
		{
			moves.add(row-1);
			moves.add(col+1);
		}
		if(col+1<8 &&!layout[row][col+1].getName().contains(color))
		{
			moves.add(row);
			moves.add(col+1);
		}
		if(col-1>=0 &&!layout[row][col-1].getName().contains(color))
		{
			moves.add(row);
			moves.add(col-1);
		}
		if(row-1>=0 &&!layout[row-1][col].getName().contains(color))
		{
			moves.add(row-1);
			moves.add(col);
		}
		if(row+1<8 &&!layout[row+1][col].getName().contains(color))
		{
			moves.add(row+1);
			moves.add(col);
		}
		for(int x=moves.size()-1;x>=0;x-=2)
		{
			if(CheckAttack.isAttacked(moves.get(x-1), moves.get(x), color, layout))
			{
				moves.remove(x);
				moves.remove(x-1);
			}
		}
		if(color.contains("B"))
			if(!Board.kingBMo)
			{
				if(layout[0][3].getName().contains("Nyehh")&&layout[0][2].getName().contains("Nyehh")&&layout[0][1].getName().contains("Nyehh")&&!Board.rookBLMo)
				{
					if(!CheckAttack.isAttacked(0, 3, "B", layout)&&!CheckAttack.isAttacked(0, 2, "B", layout)&&!CheckAttack.isAttacked(0, 4, "B", layout))
					{
					moves.add(0);
					moves.add(2);
					}
				}
				if(layout[0][5].getName().contains("Nyehh")&&layout[0][6].getName().contains("Nyehh")&&!Board.rookBRMo)
				{
					if(!CheckAttack.isAttacked(0, 4, "B", layout)&&!CheckAttack.isAttacked(0, 5, "B", layout)&&!CheckAttack.isAttacked(0, 6, "B", layout))
					{
					moves.add(0);
					moves.add(6);
					}
				}
			}
		if(color.contains("W"))
			if(!Board.kingWMo)
			{
				if(layout[7][3].getName().contains("Nyehh")&&layout[7][2].getName().contains("Nyehh")&&layout[7][1].getName().contains("Nyehh")&&!Board.rookWLMo)
				{
					if(!CheckAttack.isAttacked(7, 3, "W", layout)&&!CheckAttack.isAttacked(7, 2, "W", layout)&&!CheckAttack.isAttacked(7, 4, "W", layout))
					{
						moves.add(7);
						moves.add(2);
					}
					
				}
				if(layout[7][5].getName().contains("Nyehh")&&layout[7][6].getName().contains("Nyehh")&&!Board.rookWRMo)
				{
					if(!CheckAttack.isAttacked(7, 4, "W", layout)&&!CheckAttack.isAttacked(7, 5, "W", layout)&&!CheckAttack.isAttacked(7, 6, "W", layout))
					{
					moves.add(7);
					moves.add(6);
					}
				}
			}
		return moves;
		
	}
	public static ArrayList Knight(int row, int col, JLabel [][] layout, String color)
	{
		ArrayList<Integer> moves= new ArrayList<Integer>();
		if(row+2<8)
		{
			if(col+1<8 && !layout[row+2][col+1].getName().contains(color))
			{
				moves.add(row+2);
				moves.add(col+1);
			}
			if(col-1>=0 && !layout[row+2][col-1].getName().contains(color))
			{
				moves.add(row+2);
				moves.add(col-1);
			}
		}
		if(row-2>=0)
		{
			if(col+1<8 && !layout[row-2][col+1].getName().contains(color))
			{
				moves.add(row-2);
				moves.add(col+1);
			}
			if(col-1>=0 && !layout[row-2][col-1].getName().contains(color))
			{
				moves.add(row-2);
				moves.add(col-1);
			}
		}
		if(col+2<8)
		{
			if(row+1<8 && !layout[row+1][col+2].getName().contains(color))
			{
				moves.add(row+1);
				moves.add(col+2);
			}
			if(row-1>=0 && !layout[row-1][col+2].getName().contains(color))
			{
				moves.add(row-1);
				moves.add(col+2);
			}
		}
		if(col-2>=0)
		{
			if(row+1<8 && !layout[row+1][col-2].getName().contains(color))
			{
				moves.add(row+1);
				moves.add(col-2);
			}
			if(row-1>=0 && !layout[row-1][col-2].getName().contains(color))
			{
				moves.add(row-1);
				moves.add(col-2);
			}
		}
		return moves;
		
	}
		
}
