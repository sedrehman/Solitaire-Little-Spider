package model;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author syed rehman
 *
 */
public class LittleSpiderGame {
	private Card selectedCard = null;
	private PileOfCards selectedPile = null;
	private static final Point HCLocation1 = new Point(90, 300);
	private static final Point HCLocation2 = new Point(240, 300);
	private static final Point HCLocation3 = new Point(390, 300);
	private static final Point HCLocation4 = new Point(540, 300);
	private Deck deck; // new deck
	private HomecellPiles hCell; // created the 4 suit homecell piles within the class

	private TableauPile tPile1;
	private TableauPile tPile2;
	private TableauPile tPile3;
	private TableauPile tPile4;
	private TableauPile tPile5;
	private TableauPile tPile6;
	private TableauPile tPile7;
	private TableauPile tPile8;

	private static JPanel panel;
	private LittleSpiderGamePlay play;

	public JPanel littleSpiderPanel() {
		return panel;
	}

	public LittleSpiderGame() {
		deck = new Deck();
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(700, 500);
		panel.setBackground(Color.GRAY);
		play = new LittleSpiderGamePlay(panel);

		hCell = new HomecellPiles(deck);
		
		tPile1 = new TableauPile(deck, 35, 100);
		tPile2 = new TableauPile(deck, 115, 100);
		tPile3 = new TableauPile(deck, 195, 100);
		tPile4 = new TableauPile(deck, 275, 100);
		tPile5 = new TableauPile(deck, 355, 100);
		tPile6 = new TableauPile(deck, 435, 100);
		tPile7 = new TableauPile(deck, 515, 100);
		tPile8 = new TableauPile(deck, 595, 100);

		updatePanel();
		

	}

	public void updatePanel() {
		panel.removeAll();
		innitializeTableau(tPile1);
		innitializeTableau(tPile2);
		innitializeTableau(tPile3);
		innitializeTableau(tPile4);
		innitializeTableau(tPile5);
		innitializeTableau(tPile6);
		innitializeTableau(tPile7);
		innitializeTableau(tPile8);

		innitializeHomecell(hCell.getDiamondsPile(), HCLocation1);
		innitializeHomecell(hCell.getHeartsPile(), HCLocation2);
		innitializeHomecell(hCell.getSpadesPile(), HCLocation3);
		innitializeHomecell(hCell.getClubsPile(), HCLocation4);
		panel.repaint();
		
	}

	
	
	public void innitializeTableau(TableauPile pile) {
		// for Tableau
		System.out.println(pile.getClass().getName());
		for(int i = 0; i< pile.getSize(); i++) {
			System.out.println(pile.getPile().getPile().get(i).getRank() + " of " + pile.getPile().getPile().get(i).getSuit());
		}
		System.out.println();
		Card c = pile.topCard();
		MouseListener[] n = c.getImg().getMouseListeners();
		if (n.length == 0) {
			c.getImg().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (!play.isCardAlreadySelected()) { // card not selected yet
						panel.setBackground(Color.ORANGE);
						panel.repaint();
						System.out.println("in tableau, selected " + c.toString());
						play.cardClicked(c, pile.getPile());
						play.setCardAlreadySelected(true);

					} else {
						if (play.getCard() == c) {
							System.out.println("in tableau, unselected " + c.toString());
							panel.setBackground(Color.GRAY);
							panel.repaint();
							play.unselect();
						} else {
							if (pile.legalAdding(play.getCard())) {
								System.out.println("removed " + play.getCard() + " added " + c.toString());
								play.cardClicked(c, pile.getPile());
								updatePanel();
								panel.setBackground(Color.GRAY);
								panel.repaint();
							} else {
								// System.out.println("in tableau, unselected " + c.toString());
								JOptionPane.showMessageDialog(null, "cant be moved here !!");
								play.unselect();
								panel.setBackground(Color.GRAY);
								panel.repaint();
							}
						}
					}
				}
			});
		}
		panel.add(c.getImg());
	}

	public void innitializeHomecell(PileOfCards pile, Point p) {
		for (int i = 0; i < pile.getPile().size(); i++) {
			pile.getPile().get(i).getImg().setLocation(p);
		}

		Card c = pile.topCard();
		MouseListener[] n = c.getImg().getMouseListeners();
		if (n.length == 0) {
			c.getImg().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (!play.isCardAlreadySelected()) {
						// card not selected yet
						play.cardClicked(c, pile);
						play.setCardAlreadySelected(true);
						panel.setBackground(Color.GREEN);
						panel.repaint();
					} else {
						if (play.getCard() == c) {
							// if this card was already selected then unselect it
							play.unselect();
							panel.setBackground(Color.GRAY);
							panel.repaint();
						} else {
							// previously clicked card is coming here. so Tableau it must comply tableau
							// rules
							if (c.getSuit().equals("diamonds") && hCell.isLegalToAddToDiamondsPile(play.getCard())) {
								play.cardClicked(c, hCell.getDiamondsPile());
								updatePanel();
								panel.setBackground(Color.RED);
								panel.repaint();

							} else if (c.getSuit().equals("hearts") && hCell.isLegalToAddToHeartsPile(play.getCard())) {
								play.cardClicked(c, hCell.getHeartsPile());
								updatePanel();
								panel.setBackground(Color.RED);
								panel.repaint();

							} else if (c.getSuit().equals("spades") && hCell.isLegalToAddToSpadesPile(play.getCard())) {
								play.cardClicked(c, hCell.getSpadesPile());
								updatePanel();
								panel.setBackground(Color.WHITE);
								panel.repaint();

							} else if (c.getSuit().equals("clubs") && hCell.isLegalToAddToClubsPile(play.getCard())) {
								play.cardClicked(c, hCell.getClubsPile());
								updatePanel();
								panel.setBackground(Color.WHITE);
								panel.repaint();

							} else {
								JOptionPane.showMessageDialog(null, "cant be moved here !!");
								play.unselect();
								panel.setBackground(Color.GRAY);
								panel.repaint();

							}
						}
					}
				}

			});
		}
		panel.add(c.getImg());

	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
