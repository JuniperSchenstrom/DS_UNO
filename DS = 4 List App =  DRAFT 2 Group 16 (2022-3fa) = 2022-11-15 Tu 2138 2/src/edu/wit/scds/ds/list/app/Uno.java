
package edu.wit.scds.ds.list.app ;

import java.util.Scanner ;

/**
 * @author Graham Schenstrom
 *
 * @version 1.0.0 2022-11-26 Initial implementation
 */
public class Uno
    {

    /**
     * The main game that handles turns and game logic
     *
     * @param args
     *     .
     */
    public static void main( String[] args )
        {

        // control variables
        int turn = 0 ;
        int direction = 1 ;
        int addToNextControl ;
        int skipNextPlayer = 0 ;

        // card handling variables
        String topColor ;
        Card currentCard ;
        Card inputCard ;

        Scanner playerInput = new Scanner( System.in ) ;

        // class and card handling initialization
        Pile pile = new Pile() ;
        PlayingDeck playingDeck = new PlayingDeck( pile ) ;
        playingDeck.shuffle() ;
        Player[] players = new Player[ 4 ] ;

        for ( int i = 0 ; i < 4 ; i++ )
            {

            players[ i ] = new Player() ;
            playingDeck.deal( 7, players[ i ].hand ) ;

            }

        DiscardDeck discardDeck = new DiscardDeck() ;
        Card topCard = playingDeck.removeFromTop() ;
        topColor = topCard.getColor() ;
        // end class and card handling initialization

        System.out.println( "The top of the discard pile is a " +
                            cardFormatString( topCard, topColor ) ) ;

        if ( "W".equals( topColor ) ) // case for if the first card down is a wild
                                      // card
            {
            topColor = getColor( playerInput ) ;

            }

        while ( true ) // main loop
            {

            System.out.printf( "Player %d your hand is:\n", ( turn + 1 ) ) ;
            players[ turn ].printHand() ;

            while ( true ) // play card loop
                {

                while ( true ) // player input for card to play loop
                    {

                    System.out.printf( "Player %d what card would you like to play?\n" +
                                       "Enter \"N N\" if you do not have a card that currently can be played.\n",
                                       ( turn + 1 ) ) ;

                    inputCard = getPlayedCard( players[ turn ], playerInput ) ;

                    // case for when the player does have any cards in their hand
                    // that can be placed
                    if ( ( inputCard.getColor() == "N" ) && ( inputCard.getNumber() == "N" ) )
                        {

                        players[ turn ].deal( playingDeck ) ;

                        System.out.println( "The top of the discard pile is a " +
                                            cardFormatString( topCard, topColor ) ) ;
                        System.out.printf( "Player %d your hand is:\n", ( turn + 1 ) ) ;
                        players[ turn ].printHand() ;

                        continue ;

                        }

                    break ;

                    }

                currentCard = inputCard ;

                if ( "W".equals( currentCard.getColor() ) ) // checks for if the card
                                                            // can be placed
                    {

                    topColor = getColor( playerInput ) ;

                    break ;

                    }
                else if ( topCard.validPlay( currentCard, topColor ) )
                    {

                    topColor = currentCard.getColor() ;

                    break ;

                    }
                else
                    {

                    System.out.println( "That is not a valid card to play right now, " +
                                        "please pick a different one." ) ;

                    }

                }

            if ( "Skip".equals( currentCard.getNumber() ) ) // special case for Skip
                                                            // cards
                {

                if ( direction == 1 )
                    {
                    skipNextPlayer = 1 ;

                    }
                else
                    {
                    skipNextPlayer = -1 ;

                    }

                }

            if ( "Reverse".equals( currentCard.getNumber() ) ) // special case for
                                                               // Reverse cards
                {

                direction *= -1 ;

                }

            if ( "Add2".equals( currentCard.getNumber() ) ) // special case for Add2
                                                            // cards
                {

                addToNextControl = turn + direction ;
                addToNextControl = maintainTurnIntegrity( addToNextControl ) ;

                for ( int i = 0 ; i < 2 ; i++ )
                    {

                    players[ addToNextControl ].deal( playingDeck ) ;

                    }

                if ( direction == 1 )
                    {
                    skipNextPlayer = 1 ;

                    }
                else
                    {
                    skipNextPlayer = -1 ;

                    }

                }

            if ( "Add4".equals( currentCard.getNumber() ) ) // special case for Add4
                                                            // cards
                {

                addToNextControl = turn + direction ;
                addToNextControl = maintainTurnIntegrity( addToNextControl ) ;

                for ( int i = 0 ; i < 4 ; i++ )
                    {

                    players[ addToNextControl ].deal( playingDeck ) ;

                    }

                if ( direction == 1 )
                    {
                    skipNextPlayer = 1 ;

                    }
                else
                    {
                    skipNextPlayer = -1 ;

                    }

                }

            // end of turn card handling
            discardDeck.addToTop( topCard ) ;
            topCard = currentCard ;
            players[ turn ].hand.remove( currentCard ) ;

            if ( players[ turn ].hand.hasOne() )  // check for "uno" condition
                {

                System.out.println( "UNO!" ) ;

                }

            if ( players[ turn ].hand.isEmpty() ) // check for win condition
                {

                System.out.printf( "Player %d has won the game!\n", ( turn + 1 ) ) ;

                break ;

                }

            System.out.println( "The top of the discard pile is a " +
                                cardFormatString( topCard, topColor ) ) ;

            // turn handling
            turn += direction + skipNextPlayer ;
            turn = maintainTurnIntegrity( turn ) ;
            skipNextPlayer = 0 ;

            } // end main while loop

        playerInput.close() ;

        } // end main()


    /**
     * takes input from the player for what color will be played next after a wild
     * card
     *
     * @param playerInput
     *     scanner for player input
     *
     * @return return the color
     */
    public static String getColor( Scanner playerInput )
        {

        String playerColorInput ;

        System.out.println( "What color would you like the next played card to be?" ) ;

        while ( true ) // player input loop
            {

            playerColorInput = playerInput.nextLine() ;

            // check if a valid color has been given, "W" is not include because this
            // method is only called for determining what to play after a wild card
            if ( "R".equals( playerColorInput ) || "Y".equals( playerColorInput ) ||
                 "G".equals( playerColorInput ) || "B".equals( playerColorInput ) )
                {

                break ;

                }

            System.out.println( "That is not a valid color.\nValid colors are R, Y, G, B" ) ;

            }

        return playerColorInput ;

        }


    /**
     * takes input from the player for what card is to be played
     *
     * @param CurrentPlayer
     *     current player to check if inputed card in the hand of
     * @param playerInput
     *     scanner for player input
     *
     * @return returns the card
     */
    public static Card getPlayedCard( Player CurrentPlayer,
                                      Scanner playerInput )
        {

        Card cardOut ;

        while ( true ) // player input loop
            {

            String cardString = playerInput.nextLine() ;
            String[] cardStringArray = cardString.split( " " ) ;

            if ( cardStringArray.length != 2 )
                {

                System.out.println( "That is not a valid card, please try again." ) ;

                continue ;

                }

            cardOut = new Card( Color.interpretDescription( cardStringArray[ 0 ] ),
                                Number.interpretDescription( cardStringArray[ 1 ] ) ) ;

            if ( !"X".equals( cardOut.getColor() ) && !"X".equals( cardOut.getNumber() ) )
                {

                if ( "N".equals( cardOut.getColor() ) && "N".equals( cardOut.getNumber() ) )
                    {

                    break ;

                    }

                if ( !CurrentPlayer.hand.inHand( cardOut ) )
                    {

                    System.out.println( "That card is not in your hand, please try again." ) ;

                    continue ;

                    }

                break ;

                }

            System.out.println( "That is not a valid card, please try again." ) ;

            }

        return cardOut ;

        }


    /**
     * maintains the turn variable as a valid index for players[]
     *
     * @param turn
     *     variable that controls what players turn it is in main
     *
     * @return the verified value
     */
    public static int maintainTurnIntegrity( int turn )
        {

        if ( turn == 4 )
            {

            return 0 ;

            }
        else if ( turn == 5 )
            {

            return 1 ;

            }
        else if ( turn == -1 )
            {

            return 3 ;

            }
        else if ( turn == -2 )
            {

            return 2 ;

            }

        return turn ;

        }


    /**
     * @param card
     *     the card to make a formatted string representation of
     * @param topColor
     *     color of the top card, this is needed because of the player deciding what
     *     color will be played after a wild card
     *
     * @return the formatted String
     */
    public static String cardFormatString( Card card,
                                           String topColor )
        {

        String color = topColor ;
        String number = card.getNumber() ;

        return color + " " + number ;

        }

    } // end class Uno