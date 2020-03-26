package chess.domain.piece;

import static chess.domain.position.Fixtures.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class KnightTest {

	@Test
	void moveTo_When_Success() {
		Piece knight = new Knight(C3);
		knight.moveTo(D1);
		knight.moveTo(B2);

		assertThat(knight.getPosition()).isEqualTo(B2);
	}

	@Test
	void moveTo_When_Fail() {
		Piece knight = new Knight(C3);
		assertThatIllegalArgumentException()
			.isThrownBy(() -> knight.moveTo(D3))
			.withMessage("기물의 이동 범위에 속하지 않습니다.");
	}
}
