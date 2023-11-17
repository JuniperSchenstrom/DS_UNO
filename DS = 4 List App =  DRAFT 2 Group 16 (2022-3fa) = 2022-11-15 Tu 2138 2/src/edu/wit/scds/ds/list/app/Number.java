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
 * An enumeration of card ranks.
 *
 * @author David M Rosenberg
 *
 * @version 1.0.0 2016-03-16 initial version
 * @version 1.1.0 2022-11-06 add switches for standard vs alternate points and order
 *
 * @author Kathy Cao
 *
 * @version 1.2.0 2022-11-15 Modifications for use for our game
 */
public enum Number
    {

// @formatter:off
    //  Element     Display Name
    /** One */
    ZERO ( 0 , "0"),
    /** One */
    ONE ( 1 , "1" ),
    /** Two */
    TWO ( 2 , "2" )
    /** Three */,
    THREE ( 3 , "3" ),
    /** Four */
    FOUR ( 4 , "4" ),
    /** Five */
    FIVE ( 5 , "5" ),
    /** Six */
    SIX ( 6 , "6" ),
    /** Seven */
    SEVEN ( 7 , "7" ),
    /** Eight */
    EIGHT ( 8 , "8" ),
    /** Nine */
    NINE ( 9 , "9" ),
    /** Skip */
    SKIP ( 10 , "Skip" ),
    /** Reverse */
    REVERSE ( 11 , "Reverse" ),
    /** Add */
    ADD ( 12 , "Add2" ),
    /**Add 4 */
    FOURADD (13 , "Add4" ),
    /** Wild Card with no add*/
    WILD(14, "Wild"),
    /** Bad input */
    BAD(15, "X"),
    /** Deny card */
    NONE(16, "N")
    ;
 // @formatter:on

    // data fields
    private final int value ;
    private final String displayName ;

    /*
     * constructor
     */

    private Number( final int numberValue, final String numberDisplayName )
        {
        this.value = numberValue ;
        this.displayName = numberDisplayName ;

        } // end constructor

    /*
     * getters
     */


    /**
     * @return the display name
     */
    public String getDisplayName()
        {
        return this.displayName ;
        } // end getDisplayName()


    /**
     * @return the value
     */
    public int getValue()
        {
        return this.value ;
        } // end getGraphic()


    /**
     * takes a string and returns corresponding number (i.e. 0 for ZERO enum)
     *
     * @param description
     *     the string that tells the number
     *
     * @return the number that matches the description
     */
    public static Number interpretDescription( final String description )
        {
        Number correspondingNum = switch ( description.toLowerCase() )
            {
            case "0" -> ZERO;
            case "1" -> ONE;
            case "2" -> TWO;
            case "3" -> THREE;
            case "4" -> FOUR;
            case "5" -> FIVE;
            case "6" -> SIX;
            case "7" -> SEVEN;
            case "8" -> EIGHT;
            case "9" -> NINE;
            case "skip" -> SKIP;
            case "reverse" -> REVERSE;
            case "add2" -> ADD;
            case "add4" -> FOURADD;
            case "wild" -> WILD;
            case "n" -> NONE;
            default -> BAD;

            } ;

        return correspondingNum ;

        } // end interpretDescription()
    
    

    } // end enum Rank