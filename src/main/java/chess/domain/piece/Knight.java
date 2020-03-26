package chess.domain.piece;

import chess.domain.position.Position;

public class Knight extends Piece {
	public Knight(Position position) {
		super(position, "n", new KnightMoveStrategy());
	}
}
