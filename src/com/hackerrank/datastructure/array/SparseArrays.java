package com.hackerrank.datastructure.array;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/sparse-arrays/problem
public class SparseArrays {

    private static Map<String, Integer> stringMatchCount = new HashMap<>();

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        Stream.of(strings).forEach(SparseArrays::increaseCount);

        List<Integer> integerList = Stream.of(queries)
                .map(query -> stringMatchCount.getOrDefault(query, 0))
                .collect(Collectors.toList());

        return integerList.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void increaseCount(String str) {
        if (stringMatchCount.containsKey(str)) {
            stringMatchCount.put(str, stringMatchCount.get(str) + 1);
        } else {
            stringMatchCount.put(str, 1);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
