package chess.domain.board;

import chess.domain.position.Position;

public abstract class Moving {
    protected final Position from;
    protected final Position to;

    protected Moving(Position from, Position to) {
        this.from = from;
        this.to = to;
    }

    protected abstract void update(Board currentBoard, Board nextBoard);
}
