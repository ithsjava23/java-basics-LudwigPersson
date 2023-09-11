package org.example;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        int[] prices = new int[24];

        while (running) {
            System.out.println("Elpriser");
            System.out.println("========");
            System.out.println("1. Inmatning");
            System.out.println("2. Min, Max och Medel");
            System.out.println("3. Sortera");
            System.out.println("4. Bästa Laddningstid (4h)");
            System.out.println("e. Avsluta");
            System.out.print("Välj ett alternativ: ");

            String choice = input.next();

            switch (choice.toLowerCase()) {
                case "1" -> inputPricesForDay(prices, input);
                case "2" -> printMinAndMaxPrices(prices);
                case "3" -> //sortera
                case "4" -> //bästa laddtid
                case "e" -> {
                    System.out.println("Programmet avslutas.");
                    running = false;
                }
                default -> System.out.println("Ogiltigt val. Försök igen.");
            }
        }

        input.close();
    }

    public static void inputPricesForDay(int[] prices, Scanner input) {
        System.out.println("Ange elpriser för dygnet (i öre per kW/h):");

        for (int hour = 0; hour < prices.length; hour++) {
            System.out.print("Timme " + hour + " - " + (hour + 1) + ": ");
            prices[hour] = input.nextInt();
        }

        System.out.println("Elpriser har matats in för dygnet.");
    }

    public static void printMinAndMaxPrices(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = Integer.MIN_VALUE;
        int sum = 0;

        for (int price : prices) {
            sum += price;

            if (price < minPrice) {
                minPrice = price;
            }

            if (price > maxPrice) {
                maxPrice = price;
            }
        }

        double averagePrice = (double) sum / prices.length;

        System.out.println("Lägsta pris: " + minPrice + " öre/kW/h");
        System.out.println("Högsta pris: " + maxPrice + " öre/kW/h");
        System.out.println("Dygnets medelpris: " + String.format("%.2f", averagePrice) + " öre/kW/h");
    }
}