public class CreditCardValidator {
    private long ccNumber;

    public CreditCardValidator(long ccNumber) {
        // Validate that the ccNumber is positive and has 8 or 9 digits
        if (ccNumber < 0) {
            throw new IllegalArgumentException("Credit card number cannot be negative.");
        }

        String ccStr = String.valueOf(ccNumber);
        int length = ccStr.length();
        
        if (length < 8 || length > 9) {
            throw new IllegalArgumentException("Credit card number must have exactly 8 or 9 digits.");
        }

        this.ccNumber = ccNumber;
    }

    public void validateCard() {
        // Step a: Remove the Last Digit
        String ccStr = String.valueOf(this.ccNumber);
        int length = ccStr.length();
        
        int lastDigit = Integer.parseInt(ccStr.substring(length - 1));
        String remainingNumber = ccStr.substring(0, length - 1);
        System.out.println("Step a: Last digit = " + lastDigit + ", Remaining number = " + remainingNumber);
        
        // Step b: Reverse the Remaining Digits
        String reversedNumber = new StringBuilder(remainingNumber).reverse().toString();
        System.out.println("Step b: Reversed number = " + reversedNumber);

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

        // Step d: Sum All the Digits
        int sum = 0;
        for (int i = 0; i < modifiedNumber.length(); i++) {
            sum += Character.getNumericValue(modifiedNumber.charAt(i));
        }
        System.out.println("Step d: Sum of all digits = " + sum);

        // Step e: Calculate Check Digit
        int checkDigit = (10 - (sum % 10)) % 10; 
        System.out.println("Step e: 10 - (sum % 10) = " + checkDigit);

        // Step f: Compare the Check Digit with the Last Digit
        if (checkDigit == lastDigit) {
            System.out.println("The credit card number is valid.");
        } else {
            System.out.println("The credit card number is invalid.");
        }
    }

    public static void main(String[] args) {
        try {
            long ccNumber = 123467575; // Example credit card number for validation
            CreditCardValidator obj = new CreditCardValidator(ccNumber);
            obj.validateCard();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
