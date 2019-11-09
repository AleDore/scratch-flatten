package com.alessio;

import java.util.Arrays;

import com.alessio.flatten.ArrayFlatten;


/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Flatten an array of arbitrarily nested arrays of integers into a flat array of integers.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        Object[] array = { new Object[]{ 1, 2, new Object[]{ 3 }}, 4 };
        System.out.println("original: "+Arrays.deepToString(array));
        try {
            int[] result = ArrayFlatten.flatArray(array);
            System.out.println("result: "+Arrays.toString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
