
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        int cRow = 0;
        int cCol = size / 2;

        square.placeValue(cRow, cCol, 1);

        for (int i = 2; i <= size * size; i++) {
            int nRow = cRow -1;

            if (nRow < 0) {
                nRow = square.getHeight() - 1;
            }

            int nCol = cCol + 1;
            if (nCol >= square.getWidth()) {
                nCol = 0;
            }

            int nBoxValue = square.readValue(nRow, nCol);

            if (nBoxValue != 0) {
                nRow = cRow + 1;
                nCol = cCol;
            }

            square.placeValue(nRow, nCol, i);
            cRow = nRow;
            cCol = nCol;
        }
        return square;
    }

}
