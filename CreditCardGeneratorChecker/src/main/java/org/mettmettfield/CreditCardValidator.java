package org.mettmettfield;

public class CreditCardValidator {

    // Kart numarası Luhn algoritmasına göre geçerli mi?
    public static boolean isValidCardNumber(String cardNumber) {
        String cleaned = cardNumber.replaceAll("\\s+", ""); // boşlukları sil
        if (!cleaned.matches("\\d{16}")) {
            return false;
        }

        int sum = 0;
        boolean alternate = false;

        for (int i = cleaned.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cleaned.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }
            sum += n;
            alternate = !alternate;
        }

        return (sum % 10 == 0);
    }

    // CVV geçerli mi? (100-999 arası)
    public static boolean isValidCVV(int cvv) {
        return cvv >= 100 && cvv <= 999;
    }

    // SKT geçerli mi? (örn. 04/27 gibi)
    public static boolean isValidExpiry(String expiry) {
        return expiry.matches("(0[1-9]|1[0-2])/([2-3][5-9])");
    }

}
