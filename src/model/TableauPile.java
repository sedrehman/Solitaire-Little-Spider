package model;


/**
 * 
 * @author Syed Rehman
 *
 */
public class TableauPile {

	private PileOfCards pile;
//	private int xPosition;
//	private int yPosition;

	/**
	 * made a method the returns the top card
	 */

	public Card topCard(){
		return this.pile.getPile().get(pile.getPile().size()-1);
		//return cards.get(0);
	}
	/**
	 * make a constructor and make 8 new instances of piles of cards make a for-loop
	 * that adds the initial amount of cards to each
	 */
	
	public TableauPile(Deck deck, int x, int y) {
		pile = new PileOfCards();
		for (int i = 0; i < 6; i++) {
			Card e = deck.dealt();
			e.getImg().setLocation(x, y);
			pile.getPile().add(e);
		}
//		this.xPosition = x;
//		this.yPosition = y;
		
	}
	
	public int getSize() {
		return pile.getPile().size();
	}
	
	
	/**
	 * made a add card method for pile 6 where it calls the legal adding method to see if its
	 * legal to add the card and returns true if its legal.
	 */
	public boolean addCard(Card card) {
		if (legalAdding(card)) {
			pile.add(card);
		}
		return true;
	}
	
	public Card removeCard() {
		if(legalRemoving()) {
			return pile.remove();
		}else {
			return null;
		}

	}
	

	/**
	 * made a legal adding method that makes sure add is legal by checking the size
	 * and rank of the pile and card
	 */
	public boolean legalAdding(Card c) {
		if (pile.getPile().isEmpty()) {
			return true;
		} else {
			Card tem = topCard();
			if (c.getRank() == tem.getRank() || c.getRank() == tem.getRank() + 1 || c.getRank() == tem.getRank() - 1) {
				return true;
			}
		}
		return false;

	}

	/**
	 * made a legal removing method that makes sure add is legal by checking the
	 * size and rank of the pile and card
	 */

	public boolean legalRemoving() {
		return !pile.getPile().isEmpty();
	}
	public PileOfCards getPile() {
		return pile;
	}
	
//	public void setXPosition(int x) {
//		this.xPosition = x;
//	}
//
//	public void setYPosition(int y) {
//		this.yPosition = y;
//	}
//
//	public int getXPosition() {
//		return this.xPosition;
//	}
//	
//	public int getYPosition() {
//		return this.yPosition;
//	}
//	
//	
	
}
