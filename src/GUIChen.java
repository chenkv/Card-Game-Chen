//Name: Kevin Chen

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GUIChen extends Frame {

    //This makes a Dimension called screenSize and sets it to the size of the computer screen
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    //This makes a new war game
    WarChen war;
    //This makes the frame for the game, panel for the game, and panels for the win/lose screen
    JFrame frame = new JFrame("War Card Game");
    JPanel game = new JPanel();
    JPanel endComputer = new JPanel();
    JPanel endPlayer = new JPanel();

    public GUIChen()
    {
        //This sets the size of frame to 7/8 of the computer screen size
        frame.setSize(screenSize.width * 7 / 8, screenSize.height * 7 / 8);

        //This makes a new JPanel called mainMenu, sets its layout to GridBagLayout, and sets it's background
        JPanel mainMenu = new JPanel();
        mainMenu.setLayout(new GridBagLayout());
        //This GridBagConstraints c helps set the x and y to format contents on the pane
        GridBagConstraints c = new GridBagConstraints();
        mainMenu.setBackground(new Color(46, 184, 46));

        //This makes a new JPanel for the rules, sets it to BoxLayout, and sets its background color
        JPanel rules = new JPanel();
        rules.setLayout(new BoxLayout(rules, BoxLayout.Y_AXIS));
        rules.setBackground(new Color(46, 184, 46));

        //This makes a panel for the top of the rules panel to add text and also sets background color
        JPanel rulesTop = new JPanel(new GridBagLayout());
        rulesTop.setBackground(new Color(46, 184, 46));
        //This adds rulesTop to the rules panel
        rules.add(rulesTop);

        //This makes a GridBagConstraints z to format the x and y of the rules text
        GridBagConstraints z = new GridBagConstraints();
        //This sets the text of the rules, sets its font, and adds it to the rulesTop panel
        JLabel theRules = new JLabel("Rules:");
        JLabel theRules1 = new JLabel("Goal: be the first player to win all 52 cards.");
        JLabel theRules2 = new JLabel("2 is the smallest card, Ace is the largest.");
        JLabel theRules3 = new JLabel("The deck is divided evenly, with each player receiving 26 cards. Each player places his stack of cards face down.");
        JLabel theRules4 = new JLabel("Each player turns up a card and the player with the higher card takes both cards.");
        JLabel theRules5 = new JLabel("If the cards are the same rank, it is War. Each player turns up one card face down and one card face up.");
        JLabel theRules6 = new JLabel( "The player with the higher cards takes all. If the turned-up cards are again the same rank, it's another war.");
        theRules.setFont(new Font("Calibri", Font.BOLD, 60));
        theRules1.setFont(new Font("Calibri", Font.PLAIN, 25));
        theRules2.setFont(new Font("Calibri", Font.PLAIN, 25));
        theRules3.setFont(new Font("Calibri", Font.PLAIN, 25));
        theRules4.setFont(new Font("Calibri", Font.PLAIN, 25));
        theRules5.setFont(new Font("Calibri", Font.PLAIN, 25));
        theRules6.setFont(new Font("Calibri", Font.PLAIN, 25));
        //This sets the x and y of the text
        z.gridx = 0;
        z.gridy = 0;
        //this insets adds space between top and bottom
        z.insets = new Insets(15, 0,15, 0);
        rulesTop.add(theRules, z);
        z.gridy = 1;
        rulesTop.add(theRules1, z);
        z.gridy = 2;
        rulesTop.add(theRules2, z);
        z.gridy = 3;
        rulesTop.add(theRules3, z);
        z.gridy = 4;
        rulesTop.add(theRules4, z);
        z.gridy = 5;
        rulesTop.add(theRules5, z);
        z.gridy = 6;
        rulesTop.add(theRules6, z);

        //This makes a JPanel called rulesBot, sets its layout to GridBagLayout, sets its background color, sets its size, and adds it to the rules panel
        JPanel rulesBot = new JPanel(new GridBagLayout());
        rulesBot.setBackground(new Color(25, 102, 25));
        rulesBot.setMaximumSize(new Dimension(screenSize.width, 10));
        rules.add(rulesBot);

        //This sets the layout of the losing screen for when the player loses
        endComputer.setLayout(new GridBagLayout());
        //enc formats the contents on the panels
        GridBagConstraints enc = new GridBagConstraints();
        endComputer.setBackground(new Color(46, 184, 46));
        enc.gridx = 0;
        enc.gridy = 0;
        enc.insets = new Insets(15, 0,15, 0);
        //This creates and sets the text and font for "You lose!"
        JLabel endC = new JLabel();
        endC.setText("You Lost! Play Again?");
        endC.setFont(new Font("Calibri", Font.PLAIN, 80));
        endComputer.add(endC, enc);
        enc.gridy = 1;
        //This makes a new button called "Play Again" that when clicked brings back the main menu
        JButton playAgain2 = new JButton("Play Again");
        endComputer.add(playAgain2, enc);
        playAgain2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(mainMenu);
                frame.invalidate();
                frame.validate();
            }
        });

        //This is the same as the losing screen except changed to a winning screen
        endPlayer.setLayout(new GridBagLayout());
        GridBagConstraints enp = new GridBagConstraints();
        endPlayer.setBackground(new Color(46, 184, 46));
        enp.gridx = 0;
        enp.gridy = 0;
        JLabel endP = new JLabel();
        endP.setText("You Won! Play Again?");
        endP.setFont(new Font("Calibri", Font.PLAIN, 80));
        endPlayer.add(endP, enp);
        enp.gridy = 1;
        JButton playAgain1 = new JButton("Play Again");
        endPlayer.add(playAgain1, enp);
        playAgain1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(mainMenu);
                frame.invalidate();
                frame.validate();
            }
        });

        //This sets the text to welcome players to the game and adds it to the main menu
        JLabel welcome = new JLabel();
        welcome.setText("Welcome to War!");
        welcome.setFont(new Font("Calibri", Font.PLAIN, 80));
        c.gridx = 5;
        c.gridy = 0;
        c.gridwidth = 5;
        c.insets = new Insets(15, 0,15, 0);
        mainMenu.add(welcome, c);

        //This makes a JButton called play and when clicked runs the game
        JButton play = new JButton("Play Game");
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game();
            }
        });
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        mainMenu.add(play, c);

        //This makes a JButton to send the player to the main menu on the rules panel
        JButton returnMain = new JButton("Main Menu");
        returnMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(mainMenu);
                frame.invalidate();
                frame.validate();
            }
        });
        c.gridx = 0;
        c.gridy = 0;
        rulesBot.add(returnMain, c);

        //This makes a JButton to open up the rules panel on the main menu
        JButton gameRules = new JButton("Rules");
        gameRules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(rules);
                frame.invalidate();
                frame.validate();
            }
        });
        c.gridx = 0;
        c.gridy = 2;
        mainMenu.add(gameRules, c);

        //This makes a JButton that exits the program
        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> System.exit(0));
        c.gridx = 0;
        c.gridy = 3;
        mainMenu.add(exit, c);

        //This sets the frame to mainMenu, makes it visible, and sets it to close when closed
        frame.getContentPane().add(mainMenu);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //When the game opens, it plays the pacman intro sound
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    GUIChen.class.getResourceAsStream("sounds/intro.wav"));
            clip.open(inputStream);
            clip.start();
        } catch (Exception l) {
            System.err.println(l.getMessage());
        }
    }

    //This creates the game
    public void game()
    {
        //This rests the war game
        war = new WarChen();

        //This sets the game panel onto the frame
        frame.setContentPane(game);
        frame.invalidate();
        frame.validate();

        //This sets the layout of the game panel and the background color
        game.setLayout(new BoxLayout(game, BoxLayout.Y_AXIS));
        game.setBackground(new Color(46, 184, 46));

        //This makes a new JPanel to display the text during the game and adds it to the game panel
        JPanel textArea = new JPanel();
        textArea.setBackground(new Color(51, 153, 55));
        game.add(textArea);

        //This makes a JLabel to set the text on the textArea panel
        JLabel topText = new JLabel();
        topText.setText("Ready when you are!");
        topText.setFont(new Font("Calibri", Font.PLAIN, 80));
        GridBagConstraints tt = new GridBagConstraints();
        tt.gridx = 1;
        tt.gridy = 0;
        tt.insets = new Insets(0, 0,40, 0);
        textArea.add(topText, tt);

        //This makes a new JPanel called gameTop to display the game visuals
        JPanel gameTop = new JPanel(new GridBagLayout());
        gameTop.setBackground(new Color(46, 184, 46));
        game.add(gameTop);

        //This JPanel creates a panel for the computer card visuals
        JPanel gameLeft = new JPanel(new GridBagLayout());
        GridBagConstraints gl = new GridBagConstraints();
        gameLeft.setBackground(new Color(46, 184, 46));
        gl.gridx = 0;
        gl.gridy = 1;
        gl.weightx = screenSize.width * 7 / 24;
        gl.fill = GridBagConstraints.HORIZONTAL;
        gl.insets = new Insets(0, 10,0, 10);
        gl.anchor = GridBagConstraints.LINE_START;
        gameTop.add(gameLeft, gl);

        //This JLabel creates a label to set "Computer" above the computer's deck
        JLabel compCards = new JLabel();
        GridBagConstraints cc = new GridBagConstraints();
        compCards.setText("Computer");
        compCards.setFont(new Font("Calibri", Font.PLAIN, 50));
        cc.gridx = 0;
        cc.gridy = 0;
        cc.insets = new Insets(15, 0,15, 0);
        gameLeft.add(compCards, cc);

        //This JLabel displays the number of cards the computer has
        JLabel compNum = new JLabel();
        compNum.setText("Cards: 26");
        compNum.setFont(new Font("Calibri", Font.PLAIN, 30));
        cc.gridx = 0;
        cc.gridy = 2;
        cc.insets = new Insets(15, 0,15, 0);
        gameLeft.add(compNum, cc);

        //This sets the image of the computer deck to back.png
        final BufferedImage[] wPic = {null};
        try {
            wPic[0] = ImageIO.read(this.getClass().getResource("images/back.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel deck1 = new JLabel(new ImageIcon(wPic[0].getScaledInstance(wPic[0].getWidth() / 3, wPic[0].getHeight() / 3, Image.SCALE_DEFAULT)));
        cc.gridx = 0;
        cc.gridy = 1;
        cc.insets = new Insets(15, 0,15, 0);
        gameLeft.add(deck1, cc);

        //This makes a new JPanel in the middle to place the center pile
        JPanel gameMiddle = new JPanel(new GridBagLayout());
        GridBagConstraints gm = new GridBagConstraints();
        gameMiddle.setBackground(new Color(46, 184, 46));
        gm.gridx = 1;
        gm.gridy = 1;
        gm.weightx = screenSize.width * 7 / 24;
        gm.fill = GridBagConstraints.HORIZONTAL;
        gm.insets = new Insets(0, 10,0, 10);
        gm.anchor = GridBagConstraints.CENTER;
        gameTop.add(gameMiddle, gm);

        //This JLabel displays the number of cards in the center pile
        JLabel deckNum = new JLabel();
        GridBagConstraints dc = new GridBagConstraints();
        deckNum.setText("Cards: 0");
        deckNum.setFont(new Font("Calibri", Font.PLAIN, 30));
        dc.gridx = 1;
        dc.gridy = 1;
        dc.insets = new Insets(15, 0,15, 0);
        gameMiddle.add(deckNum, dc);

        //This sets the image of the center pile to back.png
        wPic[0] = null;
        try {
            wPic[0] = ImageIO.read(this.getClass().getResource("images/back.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel deck2 = new JLabel(new ImageIcon(wPic[0].getScaledInstance(wPic[0].getWidth() / 3, wPic[0].getHeight() / 3, Image.SCALE_DEFAULT)));
        dc.gridx = 1;
        dc.gridy = 0;
        gameMiddle.add(deck2, dc);

        //This is the same thing as gameLeft except for the player's deck
        JPanel gameRight = new JPanel(new GridBagLayout());
        GridBagConstraints gr = new GridBagConstraints();
        gameRight.setBackground(new Color(46, 184, 46));
        gr.gridx = 2;
        gr.gridy = 1;
        gr.weightx = screenSize.width * 7 / 24;
        gr.fill = GridBagConstraints.HORIZONTAL;
        gr.insets = new Insets(0, 10,0, 10);
        gr.anchor = GridBagConstraints.LINE_END;
        gameTop.add(gameRight, gr);

        JLabel playerCards = new JLabel();
        GridBagConstraints pc = new GridBagConstraints();
        playerCards.setText("You");
        playerCards.setFont(new Font("Calibri", Font.PLAIN, 50));
        pc.gridx = 0;
        pc.gridy = 0;
        pc.insets = new Insets(15, 0,15, 0);
        gameRight.add(playerCards, pc);

        JLabel playerNum = new JLabel();
        playerNum.setText("Cards: 26");
        playerNum.setFont(new Font("Calibri", Font.PLAIN, 30));
        pc.gridx = 0;
        pc.gridy = 2;
        pc.insets = new Insets(15, 0,15, 0);
        gameRight.add(playerNum, pc);

        wPic[0] = null;
        try {
            wPic[0] = ImageIO.read(this.getClass().getResource("images/back.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel deck3 = new JLabel(new ImageIcon(wPic[0].getScaledInstance(wPic[0].getWidth() / 3, wPic[0].getHeight() / 3, Image.SCALE_DEFAULT)));
        pc.gridx = 0;
        pc.gridy = 1;
        pc.insets = new Insets(15, 0,15, 0);
        gameRight.add(deck3, pc);

        //This makes a JPanel called gameBot to place the button to place a card and play the game
        JPanel gameBot = new JPanel(new GridBagLayout());
        gameBot.setBackground(new Color(25, 102, 25));
        game.add(gameBot);

        //This makes a JButton that places a card from the player deck
        JButton hit = new JButton("Place a Card");
        GridBagConstraints h = new GridBagConstraints();
        h.insets = new Insets(50, 0,50, 0);
        gameBot.add(hit, h);

        //This refreshes the frame to update it
        refresh();

        //This starts the war game
        war.warGame();

        //When the hit button is pressed, it does these actions
        hit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This gives compPic and playPic a value
                BufferedImage compPic = null, playPic = null;
                //These are used to format the contents on the panel
                GridBagConstraints images = new GridBagConstraints();
                GridBagConstraints dc = new GridBagConstraints();
                //If both players still have cards, this will run
                if (war.player.getSize() != 0 && war.computer.getSize() != 0) {
                    //When the cards are placed, this plays a card flipping sound called cardflip.wav
                    try {
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                                GUIChen.class.getResourceAsStream("sounds/cardflip.wav"));
                        clip.open(inputStream);
                        clip.start();
                    } catch (Exception l) {
                        System.err.println(l.getMessage());
                    }

                    //This removes the center pile to refresh it
                    gameMiddle.removeAll();
                    //This resets the label for the number of cards in the center pile
                    JLabel deckNum = new JLabel();
                    deckNum.setText("Cards: 0");
                    deckNum.setFont(new Font("Calibri", Font.PLAIN, 30));
                    dc.gridx = 1;
                    dc.gridy = 1;
                    dc.insets = new Insets(15, 0, 15, 0);
                    gameMiddle.add(deckNum, dc);

                    //This adds pictures of the next card from the player and computer to the middle panel in game
                    try {
                        compPic = ImageIO.read(this.getClass().getResource("images/" + war.computer.getNextCard() + ".png"));
                        playPic = ImageIO.read(this.getClass().getResource("images/" + war.player.getNextCard() + ".png"));
                    } catch (IOException f) {
                        f.printStackTrace();
                    }
                    //This makes the images smaller to fit on the screen
                    JLabel computerCard = new JLabel(new ImageIcon(compPic.getScaledInstance(compPic.getWidth() / 3, compPic.getHeight() / 3, Image.SCALE_DEFAULT)));
                    JLabel playerCard = new JLabel(new ImageIcon(playPic.getScaledInstance(playPic.getWidth() / 3, playPic.getHeight() / 3, Image.SCALE_DEFAULT)));
                    wPic[0] = null;
                    //This readds the picture of the back.png to the middle
                    try {
                        wPic[0] = ImageIO.read(this.getClass().getResource("images/back.png"));
                    } catch (IOException h) {
                        h.printStackTrace();
                    }
                    JLabel deck2 = new JLabel(new ImageIcon(wPic[0].getScaledInstance(wPic[0].getWidth() / 3, wPic[0].getHeight() / 3, Image.SCALE_DEFAULT)));

                    //This formats and adds the images of the cards to the panel
                    dc.gridx = 1;
                    dc.gridy = 0;
                    gameMiddle.add(deck2, dc);
                    images.gridx = 0;
                    images.gridy = 0;
                    gameMiddle.add(computerCard, images);
                    images.gridx = 2;
                    images.gridy = 0;
                    gameMiddle.add(playerCard, images);
                    war.getResult();
                    String theString = war.didIWin(war.result);
                    //This updates the number of cards in each deck/pile
                    deckNum.setText("Cards: " + war.pile.getSize());
                    compNum.setText("Cards: " + war.computer.getSize());
                    playerNum.setText("Cards: " + war.player.getSize());
                    //This updates the top text to whether the player or computer won or war
                    topText.setText(theString);

                    //This refreshes the frame
                    refresh();
                    }
                //If the player runs out of cards and loses, this will run
                else if (war.player.getSize() == 0) {
                    //This sets the frame to the losing panel
                    frame.setContentPane(endComputer);
                    //This resets the visuals for the game panel
                    gameMiddle.removeAll();
                    dc.gridx = 1;
                    dc.gridy = 1;
                    dc.insets = new Insets(15, 0, 15, 0);
                    gameMiddle.add(deckNum, dc);
                    dc.gridx = 1;
                    dc.gridy = 0;
                    gameMiddle.add(deck2, dc);
                    compNum.setText("Cards: 26");
                    playerNum.setText("Cards: 26");
                    frame.invalidate();
                    frame.validate();
                    refresh();
                    //This plays a losing sound
                    try {
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                                GUIChen.class.getResourceAsStream("sounds/lose.wav"));
                        clip.open(inputStream);
                        clip.start();
                    } catch (Exception l) {
                        System.err.println(l.getMessage());
                    }
                }
                //This runs if the computer runs out of cards and the player wins
                else
                {
                    //This sets the frame to the winning panel
                    frame.setContentPane(endPlayer);
                    gameMiddle.removeAll();
                    dc.gridx = 1;
                    dc.gridy = 1;
                    dc.insets = new Insets(15, 0, 15, 0);
                    gameMiddle.add(deckNum, dc);
                    dc.gridx = 1;
                    dc.gridy = 0;
                    gameMiddle.add(deck2, dc);
                    compNum.setText("Cards: 26");
                    playerNum.setText("Cards: 26");
                    frame.invalidate();
                    frame.validate();
                    refresh();
                    //This plays a winning sound
                    try {
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                                GUIChen.class.getResourceAsStream("sounds/win.wav"));
                        clip.open(inputStream);
                        clip.start();
                    } catch (Exception l) {
                        System.err.println(l.getMessage());
                    }
                }
            }
        });
    }

    //This method refreshes the screen because if you just change the panel, it will not update
    public void refresh()
    {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //This starts the game
        new GUIChen();
    }
}