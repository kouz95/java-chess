package chess;

import chess.domain.InitialInputType;
import chess.domain.RunInfo;
import chess.domain.board.Turn;
import chess.domain.board.BoardFactory;
import chess.domain.board.Boards;
import chess.controller.ChessController;
import chess.view.InputView;
import chess.view.OutputView;

public class ConsoleUIChessApplication {
	public static void main(String[] args) {
		OutputView.printInitialMessage();

		if (InitialInputType.of(InputView.inputInitial()).isStart()) {
			Boards boards = BoardFactory.create();
			Turn current = Turn.LOWER;
			OutputView.printBoard(boards.getTotal());

			while (true) {
				ChessController.run(RunInfo.of(InputView.inputRunInfo()), boards, current);
				current = current.next();
			}
		}
	}
}
