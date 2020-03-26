package chess.domain.position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Positions {
	private final List<Position> path;

	private Positions(List<Position> path) {
		this.path = path;
	}

	public static Positions of(Position start, Position end) {
		List<Position> path = new ArrayList<>();

		Position current = start;
		for (int i = 1; i < Distance.of(start, end).getDistance(); i++) {
			current = Direction.of(current, end).move(current);
			path.add(current);
		}
		return new Positions(path);
	}

	public static Positions of(String start, String end) {
		return of(Position.of(start), Position.of(end));
	}

	public List<String> path() {
		return path.stream()
			.map(Position::getName)
			.collect(Collectors.toUnmodifiableList());
	}
}
