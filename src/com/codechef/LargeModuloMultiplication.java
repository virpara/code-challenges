package com.codechef;

public class LargeModuloMultiplication {

    public static void main(String[] args) {
        int base = 4;
        int exp = 11;
        long mod = (long) 10e9 + 7;
        System.out.println("badMod:" + badMod(base, exp, mod));
        System.out.println("goodMod:" + goodMod(base, exp, mod));
        System.out.println("betterMod:" + betterMod(base, exp, mod));
        System.out.println("betterModRecursive:" + betterModRecursive(base, exp, mod));

    }

    private static long badMod(int base, int exp, long mod) {
        long largeMod = 1L;
        for (int i = 0; i < exp; i++) {
            largeMod = largeMod * (base % mod);
        }

        return largeMod;
    }
    // this approach still requires approximately exp/2 iterations
    private static long goodMod(int base, int exp, long mod) {
        long largeMod = 1L;

        while (exp > 0) {
            if (exp == 1) {
                largeMod = largeMod * (base % mod);
            } else {
                largeMod = largeMod * ((base * base) % mod);
            }

            exp -= 2;
        }

        return largeMod;
    }

    // half the exponent to decrease the iteration and square the base
    // O(long n)
    private static long betterMod(long base, int exp, long mod) {
        long largeMod = 1L;

        while (exp > 0) {
//            System.out.println("exp=" + exp + ", base=" + base);
            if (exp % 2 == 1) {
                largeMod = (largeMod * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return largeMod;
    }

    // recursive version of betterMod()
    private static long betterModRecursive(long base, int exp, long mod) {
//        System.out.println("exp=" + exp);
        if (exp == 1) {
            return base;
        } else {
            if (exp % 2 == 1) {
                return (long) ( base * Math.pow( betterModRecursive( base, (exp - 1)/2, mod ), 2 ) ) % mod ;
            } else {
                return (long) Math.pow(betterModRecursive(base, exp/2, mod), 2);
            }
        }
    }
}
