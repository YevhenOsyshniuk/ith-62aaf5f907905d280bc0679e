package ua.ithillel.lesson23.homework;

public class Application {
    public static void main(String[] args) {
        int[] testArray = {6, 8, 1, 9, 7, 4, 2, 3, 5, 10};
        int[] source = {5, 6, 7, 8, 9, 10};
        int[] target = {1, 2, 3, 4};

        shakerSorting(testArray);
        System.out.println(" ");
        arrayCopy(source, target);
    }

    public static void shakerSorting(int[] testArray) {
        int tempNumber;
        int leftSort = 0;
        int rightSort = testArray.length - 1;

        do {
            for (int i = leftSort; i < rightSort; i++) {
                if (testArray[i] > testArray[i + 1]) {
                    tempNumber = testArray[i];
                    testArray[i] = testArray[i + 1];
                    testArray[i + 1] = tempNumber;
                }
            }
            rightSort--;
            for (int i = rightSort; i > leftSort; i--) {
                if (testArray[i] < testArray[i - 1]) {
                    tempNumber = testArray[i];
                    testArray[i] = testArray[i - 1];
                    testArray[i - 1] = tempNumber;
                }
            }
            leftSort++;
        }
        while (leftSort < rightSort);
        for (int i : testArray) {
            System.out.print(testArray[i - 1] + " ");
        }
    }

    public static void arrayCopy(int[] source, int[] target) {
        int[] c = new int[target.length + source.length];
        int count = 0;
        for (int i = 0; i < target.length; i++) {
            c[i] = target[i];
            count++;
        }
        for (int j = 0; j < source.length; j++) {
            c[count++] = source[j];
        }
        for (int i = 0; i < c.length; i++)
            System.out.print(c[i] + " ");
    }
}
