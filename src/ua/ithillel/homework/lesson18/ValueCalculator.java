package ua.ithillel.homework.lesson18;

import java.util.Arrays;

public class ValueCalculator {
    private static final int VALUES_FOR_CALCULATION = 2000000;
    private static final int HALF_SIZE_OF_VALUE_FOR_CALCULATION = VALUES_FOR_CALCULATION / 2;
    private float[] testArrayToThreads = new float[VALUES_FOR_CALCULATION];

    public void doCalc() {
        long start = System.currentTimeMillis();
        Arrays.fill(testArrayToThreads, 2);

        float arrayLength = testArrayToThreads.length;
        float[] partOfArray1 = new float[(int) ((arrayLength + 1) / 2)];
        float[] partOfArray2 = new float[(int) (arrayLength - partOfArray1.length)];
        System.arraycopy(testArrayToThreads, 0, partOfArray1, 0, partOfArray1.length);
        System.arraycopy(testArrayToThreads, partOfArray1.length, partOfArray2, 0, partOfArray2.length);

        var thread1 = new Thread(doArrayChange(testArrayToThreads));
        var thread2 = new Thread(doArrayChange(testArrayToThreads));

        thread1.start();
        thread2.start();

        try {
             thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException("Something going wrong in running threads in ValueCalculator class");
        }

        joinArrays(partOfArray1, partOfArray2);

        System.out.println("Время выполнения метода: " + (System.currentTimeMillis() - start) + " милисекунд");
    }

    private static float[] joinArrays(float[] partOfArray1, float[] partOfArray2) {
        float[] joinedArray = new float[partOfArray1.length + partOfArray2.length];

        System.arraycopy(partOfArray1, 0, joinedArray, 0, partOfArray1.length);
        System.arraycopy(partOfArray2, 0, joinedArray, partOfArray1.length, partOfArray2.length);

        return joinedArray;
    }

    static synchronized Runnable doArrayChange(float[] testArray) {
        return () -> {
            for (int i = 0; i < VALUES_FOR_CALCULATION; i++) {
                testArray[i] = (float) (testArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        };
    }
}
