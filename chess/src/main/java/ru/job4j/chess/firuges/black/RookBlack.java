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
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
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
        if (source.x != dest.x && source.y != dest.y) {
            throw new ImpossibleMoveException("It`s impossible to move this way");
        }
        int size = Math.max(Math.abs(rangeX), Math.abs(rangeY));
        Cell[] steps = new Cell[size];
        for (int i = 0; i < size; i++) {
            if (source.x == dest.x) {
                steps[i] = Cell.moveCell(source.x, source.y + (rangeY < 0 ? 1 : -1) * (i + 1));
            }
            if (source.y == dest.y) {
                steps[i] = Cell.moveCell(source.x + (rangeX < 0 ? 1 : -1) * (i + 1), source.y);
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
