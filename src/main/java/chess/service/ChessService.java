package chess.service;

import chess.domain.MoveInfo;
import chess.domain.board.Turn;
import chess.domain.board.Boards;
import chess.domain.position.Positions;

public class ChessService {
	public static void move(Boards boards, Turn turn, MoveInfo moveInfo) {
		String from = turn.key(moveInfo.getFrom());
		String to = turn.key(moveInfo.getTo());

		if (boards.hasPieceIn(Positions.of(from, to).path())) {
			throw new IllegalArgumentException("이동할 수 없는 경로입니다.");
		}
		boards.move(from, to, turn);
	}
}
