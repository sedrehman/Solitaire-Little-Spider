package model;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class LittleSpiderGamePlay {
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
	private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK);

	private static Card card = null;
	private static Card card2 = null;
	private static PileOfCards pile = null; // from
	private boolean cardAlreadySelected = false;
	private JPanel panel;

	public LittleSpiderGamePlay(JPanel panel) {
		this.panel = panel;
	}
/**
 * if a card is clicked 
 * @param c
 * @param p
 */
	public void cardClicked(Card c, PileOfCards p) {
		if (card == null) {
			pile = p;
			card = c;
			c.getImg().setBorder(SELECTED_BORDER);
		} else {
			card2 = c;
			p.add(pile.remove()); // removes top card and adds it to p.
			changeLocation();
			panel.remove(card.getImg());
			panel.remove(card2.getImg());
			panel.add(pile.topCard().getImg());
			panel.add(p.topCard().getImg());
			panel.repaint();
			setEverythingToNull();
		}
	}

	public void unselect() {
		card.getImg().setBorder(UNSELECTED_BORDER);
		card = null;
		card2 = null;
		// pile = null;
		cardAlreadySelected = false;
		panel.repaint();
	}

	public void changeLocation() {
		card.getImg().setBorder(UNSELECTED_BORDER);
		Point p = card2.getImg().getLocation();
		card.getImg().setLocation(p);
	}

	public boolean isCardAlreadySelected() {
		return cardAlreadySelected;
	}

	public void setCardAlreadySelected(boolean cardAlreadySelected) {
		this.cardAlreadySelected = cardAlreadySelected;
	}

	public Card getCard() {
		return card;
	}

	public PileOfCards getPile() {
		return pile;
	}

	public void setPilesToNull() {
		pile = null;
	}

	public void setEverythingToNull() {
		// pile = null;
		card = null;
		card2 = null;
		this.cardAlreadySelected = false;
	}

}
