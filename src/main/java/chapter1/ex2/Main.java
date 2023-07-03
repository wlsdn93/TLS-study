package chapter1.ex2;

import core.DiffieHellman;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        DiffieHellman alice = new DiffieHellman();
        alice.init(true);
        BigInteger primeNumber = alice.getPrimeNumber();
        BigInteger generator = alice.getGenerator();
        BigInteger alicePublicKey = alice.getPublicKey();

        DiffieHellman bob = new DiffieHellman(primeNumber, generator);
        bob.init();
        BigInteger bobPublicKey = bob.getPublicKey();

        alice.setPeerPublicKey(bobPublicKey);
        bob.setPeerPublicKey(alicePublicKey);

        boolean equalSymmetricKey = alice.getSymmetricKey().equals(bob.getSymmetricKey());
        System.out.println("generated SymmetricKey is equal ? : " + equalSymmetricKey);
        System.out.println("generated SymmetricKey : " + alice.getSymmetricKey());
    }
}
