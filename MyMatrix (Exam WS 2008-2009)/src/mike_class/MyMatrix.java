package mike_class;
import java.util.*;

public class MyMatrix<T> implements Matrix<T> {
    private Map<MatrixIndex, T> matrixEntries = new HashMap<>();
    private int rowCount = 0;
    private int columnCount = 0;

    @Override
    public T get(int row, int column) {
        if (!isValidPosition(row, column) || row >= rowCount || column >= columnCount)
            throw new IllegalArgumentException();

        return matrixEntries.get(new MatrixIndex(row, column));
    }

    @Override
    public T put(int row, int column, T value) {
        if (!isValidPosition(row, column)) {
            throw new IllegalArgumentException();
        }

        MatrixIndex key = new MatrixIndex(row, column);
        if (value == null) {
            T oldValue = matrixEntries.remove(key);
            if (row + 1 == rowCount || column + 1 == columnCount)
                updateRowAndColumnCount();

            return oldValue;
        }

        if (row >= rowCount)
            rowCount = row + 1;
        if (column >= columnCount)
            columnCount = column + 1;

        return matrixEntries.put(key, value);
    }

    @Override
    public boolean contains(T value) {
        return matrixEntries.containsValue(value);
    }

    @Override
    public int getObjectCount() {
        return matrixEntries.size();
    }

    @Override
    public int getDistinctObjectCount() {
        return new HashSet<>(matrixEntries.values()).size();
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Iterator<T> iterator() {
        return new DepthFirstIterator();
    }

    private boolean isValidPosition(int row, int column) {
        return row >= 0 && column >= 0;
    }

    private void updateRowAndColumnCount() {
        columnCount = Collections.max(
                matrixEntries.keySet(),
                Comparator.comparingInt(MatrixIndex::getColumn)
        ).getColumn() + 1;
        rowCount = Collections.max(
                matrixEntries.keySet(),
                Comparator.comparingInt(MatrixIndex::getRow)
        ).getRow() + 1;
    }

    public class DepthFirstIterator implements Iterator<T> {
        private int currentColumn = 0;
        private int currentRow = -1;

        @Override
        public boolean hasNext() {
            if (currentColumn < columnCount - 1)
                return true;
            if (currentColumn >= columnCount)
                return false;
            if (currentRow >= rowCount - 1)
                return false;

            for (int i = currentRow + 1; i < rowCount; i++) {
                if (get(i, currentColumn) != null)
                    return true;
            }

            return false;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();

            for (int j = currentColumn; j < columnCount; j++) {
                int startRow = j == currentColumn
                        ? currentRow + 1
                        : 0;

                for (int i = startRow; i < rowCount; i++) {
                    T valueAtPos = get(i, j);

                    if (valueAtPos != null) {
                        currentRow = i;
                        currentColumn = j;
                        return valueAtPos;
                    }
                }
            }

            System.err.println("Should not be able to reach this line, hasNext() broken or race condition");
            throw new NoSuchElementException();
        }
    }
}
