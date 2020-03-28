package chess;

import chess.domain.InitialInputType;
import chess.domain.RunInfo;
import chess.domain.board.*;
import chess.controller.ChessController;
import chess.view.InputView;
import chess.view.OutputView;

public class ConsoleUIChessApplication {
	public static void main(String[] args) {
		OutputView.printInitialMessage();

		if (InitialInputType.of(InputView.inputInitial()).isStart()) {
			Board lower = BoardFactory.lowerBoard();
			Board upper = BoardFactory.upperBoard();

			ChessGame chessGame = new ChessGame(GameState.of(lower, upper, Turn.LOWER));
			OutputView.printBoard(chessGame.completeBoard());

			while (true) {
				ChessController.run(RunInfo.of(InputView.inputRunInfo()), chessGame);
			}
		}
	}
}
