//Name: Kevin Chen

import java.util.ArrayList;
import java.util.Arrays;

public class WarChen
{
    //Creates a deck for the player, computer, center pile, and the dealing deck
    public DeckChen player = new DeckChen();
    public DeckChen computer = new DeckChen();
    public DeckChen pile = new DeckChen();
    public DeckChen deck = new DeckChen();
    //Gives the result a value
    public int result = -10;

    //Creates a deck, shuffles it, and deals the cards to the player and computer
    public void warGame()
    {
        deck.createDeck();
        deck.shuffle();
        dealCards();
    }

    //Puts another card from the player and computer into the pile and returns "WAR!"
    private String war()
    {
        pile.addCard(player.dealCard());
        pile.addCard(computer.dealCard());
        return "WAR!";
    }

    //Deals all cards to the computer and player
    private void dealCards()
    {
        while (deck.getSize() > 1)
        {
            player.addCard(deck.dealCard());
            computer.addCard(deck.dealCard());
        }
    }

    //Gets the result of next card in player and computer decks and adds them to the pile
    public void getResult()
    {
        //Gets the winner and loser
        result = winOrLose(player.getNextCard(), computer.getNextCard());
        pile.addCard(player.dealCard());
        pile.addCard(computer.dealCard());
        pile.shuffle();
    }

    //Using a card from the player and computer, it returns who won and lost or tie
    private int winOrLose(CardChen user, CardChen comp)
    {
        //This makes a new deck to change the order of the cards because in this game, Ace is the largest not smallest
        ArrayList<String> faces = new ArrayList<>(Arrays.asList(CardChen.FACES));
        faces.set(1, "BLANK");
        faces.add("ACE");

        //If player wins, it returns 1, if player loses, it's -1, if it's a tie, it's 0, else it returns an error
        if (faces.indexOf(user.getFace()) > faces.indexOf(comp.getFace()))
            return 1;
        else if (faces.indexOf(user.getFace()) < faces.indexOf(comp.getFace()))
            return -1;
        else if (faces.indexOf(user.getFace()) == faces.indexOf((comp.getFace())))
            return 0;
        else
            return 100;
    }

    //This takes the result from winOrLose and interprets it
    public String didIWin(int result)
    {
        //If player wins, it gives the pile cards to the player and returns "You win!"
        if (result == 1)
        {
            while (pile.getSize() != 0)
                player.addCard(pile.dealCard());
            return "You win!\n";
        }
        //If the computer wins, it gives the pile cards to the computer and returns "Computer wins!"
        else if (result == -1)
        {
            while (pile.getSize() != 0)
                computer.addCard(pile.dealCard());
            return "Computer wins!\n";
        }
        //If it's a tie, it calls war() and returns "WAR!"
        else if (result == 0)
        {
            war();
            return "WAR!\n";
        }
        //If it's anything else, it's an error
        else
            return "ERROR!";
    }
}
