package edu.ilstu;

import java.util.Scanner;

/**
 * This program finds the check digit for a thirteen digit ISBN number given the first twelve relevant digits of the ISBN number. 
 * 
 * @author Christopher Runyan
 */
public class ThirteenDigitISBNCheckDigitFinder {
	static String returnCheckDigitGivenTwelveDigitISBNFragment(String twelveDigitISBNFragment) {
		String toReturn = "E";
		int totalBeforeCheckDigit = 0;
		
		if(twelveDigitISBNFragment.length() == 12) {
			for(int i=0, j=1; i<12; i++) {
				totalBeforeCheckDigit += (Integer.parseInt(Character.toString(twelveDigitISBNFragment.charAt(i))) * j);
				if(j==1) {
					j=3;
				}
				else if(j==3) {
					j=1;
				}
			}
			
			int checkDigit = 10-(totalBeforeCheckDigit%10); 
			if(checkDigit == 10) {
				return "0";
			}
			else {
				return Integer.toString(checkDigit);
			}
		}
		
		return toReturn;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String input="";
		
		System.out.print("Enter the first twelve digits of the ISBN number to find the thirteenth number, which is a check digit: ");
		input = kb.nextLine();
		
		try {
			Double.parseDouble(input);
			
			if(input.length() == 12) {
				String checkDigit = returnCheckDigitGivenTwelveDigitISBNFragment(input);
				
				if(!checkDigit.equals("E")) {
					System.out.println("Check digit: " + checkDigit);
					System.out.println("Full ISBN: " + input + checkDigit);
				}
				else {
					System.out.println("An unknown error has occurred.");
				}
			}
			else {
				System.out.println("Invalid input (improper length).");
			}
		}
		catch(Exception e) {
			System.out.println("Invalid input (not integers).");
			System.exit(1);
		}
		
		kb.close();
	}
}
