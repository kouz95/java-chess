package chess.domain.board;

import chess.domain.position.Position;

public class Move extends Moving {
    protected Move(Position from, Position to) {
        super(from, to);
    }

    @Override
    public void update(Board currentBoard, Board nextBoard) {
        currentBoard.movePiece(from, to);
    }
}
