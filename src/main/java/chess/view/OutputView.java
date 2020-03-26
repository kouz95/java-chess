package chess.view;

import java.util.Map;

import chess.domain.Status;

public class OutputView {
	private static final String NEW_LINE = System.lineSeparator();

	public static void printInitialMessage() {
		System.out.println("체스 게임을 시작합니다.");
		System.out.println("게임 시작 : start");
		System.out.println("게임 종료 : end");
		System.out.println("게임 이동 : move source위치 target위치 - 예. move b2 b3");
	}

	public static void printBoard(Map<String, String> board) {
		for (int i = 8; i >= 1; i--) {
			for (char c = 'a'; c <= 'h'; c++) {
				String key = String.valueOf(c) + i;
				if (board.containsKey(key)) {
					System.out.print(board.get(key));
					continue;
				}
				System.out.print(".");
			}
			System.out.print(NEW_LINE);
		}
		System.out.print(NEW_LINE);
	}

	public static void printStatus(Status status) {
		System.out.println("White 팀 점수: " + status.getWhiteScore());
		System.out.println("Black 팀 점수: " + status.getBlackScore());
		System.out.println("결과 : " + status.getResult());
	}
}
