package com.community;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * Run instance based test setup and tear-downs (vs static).
 *
 * Adapted from:
 * http://saltnlight5.blogspot.com/2012/09/enhancing-spring-test-framework-with.html
 *
 * @author mjohns
 *
 */
public class InstanceTestClassRunner extends BlockJUnit4ClassRunner {

    private InstanceTestClassListener instanceSetupListener;

    public InstanceTestClassRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    protected Object createTest() throws Exception {
        Object test = super.createTest();
        // Note that JUnit4 will call this createTest() multiple times for each
        // test method, so we need to ensure to call "beforeClassSetup" only once.
        if (test instanceof InstanceTestClassListener && instanceSetupListener == null) {
            instanceSetupListener = (InstanceTestClassListener) test;
            instanceSetupListener.beforeClassSetup();
        }
        return test;
    }

    @Override
    public void run(RunNotifier notifier) {
        super.run(notifier);
        if (instanceSetupListener != null)
            instanceSetupListener.afterClassSetup();
    }
}
