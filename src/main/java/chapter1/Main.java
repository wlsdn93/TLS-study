package chapter1;

public class Main {
    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher(3);
        // ASCII table을 열심히 보면서, 예상되는 문자열을 만들어보자
        String message = "Hello World!";
        String expect = "Khoor#Zruog$";

        String encode = caesarCipher.encode(message);
        boolean encodedAsExpected = encode.equals(expect);
        System.out.println("encodedAsExpected = " + encodedAsExpected);

        String decode = caesarCipher.decode(encode);
        boolean decodedAsOrigin = decode.equals(message);
        System.out.println("decodedAsOrigin = " + decodedAsOrigin);
    }
}
