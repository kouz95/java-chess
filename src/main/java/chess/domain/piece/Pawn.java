package chess.domain.piece;

import chess.domain.position.Position;

public class Pawn extends Piece {
	public Pawn(Position position) {
		super(position, "p", new PawnMoveStrategy());
	}
}
