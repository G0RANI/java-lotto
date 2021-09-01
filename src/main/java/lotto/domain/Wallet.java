package lotto.domain;

import static lotto.util.RandomNumbersGenerator.generateNumbers;

public class Wallet {

    private final Money money;

    private final Lottos lottos;

    public Wallet(Money money) {
        this.money = money;
        lottos = new Lottos();
    }

    public Wallet(Money money, Lottos lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public Money money() {
        return money;
    }

    public Lottos lottos() {
        return lottos;
    }

    public int lottosCount() {
        return lottos.size();
    }

    public Wallet purchaseLotto() {
        int lottoCount = money.calculatePurchaseCount();
        Money useMoney = money.useMoney(lottoCount);

        Lottos purchaseLottos = new Lottos();
        addNewLotto(lottoCount, purchaseLottos);
        return new Wallet(useMoney, purchaseLottos);
    }

    private void addNewLotto(int lottoCount, Lottos purchaseLottos) {
        for (int i = 0; i < lottoCount; i++) {
            purchaseLottos.add(new Lotto(generateNumbers()));
        }
    }

}