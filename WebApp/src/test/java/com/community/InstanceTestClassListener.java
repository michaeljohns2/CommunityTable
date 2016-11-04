package com.community;

/**
 * Interface for tests implementing instance based test setup and tear-downs (vs static).
 *
 * Adapted from:
 * http://saltnlight5.blogspot.com/2012/09/enhancing-spring-test-framework-with.html
 *
 * @author mjohns
 *
 */
public interface InstanceTestClassListener {

    void beforeClassSetup() throws Exception;
    void afterClassSetup();
}
