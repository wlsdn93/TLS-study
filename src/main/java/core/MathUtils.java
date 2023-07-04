package core;

import java.math.BigInteger;
import java.util.*;

public class MathUtils {

    public static BigInteger generatePrimeNumber(int size) {
        Random random = new Random();
        BigInteger prime = new BigInteger(size, random);
        while(!isPrime(prime)) {
            prime = new BigInteger(size, random);
        }
        return prime;
    }

    public static boolean isPrime(Integer n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 충분히 큰 숫자에 대해서는 밀러-라빈 소수 판별법을 사용한다.
     */
    public static boolean isPrime(BigInteger n) {
        int iteration = 25;
        if (n.equals(BigInteger.TWO)) {
            return true;
        }

        if (n.compareTo(BigInteger.TWO) < 0 || n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            return false;
        }

        BigInteger d = n.subtract(BigInteger.ONE);
        int r = 0;
        while (d.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            d = d.divide(BigInteger.TWO);
            r++;
        }

        Random random = new Random();
        for (int i = 0; i < iteration; i++) {
            BigInteger a = getRandomBase(n, random);

            BigInteger x = a.modPow(d, n);
            if (x.equals(BigInteger.ONE) || x.equals(n.subtract(BigInteger.ONE))) {
                continue;
            }

            boolean isProbablePrime = false;
            for (int j = 0; j < r - 1; j++) {
                x = x.modPow(BigInteger.TWO, n);
                if (x.equals(BigInteger.ONE)) {
                    return false;
                }
                if (x.equals(n.subtract(BigInteger.ONE))) {
                    isProbablePrime = true;
                    break;
                }
            }

            if (!isProbablePrime) {
                return false;
            }
        }

        return true;
    }

    private static BigInteger getRandomBase(BigInteger n, Random random) {
        BigInteger a;
        do {
            a = new BigInteger(n.bitLength(), random);
        } while (a.compareTo(BigInteger.TWO) < 0 || a.compareTo(n.subtract(BigInteger.TWO)) > 0);
        return a;
    }

    public static BigInteger gcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return a;
        }
        return gcd(b, a.mod(b));
    }

    public static BigInteger lcm(BigInteger a, BigInteger b) {
        BigInteger gcd = gcd(a, b);
        return a.multiply(b).divide(gcd);
    }

    public static BigInteger getRandomPrimitiveRoot(BigInteger number) {
        int bitLength = number.bitLength() - 1;
        boolean isPrimitive = false;
        BigInteger candidate = null;
        Random random = new Random();
        while(!isPrimitive) {
            candidate = new BigInteger(bitLength, random);
            isPrimitive = isPrimitiveRoot(number, candidate);
        }
        return candidate;
    }

    private static Boolean isPrimitiveRoot(BigInteger number, BigInteger candidate) {
        return candidate.modPow(number.subtract(BigInteger.ONE), number).equals(BigInteger.ONE);
    }
}

