package edu.vccs.mla2911.gui.lab;

/**
 * Does all the operations of the calculator in the GUI from RPNCalcGUI.
 * The man behind the curtain.
 * 2/8/2017
 * @author Michele Ambrose
 * @author Ryan Hurst
 */
public class RPNCalcGUIHelper {
    // StringBuilder object to be able to manipulate the display
    private StringBuilder display = new StringBuilder();

    // RPNCalc object to be able to actually calculate things
   private RPNCalc calc = new RPNCalc();

    // flag to check for when the number is done being entered
    private boolean numberDone = false;

    /**
     * Constructor.
     */
    public RPNCalcGUIHelper() {

    }

    /**
     * Does all the operations of each key in the calculator.
     * calls RPNCalc methods: enterNumber(), add(), subtract(), multiply(), divide().
     * @param key string value of the key pressed
     * @return String to put on the display of calculator
     */
    public String addKey(String key){
        double num;  // to hold the number in display.

        //switch statement for all different key presses.
        switch (key){

            //adds a decimal point only if there isn't one already.
            case  ".":

                if (!display.toString().contains(".")){
                    display.append(".");
                }
                break;
           /*adds the top two numbers on the stack together. If there aren't any
            numbers in the stack, then do nothing.*/
            case "+":
                /*if the numberDone is false, enter the number in the stack, otherwise
                just add what is in the stack already*/
                if (!numberDone) {
                    // make the number on the display a double,
                    num = Double.parseDouble(display.toString());
                    // put that double in the stack
                    calc.enterNumber(num);
                    // set flag so a new number will start on the display
                    numberDone = true;
                }
                //get the sum
                num = calc.add();
                //put the sum on the display
                display.replace(0, display.length(), ("" + num));
                break;

            /*subtracts the top two numbers on the stack together. If there aren't any
            numbers in the stack, then do nothing.*/
            case "-":
                /*if the numberDone is false, enter the number in the stack, otherwise
                just subtract what is in the stack already*/
                if (!numberDone){
                    // make the number on display a double
                    num = Double.parseDouble(display.toString());
                    //put double into stack
                    calc.enterNumber(num);
                    //set flag so a new number can start on screen
                    numberDone = true;
                }
                //get the difference
                num = calc.subtract();
                //put difference on display
                display.replace(0,display.length(),("" + num));
                break;

            /* multiplies the top two numbers on the stack together. If there aren't any
            numbers in the stack, then do nothing.*/
            case "*":
                /*if the numberDone is false, enter the number in the stack, otherwise
                just multiply what is in the stack already*/
                if (!numberDone){
                    //make the number on the display a double
                    num = Double.parseDouble(display.toString());
                    // put double into stack
                    calc.enterNumber(num);
                    //set flag so a new number can start
                    numberDone = true;
                }
                //get the product
                num = calc.multiply();
                //put product on the display
                display.replace(0, display.length(), ("" + num));
                break;

            /*divides the top two numbers on the stack together. If there aren't any
            numbers in the stack, then do nothing.*/
            case "/":
                 /*if the numberDone is false, enter the number in the stack, otherwise
                just multiply what is in the stack already*/
                if (!numberDone) {
                    //make the number on the display a double
                     num = Double.parseDouble(display.toString());
                     // put the double in the stack
                    calc.enterNumber(num);
                    // set flag so that a new number can start
                    numberDone = true;
                }
                //get the quotient
                num = calc.divide();
                // put quotient on display
                display.replace(0, display.length(),("" + num));
                break;

            // enters number into stack and puts the double equivalent on display.
            case "^":
                // new number can start on display
                numberDone = true;
                // the a string into a double, put it in the stack and on the display
                num = Double.parseDouble(display.toString());
                display.replace(0, display.length(), ("" + num));
                calc.enterNumber(num);
                break;

            // deletes the last char in the display
            case "<":
                //only delete the char if the number isn't done.  If it is done, then
                //it shouldn't be editable.
                if (!numberDone){
                    display.deleteCharAt(display.length()-1);
                }
                //otherwise don't do anything.
                break;

            // make the number on display a negative if positive, or vice versa.
            case "+/-":
                if (display.charAt(0) == '-'){
                display.deleteCharAt(0);
                }
            else {
                    display.insert(0, "-");
                }
                break;
            // put said number on display.
            case"0":
            case"1":
            case"2":
            case"3":
            case"4":
            case"5":
            case"6":
            case"7":
            case"8":
            case"9":
                /*if the number is done and has been added to the stack, start a new
                number*/
                if (numberDone){
                    display.delete(0, display.length());
                }
                //put the number on the display
                display.append(key);
                // can still add to number on display
                numberDone = false;
                break;

            // puts number on display on stack, and puts pi on screen.
            case "pi":
                //if the numberDone is false, then put number on display into stack
                if (!numberDone) {
                    // make the number in the display a double
                    num = Double.parseDouble(display.toString());
                    // put double into stack
                    calc.enterNumber(num);
                }
                //otherwise just put pi on the screen
                display.replace(0,display.length(),"" + Math.PI);
                // and put pi into the stack
                calc.enterNumber(Math.PI);
                //can't add to pi.
                numberDone = true;
        }

        //return the display.
        return display.toString();
    }

}
