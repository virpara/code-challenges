package com.codechef;

import java.math.BigInteger;

public class LargeModuloMult {
  // TODO
  public static void main(String[] args) {
    int base = 3;
    int exp = 10;
    long mod = (long) 10e9 + 7;
    
    long start = System.currentTimeMillis();
    BigInteger b = badMult2(base, 1000, mod);
    b = badMult2(base, 5000, mod);
    b = badMult2(base, 2000, mod);
    b = badMult2(base, 10000, mod);
    b = badMult2(base, 5001, mod);
    b = badMult2(base, 8000, mod);
    b = badMult2(base, 9000, mod);
    long end = System.currentTimeMillis();
    System.out.println(end - start);
    System.out.println(goodMult(base, exp, mod));
    
  }
  
  static double badMult(int base, int exp, long mod) {
    double mult = 1;
    for (int i = 0; i < exp; i++) {
      mult = mult * (base % mod);
    }
    
    return mult;
  }
  
  static BigInteger badMult2(int base, int exp, long mod) {
    BigInteger mult = BigInteger.valueOf(1);
    for (int i = 0; i < exp; i++) {
      mult = mult.multiply(BigInteger.valueOf(base % mod));
    }
    
    return mult;
  }
  
  static BigInteger goodMult(int base, int exp, long mod) {
    BigInteger mult = BigInteger.valueOf(1);
    
    while (exp > 0) {
      if (exp == 1) {
        mult = mult.multiply(BigInteger.valueOf(base % mod));
      } else {
        mult = mult.multiply(BigInteger.valueOf((base * base) % mod));
      }
      
      exp -= 2;
    }
    
    return mult;
  }
}
