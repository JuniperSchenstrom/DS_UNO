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

import java.io.File ;
import java.io.FileNotFoundException ;
import java.util.ArrayList ;
import java.util.Collections ;
import java.util.Scanner ;

/**
 * Representation of a pile of card
 * <p>
 * the bottom card is at position 0
 *
 * @author Kathy Cao
 *
 * @version 1.0.0 2022-11-15 Initial implementation
 */
public class Pile
    {

    // data fields
    /** the list of cards - directly accessible by subclasses */
    protected ArrayList<Card> cards ;    // instantiate an ArrayList or LinkedList in
                                         // the constructor

    /**
     * amount of cards in the deck
     */
    protected int numberOfCards ;

    /**
     * Initialize Pile
     */
    public Pile()
        {
        this.cards = new ArrayList<>() ;
        this.numberOfCards = 0 ;

        }


    /**
     * Puts all Uno cards into the list, read from a text file
     */
    public void populateDeck()
        {
        // read the groceries.txt
        File file = new File( "data/cards.txt" ) ;

        try ( Scanner scanner = new Scanner( file ) )
            {
            String itemStr = "" ;

            // for each line of the given text file
            while ( scanner.hasNextLine() )
                {
                itemStr = scanner.nextLine() ;
               
                String[] item = itemStr.split( " " ) ;

                // get the corresponding value using each enum
                Color color = Color.interpretDescription( item[ 0 ] ) ;
                Number number = Number.interpretDescription( item[ 1 ] ) ;

                // create a new grocery item with the given paremeters
                Card newCard = new Card( color, number ) ;
                
                // find an appropriate bag and add the grocery item
                this.cards.add( newCard ) ;
                this.numberOfCards++;

                }

            } // end try

        catch ( FileNotFoundException ex )
            {
            ex.printStackTrace() ;

            } // end catch

        }


    /**
     * adds a card to the top of the deck
     *
     * @param card
     *     to be added
     *
     * @return true if add was successful
     */
    public boolean addToTop( Card card )
        {
        if ( card == null )
            {
            return false ;

            }

        this.cards.add( card ) ;
        this.numberOfCards++ ;
        return true ;

        }


    /**
     * removes and returns a card to the top of the deck
     *
     * @return the Card that was removed
     */
    public Card removeFromTop()
        {
        if ( this.cards.isEmpty() )
            {
            return null ;

            }

        Card removed = this.cards.remove( this.numberOfCards - 1 ) ;
        this.numberOfCards-- ;
        return removed ;

        }


    /**
     * returns true when deck is empty
     *
     * @return true if the deck is empty
     */
    public boolean isEmpty()
        {
        return this.cards.isEmpty() ;

        }


    /**
     * shuffles the cards in the deck
     */
    public void shuffle()
        {
        Collections.shuffle( this.cards ) ;

        }


    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()            // debugging aid
        {
        return this.cards.toString() ;

        }   // end toString()


    /**
     * (optional) test driver
     *
     * @param args
     *     -unused-
     */
    public static void main( final String[] args )
        {
        // OPTIONAL for testing and debugging
        Pile pile = new Pile() ;
        pile.populateDeck() ;

        }   // end main()

    }   // end class Pile
