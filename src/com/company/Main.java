package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int numberOfApplicants = 100;
        int numberOfTests = 100000;
        int correctChoosing = 0;
        for(int i=0; i< numberOfTests; i++){
            int[] applicantScores = createTestInstance(numberOfApplicants);
            int bestApplicant = getBestApplicant(applicantScores);
            int chosenApplicant = chooseApplicant(applicantScores);
            if(chosenApplicant == bestApplicant){
                correctChoosing++;
            }
        }

        System.out.println("From " + numberOfTests + " tests the best candidate was chosen " + correctChoosing + " times");
        double percentage = (double)correctChoosing/(double)numberOfTests*100;
        System.out.println("Percentage: " + percentage);

    }

    private static int chooseApplicant(int[] applicantScores) {
        int stopping = (int) Math.ceil(applicantScores.length * 0.37);

        int maximumThreshold = Integer.MIN_VALUE;

        for(int i =0; i< stopping; i++){
            if(applicantScores[i] > maximumThreshold){
                maximumThreshold = applicantScores[i];
            }
        }
        for(int i=stopping; i<applicantScores.length;i++){
            if(applicantScores[i] > maximumThreshold){
                return applicantScores[i];
            }
        }
        return 0;
    }

    private static int[] createTestInstance(int numberOfApplicants) {
        Random r = new Random(System.currentTimeMillis());
        int[] applicantScores = new int[numberOfApplicants];
        for(int i =0; i< numberOfApplicants; i++){
            applicantScores[i] = r.nextInt(100);
        }
        return applicantScores;
    }


    private static int getBestApplicant(int[] applicantScores) {
        int highest = Integer.MIN_VALUE;

        for (int applicantScore : applicantScores) {
            if (applicantScore > highest) {
                highest = applicantScore;
            }
        }
        return highest;
    }
}
