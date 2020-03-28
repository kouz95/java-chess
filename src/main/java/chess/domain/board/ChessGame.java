package chess.domain.board;

import chess.domain.position.Position;

public class ChessGame {
    private GameState gameState;

    public ChessGame newGame(Board lower, Board upper, Turn turn) {
        gameState = new GameState(lower, upper, turn);
        return this;
    }

    public void movePiece(Position from, Position to) {
        MovingType movingType = gameState.getMovingType(from, to);
        Moving moving = movingType.getMoving(from, to);
        moving.update(gameState.currentBoard(), gameState.nextBoard());
    }
}
