package chess.controller;

import chess.domain.MoveInfo;
import chess.domain.RunInfo;
import chess.domain.board.ChessGame;
import chess.domain.position.Position;
import chess.view.OutputView;

public class ChessController {
	public static void run(RunInfo runInfo, ChessGame chessGame) {
		if (runInfo.isMove()) {
			move(chessGame, runInfo);
		}
		if (runInfo.isStatus()) {
//			status(chessGame);
			System.exit(0);
		}
	}

	private static void move(ChessGame chessGame, MoveInfo moveInfo) {
		if (chessGame.cannotMove()) {
			System.exit(0);
		}
		chessGame.movePiece(Position.of(moveInfo.getFrom()), Position.of(moveInfo.getTo()));
		OutputView.printBoard(chessGame.completeBoard());
	}

//	private static void status(ChessGame chessGame) {
//		OutputView.printStatus(StatusFactory.createBy(boards));
//	}
}
