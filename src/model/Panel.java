package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Panel extends JPanel{
	private JLayeredPane layer;
	private int zLevel;
	
	public Panel() {
		this.setLayout(null);
		this.setSize(new Dimension(600,600));
		this.setBackground(Color.orange);
		this.add(layer);
		layer.setSize(this.getSize());
		this.repaint();
	}
	
	public void remove(Card card) {
		layer.remove(card.getImg());
		this.repaint();
	}
	
	public void addToLayer(Component c, int z) {
		layer.add(c, z);
		this.repaint();
	}
}
