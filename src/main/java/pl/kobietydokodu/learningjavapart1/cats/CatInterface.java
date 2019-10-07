package pl.kobietydokodu.learningjavapart1.cats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatInterface {
	private static Scanner inputScanner = new Scanner(System.in);
	public final static String DATAREGEX = "\\d{4}(\\.\\d{2}){2}";
	public final static String WEIGHTREGEX = "\\d+\\.?(\\d+)?";

	public static String getInputFromUser() {
		return inputScanner.nextLine();
	}

	public static Date getDateFromUserInFormatYYYY_MM_DD() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
		Date parsedDate = null;
		Pattern datePattern = Pattern.compile(DATAREGEX);
		String userDateString = getInputFromUser();
		Matcher dateMatcher = datePattern.matcher(userDateString);
		while (!dateMatcher.matches()) {
			System.out.println("Not correct date format! Try again in YYYY.MM.DD: ");
			userDateString = getInputFromUser();
			dateMatcher = datePattern.matcher(userDateString);
		}
		try {
			parsedDate = simpleDateFormat.parse(userDateString);
		} catch (ParseException parseException) {
			parseException.printStackTrace();
		}
		return parsedDate;
	}

	public static Float getFloatWeightFromUser() {
		Float floatWeight = null;
		Pattern weightPattern = Pattern.compile(WEIGHTREGEX);
		String userWeightString = getInputFromUser();
		Matcher weightMatcher = weightPattern.matcher(userWeightString);
		while (!weightMatcher.matches()) {
			System.out.println("Not correct weight format! Try again in numbers with decimal: ");
			userWeightString = getInputFromUser();
			weightMatcher = weightPattern.matcher(userWeightString);
		}
		try {
			floatWeight = Float.valueOf(userWeightString);
		} catch (NumberFormatException numberFormatException) {
			numberFormatException.printStackTrace();
		}
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

		cat.introduceYourself();
		CatDao catDao = new CatDao();
		catDao.addCat(cat);
	}

}
