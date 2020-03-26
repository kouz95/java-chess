package chess.domain.piece;

import java.util.ArrayList;
import java.util.List;

import chess.domain.position.MovableAreaFactory;
import chess.domain.position.Position;

public class QueenMoveStrategy implements MoveStrategy {
	@Override
	public boolean isNotMovableTo(Position start, Position destination) {
		List<Position> movable = new ArrayList<>();
		movable.addAll(MovableAreaFactory.columnOf(start));
		movable.addAll(MovableAreaFactory.rowOf(start));
		movable.addAll(MovableAreaFactory.diagonalsOf(start));
		return !movable.contains(destination);
	}
}
