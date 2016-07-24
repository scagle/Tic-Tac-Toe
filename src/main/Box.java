package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Box extends JPanel implements MouseListener{
	
	private int number;
	public String text = "";
	Font myFont = new Font("Serif", Font.BOLD, 48);
	BufferedImage xcursor, ocursor;
	
	public Box(int number)
	{
		xcursor = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = xcursor.createGraphics();
		g.setColor(Color.black);
		g.setFont(new Font("Serif", Font.BOLD, 10));
		g.drawString("X", 10, 10);
		ocursor = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = ocursor.createGraphics();
		g2.setColor(Color.black);
		g2.setFont(new Font("Serif", Font.BOLD, 10));
		g2.drawString("O", 10, 10);
		this.number = number;
		addMouseListener(this);
	}
	public int getNumber()
	{
		return number;
	}
	public void mouseClicked(MouseEvent e) {

	}
	public void mousePressed(MouseEvent e) {
		if (!Tic.getGameOver())
		{
			if (text.equals(""))
			{
				text = Tic.currentPlayer;
				if (Tic.currentPlayer.equals("X"))
				{
					Tic.currentPlayer = "O";
				}
				else if (Tic.currentPlayer.equals("O"))
				{
					Tic.currentPlayer = "X";
				}
				Tic.checkVictory();
			}
		}
		else
		{
			Tic.reset();
		}
		repaint();
		mouseEntered(e);
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		BufferedImage cursor = null;
		if (Tic.currentPlayer.equals("X"))
		{
			cursor = xcursor;
		}
		if (Tic.currentPlayer.equals("O"))
		{
			cursor = ocursor;
		}
		Tic.getInstance().setCursor(Toolkit.getDefaultToolkit().createCustomCursor(cursor, new Point(14, 8), ""));
	}
	public void mouseExited(MouseEvent e) {
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.black);
		g.setFont(myFont);
		g.drawString(text, getWidth()/2-22, getHeight()/2+10);
	}
}
