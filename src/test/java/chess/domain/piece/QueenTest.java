package chess.domain.piece;

import static chess.domain.position.Fixtures.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueenTest {

	@Test
	void moveTo_When_Success() {
		Piece queen = new Queen(C3);
		queen.moveTo(H8);
		queen.moveTo(H3);

		assertThat(queen.getPosition()).isEqualTo(H3);
	}

	@Test
	void moveTo_When_Fail() {
		Piece queen = new Queen(C3);
		assertThatIllegalArgumentException()
			.isThrownBy(() -> queen.moveTo(D1))
			.withMessage("기물의 이동 범위에 속하지 않습니다.");
	}
}