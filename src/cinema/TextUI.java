package cinema;

import java.util.Scanner;

public class TextUI {
    private final Scanner SCN = new Scanner(System.in);
    private boolean run = true;
    private Room room;

    public TextUI() {
        createRoom();
    }

    private void createRoom() {
        System.out.println("Enter the number of rows:");
        int rows = SCN.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int cols = SCN.nextInt();
        System.out.println();
        room = new Room(rows, cols);
    }

    public void start() {
        menu();
    }

    private void menu() {
        while (run) {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            int choice = SCN.nextInt();
            switch (choice) {
                case 1:
                    printRoom();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    printStats();
                    break;
                default:
                    run = false;
            }
        }
    }

    private void printRoom() {
        System.out.println("\n" + room);
    }

    private void buyTicket() {
        while (true) {
            System.out.println("\nEnter a row number:");
            int row = SCN.nextInt() - 1;
            System.out.println("Enter a seat number in that row:");
            int col = SCN.nextInt() - 1;
            if (row < 0 || row >= room.getRows() || col < 0 || col >= room.getCols()) {
                System.out.println("Wrong input!");
                continue;
            }
            if (!room.buySeat(row, col)) {
                System.out.println("That ticket has already been purchased!");
                continue;
            }
            int price = room.calcPrice(row);
            System.out.println("Ticket price: $" + price + "\n");
            break;
        }
    }

    private void printStats() {
        System.out.println(room.getStats());
    }
}
