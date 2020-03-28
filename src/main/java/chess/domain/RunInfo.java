package chess.domain;

import java.util.Arrays;
import java.util.List;

public class RunInfo implements MoveInfo {
	private static final String DELIMITER = " ";
	private static final int FUNCTION_TYPE_INDEX = 0;
	private static final int FROM_INDEX = 1;
	private static final int TO_INDEX = 2;
	private static final String MOVE_FUNCTION = "move";
	private static final String STATUS_FUNCTION = "status";
	private static final List<String> FUNCTION_TYPES = List.of(MOVE_FUNCTION, STATUS_FUNCTION);

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

		verifyRunInfos(infos);

		if (infos.get(FUNCTION_TYPE_INDEX).equals(MOVE_FUNCTION)) {
			return new RunInfo(MOVE_FUNCTION, infos.get(FROM_INDEX), infos.get(TO_INDEX));
		}

		return new RunInfo(STATUS_FUNCTION);
	}

	private static void verifyRunInfos(List<String> infos) {
		if (!FUNCTION_TYPES.contains(infos.get(FUNCTION_TYPE_INDEX))) {
			throw new IllegalArgumentException("잘못된 입력입니다.");
		}
	}

	public boolean isMove() {
		return MOVE_FUNCTION.equals(functionType);
	}

	public boolean isStatus() {
		return STATUS_FUNCTION.equals(functionType);
	}

	@Override
	public String getFrom() {
		return from;
	}

	@Override
	public String getTo() {
		return to;
	}
}
