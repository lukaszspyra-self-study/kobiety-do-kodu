package pl.kobietydokodu.learningjavapart1.cats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatInterface {
	private static Scanner inputScanner = new Scanner(System.in);
	public final static String DATAREGEX = "\\d{4}(\\.\\d{2}){2}";
	public final static String WEIGHTREGEX = "\\d+\\.?(\\d+)?";
	public final static String CHOICEREGEX = "[12xX]";
	protected static CatDao catDao = new CatDao();

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

	public static String getMenu12XChoiceFromUser() {
		Pattern userChoice12XPattern = Pattern.compile(CHOICEREGEX);
		String userChoiceString = getInputFromUser();
		Matcher choiceStringMatcher = userChoice12XPattern.matcher(userChoiceString);
		while (!choiceStringMatcher.matches()) {
			System.out.println("Not correct choice! Try again 1, 2, or x");
			userChoiceString = getInputFromUser();
			choiceStringMatcher = userChoice12XPattern.matcher(userChoiceString);
		}
		return userChoiceString;
	}

	public static void createCat() {
		Cat cat = new Cat();

		System.out.print("Type cat name: ");
		cat.setCatName(getInputFromUser());

		System.out.print("Type owner name: ");
		cat.setOwnerName(getInputFromUser());

		System.out.print("Type cat's date of birth in format YYYY.MM.DD: ");
		cat.setDateOfBirth(getDateFromUserInFormatYYYY_MM_DD());

		System.out.print("Type cat's weight: ");
		cat.setWeight(getFloatWeightFromUser());

		catDao.addCatToTheList(cat);
	}

	public static int getCatNumberFromUser() {
		int catNumberChoice = 0;
		while (true) {
			try {
				catNumberChoice = inputScanner.nextInt();
			} catch (InputMismatchException inputMismatchException) {
				System.out.print("Wrong number format! Try again: ");
				inputScanner.nextLine();
				continue;

			}
			if (catNumberChoice >= 0 && catNumberChoice < catDao.getCatList().size()) {
				break;
			}
			System.out.println("Try again to type cat number from the list! ");
		}
		return catNumberChoice;
	}

	public static void main(String[] args) {
		String newLine = System.getProperty("line.separator");
		while (true) {
			System.out.println("Hi! What do you want to do? Type:" + newLine + "1 - to add cat" + newLine
					+ "2 - to show cat" + newLine + "x - to close the programme");
			String userChoiceString = getMenu12XChoiceFromUser();
			if (userChoiceString.equalsIgnoreCase("1")) {
				createCat();
			} else if (userChoiceString.equalsIgnoreCase("2")) {
				if (catDao.getCatList().isEmpty()) {
					System.out.println("Cat list is empty, add cat first...");
					continue;
				}
				for (int i = 0; i < catDao.getCatList().size(); i++) {
					System.out.println(catDao.getCatList().get(i).getCatName() + " is number: " + i);
				}
				System.out.print("Type cat number to introduce itself: ");
				System.out.println(catDao.getCatList().get(getCatNumberFromUser()).introduceYourself());
			} else if (userChoiceString.equalsIgnoreCase("x")) {
				System.out.println("Programme will close now...");
				break;
			}
		}
	}
}
