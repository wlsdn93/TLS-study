package key_exchange;

import core.MathUtils;

import java.math.BigInteger;
import java.util.Random;

public class DiffieHellman {

    private BigInteger modular;
    private BigInteger generator;
    private BigInteger secretKey;
    private BigInteger peerPublicKey;
    private BigInteger symmetricKey;
    private final Integer SECRET_KEY_SIZE = 1024;
    private final Integer PRIME_NUMBER_SIZE = 1024;

    public DiffieHellman(BigInteger modular, BigInteger generator) {
        this.modular = modular;
        this.generator = generator;
    }

    public DiffieHellman() {
    }

    public void init() {
        init(false);
    }

    public void init(Boolean isStater) {
        if (isStater) {
            modular = MathUtils.generatePrimeNumber(PRIME_NUMBER_SIZE);
            generator = MathUtils.getRandomPrimitiveRoot(modular);
        }
        secretKey = new BigInteger(SECRET_KEY_SIZE, new Random());
    }

    public BigInteger getModular() {
        return modular;
    }

    public BigInteger getGenerator() {
        return generator;
    }

    public BigInteger getPublicKey() {
        return generator.modPow(secretKey, modular);
    }

    public void setPeerPublicKey(BigInteger peerPublicKey) {
        this.peerPublicKey = peerPublicKey;
        this.setSymmetricKey();
    }

    private void setSymmetricKey() {
        this.symmetricKey = this.peerPublicKey.modPow(secretKey, modular);
    }

    public BigInteger getSymmetricKey() {
        return symmetricKey;
    }
}
