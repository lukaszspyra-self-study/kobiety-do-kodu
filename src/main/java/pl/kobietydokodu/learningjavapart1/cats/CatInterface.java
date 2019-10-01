package pl.kobietydokodu.learningjavapart1.cats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CatInterface {
	private static Scanner inputScanner = new Scanner(System.in);
	
	
	public static String getInputFromUser() {
		return inputScanner.nextLine();
	}
	
	public static Date getDateFromUserInFormatYYYY_MM_DD() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
		Date parsedDate = null;
		boolean flag = false;
		do {
			try {
				parsedDate = simpleDateFormat.parse(getInputFromUser());
			} catch (ParseException parseException) {
				System.out.println("Not correct date format! Try again in YYYY.MM.DD: ");
				flag = true;
			}
			
		} while (flag);
		return parsedDate;
	}
	
	public static Float getFloatWeightFromUser(){
		boolean flag = false;
		Float floatWeight = null;
		do {
			try {
				floatWeight = Float.valueOf(getInputFromUser());
			} catch (NumberFormatException numberFormatException) {
				System.out.print("Not correct weight format! Try again with digits separated by dot:");
				flag = true;
			}
			
		} while (flag);
		return floatWeight;		
	}
	
	public static void main(String[] args) {
		Cat cat = new Cat();
		
		System.out.print("Type cat name: ");
		cat.setCatName(getInputFromUser());
		
		System.out.print("Type owner name: ");
		cat.setOwnerName(getInputFromUser());
		
		System.out.print("Type cat's date of birth in format YYYY.MM.DD: ");
		cat.setDateOfBirth(getDateFromUserInFormatYYYY_MM_DD());
		
		System.out.print("Type cat's weight: ");
		cat.setWeight(getFloatWeightFromUser());

	}

}
