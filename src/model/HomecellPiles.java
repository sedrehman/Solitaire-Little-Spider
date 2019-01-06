package model;

import java.util.ArrayList;

/**
 * 
 * @author Syed Rehman
 *
 */
public class HomecellPiles {
	
	/**
	 * Each pile has a specific suit
	 * There are 4 pile of cards. One for each 
	 */

	private PileOfCards diamondsPile;
	private PileOfCards heartsPile;
	private PileOfCards spadesPile;
	private PileOfCards clubsPile;

	/**
	 * 
	 * creates the 4 new piles 
	 */
	public HomecellPiles(Deck deck) {
		diamondsPile = new PileOfCards();
		heartsPile = new PileOfCards();
		spadesPile = new PileOfCards();
		clubsPile = new PileOfCards();
		initialize(deck);
	}

	
	private void initialize(Deck deck) {
		Card aceOfDiamond = deck.removeByCard("diamonds", 1);
		diamondsPile.add(aceOfDiamond);
		Card aceOfHeart = deck.removeByCard("hearts", 1);
		heartsPile.add(aceOfHeart);
		Card kingOfClub = deck.removeByCard("clubs", 13);
		clubsPile.add(kingOfClub);
		Card kingOfSpade = deck.removeByCard("spades", 13);
		spadesPile.add(kingOfSpade);
		
	}


	public PileOfCards getDiamondsPile() {
		return diamondsPile;
	}

	public void setDiamondsPile(PileOfCards diamondsPile) {
		this.diamondsPile = diamondsPile;
	}

	public PileOfCards getHeartsPile() {
		return heartsPile;
	}

	public void setHeartsPile(PileOfCards heartsPile) {
		this.heartsPile = heartsPile;
	}

	public PileOfCards getSpadesPile() {
		return spadesPile;
	}

	public void setSpadesPile(PileOfCards spadesPile) {
		this.spadesPile = spadesPile;
	}

	public PileOfCards getClubsPile() {
		return clubsPile;
	}

	public void setClubsPile(PileOfCards clubsPile) {
		this.clubsPile = clubsPile;
	}
	
	/**
	 * 
	 * @param p
	 * @return top card from the desired pile
	 */
	public Card topCard(PileOfCards p) {
		return p.getPile().get(p.getPile().size()-1);
	}
	
	/**
	 * 
	 * @param p
	 * @return top card's index from the desired pile
	 */
	public int topCardIndex(PileOfCards p) {
		return p.getPile().size()-1;
	}
	
	/**
	 * 
	 * @param c
	 * adds a card to the spadesPile 
	 */
	public void addToSpadesPile(Card c) {
		if (isLegalToAddToSpadesPile(c)) {
			spadesPile.getPile().add(c);
		} else {
			System.out.println("could not add a card to speadesPile leagally !!");
		}
	}
	
	/**
	 * 
	 * @param c
	 * adds a card to the clubsPile 
	 */
	public void addToClubsPile(Card c) {
		if (isLegalToAddToClubsPile(c)) {
			clubsPile.getPile().add(c);
		} else {
			System.out.println("could not add a card to clubsPile leagally !!");
		}
	}
	
	/**
	 * 
	 * @param c
	 * adds a card to the heartsPile 
	 */
	public void addToHeartsPile(Card c) {
		if (isLegalToAddToHeartsPile(c)) {
			heartsPile.getPile().add(c);
		} else {
			System.out.println("could not add a card to heartsPile leagally !!");
		}
	}
	
	/**
	 * 
	 * @param c
	 * adds a card to the diamondsPile 
	 */
	public boolean addToDiamondsPile(Card c) {
		if (isLegalToAddToDiamondsPile(c)) {
			diamondsPile.getPile().add(c);
			return true;
		} else {
			System.out.println("could not add a card to diamondsPile leagally !!");
			return false;
		}
	}
	
	public boolean isLegalToAddToDiamondsPile(Card c) {
		if (c.getRank() == topCard(diamondsPile).getRank()+1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isLegalToAddToHeartsPile(Card c) {
		if (c.getRank() == topCard(heartsPile).getRank()+1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isLegalToAddToSpadesPile(Card c) {
		if (c.getRank()+1 == topCard(spadesPile).getRank()) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isLegalToAddToClubsPile(Card c) {
		if (c.getRank()+1 == topCard(clubsPile).getRank()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * 
	 * @param p
	 * @return true : if there are at least 2 cards in the pile
	 */
	public boolean isLegalToRemove(PileOfCards p) {
		if(p.getPile().size() > 1) {
			// at least has two cards.. because you cant remove the last card !
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * removes topCard
	 * @return the removed card
	 */
	public Card removeFromHearts() {
		if(isLegalToRemove(heartsPile)) {
			return heartsPile.getPile().remove(topCardIndex(heartsPile));
		}else {
			return null;
		}
	}
	
	/**
	 * removes topCard
	 * @return the removed card
	 */
	public Card removeFromDiamonds() {
		if(isLegalToRemove(diamondsPile)) {
			return diamondsPile.getPile().remove(topCardIndex(diamondsPile));
		}else {
			return null;
		}
	}
	
	/**
	 * removes topCard
	 * @return the removed card
	 */
	public Card removeFromSpades() {
		if(isLegalToRemove(spadesPile)) {
			return spadesPile.getPile().remove(topCardIndex(spadesPile));
		}else {
			return null;
		}
	}
	
	/**
	 * removes topCard
	 * @return the removed card
	 */
	public Card removeFromClubs() {
		if(isLegalToRemove(clubsPile)) {
			return clubsPile.getPile().remove(topCardIndex(clubsPile));
		}else {
			return null;
		}
	}

}
