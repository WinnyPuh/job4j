package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QueenBlack implements Figure {
    private final Cell position;

    public QueenBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int rangeX = source.x - dest.x;
        int rangeY = source.y - dest.y;
        if ((rangeX != 0 && rangeY != 0) && (Math.abs(rangeX) != Math.abs(rangeY))) {
             throw new ImpossibleMoveException("It`s impossible to move this way");
        }
        Cell[] steps = new Cell[Math.abs(rangeX)];
        int size = Math.max(Math.abs(rangeX), Math.abs(rangeY));
        for (int i = 0; i < size; i++) {
            if (rangeX != 0 && rangeY != 0) {
                steps[i] = Cell.moveCell(source.x + (rangeX < 0 ? 1 : -1) * (i + 1), source.y + (rangeY < 0 ? 1 : -1) * (i + 1));
            }
            if (rangeX == 0) {
                steps[i] = Cell.moveCell(source.x, source.y + (rangeY < 0 ? 1 : -1) * (i + 1));
            }
            if (rangeY == 0) {
                steps[i] = Cell.moveCell(source.x + (rangeX < 0 ? 1 : -1) * (i + 1), source.y);
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QueenBlack(dest);
    }
}
