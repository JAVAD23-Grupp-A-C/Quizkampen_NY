package QuizClientSide;

import javax.swing.*;
import java.awt.*;

public class QuizGUI_Score {

    String playerName1 = "Player 1";
    String playerName2 = "Player 2";
    ImageIcon player1Icon = new ImageIcon("Images/Avatar_1.jpg");
    ImageIcon player2Icon = new ImageIcon("Images/Avatar_2.jpg");

    static int rounds = 10;
    int scorePlayer1 = 0;

    public static void setRounds(int rounds) {
        QuizGUI_Score.rounds = rounds;
    }

    int scorePlayer2 = 5;
    int roundPointsPlayer1 = 2;
    int roundPointsPlayer2 = 3;
    String whoTurn = "Your turn";

    QuizGUI_Score() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Quizkampen");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 600);
            frame.setBackground(Color.BLUE);
            JPanel borderPanel = new JPanel(new BorderLayout());
            borderPanel.setBackground(Color.BLUE);
            JLabel whoTurnLabel = new JLabel(whoTurn);
            whoTurnLabel.setHorizontalAlignment(JLabel.CENTER);
            borderPanel.add(whoTurnLabel, BorderLayout.NORTH);

            // Player profiles
            JPanel player1Panel = createPlayerPanel(playerName1, roundPointsPlayer1, player1Icon);
            JPanel player2Panel = createPlayerPanel(playerName2, roundPointsPlayer2, player2Icon);
            borderPanel.add(player1Panel, BorderLayout.WEST);
            borderPanel.add(player2Panel, BorderLayout.EAST);

            // Score display
            JLabel scoreLabel = new JLabel(scorePlayer1 + " - " + scorePlayer2);
            scoreLabel.setHorizontalAlignment(JLabel.CENTER);
            borderPanel.add(scoreLabel, BorderLayout.CENTER);

            // Kör button
            JButton button = new JButton("Starta");
            button.setBackground(Color.GREEN);
            button.setOpaque(true);
            button.setContentAreaFilled(true);
            borderPanel.add(button, BorderLayout.SOUTH);
            // Add more components as needed

            frame.getContentPane().add(borderPanel, BorderLayout.NORTH);
            frame.setVisible(true);

        });
    }
    public JPanel createPlayerPanel(String name, int roundPointsPlayer, ImageIcon playerIcon) {
        JPanel playerNamePanel = new JPanel();
        playerNamePanel.setLayout(new BoxLayout(playerNamePanel, BoxLayout.Y_AXIS));
        playerNamePanel.setBackground(Color.darkGray);

        ImageIcon win = new ImageIcon("Images/check.png");
        ImageIcon lose = new ImageIcon("Images/delete.png");
        ImageIcon star = new ImageIcon("Images/star.png");

        JLabel nameLabel = new JLabel(name);
        JLabel starLabel = new JLabel(star);
        JLabel roundScore = new JLabel(Integer.toString(roundPointsPlayer));
        JLabel playerIconLabel = new JLabel(playerIcon);

        playerNamePanel.add(playerIconLabel);
        playerNamePanel.add(nameLabel);
        playerNamePanel.add(Box.createHorizontalGlue());  // Pushes the two labels apart
        playerNamePanel.add(starLabel);
        playerNamePanel.add(roundScore);

        JPanel scorePanel = addScorePanel(rounds, win, lose);
        playerNamePanel.add(scorePanel);


        return playerNamePanel;
    }

    public static JPanel addScorePanel(int rounds, ImageIcon win, ImageIcon lose) {
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));
        scorePanel.setBackground(Color.lightGray);

        for (int i = 0; i < rounds; i++) {
            JPanel roundPanel = new JPanel(new FlowLayout());
            roundPanel.setBackground(Color.lightGray);
            JLabel winLabel = new JLabel(win);
            JLabel loseLabel = new JLabel(lose);
            roundPanel.add(winLabel);
            roundPanel.add(loseLabel);
            scorePanel.add(roundPanel);
            /*if (isWinner(i)) {
                winLabel.setVisible(true);
                loseLabel.setVisible(false);
            } else {
                winLabel.setVisible(false);
                loseLabel.setVisible(true);
            }*/
        }
        return scorePanel;
    }

    /*public static boolean isWinner() {

    }*/


    public static void main(String[] args) {
        new QuizGUI_Score();
    }
}
