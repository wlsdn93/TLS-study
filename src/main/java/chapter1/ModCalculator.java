package chapter1;

public class ModCalculator {

    public int powm(int base, int exp, int mod) {
        int r = 1;
        for (int i = 0; i < exp; i++) {
            r *= base;
            r %= mod;
        }
        return r;
    }

}
