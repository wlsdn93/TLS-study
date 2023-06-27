package chapter1.ex2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimitiveRootSearcher {

    /**
     * 원시근이란 1을 제외한 p이하의 모든 자연수 중, 그 거듭제곱을 p로 나눈 나머지가 p미만의 자연수로 고르게 나타나는 수를 의미한다.
     */
    public List<Integer> find(Integer number) {
        if (number == null) throw new IllegalArgumentException("Number must not be null");
        if (!isPrimeNumber(number)) throw new IllegalArgumentException("Number must be a prime number");
        List<Integer> primitiveRoots = new ArrayList<>();
        // 중복되는 나머지 값이 발생하면 연산을 종료한다.
        for (int i = 2; i < number; i++) {
            int r = 1;
            Set<Integer> set = new HashSet<>();
            while (true) {
                r *= i;
                boolean isNewValue = set.add(r % number);
                if (!isNewValue) break;
            }
            if (set.size() == number - 1) primitiveRoots.add(i);
        }
        return primitiveRoots;
    }

    /**
     * 소수 판별은 6k ± 1 최적화를 이용한다.
     */
    private Boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

}
