package com.tdd.dao.example.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public final class TddExampleAppContext {

    /**
     * Instantiates a new GMI stars spring App context.
     */
    // Should have private constructor.
    // As it is utility class and we do not want it's object in application.
    private TddExampleAppContext() {
        throw new UnsupportedOperationException();
    }

    private static final ClassPathXmlApplicationContext CONTEXT = new ClassPathXmlApplicationContext("spring-configuration.xml");

    /**
     * Close spring application context of the GMI stars application.
     */
    public static void closeApplicationContext() {
        CONTEXT.close();
    }

    /**
     * Gets the bean.
     *
     * @param beanName the bean name
     * @return the bean
     */
    public static Object getBean(String beanName) {
        ApplicationContext ac = CONTEXT;
        return ac.getBean(beanName);
    }
}
