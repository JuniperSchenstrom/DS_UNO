/* @formatter:off
 *
 * Dave Rosenberg
 * Comp 2000 - Data Structures
 * Lab: List application - card game
 * Fall, 2022
 *
 * Usage restrictions:
 *
 * You may use this code for exploration, experimentation, and furthering your
 * learning for this course. You may not use this code for any other
 * assignments, in my course or elsewhere, without explicit permission, in
 * advance, from myself (and the instructor of any other course).
 *
 * Further, you may not post (including in a public repository such as on github)
 * nor otherwise share this code with anyone other than current students in my
 * sections of this course. Violation of these usage restrictions will be considered
 * a violation of the Wentworth Institute of Technology Academic Honesty Policy.
 *
 * Do not remove this notice.
 *
 * @formatter:on
 */

package edu.wit.scds.ds.list.app ;


/**
 * Representation of a player
 *
 * @author Masakazu Yasumoto
 * @version 16.0.2 2022-11-15 Initial implementation
 */
public class Player
    {
    // DONE implement this

    /**
     * player's hand
     */
    Hand hand ;

    /**
     * no-arg constructor
     */
    public Player()
        {
        this.hand = new Hand( this ) ;
        }


    /**
     * get the players cards
     * 
     * @return the list of cards in the players hand
     */
    public Hand getHand()
        {
        return this.hand ;

        }


    /**
     * removes card from hand and puts the card on the discard pile
     * @param discardDeck - discardDeck object that the new card will 
     * 
     * @param cardToPlay
     *     the card that will be played
     */
    public void play( DiscardDeck discardDeck,
                      Card cardToPlay )
        {
        this.hand.remove( cardToPlay );
        discardDeck.addToTop( cardToPlay );
        }


    /**
     * remove a top card from the playing deck and add it to the hand
     * 
     * @param playingDeck - playing deck with cards
     */
    public void deal( PlayingDeck playingDeck )
        {
        
        // add to hand what is removed from top of the playing deck
        this.hand.addToTop(playingDeck.removeFromTop());
        }


    /**
     * prints the cards in the players hand
     */
    public void printHand()
        {
        for (Card card : this.hand.cards)
            {
            System.out.println(card.getColor() + " " + card.getNumber());
            }
        }


    /**
     * (optional) test driver
     *
     * @param args
     *     -unused-
     */
    public static void main( final String[] args )
        {
        // OPTIONAL for testing and debugging

        }   // end main()

    }   // end class Player