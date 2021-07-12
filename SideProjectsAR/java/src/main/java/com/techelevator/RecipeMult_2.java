package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecipeMult_2 {
    private static Scanner userInput = new Scanner(System.in);
    private static String fileName = "";

    private static List<Recipe> recipeCard = new ArrayList<Recipe>();

    public static int factor = 1;
    public static String convert = "M";

    public static void main(String[] args) {
        convert = "M";
        welcomeGetInput(recipeCard);
        multiplyRecipe(recipeCard, convert, factor);
        convertToFraction(recipeCard);
        for (Recipe entry : recipeCard)
        {
//            System.out.println(entry.getRecipeMultiplied());
            System.out.println(entry.getRecipeString());
        }
    }



    public static void welcomeGetInput(List<Recipe> recipeCard) {

        String lineIn;

        System.out.println("Welcome to my Recipe Multiplier");
//        System.out.print("Would you like to Multiply (M) or Divide (D) your recipe M/D?:");
//        convert = userInput.nextLine();
        System.out.print("Multiply by what factor? Enter 2 to double, 3 to triple, etc: ");
        factor = Integer.parseInt(userInput.nextLine());
        System.out.println("Please enter each ingredient, one per line, blank line to end.");

        lineIn = userInput.nextLine();
        while (lineIn.length() > 0) {
            String[] temp = lineIn.split(" ");
            recipeCard.add(new Recipe(temp));
            lineIn = userInput.nextLine();
        }
    }


    public static void multiplyRecipe(List<Recipe> recipeCard, String conv, int factor) {
        for (Recipe entry : recipeCard) {
             entry.setM_qty(entry.getW_qty() * factor);
        }
    }


    public static void convertToDecimal(List<Recipe> recipeCard) {
        String[] partsA;
        String[] partsB;
        int wholePart;
        double numer;
        double denom;
        for (Recipe entry : recipeCard) {

            if (entry.getOrigQty().contains(" ") && entry.getOrigQty().contains("/"))
            {
                partsA = entry.getOrigQty().split(" ");
                wholePart = Integer.parseInt(partsA[0]);
                partsB = partsA[1].split("/");
                numer = Integer.parseInt(partsB[0]);
                denom = Integer.parseInt(partsB[1]);
                entry.setW_qty( (numer / denom) + wholePart);
            } else
            {
                if (entry.getOrigQty().contains("/"))
                {
                    partsB = entry.getOrigQty().split("/");
                    numer = Integer.parseInt(partsB[0]);
                    denom = Integer.parseInt(partsB[1]);
                    entry.setW_qty(numer / denom);
                } else
                    {
                    entry.setW_qty(Double.parseDouble((entry.getOrigQty())));
                    }
            }
        }
    }
    
    public static void convertToFraction(List<Recipe> recipeCard) {
        String[] partsA;
        String workString;
        String fraction = "";
        String testValue = "";

        for (Recipe entry : recipeCard) {
            workString = String.valueOf(entry.getM_qty());
            partsA = workString.split("\\.");
            fraction = "";

            //trim down to 3 characters
            if (partsA[1].length()>3){
                testValue = partsA[1].substring(0,3);
            } else {testValue = partsA[1];};

            switch (testValue) {
                case "000" :  fraction = " "; break;
                case "125" :  fraction = " 1/8"; break;
                case "25" :  fraction = " 1/4"; break;
                case "333" :  fraction = " 1/3"; break;
                case "375" :  fraction = " 3/8"; break;
                case "5" :  fraction = " 1/2"; break;
                case "625" :  fraction = " 5/8"; break;
                case "666" :  fraction = " 2/3"; break;
                case "75" :  fraction = " 3/4"; break;
                case "875" :  fraction = " 7/8"; break;
            }
            if (partsA[0].equals("0")) {
                workString = fraction;
            } else {
                 workString = partsA[0]  + fraction;}
            entry.setFinal_qty(workString);
            }
        }
    }