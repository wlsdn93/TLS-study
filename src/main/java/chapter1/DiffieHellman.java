package chapter1;

import util.MathUtils;

import java.math.BigInteger;
import java.util.Random;

public class DiffieHellman {

    private BigInteger primeNumber;
    private BigInteger generator;
    private BigInteger secretKey;
    private BigInteger peerPublicKey;
    private BigInteger symmetricKey;
    private final Integer SECRET_KEY_SIZE = 1024;
    private final Integer PRIME_NUMBER_SIZE = 1024;

    public DiffieHellman(BigInteger primeNumber, BigInteger generator) {
        this.primeNumber = primeNumber;
        this.generator = generator;
    }

    public DiffieHellman() {
    }

    public void init() {
        init(false);
    }

    public void init(Boolean isStater) {
        if (isStater) {
            primeNumber = MathUtils.generatePrimeNumber(PRIME_NUMBER_SIZE);
            generator = MathUtils.getRandomPrimitiveRoot(primeNumber);
        }
        secretKey = new BigInteger(SECRET_KEY_SIZE, new Random());
    }

    public BigInteger getPrimeNumber() {
        return primeNumber;
    }

    public BigInteger getGenerator() {
        return generator;
    }

    public BigInteger getPublicKey() {
        return generator.modPow(secretKey, primeNumber);
    }

    public void setPeerPublicKey(BigInteger peerPublicKey) {
        this.peerPublicKey = peerPublicKey;
        this.setSymmetricKey();
    }

    private void setSymmetricKey() {
        this.symmetricKey = this.peerPublicKey.modPow(secretKey, primeNumber);
    }

    public BigInteger getSymmetricKey() {
        return symmetricKey;
    }
}
