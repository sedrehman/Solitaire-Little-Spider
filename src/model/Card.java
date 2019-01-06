package model;

import javax.swing.JLabel;

/**
 * 
 * @author Syed Rehman
 */
public class Card {
	/**
	 * String suit of the card int rank of the card
	 */
	private String suit;// suit of the card
	private int rank;// rank of the card
	private JLabel img;

	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public Card(String suit, int rank, JLabel img) {
		super();
		this.suit = suit;
		this.rank = rank;
		this.img = img;
	}

	public JLabel getImg() {
		return img;
	}

	public void setImg(JLabel img) {
		this.img = img;
	}

	public int getRank() {
		return rank;
	}

	public String getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		return "Card [suit=" + suit + ", rank=" + rank + "]";
	}
	

}
