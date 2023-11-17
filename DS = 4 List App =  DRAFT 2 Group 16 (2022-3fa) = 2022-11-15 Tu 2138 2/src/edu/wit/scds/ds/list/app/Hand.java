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

import java.util.ArrayList ;

/**
 * Representation of a hand of cards
 *
 * @author Masakazu Yasumoto
 * @version 16.0.2 2022-11-15 Initial implementation
 */
public class Hand extends Pile
    {
    // TODO implement this

    private Player player ;

    /**
     * 1-arg constructor
     * 
     * @param initialPlayer
     *     - player object with this hand
     */
    public Hand( Player initialPlayer )
        {
        super.cards = new ArrayList<>() ;
        super.numberOfCards = 0 ;
        this.player = initialPlayer ;
        }


    /**
     * checks if there is one card left in hand
     * 
     * @return true if there is only one card
     */
    public boolean hasOne()
        {
        return super.numberOfCards == 1 ;
        }


    /**
     * checks if a card is in the hand
     * 
     * @param cardToFind
     *     card to check in hand
     * @return true if card is found in the hand
     */
    public boolean inHand( Card cardToFind )
        {
        for ( Card aCard : super.cards )
            {
            if ( aCard.compareTo( cardToFind ) == 0 )
                {
                return true ;
                }
            }

        return false ;

        }


    /**
     * removes a card from the hand
     * 
     * @param cardToRemove
     *     from the hand
     */
    public void remove( Card cardToRemove )
        {
        for ( Card aCard : this.cards )
            {
            if ( aCard.compareTo( cardToRemove ) == 0 )
                {
                this.cards.remove( aCard ) ;
                this.numberOfCards-- ;
                break ;
                }
            }
        }

    /*
     * getter methods
     */


    /**
     * getter method for the player
     *
     * @return the player object for this hand
     */
    public Player getPlayer()
        {
        return this.player ;
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
        // comment

        }   // end main()

    }   // end class Hand