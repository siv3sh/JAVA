Alphabet War Game

The Alphabet War Game is a Java program where each letter has a strength point, and the goal is to determine the winning side based on the input string. Letters on the left and right sides are assigned specific strengths, and the program calculates which side has more strength.

Instructions

Run the program and enter a string of letters.
The program will evaluate the total strength for each side and declare the winner, or announce a tie if strengths are equal.

#############################################################################
CreditCardValidator

The CreditCardValidator class checks if a given credit card number is valid. It goes through a series of steps, including extracting the check digit, reversing digits, modifying odd-positioned digits, summing them up, and comparing the check digit with the calculated value.

Steps of Validation

Extract Last Digit – The last digit is separated to be compared at the end.
Reverse Digits – The remaining digits (without the last) are reversed.
Double Odd-Positioned Digits – Every odd-positioned digit (from the reversed sequence) is doubled. If doubling results in a two-digit number, the digits are summed.
Sum All Digits – The modified digits are summed.
Calculate Check Digit – Based on the sum, a check digit is calculated.
Compare Check Digit – The calculated check digit is compared with the extracted last digit to determine validity.
Usage

To run the program, instantiate CreditCardValidator with a credit card number and call validateCard().
#############################################################################


MaxFreq

The MaxFreq program allows the user to input an array of integers and counts the frequencies of the first k unique elements.

Features

Input Handling: The program accepts user input for the array size and elements, as well as the value of k (the number of unique elements for which frequencies should be displayed).
Frequency Calculation: It uses a visited array to mark elements that have already been counted, ensuring only the first k unique elements are processed.
Output: Displays each of the k unique elements with their frequency.
Usage

Run the program.
Input the number of elements and the elements themselves.
Enter the value of k to specify how many unique elements' frequencies you want to see.

#############################################################################
ShareTrader

The ShareTrader program helps maximize profit from stock trading by finding the best two buy-sell opportunities given a series of stock prices. It’s designed to allow for up to two trades to achieve the highest profit.

Key Features

Dynamic Profit Calculation:
firstBuy and firstSell: Track the lowest price to buy and the highest profit for the first trade.
secondBuy and secondSell: Adjust based on the profit from the first trade, allowing a second trade at an optimal price point.
Input Handling: The program prompts the user to enter the number of prices and the respective stock prices for each day.
Output: After processing the prices, it outputs the maximum achievable profit with up to two trades.
Usage

#############################################################################

Run the program.
Enter the number of price points.
Input the stock prices sequentially.
The program will display the maximum profit possible with up to two trades.
