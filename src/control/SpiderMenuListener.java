package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.*;
import model.*;
/**
 * 
 * @author Syed Rehman
 * this class is just to run Little Spider Game 
 *
 */
public class SpiderMenuListener implements ActionListener {
	private JFrame frame;
	private JPanel panel;
	
	public SpiderMenuListener(JFrame f, JPanel panel) {
		this.frame = f;
		this.panel = panel;
	}
	
	/**
	 * Clears out the frame and adds Little Spider game to the frame
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		LittleSpiderGame lsg = new LittleSpiderGame();
		frame.getContentPane().removeAll();
		//frame.remove(pane);
		panel = lsg.getPanel();
		frame.pack();
		frame.add(panel);
		frame.setSize(panel.getSize());
		panel.repaint();
		frame.repaint();
	}

}
