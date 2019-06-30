package javatests;

public class PrimaryTypeTest {

    public static void main(String[] args) {
        char x = '\u0000';  // it is unsigned 16 bit int
        while (x < Character.MAX_VALUE) {
            System.out.println(x + " " + (int) x);
            x++;
        }

        char a = '\127';    // octal literal
        char b = '\uAB0C';  // hexadecimal literal
        char c = 'A';       // character literal

        char d = 01111 ;    // octal integer literal
        char e = 65;        // integer literal
        char f = 0x1234;    // hexadecimal integer literal

        int g = 'A';        // g = 65

        String h = "A\012\uAF34"; // string with octal and hexadecimal literals
    }
}
