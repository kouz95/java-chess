package chess.domain;

import java.util.Arrays;

public enum InitialInputType {
	START("start"),
	END("end");

	private final String name;

	InitialInputType(String name) {
		this.name = name;
	}

	public static InitialInputType of(String input) {
		return Arrays.stream(InitialInputType.values())
			.filter(value -> value.name.equals(input))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."));
	}

	public boolean isStart() {
		return START.equals(this);
	}
}
