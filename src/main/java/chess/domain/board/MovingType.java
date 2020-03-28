package chess.domain.board;

import chess.domain.piece.Empty;
import chess.domain.piece.Piece;
import chess.domain.position.Position;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum MovingType {
    MOVE((from, to) -> to instanceof Empty),
    ATTACK((from, to) -> !(to instanceof Empty));

    private final BiPredicate<Piece, Piece> movingTypeJudge;

    MovingType(BiPredicate<Piece, Piece> movingTypeJudge) {
        this.movingTypeJudge = movingTypeJudge;
    }

    public static MovingType of(Piece from, Piece to) {
        return Arrays.stream(MovingType.values())
                .filter(movingType -> movingType.movingTypeJudge.test(from, to))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("정의 되지 않은 움직임 입니다."));
    }

    public Moving getMoving(Position from, Position to) {
        if (MOVE.equals(this)) {
            return new Move(from, to);
        }
        if (ATTACK.equals(this)) {
            return new Attack(from, to);
        }
        throw new IllegalArgumentException("정의 되지 않은 움직임 입니다.");
    }
}
