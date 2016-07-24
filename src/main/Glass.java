package main;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLayeredPane;

@SuppressWarnings("serial")
public class Glass extends JLayeredPane{
	String text = "";
	public Glass()
	{
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.WHITE);
		g.drawString(text, getWidth()/2-35,getHeight()/2);
	}
}
