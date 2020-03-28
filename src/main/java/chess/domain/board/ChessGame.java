package chess.domain.board;

import chess.domain.piece.Piece;
import chess.domain.position.Position;
import chess.domain.position.Positions;

import java.util.LinkedHashMap;
import java.util.Map;

public class ChessGame {
    private final GameState gameState;

    public ChessGame(GameState gameState) {
        this.gameState = gameState;
    }

    public void movePiece(Position from, Position to) {
        if (gameState.hasPieceIn(Positions.of(from, to).path())) {
            throw new IllegalArgumentException("이동 경로에 기물이 있습니다.");
        }

        // TODO: 2020-03-28 from / to should be selectively reversed, depends on turn
        MovingType movingType = gameState.getMovingType(from, to);
        Moving moving = movingType.getMoving(from, to);
        moving.update(gameState.currentBoard(), gameState.nextBoard());
    }

    public Map<String, String> completeBoard() {
        Map<String, String> result = new LinkedHashMap<>();

        Map<Position, Piece> board = gameState.completeBoard();
        board.forEach((position, piece) -> result.put(position.getName(), piece.getName()));

        return result;
    }

    public boolean cannotMove() {
        return gameState.isKingDead();
    }
}
