package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputViewTest {

	@Test
	public void test(){
		List<Integer> list = new ArrayList<>();
		if(list.isEmpty()){
			System.out.println("비어있음");
			System.out.println(list.size());
		}

	}
	@Test
	public void 지난주_당첨번호가_잘입력되었는가_테스트() {
		InputView inputView = new InputView();
		assertThat(inputView.convertStringToInteger("1, 2, 3, 4, 5, 6").getLottoNumbers().size()).isEqualTo(6);
		assertThat(inputView.convertStringToInteger("1 , 2 , 3 , 4, 5, 6").getLottoNumbers().size()).isEqualTo(6);
		assertThatIllegalArgumentException().isThrownBy(() -> {
			inputView.convertStringToInteger("1, 2, 3, 4, 5, 6, 7");
		});
		assertThatIllegalArgumentException().isThrownBy(() -> {
			inputView.convertStringToInteger("1, 1, 1, 1, 5");
		});

		assertThatIllegalArgumentException().isThrownBy(() -> {
			inputView.convertStringToInteger("A, 2, 3, 4, 5, 6, 7");
		});
	}
}