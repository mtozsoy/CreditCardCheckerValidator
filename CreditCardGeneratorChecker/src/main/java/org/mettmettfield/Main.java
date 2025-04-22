package org.mettmettfield;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CreditCardValidator.isValidCardNumber("4119 7924 7406 5945".replace(" ",""));
        System.out.println(CreditCardValidator.isValidCardNumber("4119 7924 7406 5945".replace(" ","")));
    }
}