package chess.domain.piece;

import chess.domain.position.Position;

public class Empty extends Piece {
    public Empty(Position position) {
        super(position, ".", new CannotMove());
    }

    private static class CannotMove implements MoveStrategy {
        @Override
        public boolean isNotMovableTo(Position start, Position destination) {
            return true;
        }
    }
}
