import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ElGamal crypto = new ElGamal();
        String input = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String hash = crypto.byteArrayToHexString(Objects.requireNonNull(md).digest(input.getBytes()));
        System.out.println(hash);
        System.out.println("Generate random parameters or input them? 1 - input, else - random.");
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.nextLine().charAt(0);
        BigInteger[] vals = crypto.getParameters(choice);
        BigInteger p = vals[0], g = vals[1], x = vals[2];
        System.out.println("p  =  " + p.toString(10));
        System.out.println("g  =  " + g.toString(10));
        System.out.println("x  =  " + x.toString(10));
        vals = crypto.sign(p, g, x, choice, hash);
        BigInteger y = vals[0], k = vals[1], r = vals[2], s = vals[3];
        System.out.println("y  =  " + y.toString(10));
        System.out.println("k  =  " + k.toString(10));
        System.out.println("r  =  " + r.toString(10));
        System.out.println("s  =  " + s.toString(10));
    }
}
