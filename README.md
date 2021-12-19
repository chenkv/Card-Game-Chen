# Summary
A simple game of the card game "War" against the computer. The game works by randomly shuffling and dealing a deck of cards to two players. Then, the players each draw a card from the top of their deck. If one player's card is bigger than the other, with 2 being the smallest and A being the biggest, the player with the bigger card takes both cards and puts it at the bottom of their deck. If both player's turn over cards of the same rank, a war is initiated. The players continue to draw until one player has a larger card, which they then take all of the cards that have been played. A player wins when they have all of the other player's cards.

## Running the Game
To run the game, run `GUIChen.java` which is located in the src directory.

## Explaining the files

### `src`
The src folder contains the game's files.

### `CardChen.java`
This is the class used for card objects. Within contains methods for setting the card's value, suite, etc. It also contains get methods to retrieve these values.

### `DeckChen.java`
This is the class for the deck of cards. It has methods to create a deck, shuffle the deck, retrieve the number of cards, draw a card, add a card, and deal a card.

### `GUIChen.java`
This is where you run the game and the user interface logistics is located. The GUI is created with JFrame. The constructor loads all of the different screens and sounds for the game, such as the losing screen or the rules screen. The game method creates the actual game logic, including creating a deck, dealing cards, creating card visuals, playing the game, etc. The refresh method is for reloading the screen after drawing cards. The main method is used to launch the actual game.

### `WarChen.java`
This class contains the logistics of the game. For example, it draws cards, sees who wins or loses, and manages the deck.

### `images`
This directory contains all the images of the game, which is mostly images for all of the cards in a deck.

### `sounds`
This directory contains all of the sounds of the game, such as the opening screen sound, the card flip sound, and the winning and losing sound.
