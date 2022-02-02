package cinema;

import java.util.Arrays;

public class Room {
    private int rows;
    private int cols;
    private char[][] seats;
    private Statistics stats;

    public Room(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        seats = new char[rows][cols];
        stats = new Statistics(rows, cols);
        initSeats();
    }

    private void initSeats() {
        for (char[] row : seats) {
            Arrays.fill(row, 'S');
        }
    }

    public boolean buySeat(int row, int col) {
        if (checkAvailable(row, col)) {
            seats[row][col] = 'B';
            stats.update(calcPrice(row));
            return true;
        }
        return false;
    }

    public int calcPrice(int row) {
        int frontRows = rows / 2;
        if (rows * cols > 60 && row >= frontRows) {
            return 8;
        }
        return 10;
    }

    public boolean checkAvailable(int row, int col) {
        return seats[row][col] == 'S';
    }

    public Statistics getStats() {
        return stats;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cinema:\n ");
        for (int i = 1; i <= cols; ++i) {
            sb.append(" ").append(i);
        }
        sb.append("\n");
        for (int i = 0; i < rows; ++i) {
            sb.append(i + 1);
            for (int j = 0; j < cols; ++j) {
                sb.append(" ").append(seats[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
