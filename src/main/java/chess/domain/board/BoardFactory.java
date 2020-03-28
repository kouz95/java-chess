package chess.domain.board;

import java.util.LinkedHashMap;
import java.util.Map;

import chess.domain.piece.*;
import chess.domain.position.Position;

public class BoardFactory {
	private static final Map<Position, Piece> lowerBoard;
	private static final Map<Position, Piece> upperBoard;

	static {
		lowerBoard = new LinkedHashMap<>();
		upperBoard = new LinkedHashMap<>();

		lowerBoard.put(Position.of("a1"), new Rook(Position.of("a1")));
		lowerBoard.put(Position.of("b1"), new Knight(Position.of("b1")));
		lowerBoard.put(Position.of("c1"), new Bishop(Position.of("c1")));
		lowerBoard.put(Position.of("d1"), new Queen(Position.of("d1")));
		lowerBoard.put(Position.of("e1"), new King(Position.of("e1")));
		lowerBoard.put(Position.of("f1"), new Bishop(Position.of("f1")));
		lowerBoard.put(Position.of("g1"), new Knight(Position.of("g1")));
		lowerBoard.put(Position.of("h1"), new Rook(Position.of("h1")));

		upperBoard.put(Position.of("a1"), new Rook(Position.of("a1")));
		upperBoard.put(Position.of("b1"), new Knight(Position.of("b1")));
		upperBoard.put(Position.of("c1"), new Bishop(Position.of("c1")));
		upperBoard.put(Position.of("d1"), new King(Position.of("d1")));
		upperBoard.put(Position.of("e1"), new Queen(Position.of("e1")));
		upperBoard.put(Position.of("f1"), new Bishop(Position.of("f1")));
		upperBoard.put(Position.of("g1"), new Knight(Position.of("g1")));
		upperBoard.put(Position.of("h1"), new Rook(Position.of("h1")));

		for (char c = 'a'; c <= 'h'; c++) {
			String key = String.valueOf(c) + 2;
			lowerBoard.put(Position.of(key), new Pawn(Position.of(key)));
			upperBoard.put(Position.of(key), new Pawn(Position.of(key)));
			for (int i = 3; i <= 8; i++) {
				key = String.valueOf(c) + i;
				lowerBoard.put(Position.of(key), new Empty(Position.of(key)));
				upperBoard.put(Position.of(key), new Empty(Position.of(key)));
			}
		}
	}

	public static Board lowerBoard() {
		return new Board(lowerBoard);
	}

	public static Board upperBoard() {
		return new Board(upperBoard);
	}
}
