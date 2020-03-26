package chess.domain.piece;

import chess.domain.position.Position;

public class Rook extends Piece {
	public Rook(Position position) {
		super(position, "r", new RookMoveStrategy());
	}
}
