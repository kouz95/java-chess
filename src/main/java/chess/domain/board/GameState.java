package chess.domain.board;

import chess.domain.piece.Piece;
import chess.domain.position.Position;

import java.util.List;
import java.util.Map;

public class GameState {
    private final Board lower;
    private final Board upper;
    private final Turn turn;

    private GameState(Board lower, Board upper, Turn turn) {
        this.lower = lower;
        this.upper = upper;
        this.turn = turn;
    }

    public static GameState of(Board lower, Board upper, Turn turn) {
        return new GameState(lower, upper, turn);
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

    public Map<Position, Piece> completeBoard() {
        return lower.getMerged(upper.reverse());
    }

    public boolean isKingDead() {
        return lower.isKingDead() || upper.isKingDead();
    }

    public boolean hasPieceIn(List<Position> path) {
        return completeBoard().values()
                .stream()
                .filter(Piece::isNotEmpty)
                .anyMatch(piece -> path.contains(piece.getPosition()));
    }
}
