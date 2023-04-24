package calculator;

import calculator.domain.Number;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {

    @Test
    void Number_생성() {
        int num = new Number("1").intValue();
        assertThat(num).isEqualTo(1);
    }

    @Test
    void 숫자가_아닌경우_예외처리() {
        assertThatThrownBy(() -> new Number("/"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("숫자가 아닙니다.");
    }

    @Test
    void null_예외처리() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Number(null))
                .withMessageContaining("입력값이 없습니다.");
    }

    @Test
    void 공백_예외처리() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Number(""))
                .withMessageContaining("입력값이 없습니다.");
    }

}