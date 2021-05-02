//Name: Kevin Chen

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckChen
{
    //Creates an ArrayList for all cards in the deck
    private List<CardChen> Cards = new ArrayList<>();

    //Resets the deck
    public DeckChen()
    {
        Cards.clear();
    }

    //Returns the size of the deck
    public int getSize()
    {
        return Cards.size();
    }

    //Returns the next card in the deck without removing it
    public CardChen getNextCard()
    {
        return Cards.get(Cards.size() - 1);
    }

    //Creates a full deck
    public void createDeck()
    {
        for (int i = 0; i < CardChen.SUITS.length; i++)
        {
            for (int g = 1; g < CardChen.FACES.length; g++)
            {
                Cards.add(new CardChen(CardChen.SUITS[i], CardChen.FACES[g]));
            }
        }
    }

    //Shuffles randomly all cards in the deck
    public void shuffle()
    {
        for (int i = 0; i < Math.random() * 51 + 1; i++)
        {
            Collections.shuffle(Cards);
        }
    }

    //Adds a card card to the bottom of the deck
    public void addCard(CardChen card)
    {
        Cards.add(0, card);
    }

    //Returns the top card and removes it from the deck
    public CardChen dealCard()
    {
        CardChen topCard = Cards.get(Cards.size() - 1);
        Cards.remove(Cards.size() - 1);
        return topCard;
    }

    //Returns a string of all cards in the deck
    public String toString()
    {
        String result = "";
        for (CardChen card : Cards)
        {
            result += card.getCard() + "\n";
        }
        return result;
    }
}
