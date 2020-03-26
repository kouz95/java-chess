package chess.domain;

import java.util.Arrays;
import java.util.List;

public class RunInfo implements MoveInfo {
	private static final String DELIMITER = " ";
	private static final int FROM = 1;
	private static final int TO = 2;
	private static final int FUNCTION_TYPE_INDEX = 0;
	private static final List<String> FUNCTION_TYPES = List.of("move", "status");

	private final String functionType;
	private String from;
	private String to;

	private RunInfo(String functionType) {
		this.functionType = functionType;
	}

	private RunInfo(String functionType, String from, String to) {
		this.functionType = functionType;
		this.from = from;
		this.to = to;
	}

	public static RunInfo of(String runInfo) {
		List<String> infos = Arrays.asList(runInfo.split(DELIMITER));
		if (!FUNCTION_TYPES.contains(infos.get(FUNCTION_TYPE_INDEX))) {
			throw new IllegalArgumentException("잘못된 입력입니다.");
		}
		if (infos.get(FUNCTION_TYPE_INDEX).equals("move")) {
			return new RunInfo("move", infos.get(FROM), infos.get(TO));
		}
		return new RunInfo("status");
	}

	@Override
	public String getFrom() {
		return from;
	}

	@Override
	public String getTo() {
		return to;
	}

	public boolean isMove() {
		return "move".equals(functionType);
	}

	public boolean isStatus() {
		return "status".equals(functionType);
	}
}
