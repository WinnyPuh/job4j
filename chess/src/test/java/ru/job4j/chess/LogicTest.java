package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class LogicTest {
    Logic logic = new Logic();

    @Test
    public void whereBishopBlackCanMove() {
        logic.add(new BishopBlack(Cell.F8));
        try {
            assertThat(logic.move(Cell.F8, Cell.D6), is(true));
        } catch (ImpossibleMoveException ime) {
            ime.printStackTrace();
        } catch (OccupiedWayException owe) {
            owe.printStackTrace();
        } catch (FigureNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

    }
    @Test
    public void whereBishopBlackCanNotMove() {
        logic.add(new BishopBlack(Cell.F8));
        try {
            assertThat(logic.move(Cell.F8, Cell.F5), is(false));
        } catch (ImpossibleMoveException ime) {
            ime.printStackTrace();
        } catch (OccupiedWayException owe) {
            owe.printStackTrace();
        } catch (FigureNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
    @Test
    public void whereKingBlackCanMove() {
        logic.add(new KingBlack(Cell.E8));
        try {
            assertThat(logic.move(Cell.E8, Cell.F7), is(true));
        } catch (ImpossibleMoveException ime) {
            ime.printStackTrace();
        } catch (OccupiedWayException owe) {
            owe.printStackTrace();
        } catch (FigureNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
    @Test
    public void whereKingBlackCanNotMove() {
        logic.add(new KingBlack(Cell.E8));
        try {
            assertThat(logic.move(Cell.E8, Cell.C5), is(false));
        } catch (ImpossibleMoveException ime) {
            ime.printStackTrace();
        } catch (OccupiedWayException owe) {
            owe.printStackTrace();
        } catch (FigureNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
    @Test
    public void whereKnightBlackCanMove() {
        logic.add(new KnightBlack(Cell.G8));
        try {
            assertThat(logic.move(Cell.G8, Cell.F6), is(true));
        } catch (ImpossibleMoveException ime) {
            ime.printStackTrace();
        } catch (OccupiedWayException owe) {
            owe.printStackTrace();
        } catch (FigureNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
    @Test
    public void whereKnightBlackCanNotMove() {
        logic.add(new KnightBlack(Cell.G8));
        try {
            assertThat(logic.move(Cell.G8, Cell.G6), is(false));
        } catch (ImpossibleMoveException ime) {
            ime.printStackTrace();
        } catch (OccupiedWayException owe) {
            owe.printStackTrace();
        } catch (FigureNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
    @Test
    public void wherePawnBlackCanMove() {
        logic.add(new PawnBlack(Cell.A7));
        try {
            assertThat(logic.move(Cell.A7, Cell.A6), is(true));
        } catch (ImpossibleMoveException ime) {
            ime.printStackTrace();
        } catch (OccupiedWayException owe) {
            owe.printStackTrace();
        } catch (FigureNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
    @Test
    public void wherePawnBlackCanNotMove() {
        logic.add(new PawnBlack(Cell.A7));
        try {
            assertThat(logic.move(Cell.A7, Cell.B6), is(false));
        } catch (ImpossibleMoveException ime) {
            ime.printStackTrace();
        } catch (OccupiedWayException owe) {
            owe.printStackTrace();
        } catch (FigureNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
    @Test
    public void whereQueenBlackCanMove() {
        logic.add(new QueenBlack(Cell.D8));
        try {
            assertThat(logic.move(Cell.D8, Cell.D5), is(true));
        } catch (ImpossibleMoveException ime) {
            ime.printStackTrace();
        } catch (OccupiedWayException owe) {
            owe.printStackTrace();
        } catch (FigureNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
    @Test
    public void whereQueenBlackCanNotMove() {
        logic.add(new QueenBlack(Cell.D8));
        try {
            assertThat(logic.move(Cell.D8, Cell.C5), is(false));
        } catch (ImpossibleMoveException ime) {
            ime.printStackTrace();
        } catch (OccupiedWayException owe) {
            owe.printStackTrace();
        } catch (FigureNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
    @Test
    public void whereRookBlackCanMove() {
        logic.add(new RookBlack(Cell.D8));
        try {
            assertThat(logic.move(Cell.D8, Cell.D5), is(true));
        } catch (ImpossibleMoveException ime) {
            ime.printStackTrace();
        } catch (OccupiedWayException owe) {
            owe.printStackTrace();
        } catch (FigureNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
    @Test
    public void whereRookBlackCanNotMove() {
        logic.add(new RookBlack(Cell.D8));
        try {
            assertThat(logic.move(Cell.D8, Cell.C5), is(false));
        } catch (ImpossibleMoveException ime) {
            ime.printStackTrace();
        } catch (OccupiedWayException owe) {
            owe.printStackTrace();
        } catch (FigureNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

}