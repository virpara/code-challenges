package com.misc;

import java.math.BigInteger;

public class BigFactorial {

  public static void main(String[] args) {
    //System.out.println(fib(new BigInteger("9545316546546521546487897984653213215465498798798798787984513213132132154645498798798798798798794654984121984512164513216548654321321646545646545132154654877987987878978454984845461321654984546513215465489784545613165484985454546546545465413132165456465465465465456456465449878979879879879879879879879879879879877987")));
    System.out.println(fib(new BigInteger("5")));
  }
  
  static BigInteger fact(BigInteger i) {
    if (i.equals(BigInteger.valueOf(1)))
      return BigInteger.valueOf(1);
    else
      return i.multiply(i.subtract(BigInteger.valueOf(1)));
  }
  
  static BigInteger fib(BigInteger i) {
    if (i.equals(Integer.valueOf(1)) || i.equals(Integer.valueOf(2))) {
      return BigInteger.valueOf(1);
    } else {
      return fib(i.subtract(BigInteger.valueOf(1))).add(fib(i.subtract(BigInteger.valueOf(1))));
    }
  }
}
