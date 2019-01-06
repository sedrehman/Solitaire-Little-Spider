package model;

import java.awt.BorderLayout;
/**
 * @author syed rehman
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import control.*;


public class Frame extends JFrame {
	private JFrame frame;
	private JPanel pane;
	private JMenuBar menuBar;
	private Thread t;

/**
 * creates the main frame and returns it
 * @param t
 */
	public Frame(Thread t) {
		this.t = t;
		this.dispose();
		this.frame = new JFrame();
		this.pane = new JPanel();
		this.menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);
		JMenuItem exitMenu = new JMenuItem("Exit");
		JMenuItem litteSpiderMenu = new JMenuItem("new Little Spider");
		JMenuItem golfMenu = new JMenuItem("new Golf");
		menu.add(litteSpiderMenu);
		menu.add(golfMenu);
		menu.add(exitMenu);

		exitMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});

		litteSpiderMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				initiateSpider();
			}
		});
		

		frame.setVisible(true);
		frame.setSize(700, 500);
		frame.setTitle("A12 Team 3");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		pane.setLayout(null);
		pane.setSize(frame.getSize());
		JLabel lbl = new JLabel("Welcome to the main menu. Please select a game from the menu");
		lbl.setLocation(100, 100);
		lbl.setSize(600, 200);

		pane.setBackground(Color.GRAY);
		pane.add(lbl);

		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(pane);
	}


/**
* initaites little spider
*/
	public void initiateSpider() {
		LittleSpiderGame lsg = new LittleSpiderGame();
		frame.getContentPane().removeAll();
		frame.remove(pane);
		pane = lsg.getPanel();
		frame.pack();
		frame.add(pane);
		frame.setSize(pane.getSize());
		pane.repaint();
		frame.repaint();
	}

	public JFrame getMainFrame() {
		return frame;
	}

	public JPanel getPane() {
		return pane;
	}

/**
 * adds component to pane
 * @param c
 */
	public void addToPanel(Component c) {
		this.pane.add(c);
		this.pane.repaint();
	}
	/**
	 * updated panel
	 * @param c
	 */

	public void updatePanel(JPanel C) {
		this.frame.remove(pane);
		this.pane = C;
		addToFrame(pane);
		pane.repaint();
	}
	/**
	 * adds to frame
	 * @param c
	 */
	public void addToFrame(Component c) {
		this.frame.add(c);
		this.frame.repaint();
	}
}