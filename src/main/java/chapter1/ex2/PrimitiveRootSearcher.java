package chapter1.ex2;

import util.MathUtils;

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
        if (!MathUtils.isPrime(number)) throw new IllegalArgumentException("Number must be a prime number");
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

}
