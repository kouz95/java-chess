package chess.service;

import java.util.HashMap;
import java.util.Map;

import chess.domain.MoveInfo;
import chess.domain.Status;
import chess.domain.Turn;
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

	public static Status getStatus(Boards boards) {
		Map<String, Double> status = new HashMap<>();
		status.put(Turn.LOWER.getName(), boards.getScoreOf(Turn.LOWER));
		status.put(Turn.UPPER.getName(), boards.getScoreOf(Turn.UPPER));
		return new Status(status);
	}
}
