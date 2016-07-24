package main;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Menu extends JMenuBar implements ActionListener{
	public Menu()
	{
		JMenu game = new JMenu("Game");
		game.setBackground(Color.lightGray);
		add(game);
		JMenuItem close = new JMenuItem("Close");
		game.add(close);
		close.setActionCommand("close");
		close.addActionListener(this);
		JMenuItem reset = new JMenuItem("Reset");
		game.add(reset);
		reset.setActionCommand("reset");
		reset.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		if (command.equals("reset"))
		{
			Tic.reset();
		}
		if (command.equals("close"))
		{
			Tic.quit();
		}
	}
}
