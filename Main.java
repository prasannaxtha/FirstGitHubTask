import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        boolean isExiting = false;
        double totalCost = 0;
        double totalWithVAT;
        int vatPercentage = 13;

        while (true) {
            System.out.println("Enter user ID : ");
            String userId = inputScanner.nextLine();
            if (userId.equalsIgnoreCase("quit")) {
                break;
            }

            System.out.println("Enter the password: ");
            String userPassword = inputScanner.nextLine();
            if (userPassword.equalsIgnoreCase("quit")) {
                break;
            }

            System.out.println("Enter the number of items you want to buy: ");
            String itemCountString = inputScanner.nextLine();
            if (itemCountString.equalsIgnoreCase("quit")) {
                return;
            }
            int itemCount = Integer.parseInt(itemCountString);

            ArrayList<String> itemNames = new ArrayList<>();
            ArrayList<Double> itemPrices = new ArrayList<>();

            for (int i = 0; i < itemCount; i++) {
                System.out.print("Enter the name of item " + (i + 1) + ": ");
                String itemName = inputScanner.nextLine();
                if (itemName.equalsIgnoreCase("quit")) {
                    break;
                }
                itemNames.add(itemName);
            }

            for (int i = 0; i < itemCount; i++) {
                System.out.print("Enter the cost of item " + (i + 1) + ": ");
                double itemPrice = inputScanner.nextDouble();
                itemPrices.add(itemPrice);
                totalCost += itemPrice;
            }

            totalWithVAT = totalCost;
            System.out.println("The total cost is: " + totalCost);
            System.out.println("Shall we add VAT (y/n): ");
            String addVATResponse = inputScanner.next().toLowerCase();
            double totalCostWithVAT;

            if (addVATResponse.equalsIgnoreCase("y")) {
                totalCostWithVAT = totalWithVAT + (vatPercentage / 100.0) * totalWithVAT;
                System.out.println("The total cost after VAT is: " + totalCostWithVAT);
            } else {
                totalCostWithVAT = totalWithVAT;
                System.out.println("The total cost is: " + totalCostWithVAT);
            }

            boolean discountIsValid = false;
            double finalCost = totalCostWithVAT;

            while (!discountIsValid) {
                System.out.println("Enter the discount: ");
                float discountRate = inputScanner.nextFloat();
                if (discountRate > 60.00) {
                    System.out.println("The discount cannot be greater than 60 percent.");
                } else {
                    discountIsValid = true;
                    finalCost = totalCostWithVAT - (discountRate / 100) * totalCostWithVAT;
                    System.out.println("The final cost after the discount is: " + finalCost);
                }
            }

            System.out.println("Enter the payment amount: ");
            double paymentAmount = inputScanner.nextDouble();
            double changeAmount = paymentAmount - finalCost;

            System.out.println("The change to be returned is: " + changeAmount);
            System.out.println("The highest denominations are: ");

            if (changeAmount >= 1000) {
                int numOfThousand = (int) (changeAmount / 1000);
                System.out.println("1000 x " + numOfThousand);
                changeAmount = changeAmount % 1000;
            }
            if (changeAmount >= 500) {
                int numOfFiveHundred = (int) (changeAmount / 500);
                System.out.println("500 x " + numOfFiveHundred);
                changeAmount = changeAmount % 500;
            }
            if (changeAmount >= 100) {
                int numOfHundred = (int) (changeAmount / 100);
                System.out.println("100 x " + numOfHundred);
                changeAmount = changeAmount % 100;
            }
            if (changeAmount >= 50) {
                int numOfFifty = (int) (changeAmount / 50);
                System.out.println("50 x " + numOfFifty);
                changeAmount = changeAmount % 50;
            }
            if (changeAmount >= 20) {
                int numOfTwenty = (int) (changeAmount / 20);
                System.out.println("20 x " + numOfTwenty);
                changeAmount = changeAmount % 20;
            }
            if (changeAmount >= 10) {
                int numOfTen = (int) (changeAmount / 10);
                System.out.println("10 x " + numOfTen);
                changeAmount = changeAmount % 10;
            }
            if (changeAmount >= 5) {
                int numOfFive = (int) (changeAmount / 5);
                System.out.println("5 x " + numOfFive);
                changeAmount = changeAmount % 5;
            }
            if (changeAmount >= 1) {
                int numOfOne = (int) (changeAmount / 1);
                System.out.println("1 x " + numOfOne);
            }

            System.out.println("Do you want to quit or buy something else? (y/n): ");
            String quitResponse = inputScanner.next();
            if (quitResponse.equalsIgnoreCase("y")) {
                break;
            }
            inputScanner.nextLine();
        }

        inputScanner.close();
    }
}

