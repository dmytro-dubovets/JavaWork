package com.test.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Model {

    public Model() {
    }

    public void guessTheNumber() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> listOfAllNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int firstNumber = 0;
        int secondNumber = 100;
        int attempts = 1;
        int firstNextRangeNumber = 0;
        int secondNextRangeNumber = 0;
        int temp = 0;

        System.out.printf("Guess the number from '%d' to '%d'", firstNumber, secondNumber);
        System.out.println();
        System.out.println("(if you do not guess, you'll be guessing from previously entered numbers!)");
        int randomNumber = rand(firstNumber, secondNumber);

        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Enter the integer number!");
        }
        int next = scanner.nextInt();
        while (next != randomNumber) {
            System.out.println("Try again!");
            numbers.add(next);
            if (next > randomNumber) {
                System.out.println("The entered number is greater than random number!");
            } else {
                System.out.println("The entered number is less than random number");
            }
            if(attempts == 2) {
                try {
                    firstNextRangeNumber = numbers.get(0);
                    secondNextRangeNumber = numbers.get(1);
                    if(firstNextRangeNumber > secondNextRangeNumber) {
                        temp = firstNextRangeNumber;
                        firstNextRangeNumber = secondNextRangeNumber;
                        secondNextRangeNumber = temp;
                    }
                    firstNumber = firstNextRangeNumber;
                    secondNumber = secondNextRangeNumber;
                    randomNumber = rand(firstNextRangeNumber, secondNextRangeNumber);
                    System.out.println("--- You have new range! Be careful! ---");
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            attempts++;
            next = scanner.nextInt();
        }
        System.out.println("You guessed!");
        System.out.println();
        System.out.println("There is next statistic: ");
        System.out.println("- used attempts: " + attempts + ";");
        System.out.printf("- range was from '%d' to '%d';", firstNumber, secondNumber);
        System.out.println();
        System.out.println("- random number was: " + randomNumber  + ".");
    }

    public int rand() {
        Random random = new Random();
        int RAND_MAX = 21;
        return random.nextInt(RAND_MAX);

    }

    public int rand(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater or not equal than min");
        }
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
