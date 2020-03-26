package chess.domain;

import java.util.Map;

public class Status {
	private static final String DRAW = "무승부";
	private static final String WIN = "승";

	private final Map<String, Double> status;

	public Status(Map<String, Double> status) {
		this.status = status;
	}

	public double getWhiteScore() {
		return status.get(Turn.LOWER.getName());
	}

	public double getBlackScore() {
		return status.get(Turn.UPPER.getName());
	}

	public String getResult() {
		double lowerScore =	status.get(Turn.LOWER.getName());
		double upperScore =	status.get(Turn.UPPER.getName());
		if (lowerScore > upperScore) {
			return Turn.LOWER.getName() + WIN;
		}
		if (upperScore > lowerScore) {
			return Turn.UPPER.getName() + WIN;
		}
		return DRAW;
	}
}
