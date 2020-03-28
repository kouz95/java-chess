package chess.domain.board;

import chess.domain.position.Position;

public class GameState {
    private final Board lower;
    private final Board upper;
    private final Turn turn;

    public GameState(Board lower, Board upper, Turn turn) {
        this.lower = lower;
        this.upper = upper;
        this.turn = turn;
    }

    public Board currentBoard() {
        if (turn.isLower()) {
            return lower;
        }
        if (turn.isUpper()) {
            return upper;
        }
        throw new IllegalArgumentException();
    }

    public Board nextBoard() {
        if (turn.isLower()) {
            return upper;
        }
        if (turn.isUpper()) {
            return lower;
        }
        throw new IllegalArgumentException();
    }

    public MovingType getMovingType(Position from, Position to) {
        return MovingType.of(currentBoard().pieceIn(from), nextBoard().pieceIn(to));
    }
}
