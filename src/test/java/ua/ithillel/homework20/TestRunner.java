package ua.ithillel.homework20;

import lombok.SneakyThrows;
import org.junit.platform.engine.Filter;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.PrintWriter;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

public class TestRunner {

    @SneakyThrows
    public static void main(String[] args) {
        TestRunner runner = new TestRunner();
        runner.runAllByPathToPackage();

        TestExecutionSummary summary = runner.listener.getSummary();
        summary.printTo(new PrintWriter(System.out));
        summary.printTo(new PrintWriter("fileForTest.txt"));

        TestResultParser testResultParser = new TestResultParser();
        testResultParser.parseFileByPath();
        System.out.println(testResultParser.getTestsFound());
        System.out.println(testResultParser.getTestsSuccessful());
        System.out.println(testResultParser.getTestsFailed());
        System.out.println("Current time of using tests" + testResultParser.getDate());
    }

    SummaryGeneratingListener listener = new SummaryGeneratingListener();

    public void runOneByStringNameOfClass() {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass("SimpleMathLibraryTest"))
                .build();
        Launcher launcher = LauncherFactory.create();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
    }

    public void runOneByClassType() {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(SimpleMathLibrary.class))
                .build();
        Launcher launcher = LauncherFactory.create();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
    }

    public void runAllByStringNameOfClass() {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .filters(includeClassNamePatterns(".*Test"))
                .build();
        Launcher launcher = LauncherFactory.create();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
    }


    public void runAllByClassType() {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .filters((Filter<?>) selectClass(SimpleMathLibraryTest.class))
                .build();
        Launcher launcher = LauncherFactory.create();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
    }

    public void runAllByPathToPackage() {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectPackage("ua.ithillel.homework20"))
                .filters(includeClassNamePatterns(".*Test"))
                .build();
        Launcher launcher = LauncherFactory.create();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
    }
}
