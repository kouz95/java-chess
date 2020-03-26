package chess.domain.piece;

import chess.domain.position.Position;

public class Bishop extends Piece {
	public Bishop(Position position) {
		super(position, "b", new BishopMoveStrategy());
	}
}
