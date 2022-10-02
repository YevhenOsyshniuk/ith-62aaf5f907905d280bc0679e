package ua.ithillel.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestRunner {

    public TestRunner() {
    }

    public static void start(Class<TestClass> testClass) {
        checkForSuits(testClass);
        runningTests(testClass);
    }

    public static void checkForSuits(Class<TestClass> testClass) {
        Method[] testMethods = testClass.getDeclaredMethods();
        int counterBeforeSuits = 0;
        int counterAfterSuits = 0;

        for (Method methods : testMethods) {
            if (methods.isAnnotationPresent(AfterSuite.class)) {
                counterAfterSuits++;
            }
            if (methods.isAnnotationPresent(BeforeSuite.class)) {
                counterBeforeSuits++;
            }
            if (counterBeforeSuits > 1) {
                throw new RuntimeException("BeforeSuite annotations is more than 1");
            } else if (counterAfterSuits > 1) {
                throw new RuntimeException("AfterSuite annotations is more than 1");
            }
        }
    }

    public static void runningTests(Class<TestClass> testClass) {
        Object testObject;
        try {
            testObject = testClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        Method[] methods = testClass.getDeclaredMethods();
        List<Method> list = new ArrayList<>();
        for (Method method1 : testClass.getDeclaredMethods()) {
            if (method1.isAnnotationPresent(Test.class)) {
                list.add(method1);
            }
        }
        list.sort(Comparator.comparingInt(method -> method.getAnnotation(Test.class).priority()));
        List<Method> testMethod = new java.util.ArrayList<>((list));
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                testMethod.add(0, method);
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                testMethod.add(method);
            }
        }
        try {
            for (Method method : testMethod) {
                method.invoke(testObject);
            }
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
