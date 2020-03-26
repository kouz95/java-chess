package chess.domain.piece;

import chess.domain.position.Position;

public class King extends Piece {
	public King(Position position) {
		super(position, "k", new KingMoveStrategy());
	}
}