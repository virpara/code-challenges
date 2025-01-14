/* package codechef; // don't place package name! */
package com.codechef.jan19;

import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        s.next(); // skip the line

        for (int j = 0; j < i; j++) {
            String quote = s.nextLine();
            String[] words = quote.replaceAll("[\\-\\+\\.\\^;,]", "").split(" ");

            boolean isFancy = false;

            for (String word : words) {

                if (word.equals("not")) {
                    isFancy = true;
                    break;
                }
            }

            if (isFancy) System.out.println("Real Fancy");
            else System.out.println("regularly fancy");
        }
    }
}
