import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingNumber {
    static ArrayList<Integer> guessedNumbersCounter = new ArrayList();

    public static void main(String[] args) {
        introduction();
    }

    static int randomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        return randomNumber;
    }

    static void introduction() {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello!" + "\n" + "Welcome to the Number Guessing Game");
        System.out.println("---------------------");
        System.out.println("1 - Play the game");
        System.out.println("2 - Score board");
        System.out.println("3 - Exit the game");
        System.out.println("---------------------");
        System.out.println("Please pick one of above number: ");
        int number = input.nextInt();

        switch (number) {
            case 1:
                System.out.println("Pick one number between 1 to 100");
                guessNumber();
                break;
            case 2:
                if (guessedNumbersCounter.isEmpty()){
                    System.out.println("BEFORE YOU CHECK SCORE BOARD YOU HAVE TO PLAY :)");
                    introduction();
                    guessNumber();
                }else {
                    System.out.println("Your score is:");
                    guessedNumbersCounter.forEach(System.out::println);
                    introduction();
                    guessNumber();
                }
                break;
            case 3:
                System.out.println("Thank you for playing :)");
                break;

        }
        input.close();

    }

    private static void guessNumber() {
        Scanner input = new Scanner(System.in);
        int numberOfGenerator = randomNumber();
        int counterOfGuessing = 0;
        int pickedNumber;

        do {
            pickedNumber = input.nextInt();

            if(pickedNumber > 100 || pickedNumber < 0){
                System.out.println("PICK NUMBER BETWEEN 0 AND 100!");
                introduction();
            }

            if (pickedNumber < numberOfGenerator) {
                counterOfGuessing++;
                System.out.println("Higher");
            } else {
                counterOfGuessing++;
                System.out.println("Lower");
            }

        } while (pickedNumber != numberOfGenerator);
        System.out.println("CONGRATULATIONS YOU PICKED CORRECT NUMBER!!!" + "\n" +
                "The number is: " + numberOfGenerator);
        guessedNumbersCounter.add(counterOfGuessing);
        introduction();
    }
}
