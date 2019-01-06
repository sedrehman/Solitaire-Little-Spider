package model;

import java.util.ArrayList;


/**
 * 
 * @author Syed Rehman
 *
 */
public class PileOfCards {
	
	/**
	 * used for make piles of whatever size needed
	 */
	private ArrayList<Card> pile = new ArrayList<Card>();
	
	public PileOfCards() {
		//empty parameter constructor;
	}
	
	public ArrayList<Card> getPile() {
		return pile;
	}

	public void setPile(ArrayList<Card> pile) {
		this.pile = pile;
	}
	
	public Card remove() {
		return pile.remove(pile.size() - 1);
	}

	public void add(Card card) {
		pile.add(card);
		
	}
	
	public Card topCard() {
		if(pile.isEmpty()) {
			return null;
		}else {
			return pile.get(pile.size()-1);
		}
	}
	
}
