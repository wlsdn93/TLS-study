package chapter1;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ModCalculator modCalculator = new ModCalculator();
        int base = 3;
        int exp = 100;
        int mod = 23;
        LocalDateTime start = LocalDateTime.now();
        int remain = modCalculator.powm(base, exp, mod);
        LocalDateTime end = LocalDateTime.now();
        Duration between = Duration.between(start, end);
        int nanoSec = between.getNano();
        System.out.println("nanoSec = " + nanoSec);
        System.out.printf("%d^%d mod %d = %d%n", base, exp, mod, remain);

    }
}
