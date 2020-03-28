package chess.domain.board;

import java.util.Arrays;
import java.util.function.Function;

import chess.domain.position.Position;

public enum Turn {
	LOWER("백", 0, 1, key -> key),
	UPPER("흑", 1, 0, Position::getReversedNameOf);

	private final String name;
	private final int self;
	private final int enemy;
	private final Function<String, String> getKey;

	Turn(String name, int self, int enemy, Function<String, String> getKey) {
		this.name = name;
		this.self = self;
		this.enemy = enemy;
		this.getKey = getKey;
	}

	public Turn next() {
		return Arrays.stream(Turn.values())
			.filter(value -> !this.equals(value))
			.findFirst()
			.orElseThrow(NullPointerException::new);
	}

	public String key(String position) {
		return getKey.apply(position);
	}

	public String getName() {
		return name;
	}

	public int self() {
		return self;
	}

	public int enemy() {
		return enemy;
	}

	public boolean isUpper() {
		return UPPER.equals(this);
	}

	public boolean isLower() {
		return LOWER.equals(this);
	}
}
