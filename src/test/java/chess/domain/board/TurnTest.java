package chess.domain.board;

import static org.assertj.core.api.Assertions.*;

import chess.domain.board.Turn;
import org.junit.jupiter.api.Test;

class TurnTest {
	@Test
	void next() {
		assertThat(Turn.LOWER.next()).isEqualTo(Turn.UPPER);
	}

	@Test
	void key() {
		assertThat(Turn.LOWER.key("a1")).isEqualTo("a1");
		assertThat(Turn.UPPER.key("a1")).isEqualTo("h8");
	}
}