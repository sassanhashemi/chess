package chess;

public class Queen extends Piece {

    Queen(int color, int location) {
        super(color, location);
    }
    public boolean isLegalMove(Board board, int location) {
        boolean obstructedEnd = (board.getSquare(location).getColor() == this.getColor());
        int dX = Utility.getRC(location)[1] - Utility.getRC(this.getLocation())[1];
        int dY = Utility.getRC(location)[0] - Utility.getRC(this.getLocation())[0];
        boolean rightDirection = (Math.abs(dX - dY) == 0 || dY == 0 || dX == 0);
        boolean obstructedPath = false;
        for (int square : Utility.squaresBetween(this.getLocation(), location)) {
            if (board.getSquare(square) != null) {
                obstructedPath = true;
            }
        }
        return (rightDirection && !obstructedEnd && !obstructedPath);
    }

    @Override
    public String toString() {
        if (this.getColor() == Utility.WHITE) {
            return "Q";
        } else if (this.getColor() == Utility.BLACK) {
            return "q";
        } else {
            return null;
        }
    }

}