package com.techelevator;

import java.math.BigDecimal;
import java.util.List;

public class Recipe {
    String origQty;
    String working_qty;
    String final_qty;
    String measure;
    String working_measure;
    String final_measure;
    String ingredient;
    double w_qty;
    double m_qty;

// input array expected to be 3, 4, or 5 items long
// 3 items: quantity, measure, ingredient i.e. 1 cup flour
// 5 items: 1st two are quantity:  "1 1/2", then measure "cups", then ingredient "sifted flour"
// 4 items could go either way:
//    1    cup   onion  minced       OR
//    1    1/2   cups   butter
//     Determine by '/' character at items index 1


    public Recipe(String[] in)
    {
        double temp;
        if (in.length == 3){
            this.origQty = in[0];
            this.measure = in[1];
            this.ingredient = in[2];
            this.w_qty = makeDecimal(in[0]);
        }
        else {if (in.length == 5) {
            this.origQty = in[0] + " " + in[1];
            this.measure = in[2];
            this.ingredient = in[3] + " " + in[4];
            temp = makeDecimal(in[1]);
            this.w_qty = Double.parseDouble(in[0])+ temp;
        }
        else if (in.length == 4) {
                 if (in[1].contains("/")) {
                    this.origQty = in[0] + " " + in[1];
                    this.measure = in[2];
                    this.ingredient = in[3];
                    temp = makeDecimal(in[1]);
                    this.w_qty = temp + Double.parseDouble(in[0]);}
                 else {
                    this.origQty = in[0];
                    this.measure = in[1];
                    this.ingredient = in[2] + " " + in[3];
                    this.w_qty = makeDecimal(in[0]);}
                   }
            }
            this.working_measure = measure;
            this.final_measure = measure;
    }

    public String getOrigQty() {
        return origQty;
    }

    public String getWorking_qty() { return working_qty; }

    public void setWorking_measure(String working_measure) {
        this.working_measure = working_measure;
    }
    public void setWorking_qty(String working_qty) {
        this.working_qty = working_qty;
    }

    public void setFinal_qty(String final_qty) {
        this.final_qty = final_qty;
    }

    public String getRecipeString() {
        return String.format("%6s  %s  %-20s yields %6s  %s  %s",
                origQty, measure, ingredient, final_qty, measure, ingredient);
    }

    public void setW_qty(double w_qty) {
        this.w_qty = w_qty;
    }

    public double getW_qty() {
        return w_qty;
    }

    public void setM_qty(double m_qty) {
        this.m_qty = m_qty;
    }

    public double getM_qty() {
        return m_qty;
    }

    public double makeDecimal(String inFraction) {

        double numer;
        double denom;
        String[] temp;
        double bd;
        if (inFraction.contains("/")){
            temp = inFraction.split("/");
            numer = Integer.valueOf(temp[0]);
            denom = Integer.valueOf(temp[1]);
            bd = numer/denom;

            return (numer / denom) ;}


        else return (Double.valueOf( inFraction));
    }

}
