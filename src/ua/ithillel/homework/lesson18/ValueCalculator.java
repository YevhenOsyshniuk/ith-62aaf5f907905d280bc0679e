package ua.ithillel.homework.lesson18;

public class ValueCalculator {
    private static final int SIZE_OF_ARRAY = 2000000;
    private static final int HALF_SIZE_OF_ARRAY = SIZE_OF_ARRAY / 2;
    private float[] testArray = new float[SIZE_OF_ARRAY];

    public ValueCalculator() {
    }

      public synchronized void doCalc() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            testArray[i] = 2;
        }

        float arrayLength = testArray.length;
        float[] partOfArray1 = new float[(int) ((arrayLength + 1) / 2)];
        float[] partOfArray2 = new float[(int) (arrayLength - partOfArray1.length)];
        System.arraycopy(testArray, 0, partOfArray1, 0, partOfArray1.length);
        System.arraycopy(testArray, partOfArray1.length, partOfArray2, 0, partOfArray2.length);

        var thread1 = new Thread(String.valueOf(testArray));
        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            testArray[i] = (float) (testArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        var thread2 = new Thread(String.valueOf(testArray));
        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            testArray[i] = (float) (testArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
}
