package chess.controller;

import chess.domain.MoveInfo;
import chess.domain.RunInfo;
import chess.domain.board.Turn;
import chess.domain.board.Boards;
import chess.domain.status.StatusFactory;
import chess.service.ChessService;
import chess.view.OutputView;

public class ChessController {
	public static void run(RunInfo runInfo, Boards boards, Turn turn) {
		if (runInfo.isMove()) {
			move(boards, turn, runInfo);
		}
		if (runInfo.isStatus()) {

			status(boards);
			System.exit(0);
		}
	}

	private static void move(Boards boards, Turn turn, MoveInfo moveInfo) {
		if (boards.isKingDead()) {
			System.exit(0);
		}
		ChessService.move(boards, turn, moveInfo);
		OutputView.printBoard(boards.getTotal());
	}

	private static void status(Boards boards) {
		OutputView.printStatus(StatusFactory.createBy(boards));
	}
}
