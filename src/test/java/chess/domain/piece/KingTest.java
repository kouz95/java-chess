package chess.domain.piece;

import static chess.domain.position.Fixtures.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KingTest {

	@Test
	void moveTo_When_Success() {
		Piece king = new King(C3);
		king.moveTo(C4);

		assertThat(king.getPosition()).isEqualTo(C4);
	}

	@Test
	void moveTo_When_Fail() {
		Piece king = new King(C3);
		assertThatIllegalArgumentException()
			.isThrownBy(() -> king.moveTo(C5))
			.withMessage("기물의 이동 범위에 속하지 않습니다.");
	}
}