package chess.domain.board;

import chess.domain.position.Position;

public class Attack extends Moving {
    public Attack(Position from, Position to) {
        super(from, to);
    }

    @Override
    protected void update(Board currentBoard, Board nextBoard) {
        currentBoard.movePiece(from, to);
        nextBoard.remove(to.reverse());
    }
}
