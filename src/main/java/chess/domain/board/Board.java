package chess.domain.board;

import static java.util.stream.Collectors.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import chess.domain.piece.Pawn;
import chess.domain.piece.Piece;
import chess.domain.position.Position;

public class Board {
	private final Map<String, Piece> board;

	public Board(Map<String, Piece> board) {
		this.board = board;
	}

	public Map<String, Piece> getBoard() {
		return Map.copyOf(board);
	}

	public Map<String, Piece> getReversedBoard() {
		return board.entrySet()
			.stream()
			.collect(Collectors.toMap(
				entry -> Position.getReversedNameOf(entry.getKey()),
				Map.Entry::getValue,
				(e1, e2) -> e1,
				LinkedHashMap::new));
	}

	private Piece getPieceIn(String key) {
		if (hasNotPieceIn(key)) {
			throw new IllegalArgumentException("기물이 존재하지 않습니다.");
		}
		return board.get(key);
	}

	public boolean hasNotPieceIn(String key) {
		return !board.containsKey(key);
	}

	public boolean hasPieceIn(String key) {
		return board.containsKey(key);
	}

	public void movePiece(String from, String to) {
		Piece target = getPieceIn(from);
		if (hasPieceIn(to)) {
			throw new IllegalArgumentException("아군 기물이 위치하고 있습니다.");
		}

		target.moveTo(Position.of(to));
		board.put(to, target);
		remove(from);
	}

	public void remove(String key) {
		board.remove(key);
	}

	public double getScore() {
		return board.entrySet()
			.stream()
			.collect(groupingBy(
					entry -> entry.getKey().substring(0, 1),
					mapping(entry -> entry.getValue().getName(), toList())))
			.values().stream()
			.mapToDouble(Score::calculateScoreOf)
			.sum();
	}

	public boolean isPawnIn(String key) {
		return getPieceIn(key) instanceof Pawn;
	}
}
