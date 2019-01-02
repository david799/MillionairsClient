package milionerzy;

import java.awt.*;
import java.io.IOException;

import java.util.Random;


public class GameLogic {

    //zwraca numer prawidłowej odpowiedzi
    public static Question newQuestion(javax.swing.JLabel jMainLabel,javax.swing.JButton jAnswer1Button,javax.swing.JButton jAnswer2Button,javax.swing.JButton jAnswer3Button,javax.swing.JButton jAnswer4Button,javax.swing.JLabel[] prizeLabeltab,javax.swing.JLabel jHelpLabel) throws IOException {

        Question question = JSONReading.readQuestionJSON();

        jMainLabel.setText(question.getQuestion());
        jAnswer1Button.setText("A. " + question.getAnswer1());
        jAnswer2Button.setText("B. " + question.getAnswer2());
        jAnswer3Button.setText("C. " + question.getAnswer3());
        jAnswer4Button.setText("D. " + question.getAnswer4());
        prizeLabeltab[question.getCounter() - 1].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 2));

        return question;
    }

    public static Question checkAnswer(String thisButtonAnswerNumber,String correctAnswerNumber,Question question2, javax.swing.JLabel jMainLabel,javax.swing.JButton jAnswer1Button,javax.swing.JButton jAnswer2Button,javax.swing.JButton jAnswer3Button,javax.swing.JButton jAnswer4Button,javax.swing.JLabel[] prizeLabelTab,javax.swing.JLabel jHelpLabel, javax.swing.JButton jCashoutButton,javax.swing.JButton jHelp1Button,javax.swing.JButton jHelp2Button,javax.swing.JButton jHelp3Button) throws IOException, InterruptedException {

        Question question=question2;

        //pytania przed milionem
        if(question.getCounter() < 12) {
            if (thisButtonAnswerNumber.equals(correctAnswerNumber)) {
                question=newQuestion(jMainLabel, jAnswer1Button, jAnswer2Button, jAnswer3Button, jAnswer4Button, prizeLabelTab, jHelpLabel);
                GUI.setCorrectAnswerNumber(question.getCorrect_Answer());
                prizeLabelTab[question.getCounter() - 2].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 2));
                jHelpLabel.setForeground(Color.green);
                jHelpLabel.setText("Poprawna odpowiedź. Przed Tobą pytanie za " + prizeLabelTab[question.getCounter() - 1].getText() + " złotych:");
                jAnswer1Button.setEnabled(true);
                jAnswer2Button.setEnabled(true);
                jAnswer3Button.setEnabled(true);
                jAnswer4Button.setEnabled(true);
            } else {
                jHelpLabel.setForeground(Color.red);
                buttonsAvaliability(false, jAnswer1Button, jAnswer2Button, jAnswer3Button, jAnswer4Button,jCashoutButton,jHelp1Button,jHelp2Button,jHelp3Button);
                thatWasCorrect(correctAnswerNumber, question.getCounter(), jAnswer1Button, jAnswer2Button, jAnswer3Button, jAnswer4Button, jHelpLabel);
                jAnswer1Button.setForeground(Color.black);
                jAnswer2Button.setForeground(Color.black);
                jAnswer3Button.setForeground(Color.black);
                jAnswer4Button.setForeground(Color.black);
            }
        }
        //jeśli counter równa sie 12 przechodzimy do pytania za milion
        else{
            if (thisButtonAnswerNumber.equals(correctAnswerNumber)) {
                jHelpLabel.setForeground(Color.green);
                jHelpLabel.setText("Poprawna odpowiedź. Właśnie wygrałeś milion złotych.");
                prizeLabelTab[11].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 2));
                buttonsAvaliability(false, jAnswer1Button, jAnswer2Button, jAnswer3Button, jAnswer4Button,jCashoutButton,jHelp1Button,jHelp2Button,jHelp3Button);
            }
            else {
                jHelpLabel.setForeground(Color.red);
                buttonsAvaliability(false, jAnswer1Button, jAnswer2Button, jAnswer3Button, jAnswer4Button,jCashoutButton,jHelp1Button,jHelp2Button,jHelp3Button);
                thatWasCorrect(correctAnswerNumber, question.getCounter(), jAnswer1Button, jAnswer2Button, jAnswer3Button, jAnswer4Button, jHelpLabel);
            }
        }
        return question;
    }

    public static void thatWasCorrect(String correctAnswerNumber,int questionCounter,javax.swing.JButton jAnswer1Button,javax.swing.JButton jAnswer2Button,javax.swing.JButton jAnswer3Button,javax.swing.JButton jAnswer4Button,javax.swing.JLabel jHelpLabel) {

        if (questionCounter<3){
            jHelpLabel.setText("Zła odpowiedź. Niestety nic nie wygrałeś.");
        }
        else if (questionCounter < 8 && questionCounter > 2){
            jHelpLabel.setText("Zła odpowiedź. Wygrałeś 1000 złotych.");
        }
        else {
            jHelpLabel.setText("Zła odpowiedź. Wygrałeś 40 000 złotych.");
        }

        switch (correctAnswerNumber) {
            case "1":
                jAnswer1Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 4));
                break;
            case "2":
                jAnswer2Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 4));
                break;
            case "3":
                jAnswer3Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 4));
                break;
            case "4":
                jAnswer4Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 4));
                break;
        }
    }

    // 50/50
    public static void HelpButton1(Question question,javax.swing.JButton jAnswer1Button,javax.swing.JButton jAnswer2Button,javax.swing.JButton jAnswer3Button,javax.swing.JButton jAnswer4Button,javax.swing.JButton jHelp1Button){

        jHelp1Button.setEnabled(false);

        int counter=0;
        Random ran = new Random();
        int[] randomNums = new int[2];
        int correctAnswer = Integer.parseInt(question.getCorrect_Answer());

        randomNums[0]=correctAnswer;
        randomNums[1]=correctAnswer;

        while (randomNums[0] == correctAnswer){
            randomNums[0] = ran.nextInt(4) + 1;
        }

        while ((randomNums[1] == correctAnswer) || (randomNums[1] == randomNums[0])){
            randomNums[1] = ran.nextInt(4) + 1;
        }

        while(counter < 2) {
                switch (randomNums[counter]) {
                    case 1:
                        jAnswer1Button.setEnabled(false);
                        break;
                    case 2:
                        jAnswer2Button.setEnabled(false);
                        break;
                    case 3:
                        jAnswer3Button.setEnabled(false);
                        break;
                    case 4:
                        jAnswer4Button.setEnabled(false);
                        break;
                }
            counter++;
        }
    }

    // publicznosc
    public static void HelpButton2(Question question,javax.swing.JLabel jHelpLabel,javax.swing.JButton jHelp2Button,javax.swing.JButton jHelp1Button,javax.swing.JButton jAnswer1Button,javax.swing.JButton jAnswer2Button,javax.swing.JButton jAnswer3Button,javax.swing.JButton jAnswer4Button){

            jHelp2Button.setEnabled(false);
            jHelpLabel.setForeground(Color.white);

            Random ran = new Random();
            int[] percents = new int[4];
            int[] randomNums = new int[4];
            String[] percentForQuestion = new String[4];
            int correctAnswer = Integer.parseInt(question.getCorrect_Answer());

            //randomNums[0] nie mieszamy, w niej bedzize prawdziwa odpowiedz
            randomNums[0] = correctAnswer;
            randomNums[1] = correctAnswer;
            randomNums[2] = correctAnswer;
            randomNums[3] = correctAnswer;

            while (randomNums[1] == correctAnswer) {
                randomNums[1] = ran.nextInt(4) + 1;
            }

            while ((randomNums[2] == correctAnswer) || (randomNums[2] == randomNums[1])) {
                randomNums[2] = ran.nextInt(4) + 1;
            }

            while (randomNums[3] == correctAnswer || (randomNums[3] == randomNums[1]) || (randomNums[3] == randomNums[2])) {
                randomNums[3] = ran.nextInt(4) + 1;
            }

            percents[(randomNums[0] - 1)] = ran.nextInt(25) + 50;           //przedzial 50-75 ze wzgledu na to że w przedziale 50-100 bardzo czesto procenty w niepoprawnych odpowiedziach byly bardzo niskie
            percents[(randomNums[1] - 1)] = ran.nextInt((100 - percents[(randomNums[0] - 1)]));
            percents[(randomNums[2] - 1)] = ran.nextInt((100 - percents[(randomNums[0] - 1)] - percents[(randomNums[1] - 1)]));
            percents[(randomNums[3] - 1)] = 100 - percents[(randomNums[0] - 1)] - percents[(randomNums[1] - 1)] - percents[(randomNums[2] - 1)];

            if(jHelp1Button.isEnabled()) {
                for (int i = 0; i < 4; i++) {
                    switch (randomNums[i]) {
                        case 1:
                            percentForQuestion[randomNums[i] - 1] = "Odpowiedz A:  " + Integer.toString(percents[randomNums[i] - 1]) + "%.     ";
                            break;
                        case 2:
                            percentForQuestion[randomNums[i] - 1] = "Odpowiedz B:  " + Integer.toString(percents[randomNums[i] - 1]) + "%.     ";
                            break;
                        case 3:
                            percentForQuestion[randomNums[i] - 1] = "Odpowiedz C:  " + Integer.toString(percents[randomNums[i] - 1]) + "%.     ";
                            break;
                        case 4:
                            percentForQuestion[randomNums[i] - 1] = "Odpowiedz D:  " + Integer.toString(percents[randomNums[i] - 1]) + "%.";
                            break;
                    }
                }

                jHelpLabel.setText(percentForQuestion[0] + percentForQuestion[1] + percentForQuestion[2] + percentForQuestion[3]);
            }
            else{
                String a="";
                int b=0;
                for (int i = 0; i < 4; i++) {
                    switch (randomNums[i]) {
                        case 1:
                            if(jAnswer1Button.isEnabled()) {
                                percentForQuestion[randomNums[i] - 1] = "Odpowiedz A:  " + Integer.toString((percents[randomNums[b]- 1])+(percents[randomNums[b+2]-1])) + "%.     ";
                                b++;
                                a += percentForQuestion[randomNums[i] - 1];
                            }
                            break;
                        case 2:
                            if(jAnswer2Button.isEnabled()) {
                                percentForQuestion[randomNums[i] - 1] = "Odpowiedz B:  " + Integer.toString((percents[randomNums[b]- 1])+(percents[randomNums[b+2]-1])) + "%.     ";
                                b++;
                                a += percentForQuestion[randomNums[i] - 1];
                            }
                            break;
                        case 3:
                            if(jAnswer3Button.isEnabled()) {
                                percentForQuestion[randomNums[i] - 1] = "Odpowiedz C:  " + Integer.toString((percents[randomNums[b]- 1])+(percents[randomNums[b+2]-1])) + "%.     ";
                                b++;
                                a += percentForQuestion[randomNums[i] - 1];
                            }
                            break;
                        case 4:
                            if(jAnswer4Button.isEnabled()) {
                                percentForQuestion[randomNums[i] - 1] = "Odpowiedz D:  " + Integer.toString((percents[randomNums[b]- 1])+(percents[randomNums[b+2]-1])) + "%.     ";
                                b++;
                                a += percentForQuestion[randomNums[i] - 1];
                            }
                            break;
                    }
                }
                jHelpLabel.setText(a);
            }
    }

    // telefon
    public static void HelpButton3(Question question,javax.swing.JLabel jHelpLabel,javax.swing.JButton jHelp3Button,javax.swing.JButton jHelp1Button,javax.swing.JButton jAnswer1Button,javax.swing.JButton jAnswer2Button,javax.swing.JButton jAnswer3Button,javax.swing.JButton jAnswer4Button){
        jHelpLabel.setForeground(Color.white);
        jHelp3Button.setEnabled(false);

        Random ran = new Random();

            if (question.getCounter() < 6) {
                switch (question.getCorrect_Answer()) {
                    case "1":
                        jHelpLabel.setText("Uważam że prawidłową odpowiedzią jest odpowiedź A.");
                        break;
                    case "2":
                        jHelpLabel.setText("Uważam że prawidłową odpowiedzią jest odpowiedź B.");
                        break;
                    case "3":
                        jHelpLabel.setText("Uważam że prawidłową odpowiedzią jest odpowiedź C.");
                        break;
                    case "4":
                        jHelpLabel.setText("Uważam że prawidłową odpowiedzią jest odpowiedź D.");
                        break;
                }
            } else {
                int a=0;
                while(a==0) {
                    switch (ran.nextInt(4) + 1) {
                        case 1:
                            if(jAnswer1Button.isEnabled()) {
                                jHelpLabel.setText("Uważam że prawidłową odpowiedzią jest odpowiedź A.");
                                a++;
                            }
                            break;
                        case 2:
                            if(jAnswer2Button.isEnabled()) {
                                jHelpLabel.setText("Uważam że prawidłową odpowiedzią jest odpowiedź B.");
                                a++;
                            }
                            break;
                        case 3:
                            if(jAnswer3Button.isEnabled()) {
                                jHelpLabel.setText("Uważam że prawidłową odpowiedzią jest odpowiedź C.");
                                a++;
                            }
                            break;
                        case 4:
                            if(jAnswer4Button.isEnabled()) {
                                jHelpLabel.setText("Uważam że prawidłową odpowiedzią jest odpowiedź D.");
                                a++;
                            }
                            break;
                    }
                }
            }

    }

    public static void cashOutButton(String correctAnswerNumber,Question question, javax.swing.JLabel jHelpLabel,javax.swing.JLabel[] prizeLabelTab,javax.swing.JButton jAnswer1Button,javax.swing.JButton jAnswer2Button,javax.swing.JButton jAnswer3Button,javax.swing.JButton jAnswer4Button,javax.swing.JButton jCashoutButton,javax.swing.JButton jHelp1Button,javax.swing.JButton jHelp2Button,javax.swing.JButton jHelp3Button){
        if(question.getCounter() > 1) {
            jHelpLabel.setText("Zrezygnowałeś z gry, wygrałeś: " + prizeLabelTab[question.getCounter() - 2].getText() + " złotych");
            buttonsAvaliability(false, jAnswer1Button, jAnswer2Button, jAnswer3Button, jAnswer4Button,jCashoutButton,jHelp1Button,jHelp2Button,jHelp3Button);

            switch (correctAnswerNumber) {
                case "1":
                    jAnswer1Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 4));
                    break;
                case "2":
                    jAnswer2Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 4));
                    break;
                case "3":
                    jAnswer3Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 4));
                    break;
                case "4":
                    jAnswer4Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 4));
                    break;
            }

        }
        else{
            jHelpLabel.setText("Zrezygnowałeś z gry, już na samym początku, niestety nic nie wygrałeś.");
            buttonsAvaliability(false, jAnswer1Button, jAnswer2Button, jAnswer3Button, jAnswer4Button,jCashoutButton,jHelp1Button,jHelp2Button,jHelp3Button);
        }
    }

    public static void buttonsAvaliability(boolean avaliability,javax.swing.JButton jAnswer1Button,javax.swing.JButton jAnswer2Button,javax.swing.JButton jAnswer3Button,javax.swing.JButton jAnswer4Button,javax.swing.JButton jCashoutButton,javax.swing.JButton jHelp1Button,javax.swing.JButton jHelp2Button,javax.swing.JButton jHelp3Button){
        jAnswer1Button.setEnabled(avaliability);
        jAnswer2Button.setEnabled(avaliability);
        jAnswer3Button.setEnabled(avaliability);
        jAnswer4Button.setEnabled(avaliability);
        jCashoutButton.setEnabled(avaliability);
        jHelp1Button.setEnabled(avaliability);
        jHelp2Button.setEnabled(avaliability);
        jHelp3Button.setEnabled(avaliability);
    }
}