package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
	public static final String USER_INPUT_SEPARATOR = ",";

	public static LottoNumbers manual(List<Integer> manualNumbers) {
		return generateLottoNumbers(manualNumbers);
	}

	public static LottoNumbers auto() {
		List<Integer> autoNumber = new ArrayList<>();
		IntStream.range(0, LottoNumber.MAX_LOTTO_NUMBER).forEach(index -> autoNumber.add(index + 1));
		Collections.shuffle(autoNumber);
		ArrayList<Integer> shuffledAutoNumbers = new ArrayList<>(autoNumber.subList(0, LottoNumbers.MAX_LOTTO_NUMBERS_SIZE));

		return generateLottoNumbers(shuffledAutoNumbers);
	}

	public static LottoNumbers ofInput(String input) {
		List<Integer> userInputNumber = Arrays.stream(input.split(USER_INPUT_SEPARATOR))
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		return LottoNumberGenerator.manual(userInputNumber);
	}

	private static LottoNumbers generateLottoNumbers(List<Integer> targetNumbers) {
		return targetNumbers.stream()
			.map(LottoNumber::new)
			.sorted(LottoNumber::isGraterThanNumber)
			.collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumbers::new));
	}
}
