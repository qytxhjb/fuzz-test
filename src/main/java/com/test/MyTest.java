package com.test;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;

class MyTest {
    @FuzzTest
    void myFuzzTest(FuzzedDataProvider data) {
        // Call the functions you want to test with the provided data and optionally
        // assert that the results are as expected.

        // If you want to know more about writing fuzz tests you can check out the
        // example projects at https://github.com/CodeIntelligenceTesting/cifuzz/tree/main/examples
        // or have a look at our docs at https://docs.code-intelligence.com/
        int a = data.consumeInt();
        int b = data.consumeInt();
        String c = data.consumeRemainingAsString();

        ExploreMe.exploreMe(a, b, c);
    }
}


class ExploreMe {
    public static void exploreMe(int a, int b, String c) {
        if (a >= 20000) {
            if (b >= 2000000) {
                if (b - a < 100000) {
                    // Create reflective call
                    if (c.startsWith("@")) {
                        String className = c.substring(1);
                        try {
                            Class.forName(className);
                        } catch (ClassNotFoundException ignored) {
                        }
                    }
                }
            }
        }
    }
}