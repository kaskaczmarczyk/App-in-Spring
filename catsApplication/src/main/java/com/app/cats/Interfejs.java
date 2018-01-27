package com.app.cats;

import com.app.cats.domain.Cat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Interfejs {

    static Scanner inputScanner = new Scanner(System.in);

    static CatDAO catDAO = new CatDAO();

    public static void main(String[] args) {
        String userSelection;

        do {
            System.out.println();
            System.out.println("Choose what you want to do and then confirm with the enter: ");
            System.out.println("[1] Add a new cat");
            System.out.println("[2] Show all cats");
            System.out.println("[x] Exit");
            userSelection = getUserInput();
            if (userSelection.equals("1")) {
                addCat();
            } else if (userSelection.equals("2")) {
                showCats();
            }
        } while (!userSelection.equalsIgnoreCase("x"));
    }

    private static void showCats() {
        System.out.println();
        System.out.println("########################################################");
        System.out.println("###                     CAT LIST                     ###");
        System.out.println("########################################################");

        Cat cat = new Cat();
        for (int i = 0; i < catDAO.getCats().size(); i++) {
            cat = catDAO.getCats().get(i);
            System.out.println(i + ": " + cat.getName());
        }
        System.out.println();
        Pattern patternNumber = Pattern.compile("[0-9]+");
        String readNumber;
        do {
            System.out.println("Which cat do you want to know more about? ");
            readNumber = getUserInput();
        } while (!patternNumber.matcher(readNumber).matches());

        Integer catNumber = Integer.parseInt(readNumber);
        if (catDAO.getCats().size() > catNumber) {
            Cat chosenCat = catDAO.getCats().get(catNumber);
            System.out.println("The chosen cat has name is " + chosenCat.getName() + ", weighs "
                    + chosenCat.getWeight() + ", born " + chosenCat.getDateOfBirth().toString()
                    + ", look after him " + chosenCat.getCatOwnerName());
        } else {
            System.out.println("Unfortunately, I did not find a cat with the chosen number :( Try again or add it");
        }
    }

    private static void addCat() {
        System.out.println();
        System.out.println("#########################################################");
        System.out.println("###                     ADD A CAT                     ###");
        System.out.println("#########################################################");

        Cat cat = new Cat();
        System.out.print("Enter the name of the cat: ");
        cat.setName(getUserInput());

        Pattern patternDate = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.mm.dd");
        String readDateBirth;
        do {
            System.out.print("Enter the date of birth of the cat in the format YYYY.MM.DD: ");
            readDateBirth = getUserInput();
            if (patternDate.matcher(readDateBirth).matches()) {
                try {
                    cat.setDateOfBirth(sdf.parse(getUserInput()));
                } catch (ParseException pexc) {
                    System.out.println("Something is wrong with the date format! Example date: 2014.01.05");
                }
            }
        } while (cat.getDateOfBirth() == null);

        Pattern patternWeight = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        String readWeight;
        do {
            System.out.print("Enter the weight of the cat: ");
            readWeight = getUserInput();
            if (patternWeight.matcher(readWeight).matches()) {
                cat.setWeight(Float.valueOf(getUserInput()));
            }
        } while (cat.getWeight() == null);

        System.out.print("Who is the cat's owner: ");
        cat.setCatOwnerName(getUserInput());
        System.out.println("Thank you, now I know everything really about the cat! I added it to our collection.");

        catDAO.addCat(cat);
    }

    public static String getUserInput() {
        return inputScanner.nextLine().trim();
    }

}
