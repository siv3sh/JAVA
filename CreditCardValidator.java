public class CreditCardValidator {
    private long ccNumber;

    public CreditCardValidator(long ccNumber) {
        this.ccNumber = ccNumber;
    }

    public void validateCard() {
        // Step a: Remove the Last Digit
        String ccStr = String.valueOf(this.ccNumber);
        int Length = ccStr.length();

        if (Length < 8 || Length > 9) { 
            System.out.println("Invalid Card Number");
            return;
        }
        int lastDigit = Integer.parseInt(ccStr.substring(Length - 1));
        String remainingNumber = ccStr.substring(0, Length - 1);
        System.out.println("Step a: Last digit = " + lastDigit + ", Remaining number = " + remainingNumber);
//////////////////////////////////////////////////////////

        // Step b: Reverse the Remaining Digits
        String reversedNumber = new StringBuilder(remainingNumber).reverse().toString();
        System.out.println("Step b: Reversed number = " + reversedNumber);

//////////////////////////////////////////////////////////
        // Step c: Double the Odd-Positioned Digits
        StringBuilder modifiedNumber = new StringBuilder();
        for (int i = 0; i < reversedNumber.length(); i++) {
            int digit = Character.getNumericValue(reversedNumber.charAt(i));
            if ((i + 1) % 2 != 0) { 
                digit *= 2;
                if (digit > 9) {
                    digit = digit / 10 + digit % 10; // Sum the digits if doubled value is more than 9
                }
            }
            modifiedNumber.append(digit);
        }
        System.out.println("Step c: After doubling odd-positioned digits = " + modifiedNumber);
//////////////////////////////////////////////////////////
        // Step d: Sum All the Digits
        int sum = 0;
        for (int i = 0; i < modifiedNumber.length(); i++) {
            sum += Character.getNumericValue(modifiedNumber.charAt(i));
        }
        System.out.println("Step d: Sum of all digits = " + sum);
//////////////////////////////////////////////////////////
        // Step e: Calculate Check Digit
        int checkDigit = (10 - (sum % 10)) % 10; 
        System.out.println("Step e: 10 - (sum % 10) = " + checkDigit);
//////////////////////////////////////////////////////////
        // Step f: Compare the Check Digit with the Last Digit
        if (checkDigit == lastDigit) {
            System.out.println("The credit card number is valid.");
        } else {
            System.out.println("The credit card number is invalid.");
        }
    }
//////////////////////////////////////////////////////////
    public static void main(String[] args) {
        long ccNumber = 123467575;
        CreditCardValidator obj = new CreditCardValidator(ccNumber);
        obj.validateCard();
    }
}