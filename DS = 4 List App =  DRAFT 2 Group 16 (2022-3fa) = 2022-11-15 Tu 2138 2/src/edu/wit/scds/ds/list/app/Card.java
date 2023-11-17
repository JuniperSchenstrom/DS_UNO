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
 * Representation of a playing card with a suit and rank.
 * <p>
 * The suit and rank are immutable.
 *
 * @author Dave Rosenberg
 *
 * @version 1.0.0 2020-11-19 initial version
 * @version 2.0.0 2021-12-08
 *     <ul>
 *     <li>add support for face up/down
 *     <li>add {@code matches()}
 *     </ul>
 * @version 2.1.0 2022-11-06 support dynamic switching to compare cards based on suit
 *     and rank or rank alone
 *
 * @author Graham Schenstrom
 *
 * @version 2.2.0 2022-11-15 Modifications made for use with the game Uno
 */
public class Card implements Comparable<Card>
    {

    // data fields
    /** The card's color */
    public final Color color ;
    /** The card's number or special value */
    public final Number number ;

    /*
     * constructors
     */

    /**
     * @param thisColor
     *     this card's color
     * @param thisNumber
     *     this card's number
     */
    public Card( final Color thisColor, final Number thisNumber )
        {
        this.color = thisColor ;
        this.number = thisNumber ;

        }   // end full/2-arg constructor


    /**
     * gets the color of this card
     *
     * @return the color string
     */
    public String getColor()
        {

        return this.color.getDisplayName() ;

        }


    /**
     * gets the number of this card
     *
     * @return the number of the card
     */
    public String getNumber()
        {

        return this.number.getDisplayName() ;

        }


    /**
     * @param otherCard
     *     to compare
     *
     * @return true if the color matches or either one is a wild
     */
    public boolean compareColor( Card otherCard )
        {

        return ( this.color.getDisplayName().equals( otherCard.color.getDisplayName() )) ||
               "Wild".equals( this.number.getDisplayName() ) ||
               "Wild".equals( otherCard.number.getDisplayName() ) ;

        }


    /**
     * @param otherCard
     *     to compare
     *
     * @return true if the number matches or either one is a wild
     */
    public boolean compareNumber( Card otherCard )
        {

        return ( this.number.getDisplayName().equals( otherCard.number.getDisplayName() ))||
               "Wild".equals( this.number.getDisplayName() ) ||
               "Wild".equals( otherCard.number.getDisplayName() ) ;

        }


    /**
     * @param otherCard
     *     to compare
     * @param topColor
     *     the color of the top card on the discard deck, this is needed because of
     *     the player deciding what color will be played after a wild card
     *
     * @return true of card described by parameter is valid to play on this card
     */
    public boolean validPlay( Card otherCard,
                              String topColor )
        {

        return ( topColor.equals(otherCard.color.getDisplayName() )) ||
               ( this.number.getDisplayName().equals(otherCard.number.getDisplayName()) ) ||
               "Wild".equals( this.number.getDisplayName() ) ||
               "Wild".equals( otherCard.number.getDisplayName() ) ;

        }


    @Override
    public int compareTo( Card otherCard )
        {

        String thisColor = this.color.getDisplayName() ;
        String otherColor = otherCard.color.getDisplayName() ;
        String thisNumber = this.number.getDisplayName() ;
        String otherNumber = otherCard.number.getDisplayName() ;

        for ( int i = 0 ; i < thisColor.length() ; i++ )
            {

            if ( ( thisColor.charAt( i ) - otherColor.charAt( i ) ) != 0 )
                {

                return thisColor.charAt( i ) - otherColor.charAt( i ) ;

                }

            }

        for ( int i = 0 ; i < thisNumber.length() ; i++ )
            {

            if ( ( thisNumber.charAt( i ) - otherNumber.charAt( i ) ) != 0 )
                {

                return thisNumber.charAt( i ) - otherNumber.charAt( i ) ;

                }

            }

        return 0 ;

        }


    /**
     * Sample demo program
     *
     * @param args
     *     -unused-
     */
    public static void main( final String[] args )
        {

        }   // end main()

    }   // end class Card