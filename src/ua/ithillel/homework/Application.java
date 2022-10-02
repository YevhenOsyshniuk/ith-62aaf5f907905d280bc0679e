package ua.ithillel.homework;

public class Application {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        TestRunner.start((Class<TestClass>) testClass.getClass());
    }
}
