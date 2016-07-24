package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Tic extends JFrame{
	private static Tic instance;
	public static String currentPlayer = "X";
	private static Box[][] boxes = new Box[3][3];
	private static boolean GameOver = false;
	private Glass glass;
	private Menu menu;
	
	public Tic()
	{
		instance = this;
		menu = new Menu();
		setJMenuBar(menu);
		setLayout(new GridLayout(3, 3, 5, 5));
		int i = 0;
		for (int x = 0; x < 3; x++)
		{
			for (int y = 0; y < 3; y++)
			{
				Box pan = new Box(i);
				pan.setVisible(true);
				pan.setBackground(Color.LIGHT_GRAY);
				add(pan);
				boxes[x][y] = pan;
				i++;
			}
		}
		glass = new Glass();
		setGlassPane(glass);
		glass.setVisible(true);
	}
	public static boolean getGameOver()
	{
		return GameOver;
	}
	public static void quit()
	{
		System.exit(0);
	}
	public static void reset()
	{
		for (int x = 0; x < 3; x++)
		{
			for (int y = 0; y < 3; y++)
			{
				Box pan = boxes[x][y];
				pan.setBackground(Color.LIGHT_GRAY);
				pan.text = "";
				pan.repaint();
			}
		}
		getInstance().glass.setVisible(false);
		GameOver = false;
	}
	public static void checkVictory()
	{
		for (int row = 0;row < 3;row++) //X
		{
			if (boxes[row][0].text.equals(boxes[row][1].text) 
				&& 
				boxes[row][1].text.equals(boxes[row][2].text))
			{
				if (!boxes[row][0].text.equals(""))
				{
					for (int i = 0; i<3; i++)
					{
						boxes[row][i].setBackground(new Color(0,200,0));
					}
					GameOver = true;
				}
			}
		}
		for (int column = 0;column < 3;column++) //X
		{
			if (boxes[0][column].text.equals(boxes[1][column].text) 
				&& 
				boxes[1][column].text.equals(boxes[2][column].text))
			{
				if (!boxes[0][column].text.equals(""))
				{
					for (int i = 0; i<3; i++)
					{
						boxes[i][column].setBackground(new Color(0,200,0));
					}
					GameOver = true;
				}
			}
		}
		if (boxes[0][0].text.equals(boxes[1][1].text) &&
			boxes[1][1].text.equals(boxes[2][2].text))
		{
			if (!boxes[0][0].text.equals(""))
			{
				for (int i = 0;i<3;i++)
				{
					boxes[i][i].setBackground(new Color(0,200,0));
				}
				GameOver = true;
			}
		}
		if (boxes[0][2].text.equals(boxes[1][1].text) &&
			boxes[1][1].text.equals(boxes[2][0].text))
		{
			if (!boxes[0][2].text.equals(""))
			{
				for (int i = 0;i<3;i++)
				{
					boxes[i][2-i].setBackground(new Color(0,200,0));
				}
				GameOver = true;
			}
		}
		//-----If all squares are filled in and no win then...
		boolean a = true;
		for (int x = 0; x < 3; x++)
		{
			for (int y = 0; y < 3; y++)
			{
				if (boxes[x][y].text.equals(""))
				{
					a = false;
				}
			}
		}
		if (a && !GameOver)
		{
			for (int x = 0; x < 3; x++)
			{
				for (int y = 0; y < 3; y++)
				{
					boxes[x][y].setBackground(new Color(220,50,50));
				}
			}
			GameOver = true;
		}
		if (GameOver)
		{
			getInstance().glass.text = "Game Over!";
			getInstance().glass.setVisible(true);
		}
	}
	public static Tic getInstance()
	{
		return instance;
	}
	public static void main(String[] args) {
		Tic tic = new Tic();
		tic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tic.setSize(new Dimension(500, 500));
		tic.setLocationRelativeTo(null);
		tic.setVisible(true);
	}

}
