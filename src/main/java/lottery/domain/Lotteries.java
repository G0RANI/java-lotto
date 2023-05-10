package lottery.domain;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.IntStream.range;
import static lottery.domain.Lottery.autoGeneratedLottery;
import static lottery.domain.constant.Rank.getRankByCountOfMatch;
import static lottery.domain.constant.Rank.isSecondOrThird;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lottery.domain.constant.Rank;

public class Lotteries {

    private static final int FIRST_WINNING_COUNT = 1;

    private final List<Lottery> values;

    public Lotteries(List<Lottery> values) {
        this.values = values;
    }

    public static Lotteries lotteriesByPlayNumbers(int plays) {
        List<Lottery> collect = range(0, plays)
                .mapToObj(play -> autoGeneratedLottery())
                .collect(Collectors.toList());
        return new Lotteries(collect);
    }

    public int size() {
        return this.values.size();
    }

    public List<Lottery> immutableGetLotteries() {
        return unmodifiableList(this.values);
    }

    public Map<Rank, Integer> statisticsByRank(WeeklyWinningNumbers weeklyWinningNumbers) {
        Map<Rank, Integer> statisticsByRank = new HashMap<>();
        for (Lottery lottery : this.values) {

            Rank rank = getRankByCountOfMatch(
                    lottery.intersectionSize(weeklyWinningNumbers.getNumbers()),
                    weeklyWinningNumbers.hasBonusNumber(lottery));

            statisticsByRank
                    .compute(rank, (key, value) -> (value == null) ?
                            FIRST_WINNING_COUNT : value + 1);
        }

        return statisticsByRank;
    }

    @Override
    public String toString() {
        return "Lotteries{" +
                "lotteries=" + values +
                '}';
    }


}