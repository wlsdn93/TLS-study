package core;

import util.MathUtils;

import java.math.BigInteger;
import java.util.Random;

public class DiffieHellman {

    private BigInteger primeNumber;
    private BigInteger generator;
    private BigInteger publicKey;
    private BigInteger peerPublicKey;
    private BigInteger symmetricKey;
    private final Integer PUBLIC_KEY_SIZE = 8;
    private final Integer PRIME_NUMBER_SIZE = 12;

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
        publicKey = new BigInteger(PUBLIC_KEY_SIZE, new Random());
    }

    public BigInteger getPrimeNumber() {
        return primeNumber;
    }

    public BigInteger getGenerator() {
        return generator;
    }

    public BigInteger getPublicKey() {
        return generator.modPow(publicKey, primeNumber);
    }

    public void setPeerPublicKey(BigInteger peerPublicKey) {
        this.peerPublicKey = peerPublicKey;
        this.setSymmetricKey();
    }

    private void setSymmetricKey() {
        this.symmetricKey = this.peerPublicKey.modPow(publicKey, primeNumber);
    }

    public BigInteger getSymmetricKey() {
        return symmetricKey;
    }
}
