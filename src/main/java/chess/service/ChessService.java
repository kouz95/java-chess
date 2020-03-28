//package chess.service;
//
//import chess.domain.MoveInfo;
//import chess.domain.board.ChessGame;
//import chess.domain.board.Turn;
//import chess.domain.board.Boards;
//import chess.domain.position.Position;
//import chess.domain.position.Positions;
//
//public class ChessService {
//	public static void move(ChessGame chessGame, MoveInfo moveInfo) {
//		Position from = Position.of(moveInfo.getFrom());
//		Position to = Position.of(moveInfo.getTo());
//
//		if (chessGame..hasPieceIn(Positions.of(from, to).path())) {
//			throw new IllegalArgumentException("이동할 수 없는 경로입니다.");
//		}
//		boards.move(from, to, turn);
//	}
//
//
//}
