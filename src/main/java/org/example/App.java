package org.example;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        int[] prices = new int[24];

        while (running) {
            System.out.println("Elpriser");
            System.out.println("=======x=");
            System.out.println("1. Inmatning");
            System.out.println("2. Min, Max och Medel");
            System.out.println("3. Sortera");
            System.out.println("4. Bästa Laddningstid (4h)");
            System.out.println("e. Avsluta");
            System.out.print("Välj ett alternativ: ");

            String choice = input.next();

            //sorteraa
            //bästa laddtid
            switch (choice.toLowerCase()) {
                case "1" -> inputPrices(prices, input);
                case "2" -> printMinAndMaxPrices(prices);
                case "3" -> System.out.println("sortera");
                case "4" -> System.out.println("bästa laddtid");
                case "e" -> {
                    System.out.println("Programmet avslutas.");
                    running = false;
                }
                default -> System.out.println("Ogiltigt val. Försök igen.");
            }
        }

        input.close();
    }

    public static void inputPrices(int[] prices, Scanner input) {
        System.out.println("Ange elpriser för dygnet (i öre per kW/h):");

        for (int hour = 0; hour < prices.length; hour++) {
            System.out.print(tim(hour) + "-" + tim(hour + 1) + ": ");
            prices[hour] = input.nextInt();
        }

        System.out.println("Elpriser har matats in för dygnet.");
    }

    public static void printMinAndMaxPrices(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = Integer.MIN_VALUE;
        int minHour = -1;
        int maxHour = -1;
        int sum = 0;

        for (int hour = 0; hour < prices.length; hour++) {
            int price = prices[hour];
            sum += price;

            if (price < minPrice) {
                minPrice = price;
                minHour = hour;
            }

            if (price > maxPrice) {
                maxPrice = price;
                maxHour = hour;
            }
        }

        double averagePrice = (double) sum / prices.length;

        System.out.println("Lägsta pris: " + tim(minHour) + "-" + tim(minHour + 1) + ", " + minPrice + " öre/kWh");
        System.out.println("Högsta pris: " + tim(maxHour) + "-" + tim(maxHour + 1) + ", " + maxPrice + " öre/kWh");
        System.out.println("Medelpris: " + String.format("%.2f", averagePrice) + " öre/kWh");
    }
    static String tim (int timme) {
        String tid;
        if (timme < 10) {
            tid = "0" + timme;
        } else {
            tid = "" + timme;
        }
        return tid;
    }

}