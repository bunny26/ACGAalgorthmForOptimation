import Ants.TravelingSalesman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("------------------ANT COLONY OPTIMIZATION------------------");
        if (args.length == 1 && args[0].equals("-p")) {
            menu();
        } else {
            System.out.println("Use the parameter '-p' for custom settings.");
            System.out.println("Otherwise the default values will be: ");
            System.out.println("Ants per epoch:   5        ");
            System.out.println("Epochs:            100       ");
            System.out.println("Evaporation Rate:     0.1    ");
            System.out.println("Alpha (pheromone impact): 10");
            System.out.println("Beta (distance impact):   0");

                      // Number of ants to run per generation.
            int gen     = 100;
            int ants    = 5;          // Number of generations.
            double evap = 0.1;          // Evaporation rate of pheromones.
            int alpha   = 10;            // Impact of pheromones on decision making.
            int beta    = 0;            // Impact of distance868 on decision making.

            TravelingSalesman travelingSalesman = new TravelingSalesman(ants, gen, evap, alpha, beta);
            travelingSalesman.run();
        }
        System.out.println("-------------------------COMPLETE--------------------------");
    }

    private static void menu () {
        TravelingSalesman tsp;
        int ants, gen;
        double evap;
        int alpha, beta;

        ants        = getUserInt("Ants per epoch:           ");
        gen         = getUserInt("Epochs:                   ");
        evap        = getUserDouble("Evaporation Rate:         ");
        alpha       = getUserInt("Alpha (pheromone impact): ");
        beta        = getUserInt("Beta (distance impact):   ");

        tsp = new TravelingSalesman(ants, gen, evap, alpha, beta);
        tsp.run();
    }

    private static double getUserDouble (String msg) {
        double input;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print(msg);

            if (sc.hasNextDouble()) {
                input = sc.nextDouble();

                if (input <= 0) {
                    System.out.println("Number must be positive.");
                } else {
                    break;
                }

            } else {
                System.out.println("Invalid input.");
            }
        }
        return input;
    }

    private static int getUserInt (String msg) {
        int input;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print(msg);

            if (sc.hasNextInt()) {
                input = sc.nextInt();

                if (input <= 0) {
                    System.out.println("Number must be positive.");
                } else {
                    break;
                }

            } else {
                System.out.println("Invalid input.");
            }
        }
        return input;
    }

}
