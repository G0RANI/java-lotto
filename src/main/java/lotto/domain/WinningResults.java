package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class WinningResults {

    public static final int DEFAULT_VALUE = 0;
    private final Map<LottoRank, Integer> values;

    public WinningResults(List<LottoRank> lottoRanks) {
        Map<LottoRank, Integer> treeMap = new TreeMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            treeMap.put(lottoRank, DEFAULT_VALUE);
        }
        this.values = treeMap;

        for (LottoRank lottoRank : lottoRanks) {
            values.put(lottoRank, createValue(lottoRank));
        }
    }

    public Map<LottoRank, Integer> getAll() {
        return this.values;
    }

    public int size() {
        return values.size();
    }

    private int createValue(LottoRank lottoRank) {
        return values.getOrDefault(lottoRank, DEFAULT_VALUE) + 1;
    }

    public RevenueRate revenue(BuyingAmount buyingAmount) {
        return new RevenueRate(prize(), buyingAmount);
    }

    private int prize() {
        int prizeTotal = 0;
        for (Map.Entry<LottoRank, Integer> winningResult : values.entrySet()) {
            LottoRank lottoRank = winningResult.getKey();
            prizeTotal += lottoRank.calculatePrize(winningResult.getValue());
        }

        return prizeTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningResults that = (WinningResults) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

}
