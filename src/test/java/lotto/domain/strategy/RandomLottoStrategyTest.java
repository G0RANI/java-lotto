package lotto.domain.strategy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoStrategyTest {

    @Test
    void 숫자_6개가_생성된다() {
        RandomLottoNumberStrategy randomLottoNumberStrategy = new RandomLottoNumberStrategy() {
            @Override
            protected List<Integer> createRandomNumbers() {
                return List.of(1, 2, 3, 4, 5, 6);
            }
        };

        List<Integer> actual = randomLottoNumberStrategy.create();
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 생성된_숫자_6개가_정렬이_되어_생성된다() {
        RandomLottoNumberStrategy randomLottoNumberStrategy = new RandomLottoNumberStrategy() {
            @Override
            protected List<Integer> createRandomNumbers() {
                return List.of(4, 1, 3, 2, 5, 6);
            }
        };

        List<Integer> actual = randomLottoNumberStrategy.create();
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        assertThat(actual).isEqualTo(expected);
    }
}
