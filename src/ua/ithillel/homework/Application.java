package ua.ithillel.homework;

public class Application {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        TestRunner.start(testClass.getClass());
    }
}
