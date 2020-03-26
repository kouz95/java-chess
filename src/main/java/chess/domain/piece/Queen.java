package chess.domain.piece;

import chess.domain.position.Position;

public class Queen extends Piece {
	public Queen(Position position) {
		super(position, "q", new QueenMoveStrategy());
	}
}
