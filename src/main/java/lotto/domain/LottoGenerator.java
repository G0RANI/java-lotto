package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_MINIMUM = 1;
    private static final int LOTTO_NUMBER_MAXIMUM = 45;
    private static final int LOTTO_TICKET_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoGenerator() {
        this.lottoNumbers = IntStream.rangeClosed(LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoTickets generate(int count) {
        return new LottoTickets(IntStream.range(0, count)
                .mapToObj(i -> generateLottoNumbers())
                .collect(Collectors.toList()));
    }

    private LottoTicket generateLottoNumbers() {
        Collections.shuffle(lottoNumbers, new Random(System.currentTimeMillis()));
        List<LottoNumber> randomLottoNumbers = new ArrayList<>(lottoNumbers.subList(0, LOTTO_TICKET_SIZE));
        return new LottoTicket(randomLottoNumbers);
    }
}