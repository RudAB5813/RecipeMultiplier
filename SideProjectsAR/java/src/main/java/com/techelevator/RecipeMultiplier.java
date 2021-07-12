package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
public class RecipeMultiplier {
    private static Scanner userInput = new Scanner(System.in);
    private static String fileName = "";

    private static List<Recipe> recipeCard = new ArrayList<Recipe>();

    public static int factor = 1;
    public static String convert = "M";

    public static void main(String[] args) {
        convert = "M";
        welcomeGetInput(recipeCard);
        multiplyRecipe(recipeCard, convert, factor);
        for (Recipe entry : recipeCard)
        {
//            System.out.println(entry.getRecipeMultiplied());
            System.out.println("entry is " + entry.getRecipeString());
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
        boolean fraction = false;
        int origQty=0;
        for (Recipe entry : recipeCard) {
// if the quantity has a space in it: 1 1/2 cups
// split on the space and multiply each part of the quantity separately
//
        if (entry.getOrigQty().contains(" ")) {
            String[] parts = entry.getOrigQty().split(" ");
            String a = multiplyWholeValue(Integer.parseInt(parts[0]), convert, factor);
            String b = multiplyFraction(parts[1], convert, factor);
            try {int q = Integer.parseInt(b);
                int aInt = Integer.valueOf(a);
            entry.setWorking_qty(String.valueOf(aInt + q));}
            catch (NumberFormatException e)
            {
                String c = reduceFractions(b);
                if (c.contains("/")){;}
                else {
                entry.setWorking_qty(String.valueOf(Integer.valueOf(c)+Integer.valueOf(a)));
            }


                entry.setWorking_qty(a + " " + b);
            };
        }
        else {
            try {
                origQty = Integer.parseInt(entry.getOrigQty());
                entry.setWorking_qty(multiplyWholeValue(origQty, convert, factor)); }
            catch (NumberFormatException e) {
                fraction = true;
                entry.setWorking_qty(multiplyFraction(entry.getOrigQty(), convert, factor));
                }
            }
        entry.setFinal_qty(reduceFractions(entry.getWorking_qty()));
        }
    }

    public static String multiplyWholeValue(int inQty, String conv, int factorBy ) {
        String newValue ;
        if (conv.equals("M")) {
            newValue = (Integer.toString(inQty * factor));
        } else {
            if (inQty == factor) {
                newValue = "1";
            } else newValue = inQty + "/" + factor;
        }
        return newValue;
    }


    public static String multiplyFraction(String inQty, String conv, int factorBy ) {
        String newValue ;
        String[] numDenom = inQty.split("/");
        int numerator = Integer.parseInt(numDenom[0]);
        int denom = Integer.parseInt(numDenom[1]);

        if (conv.equals("M")) {
            numerator = numerator * factorBy;
            if (numerator == denom) {
                newValue = "1";
            } else {
                newValue = numerator + "/" + denom;
            }
        } else {
            denom = denom * factorBy;
            newValue = numerator + "/" + denom;
        }
        return newValue;
    }

    public static String reduceFractions(String inQty)
    {
// if qty is a whole number return it, otherwise if
// it contains a space or fraction, reduce it and return the result
        String returnVal = inQty;

        if (inQty.contains(" "))
        {}
        else if (inQty.contains("/")){
            returnVal = reduFract(inQty);
        };
        return returnVal;
    }

    public static String reduFract(String input)
    {
        String[] temp = input.split("/");
        int numerator = Integer.parseInt(temp[0]);
        int denominator = Integer.parseInt(temp[1]);
        if (denominator > numerator) return input;
        if (numerator == denominator) return "1";
        if (numerator == denominator*2) return "2";
        if (numerator == denominator*3) return "3";
        if (numerator == denominator*4) return "4";
        if (numerator % denominator == 0) return Integer.toString(numerator/denominator);
        int wholePart = 0;
        while (numerator > denominator){
            wholePart++;
            numerator = numerator - denominator;
        }
        return wholePart +" " + numerator + "/" + denominator;
    }

  ?/
//            if (entry.getOrigQty().contains(" ") && entry.getOrigQty().contains("/"))
//            {
//                partsA = entry.getOrigQty().split(" ");
//                wholePart = Integer.valueOf(partsA[0]);
//                partsB = partsA[1].split("/");
//                numer = Integer.valueOf(partsB[0]);
//                denom = Integer.valueOf(partsB[1]);
//                entry.setW_qty(BigDecimal.valueOf((numer / denom) + wholePart));
//            } else
//            {
//                if (entry.getOrigQty().contains("/"))
//                {
//                    partsB = entry.getOrigQty().split("/");
//                    numer = Integer.valueOf(partsB[0]);
//                    denom = Integer.valueOf(partsB[1]);
//                    entry.setW_qty(BigDecimal.valueOf(numer / denom));
//                } else
//                    {
//                    entry.setW_qty(BigDecimal.valueOf(Long.parseLong(entry.getOrigQty())));
//                    }
//            }
//        }
//    }
//    public static void convertToFraction(List<Recipe> recipeCard) {
//        String[] partsA;
//        String workString;
//        int decPart;
//        String fraction;
//        for (Recipe entry : recipeCard) {
//            workString = String.valueOf(entry.getW_qty());
//
//            switch (decPart) {
//                case .125 :  fraction = "1/8"; break;
//                case .250 :  fraction = "1/4"; break;
//                case .333 :  fraction = "1/3"; break;
//                case .375 :  fraction = "3/8"; break;
//                case .500 :  fraction = "1/2"; break;
//                case .625 :  fraction = "5/8"; break;
//                case .666 :  fraction = "2/3"; break;
//                case .750 :  fraction = "3/4"; break;
//                case .875 :  fraction = "7/8"; break;
//            }
//
//            }
//        }

}
*/