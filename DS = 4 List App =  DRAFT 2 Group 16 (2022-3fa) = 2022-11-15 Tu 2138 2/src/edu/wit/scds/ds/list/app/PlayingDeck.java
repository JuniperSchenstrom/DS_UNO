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
 * Representation of a deck of cards
 *
 * @author Kathy Cao
 * @version 1.0.0 2022-11-15 Initial implementation
 */
public class PlayingDeck extends Pile
    {

    /**
     * 1 - arg constructor
     * @param pile - initial pile with all the cards
     */
    public PlayingDeck( Pile pile )
        {
        pile.populateDeck();
        this.cards = pile.cards;
        this.numberOfCards = pile.numberOfCards;
        }

    /**
     * will give the current player an amount of cards
     *
     * @param numberOfDeals
     *     is the number of cards to be dealt
     * @param hand - Hand object of the player
     * @param player - player that receives the card(s)
     *     that receives the cards
     */
    public void deal( int numberOfDeals,
                      Hand hand )
        {
        for ( int i = 0 ; i < numberOfDeals ; i++ )
            {
            Card cardToDeal = super.removeFromTop() ;
            hand.addToTop( cardToDeal ) ;

            }

        }

    /**
     * (optional) test driver
     *
     * @param args
     *     -unused-
     */
    public static void main( String[] args )
        {
        // OPTIONAL for testing and debugging

        }   // end main()

    }   // end class Deck