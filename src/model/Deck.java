package model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author Syed Rehman
 */
public class Deck {

	private ArrayList<Card> cards;// a list of 52 cards
	private static final String[] suits = { "diamonds", "clubs", "hearts", "spades" };// helper when initializing deck

	/**
	 * creates a brand new deck
	 * and uploads the images..
	 */
	public Deck() {// create a NEW deck of 52 cards

		cards = new ArrayList<>();

		String[] fileNames = new String[52];
		int count = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14; j++) {
				fileNames[count++] = "Cards/" + Integer.toString(j) + suits[i].charAt(0) + ".gif";
			}
		}
		count = 0;

		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14; j++) {
				cards.add(new Card(suits[i], j, createDisplayImage(fileNames[count++])));// suits[0] is diamonds,
																							// suits[1] is clubs etc..
			}
		}

		shuffle();
	}

	/**
	 * finds a specific card from the deck and removes it.
	 * 
	 * @param suit
	 * @param rank
	 * @return the removed card
	 */
	public Card removeByCard(String suit, int rank) { // looks up a card by suit and rank and returns it
														// AND REMOVES IT
		Card removedCard = null;
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getSuit().equals(suit) && cards.get(i).getRank() == rank) {
				removedCard = cards.remove(i);
			}
		}
		// IF YOURE READING THIS, know that I love sushi. I will accept sushi as gift
		// anytime.
		return removedCard;
	}
/**
 * 
 * uses the filename to upload the images of the cards 
 * @param fileNameRelativeToClassFile
 * @return JLabel
 */
	public JLabel createDisplayImage(String fileNameRelativeToClassFile) {
		JLabel retVal = new JLabel();
		java.net.URL imgURL = this.getClass().getResource(fileNameRelativeToClassFile);
		if (imgURL == null) {
			throw new IllegalArgumentException("Couldn't find file ");
		}
		ImageIcon cardImage = new ImageIcon(imgURL);
		retVal.setIcon(cardImage);
		Dimension d = new Dimension(cardImage.getIconWidth() + 10, cardImage.getIconHeight() + 10);
		retVal.setSize(d);
		retVal.setPreferredSize(d);
		retVal.setMaximumSize(d);
		retVal.setMinimumSize(d);
		return retVal;
	}

	/**
	 * removes and return the top card of the deck
	 * 
	 * @return top Card
	 */

	public Card dealt() {// return the top card and remove it from deck
		return cards.remove(0);
	}

	/**
	 * 
	 * @return deck's size()
	 */
	public int size() {// return the amount of card left
		return cards.size();
	}

	/**
	 * randomizes the deck
	 */
	public void shuffle() {// shuffle the deck
		Collections.shuffle(cards);

	}

	public ArrayList<Card> getCards() { // to get the deck of cards
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

}
