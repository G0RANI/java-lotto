package lotto.domain.strategy;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoStrategyTest {

    @Test
    void 숫자_6개가_생성된다() {
        ManualLottoNumberStrategy manualLottoNumberStrategy = new ManualLottoNumberStrategy("1, 2, 3, 4, 5, 6");

        List<LottoNumber> actual = manualLottoNumberStrategy.create();
        List<LottoNumber> expected = List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 생성된_숫자_6개가_정렬이_되어_생성된다() {
        ManualLottoNumberStrategy manualLottoNumberStrategy = new ManualLottoNumberStrategy("6, 2, 3, 4, 5, 1");

        List<LottoNumber> actual = manualLottoNumberStrategy.create();
        List<LottoNumber> expected = List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));

        assertThat(actual).isEqualTo(expected);
    }
}
