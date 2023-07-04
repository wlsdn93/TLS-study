package key_exchange;

import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        DiffieHellman alice = new DiffieHellman();
        alice.init(true);
        BigInteger modular = alice.getModular();
        BigInteger generator = alice.getGenerator();
        BigInteger alicePublicKey = alice.getPublicKey();

        DiffieHellman bob = new DiffieHellman(modular, generator);
        bob.init();
        BigInteger bobPublicKey = bob.getPublicKey();

        alice.setPeerPublicKey(bobPublicKey);
        bob.setPeerPublicKey(alicePublicKey);

        boolean equalSymmetricKey = alice.getSymmetricKey().equals(bob.getSymmetricKey());
        System.out.println("generated SymmetricKey is equal ? : " + equalSymmetricKey);
        System.out.println("generated SymmetricKey : " + alice.getSymmetricKey());
        LocalDateTime end = LocalDateTime.now();
        Duration between = Duration.between(start, end);
        System.out.println("nanoSec : " + between.getNano());
    }
}
