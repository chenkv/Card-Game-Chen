//Name: Kevin Chen

import java.util.ArrayList;
import java.util.Arrays;

public class CardChen
{
    //These arrays give all possible face values and suits
    public static final String FACES[] = {"ZERO", "ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
    public static final String SUITS[] = {"SPADES", "HEARTS", "DIAMONDS", "CLUBS"};
    //This arraylist converts the array Faces to an arraylist to get the numerical value
    private static ArrayList<String> faces = new ArrayList<>(Arrays.asList(FACES));

    //Declares a suit and face for the card
    private String suit;
    private String face;

    //Resets the values of face and suit
    public CardChen()
    {
        suit = "";
        face = "";
    }

    //Sets the value of face and suit
    public CardChen(String suit, String face)
    {
        this.suit = suit;
        this.face = face;
    }

    //Sets the suit
    public void setSuit(String suit)
    {
        this.suit = suit;
    }

    //Sets the face
    public void setFace(String face)
    {
        this.face = face;
    }

    //Gets the suit
    public String getSuit()
    {
        return suit;
    }

    //Gets the face
    public String getFace()
    {
        return face;
    }

    //Gets the numerical face value
    public int getFaceValue()
    {
        return faces.indexOf(face);
    }

    //Returns card details
    public String getCard()
    {
        return face + " of " + suit;
    }

    //Returns card details
    public String toString()
    {
        return face + " of " + suit;
    }
}