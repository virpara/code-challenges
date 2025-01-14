package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TakeInputBufferedReader {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        TakeInputBufferedReader in = new TakeInputBufferedReader();

        Integer[] ints = in.getInts();

    }

    public String[] getTokens() throws IOException {
        return in.readLine().split(" ");
    }

    public Integer[] getInts() throws IOException {
        String[] tokens = getTokens();

        Integer[] ints = new Integer[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            ints[i] = Integer.parseInt(tokens[i]);
        }

        return ints;
    }

    public String getLine() throws IOException {
        return in.readLine();
    }

    public Integer getInt() throws IOException {
        return Integer.parseInt(getLine());
    }
}
