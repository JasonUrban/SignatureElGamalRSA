import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class ElGamal {
    private BigInteger[] arr = new BigInteger[3];

    private BigInteger[] xgcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            arr[2] = BigInteger.ZERO;
            arr[1] = BigInteger.ONE;
            arr[0] = a;
            return arr;
        }
        arr = xgcd(b, a.mod(b));
        BigInteger j = arr[2];
        BigInteger i = arr[1];
        arr[1] = j;
        arr[2] = i.subtract(j.multiply(a.divide(b)));
        return arr;
    }

    private boolean isPrime(long n) {
        if (n == 1)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private BigInteger mod_inverse(BigInteger a, BigInteger b) {
        BigInteger[] tmp = xgcd(a, b);
        if (!tmp[0].equals(BigInteger.ONE))
            throw new ArithmeticException("Mod Inverse is not possible!");
        if (tmp[1].compareTo(BigInteger.ZERO) > 0)
            return tmp[1];
        else return tmp[1].add(b);
    }

    private boolean notRelativelyPrime(BigInteger a, BigInteger b) {
        return !a.gcd(b).equals(BigInteger.ONE);
    }

    String byteArrayToHexString(byte[] b) {
        StringBuilder result = new StringBuilder();
        for (byte aB : b) {
            result.append(Integer.toString((aB & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString().toUpperCase();
    }

    BigInteger[] getParameters(char choice) {
        int pInt, gInt, xInt;
        if (choice == '1') {
            while (true) {
                System.out.println("Input parameters p, g, secret key x:");
                Scanner scanner = new Scanner(System.in);
                try {
                    pInt = scanner.nextInt();
                    gInt = scanner.nextInt();
                    xInt = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Incorrect input!");
                    continue;
                }
                if (pInt > 1000000) {
                    System.out.println("p is very big! Try value less than 1M!");
                    continue;
                }
                if (gInt <= 0) {
                    System.out.println("g must be positive!");
                    continue;
                }
                if (xInt <= 1 || xInt >= pInt - 2) {
                    System.out.println("x must be more than 1 and less than p - 1!");
                    continue;
                }
                if (gInt >= pInt) {
                    System.out.println("g must be less than p!");
                    continue;
                }
                if (isPrime(pInt) && isPrime(gInt)) {
                    int temp = new BigInteger(Integer.toString(gInt)).modPow(new BigInteger(Integer.toString(pInt - 1)), new BigInteger(Integer.toString(pInt))).intValue();
                    if (temp != 1 % pInt) {
                        System.out.println("Wrong parameter g! It must be primitive root modulo p!");
                        continue;
                    }
                    break;
                } else {
                    System.out.println("p, (p - 1) / 2 and g must be prime numbers!");
                }
            }
        } else {
            int temp;
            do {
                pInt = ThreadLocalRandom.current().nextInt(2, 1000000 + 1);
                gInt = ThreadLocalRandom.current().nextInt(2, (pInt - 1) + 1);
                xInt = ThreadLocalRandom.current().nextInt(2, (pInt - 2) + 1);
                temp = new BigInteger(Integer.toString(gInt)).modPow(new BigInteger(Integer.toString(pInt - 1)), new BigInteger(Integer.toString(pInt))).intValue();
            } while (!isPrime(pInt) || !isPrime(gInt) || !isPrime((pInt - 1) / 2) || temp != 1 % pInt);
        }
        BigInteger p = new BigInteger(Integer.toString(pInt)), g = new BigInteger(Integer.toString(gInt)), x = new BigInteger(Integer.toString(xInt));
        return new BigInteger[]{p, g, x};
    }

    BigInteger[] sign(BigInteger p, BigInteger g, BigInteger x, char choice, String hash) {
        BigInteger y = g.modPow(x, p);
        BigInteger pMin1 = p.subtract(BigInteger.ONE);
        int kInt;
        BigInteger k = BigInteger.ZERO, r = BigInteger.ZERO, s = BigInteger.ZERO;
        boolean isCorrect_s = false;
        while (!isCorrect_s) {
            while (true) {
                if (choice != '1') {
                    kInt = ThreadLocalRandom.current().nextInt(2, (pMin1.intValue() - 1) + 1);
                    k = new BigInteger(Integer.toString(kInt));
                    if (notRelativelyPrime(k, pMin1)) {
                        continue;
                    }
                    break;
                } else {
                    System.out.println("Input signature key k:");
                    try {
                        Scanner scanner = new Scanner(System.in);
                        kInt = scanner.nextInt();
                        k = new BigInteger(Integer.toString(kInt));
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect input!");
                        continue;
                    }
                    if (kInt <= 1 || kInt >= pMin1.intValue()) {
                        System.out.println("k must be more than 1 and less than p - 1!");
                        continue;
                    }
                    if (notRelativelyPrime(k, pMin1)) {
                        System.out.println("k and p - 1 must be relatively prime!");
                        continue;
                    }
                    break;
                }
            }
            r = g.modPow(k, p);
            BigInteger xr = x.multiply(r);
            s = new BigInteger(hash, 16).subtract(xr);
            isCorrect_s = true;
            try {
                s = s.multiply(mod_inverse(k, pMin1));
                s = s.mod(pMin1);
            } catch (ArithmeticException e) {
                if (choice == '1') {
                    System.out.println(e.getMessage());
                }
                isCorrect_s = false;
            }
            if (s.equals(BigInteger.ZERO)) {
                if (choice == '1') {
                    System.out.println("s doesn't exist!");
                }
                isCorrect_s = false;
            }
        }
        return new BigInteger[]{y, k, r, s};
    }
}
