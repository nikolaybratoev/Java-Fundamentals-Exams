import java.util.Scanner;

public class SpringVacationTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tripDays = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int crew = Integer.parseInt(scanner.nextLine());
        double fuelPricePerKilometer = Double.parseDouble(scanner.nextLine());
        double foodExpensesPerPerson = Double.parseDouble(scanner.nextLine());
        double roomPricePerNightsForPerson = Double.parseDouble(scanner.nextLine());

        double foodExpenses = tripDays * crew * foodExpensesPerPerson;

        double hotelPrice = roomPricePerNightsForPerson * crew * tripDays;

        if (crew > 10) {
            hotelPrice = hotelPrice - (hotelPrice * 0.25);
        }

        double expenses = foodExpenses + hotelPrice;

        for (int day = 1; day <= tripDays; day++) {

            int travelledDistance = Integer.parseInt(scanner.nextLine());

            expenses += travelledDistance * fuelPricePerKilometer;

            if (day % 3 == 0 || day % 5 == 0) {
                expenses *= 1.4;
            }

            if (day % 7 == 0) {
                expenses -= expenses / crew;
            }

            if (expenses > budget) {
                double result = expenses - budget;

                System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", result);
                return;
            }
        }

        if (expenses < budget) {
            System.out.printf("You have reached the destination. You have %.2f$ budget left.", budget - expenses);
        }

    }
}
