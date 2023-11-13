package lotto.domain;

public class BuyingAmount {
    private static final int LOTTO_AMOUNT = 1000;
    private final int amount;

    public BuyingAmount(int amount) {
        validateLottoAmountUnits(amount);
        this.amount = amount;
    }

    private void validateLottoAmountUnits(int amount) {
        if (isLottoAmountUnits(amount)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isLottoAmountUnits(int amount) {
        return amount % LOTTO_AMOUNT != 0;
    }

    public int autoBuyingCount(ManualCount manualCount) {
        return manualCount.difference(amount / LOTTO_AMOUNT);
    }

    public double divide(int basic) {
        return (double) basic / this.amount;
    }

    public boolean isMoreThenAmount(int count) {
        return units() < count;
    }

    private int units() {
        return amount / LOTTO_AMOUNT;
    }
}
