/* @formatter:off
 *
 * Dave Rosenberg
 * Comp 2000 - Data Structures
 * Lab: List application - card game
 * Fall, 2022
Expand
DiscardDeck.java
5 KB
DiscardDeck with changed addToTop()
﻿
/* @formatter:off
 *
 * Dave Rosenberg
 * Comp 2000 - Data Structures
 * Lab: List application - card game
 * Fall, 2022

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
 * Representation of a deck of cards
 *
 * @author Diego Hernandez Cervoni
 * @version 1.0.0 2022-11-15 Initial implementation
 */
public class DiscardDeck extends Pile
    {

    private Card topCard ;

    /**
     * constructor
     */
    public DiscardDeck()
        {
        // initialize an empty arrayList
        super.cards = new ArrayList<>() ;
        this.cards.clear() ;
        }


    /**
     * This will be used for the hand to compare cards
     * 
     * @return the top card of the deck
     */
    public Card getTop()
        {
        return this.topCard ;
        }

     /**
     * adds a card to the top of the deck, replaces topCard
     *
     * @param cardToAdd to the top of the deck
     * @return 
     */
     public boolean addToTop( Card cardToAdd )
     {
    
     super.addToTop( cardToAdd );
     this.topCard = cardToAdd;
     return true;
     }


    /**
     * will check if the card matches to the topCard
     * 
     * @param cardToCompare
     *     to the top card
     * @return true if the cards match
     */
    public boolean checkMatch( Card cardToCompare )
        {
        if ( this.topCard.compareColor( cardToCompare ) ||
             this.topCard.compareNumber( cardToCompare ) )
            {

            return true ;
            }
        else if ( cardToCompare.color.getDisplayName() == "W" ) // wild color can go
                                                                // on top of any
                                                                // other color
            {

            return true ;
            }

        return false ;

        }


    /**
     * clears the deck
     */
    public void clear()
        {
        this.cards.clear() ;
        }


    /**
     * prints the top card
     */
    public void printTopCard()
        {
        System.out.println( "Top Card: " + this.topCard.number.getDisplayName() +
                            " " + this.topCard.color ) ;
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

        Color red = Color.RED ;
        Color blue = Color.BLUE ;
        Number three = Number.THREE ;
        Number four = Number.FOUR ;

        DiscardDeck d = new DiscardDeck() ;
        d.topCard = new Card( blue, three ) ; // for example

        Card card2 = new Card( red, three ) ;

        d.printTopCard() ;

        System.out.println( "testing checkMatch= it is a match?: " +
                            d.checkMatch( card2 ) ) ;
        System.out.println( "testing method getTop: " + d.getTop() ) ;

        d.addToTop( new Card( blue, four ) ) ;
        d.addToTop( new Card( red, three ) ) ;

        d.printTopCard() ;

        for ( Card c : d.cards )
            {
            System.out.println( c.number.getDisplayName() ) ; // check ad
            }

        }   // end main()

    }   // end class Deck