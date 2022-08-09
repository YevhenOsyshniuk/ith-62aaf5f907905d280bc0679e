package ua.ithillel.lesson4.homework;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        compareNumbersBoolean(5, 8);
        definitionOfNumber(9);
        aBooleanInt(6);
        aStringPrinting("Hello N times ", 5);
        leapYear(350);

    }

    //2. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.
    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
        // Вариант №2
        // System.out.println("Orange\nBanana\nApple");
    }

    //3. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b,
    // и инициализируйте их любыми значениями, которыми захотите. Далее метод должен просуммировать эти переменные,
    // и если их сумма больше или равна 0, то вывести в консоль сообщение “Сумма положительная”,
    // в противном случае - “Сумма отрицательная”;
    static void checkSumSign() {
        int a = 10;
        int b = -1;
        int c = a + b;

        if (c >= 0) {
            System.out.println("Sum is positive");
        } else {
            System.out.println("Sum is negative");
        }
    }

    // 4. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
    // Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”, если лежит в пределах от 0
    // (0 исключительно) до 100 (100 включительно), то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;

    static void printColor() {
        int value = 5;
        if (value <= 0) {
            System.out.println("Red");
        } else if (value > 0 && value <= 100) {
            System.out.println("Yellow");
        } else {
            System.out.println("Green");
        }
    }

    // 5. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
    // и инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b,
    // то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
    static void compareNumbers() {
        int a = 11;
        int b = 12;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //6. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах
    // от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    static boolean compareNumbersBoolean(int val1, int val2) {
        int val3 = val1 + val2;
        if (val3 >= 10 && val3 <= 20) {
            return true;
        } else {
            return false;
        }
    }

    //7.Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    // положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    static void definitionOfNumber(int def) {
        if (def >= 0) {
            System.out.println("The number is positive");
        } else {
            System.out.println("The number is negative");
        }
    }

    //8. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    // если число отрицательное, и вернуть false если положительное.
    static boolean aBooleanInt(int var3) {
        if (var3 >= 0) {
            return true;
        } else {
            return false;
        }
    }

    //9. Написать метод, которому в качестве аргументов передается строка и число,
    // метод должен отпечатать в консоль указанную строку, указанное количество раз;
    static void aStringPrinting(String str1, int numbers) {
        String repeatString = str1.repeat(numbers);
        System.out.println(repeatString);
        //Вариант 2:
        //for (int i = 0; i < numbers; i++) {
        // System.out.println(str1);
    }

    // 10. Написать метод, который определяет, является ли год високосным, и возвращает boolean
    // (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го,
    // при этом каждый 400-й – високосный.
    static boolean leapYear(int numbersOfYears) {
        if (((numbersOfYears % 4 == 0) && (numbersOfYears % 100 != 0)) || (numbersOfYears % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }
}
