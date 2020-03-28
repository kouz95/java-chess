package chess.domain.board;

import java.util.LinkedHashMap;
import java.util.Map;

import chess.domain.piece.Empty;
import chess.domain.piece.Pawn;
import chess.domain.piece.Piece;
import chess.domain.position.Position;

public class Board {
    private final Map<Position, Piece> board;

    public Board(Map<Position, Piece> board) {
        this.board = board;
    }

    public Map<Position, Piece> getBoard() {
        return Map.copyOf(board);
    }

    public Map<Position, Piece> reverse() {
        Map<Position, Piece> reversedBoard = new LinkedHashMap<>();
        board.forEach((position, piece) -> reversedBoard.put(position.reverse(), piece.getNameReversed()));
        return reversedBoard;
    }

    private Piece getPieceIn(Position key) {
        if (hasNotPieceIn(key)) {
            throw new IllegalArgumentException("기물이 존재하지 않습니다.");
        }
        return board.get(key);
    }

    public boolean hasNotPieceIn(Position key) {
        return !board.containsKey(key);
    }

    public boolean hasPieceIn(Position key) {
        return board.values()
                .stream()
                .filter(Piece::isNotEmpty)
                .anyMatch(piece -> piece.isPositionEqualsTo(key));
    }

    public void remove(Position key) {
        board.replace(key, new Empty(key));
    }

//    public double getScore() {
//        return board.entrySet()
//                .stream()
//                .collect(groupingBy(
//                        entry -> entry.getKey().substring(0, 1),
//                        mapping(entry -> entry.getValue().getName(), toList())))
//                .values().stream()
//                .mapToDouble(Score::calculateScoreOf)
//                .sum();
//    }

    public boolean isPawnIn(Position key) {
        return getPieceIn(key) instanceof Pawn;
    }

    public Piece pieceIn(Position from) {
        return getPieceIn(from);
    }

    public void movePiece(Position from, Position to) {
		Piece piece = getPieceIn(from);
		if (hasPieceIn(to)) {
			throw new IllegalArgumentException("아군 기물이 위치하고 있습니다.");
		}

		piece.moveTo(to);

        board.replace(to, board.get(from));
        board.replace(from, new Empty(from));
    }

    public Map<Position, Piece> getMerged(Map<Position, Piece> reverse) {
        Map<Position, Piece> mergedBoard = new LinkedHashMap<>(board);

        reverse.entrySet()
        .stream()
        .filter(entry -> entry.getValue().isNotEmpty())
        .forEach(entry -> mergedBoard.put(entry.getKey(), entry.getValue()));

        return mergedBoard;
    }

    public boolean isKingDead() {
        return board.values()
                .stream()
                .noneMatch(Piece::isKing);
    }
}
