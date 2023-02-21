/*
 * Class: CMSC203 
 * Instructor: Professor Tarek
 * Description: Program that randomly generated numbers and asks user to guess
 *              continuously until a correct guess is made 
 * Due: 2/23/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here:Fikir Seifu
*/

import java.util.Scanner;
public class RandomNumberGuesser {
	public static void main(String[] args) {
		//scanner for an integer guess
		Scanner scan=new Scanner(System.in);
		//scanner for string option(yes or no)
		Scanner str=new Scanner (System.in);
		RNG object=new RNG();
		int random=RNG.rand();
		int lowGuess=0, highGuess=100, nextGuess;
		String s;
		int count=RNG.getCount();
		System.out.println("Enter your first guess");
		nextGuess=scan.nextInt();
		//loops through until a correct user guess
		while(true) {
			System.out.println("Number of guesses is "+count);
			//increments the number of guesses after each time
			count++;
			//if the user guess correctly, displays option to guess again
			if(nextGuess==random) {
				System.out.println("Congratulations, you guessed correctly");
				System.out.println("Try again? (yes or no) "); 
				s=str.nextLine();
				//if user wants to guess again, repeats the program
				if(s.equalsIgnoreCase("yes")) {
					//setting lowGuess and highGuess to their original values
					lowGuess=0;
					highGuess=100;
					System.out.println("Enter your first guess");
					nextGuess=scan.nextInt();
					System.out.println("Number of guesses is "+count);
					//resets count
					RNG.resetCount();
				}
				//else if the user doesn't want to continue, ends the game
				else if(s.equalsIgnoreCase("no")) {
					System.out.println("Thanks for playing");
					System.exit(0);
				}
			}//if guess is less than random, displays message, asks for another input
				else if(nextGuess<random) {
					lowGuess=nextGuess;
					System.out.println("Your guess is too low");
				}//if guess is greater than random, displays message, asks for another input
				else if(nextGuess>random){
					highGuess=nextGuess;
					System.out.println("Your guess is too high");
			}
			
			//narrows down the numbers for the user to guess based on previous input
			System.out.println("Enter your guess between "+lowGuess+" and "+highGuess);
			nextGuess=scan.nextInt();
			//if the input is out of the low and high guess, asks user for another input
			if(!RNG.inputValidation(nextGuess, lowGuess, highGuess))
				nextGuess=scan.nextInt();
		}
	}
}



