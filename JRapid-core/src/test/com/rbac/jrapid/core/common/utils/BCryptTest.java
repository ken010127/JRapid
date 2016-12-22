package com.rbac.jrapid.core.common.utils;

import org.junit.Test;


/**
 * @author FWJ
 * @since 2016/12/22 下午5:30
 */
public class BCryptTest {
    @Test
    public void hashpw() throws Exception {
        String hasf = BCrypt.hashpw("since1989",BCrypt.gensalt(12));
        System.out.println(hasf);
    }

    @Test
    public void checkpw() throws Exception {
        String hasf = "$2a$12$6r6yYfvmIRxHKafHx15l.epsR6v0Ug8BfUQI9qSVsNMLOwAMOWgju";
        if (BCrypt.checkpw("since1989",hasf))
            System.out.println("It matches");
        else
            System.out.println("It does not match");
    }

}