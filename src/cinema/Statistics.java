package cinema;

public class Statistics {
    int seatsSold = 0;
    int totalSeats;
    int currentIncome = 0;
    int totalIncome;

    public Statistics(int rows, int cols) {
        totalSeats = rows * cols;
        calcProfit(rows, cols);
    }

    public void update(int price) {
        ++seatsSold;
        currentIncome += price;
    }

    private void calcProfit(int rows, int cols) {
        if (rows * cols <= 60) {
            totalIncome = rows * cols * 10;
        } else {
            int frontRows = rows / 2;
            totalIncome = frontRows * cols * 10;
            totalIncome += (rows - frontRows) * cols * 8;
        }
    }

    private double calcPercentage() {
        return 100.0 * seatsSold / totalSeats;
    }

    @Override
    public String toString() {
        return "Number of purchased tickets: " + seatsSold +
                "\nPercentage: " + String.format("%.2f", calcPercentage()) + "%" +
                "\nCurrent income: $" + currentIncome +
                "\nTotal income: $" + totalIncome + "\n";
    }
}
