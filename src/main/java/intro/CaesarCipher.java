package intro;

import core.Crypto;

public class CaesarCipher implements Crypto {

    private final int key;

    public CaesarCipher(int key) {
        this.key = key;
    }

    @Override
    public String encode(String message) {
        char[] charArray = message.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            char ec = (char)(c + key);
            sb.append(ec);
        }
        return sb.toString();
    }

    @Override
    public String decode(String code) {
        char[] charArray = code.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            char dc = (char)(c - key);
            sb.append(dc);
        }
        return sb.toString();
    }
}
