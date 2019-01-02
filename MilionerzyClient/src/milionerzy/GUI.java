package milionerzy;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUI extends JFrame{

    private JPanel panel1;
    private JButton jHelp1Button;
    private JButton jHelp2Button;
    private JButton jHelp3Button;
    private JButton jCashoutButton;
    private JButton jNewgameButton;
    private JButton jExitButton;
    private JButton jAnswer1Button;
    private JButton jAnswer2Button;
    private JButton jAnswer3Button;
    private JButton jAnswer4Button;
    private JLabel jPrize1Label;
    private JLabel jPrize2Label;
    private JLabel jPrize3Label;
    private JLabel jPrize4Label;
    private JLabel jPrize5Label;
    private JLabel jPrize6Label;
    private JLabel jPrize7Label;
    private JLabel jPrize8Label;
    private JLabel jPrize9Label;
    private JLabel jPrize10Label;
    private JLabel jPrize11Label;
    private JLabel jPrize12Label;
    private JLabel jHelpLabel;
    private JLabel jMainLabel;
    private JPanel prizeLabelsPanel;
    private JPanel topButtonsPanel;
    private JPanel centralPanel;

    private Question question;

    private int newGameClickCounter = 0;

    private JLabel[] labelTab = {jPrize1Label, jPrize2Label, jPrize3Label, jPrize4Label, jPrize5Label, jPrize6Label, jPrize7Label, jPrize8Label, jPrize9Label, jPrize10Label, jPrize11Label, jPrize12Label, jMainLabel, jHelpLabel};
    private JButton[] buttonTab = {jNewgameButton, jExitButton, jCashoutButton, jHelp1Button, jHelp2Button, jHelp3Button, jAnswer1Button, jAnswer2Button, jAnswer3Button, jAnswer4Button};

    private Color backgroundColor = new java.awt.Color(50, 50, 50);
    private Color foregroundColor = new java.awt.Color(255, 255, 255);
    private Font buttonsFont = new java.awt.Font("Yu Gothic UI Light", Font.PLAIN, 14);
    private Font labelsFont = new java.awt.Font("Yu Gothic UI Light", Font.PLAIN, 18);

    private static String correctAnswerNumber;

    private static String[] textsForLabels = {"          500", "        1000", "        2000", "        5000",
                                                    "     10 000", "     20 000", "     40 000", "     75 000",
                                                    "   125 000", "   250 000", "   500 000", "1 000 000", ".", "Przed Tobą pytanie za 500 złotych."};

    private static String[] textsForButtons = {"Nowa Gra", "Wyjście", "Rezygnuje", "50 / 50", "Publiczność", "Telefon" ,"A.", "B.", "C.", "D."};

    static void setCorrectAnswerNumber(String a){
        correctAnswerNumber=a;
    }

    private GUI(){

        add(panel1);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Milionerzy");
        setPreferredSize(new java.awt.Dimension(1366, 768));

        initComponents();

    }

    private void initComponents() {

        prizeLabelsPanel.setBackground(backgroundColor);
        topButtonsPanel.setBackground(backgroundColor);
        centralPanel.setBackground(backgroundColor);
        setBackground(Color.black);
        // for loops to hide elements that should not be displayed until new game button will be clicked
        for (int i=0; i < 10; i++){
            buttonTab[i].setVisible(false);
        }
        for (int i=0; i < 14; i++){
            labelTab[i].setVisible(false);
        }

        // this two buttons should be visible from the beginning
        jNewgameButton.setVisible(true);
        jExitButton.setVisible(true);

        jNewgameButton.setBackground(backgroundColor);
        jNewgameButton.setForeground(foregroundColor);
        jNewgameButton.setFont(buttonsFont);
        jNewgameButton.setText(textsForButtons[0]);
        jNewgameButton.addActionListener(evt -> {
            try {
                jNewgameButtonActionPerformed(evt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        jExitButton.setBackground(backgroundColor);
        jExitButton.setForeground(foregroundColor);
        jExitButton.setFont(buttonsFont);
        jExitButton.setText(textsForButtons[1]);
        jExitButton.addActionListener(evt -> jExitButton1ActionPerformed(evt));

        jCashoutButton.addActionListener(evt -> jCashoutButtonActionPerformed(evt));

        jHelp3Button.addActionListener(evt -> jHelp3ButtonActionPerformed(evt));

        jHelp2Button.addActionListener(evt -> jHelp2ButtonActionPerformed(evt));

        jHelp1Button.addActionListener(evt -> jHelp1ButtonActionPerformed(evt));

        jAnswer1Button.addActionListener(evt -> {
            try {
                jAnswer1ButtonActionPerformed(evt);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        jAnswer2Button.addActionListener(evt -> {
            try {
                jAnswer2ButtonActionPerformed(evt);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        jAnswer3Button.addActionListener(evt -> {
            try {
                jAnswer3ButtonActionPerformed(evt);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        jAnswer4Button.addActionListener(evt -> {
            try {
                jAnswer4ButtonActionPerformed(evt);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        pack();
    }


    private void jAnswer1ButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException, InterruptedException {
        String thisButtonAnswerNumber = "1";
        question=GameLogic.checkAnswer(thisButtonAnswerNumber,correctAnswerNumber,question, jMainLabel,jAnswer1Button, jAnswer2Button, jAnswer3Button, jAnswer4Button, labelTab,jHelpLabel,jCashoutButton,jHelp1Button,jHelp2Button,jHelp3Button);
    }
    private void jAnswer2ButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException, InterruptedException {
        String thisButtonAnswerNumber = "2";
        question=GameLogic.checkAnswer(thisButtonAnswerNumber,correctAnswerNumber,question, jMainLabel,jAnswer1Button, jAnswer2Button, jAnswer3Button, jAnswer4Button, labelTab,jHelpLabel,jCashoutButton,jHelp1Button,jHelp2Button,jHelp3Button);
    }

    private void jAnswer3ButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException, InterruptedException {
        String thisButtonAnswerNumber = "3";
        question=GameLogic.checkAnswer(thisButtonAnswerNumber,correctAnswerNumber,question, jMainLabel,jAnswer1Button, jAnswer2Button, jAnswer3Button, jAnswer4Button, labelTab,jHelpLabel,jCashoutButton,jHelp1Button,jHelp2Button,jHelp3Button);
    }

    private void jAnswer4ButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException, InterruptedException {
        String thisButtonAnswerNumber = "4";
        question=GameLogic.checkAnswer(thisButtonAnswerNumber,correctAnswerNumber,question, jMainLabel,jAnswer1Button, jAnswer2Button, jAnswer3Button, jAnswer4Button, labelTab,jHelpLabel,jCashoutButton,jHelp1Button,jHelp2Button,jHelp3Button);
    }
    private void jCashoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        GameLogic.cashOutButton(correctAnswerNumber,question,jHelpLabel,labelTab,jAnswer1Button,jAnswer2Button,jAnswer3Button,jAnswer4Button,jCashoutButton,jHelp1Button,jHelp2Button,jHelp3Button);
    }

    private void jNewgameButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {

        if (newGameClickCounter != 0){
            question.setCounter(0);
        }

        newGameClickCounter++;

        GameLogic.buttonsAvaliability(true,jAnswer1Button,jAnswer2Button,jAnswer3Button,jAnswer4Button,jCashoutButton,jHelp1Button,jHelp2Button,jHelp3Button);

        // setting all buttons
        for (int i=0; i < 10; i++){
            buttonTab[i].setVisible(true);
            buttonTab[i].setBackground(backgroundColor);
            buttonTab[i].setForeground(foregroundColor);
            buttonTab[i].setText(textsForButtons[i]);
            buttonTab[i].setFont(buttonsFont);
            buttonTab[i].setBorder(BorderFactory.createLineBorder(backgroundColor));
        }

        // setting all labels
        for (int i=0; i < 14; i++){
            labelTab[i].setVisible(true);
            labelTab[i].setBackground(backgroundColor);
            labelTab[i].setFont(labelsFont);
            labelTab[i].setForeground(foregroundColor);
            labelTab[i].setText(textsForLabels[i]);
            // to reset green and yellow borders when you click new game button after playing previous game
            labelTab[i].setBorder(BorderFactory.createLineBorder(backgroundColor));
        }

        question=GameLogic.newQuestion(jMainLabel,jAnswer1Button,jAnswer2Button,jAnswer3Button,jAnswer4Button, labelTab, jHelpLabel);
        correctAnswerNumber = question.getCorrect_Answer();
    }

    private void jHelp1ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        GameLogic.HelpButton1(question, jAnswer1Button,jAnswer2Button,jAnswer3Button,jAnswer4Button,jHelp1Button);
    }

    private void jHelp2ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        GameLogic.HelpButton2(question, jHelpLabel, jHelp2Button,jHelp1Button,jAnswer1Button,jAnswer2Button,jAnswer3Button,jAnswer4Button);
    }

    private void jHelp3ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        GameLogic.HelpButton3(question, jHelpLabel, jHelp3Button,jHelp1Button,jAnswer1Button,jAnswer2Button,jAnswer3Button,jAnswer4Button);
    }

    private void jExitButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    static void main() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(() -> new GUI().setVisible(true));
    }
}