package lotto.domain.strategy;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoStrategyTest {

    @Test
    void 숫자_6개가_생성된다() {
        RandomLottoNumberStrategy randomLottoNumberStrategy = new RandomLottoNumberStrategy() {
            @Override
            protected List<LottoNumber> createRandomNumbers() {
                return List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4),
                        LottoNumber.of(5), LottoNumber.of(6));
            }
        };

        List<LottoNumber> actual = randomLottoNumberStrategy.create();
        List<LottoNumber> expected = List.of(LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 생성된_숫자_6개가_정렬이_되어_생성된다() {
        RandomLottoNumberStrategy randomLottoNumberStrategy = new RandomLottoNumberStrategy() {
            @Override
            protected List<LottoNumber> createRandomNumbers() {
                return List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4),
                        LottoNumber.of(5), LottoNumber.of(6));
            }
        };

        List<LottoNumber> actual = randomLottoNumberStrategy.create();
        List<LottoNumber> expected = List.of(LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6));

        assertThat(actual).isEqualTo(expected);
    }
}
