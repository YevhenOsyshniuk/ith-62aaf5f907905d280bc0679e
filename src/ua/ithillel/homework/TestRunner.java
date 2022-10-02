package ua.ithillel.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestRunner {

        public static void start(Class<?> testClass) {
        checkForSuits(testClass);
        runningTests(testClass);
    }

    public static void checkForSuits(Class<?> testClass) {
        if (testClass == null){
            throw new NullPointerException("Incoming class is null");
        }
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
            }
            if (counterAfterSuits > 1) {
                throw new RuntimeException("AfterSuite annotations is more than 1");
            }
        }
    }

    public static void runningTests(Class<?> testClass) {
        Object testObject = createInstance(testClass);

        Method[] methods = testClass.getDeclaredMethods();
        List<Method> declaredMethods = new ArrayList<>();
        for (Method method1 : testClass.getDeclaredMethods()) {
            if (method1.isAnnotationPresent(Test.class)) {
                declaredMethods.add(method1);
            }
        }
        declaredMethods.sort(Comparator.comparingInt(method -> method.getAnnotation(Test.class).priority()));
        List<Method> testMethods = new java.util.ArrayList<>((declaredMethods));
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                testMethods.add(0, method);
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                testMethods.add(method);
            }
        }
        try {
            for (Method method : testMethods) {
                method.invoke(testObject);
            }
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static Object createInstance(Class<?> testClass) {
        if (testClass == null){
            throw new NullPointerException("Incoming class is null");
        }
        Object testObject;
        try {
            testObject = testClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return testObject;
    }
}
