// Program Name: SMS Expander
// Name: Julian Lalvani-Dudley
// VUnetID: lalvanjp
// Email: julian.p.lalvani-dudley@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 02 MWF 2:00 pm - 3:00 pm
// Date: 
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.
//
// Description:

import java.util.Random;
import java.util.Scanner;

public class ChangeFall2020JulianLalvaniDudley {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        int numRounds = 0;
        System.out.print("Welcome to the Kanye/ELon guessing game!\nThe rules are simple: " +
                "I am going to show a tweet by either Kanye West or Elon Musk and all you have to do" +
                "is guess who wrote it.\n");
        int seed = getValidSeed(scnr);
        System.out.println("Good choice! Are you ready to play?");

        while (getConfirmation(scnr)) {
            ++numRounds;
            System.out.println("Rounds played: " + numRounds);
            System.out.println("Continue playing? (Y/N)");
        }

    }
    public static boolean getConfirmation (Scanner scnr) {
        String confirmation = scnr.nextLine();
        confirmation = confirmation.trim();
        while (confirmation.equals("")) {
            System.out.println("What? Please answer with either yes or no.");
            confirmation = scnr.nextLine();
        }
        char answer = confirmation.charAt(0);
        answer = Character.toUpperCase(answer);
        while (answer != 'Y' && answer != 'N') {
            System.out.println("What? Please answer with either yes or no.");
            confirmation = scnr.nextLine();
            answer = confirmation.charAt(0);
            answer = Character.toUpperCase(answer);
        }
        return answer != 'N';
    }
    public static int getValidSeed(Scanner scnr) {
        System.out.println("Enter the seed (1-100) to begin the game:");
        String userString = scnr.nextLine();
        Scanner strScanner = new Scanner(userString);
        boolean isValid = false;
        int seed = 0;
        while (!isValid) {
            if (userString.length() != 0 && strScanner.hasNextInt()) {
                seed = strScanner.nextInt();

                if (seed >= 1 && seed <= 100) {
                    System.out.println("The seed you entered is " + seed +
                            ". Are you sure this is the seed that you want? (Y/N)");
                    if (getConfirmation(scnr)) {
                        isValid = true;
                    }

                } else {
                    System.out.println("Seed must be a value between 1-100 inclusive." +
                            " Enter the seed:");
                    userString = scnr.nextLine();
                    strScanner = new Scanner(userString);
                }
            } else {
                System.out.println("Seed must be a value between 1-100 inclusive." +
                        " Enter the seed:");
                userString = scnr.nextLine();
                strScanner = new Scanner(userString);
            }
        }
        return seed;
    }
}
   /* public static String getTweet () {
        return "";
        If it were possible, I would have included a way to call the tweet from the API
        I would have also made methods for generating a random number (for random tweets), calculating
        the various statistics of the game (rounds won/lost, % correct etc.), and one for validating
        if the user had gotten the answer correct or not. Unfortunately, twitter does not provide
        quick GET code for Java, and java is the only language I know how to code in.
    } */


