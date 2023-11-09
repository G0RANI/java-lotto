package lotto.domain;

import lotto.domain.strategy.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_AMOUNT = 1000;
    private List<LottoNumber> lottoNumbers;


    public LottoMachine(LottoNumberStrategy lottoNumberStrategy,
                        int amount) {
        validateLottoAmountUnits(amount);
        lottoNumbers = new ArrayList<>();
        for (int i = 0; i < amount / LOTTO_AMOUNT; i++) {
            List<Integer> numbers = lottoNumberStrategy.create();
            lottoNumbers.add(new LottoNumber(numbers));
        }
    }

    private void validateLottoAmountUnits(int amount) {
        if(isLottoAmountUnits(amount)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isLottoAmountUnits(int amount) {
        return amount % LOTTO_AMOUNT != 0;
    }

    public int lottoCount() {
        return this.lottoNumbers.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public WinningResults report(WinningLottoNumber winningLottoNumber) {
        return new WinningResults(winningLottoNumber, lottoNumbers);
    }
}
