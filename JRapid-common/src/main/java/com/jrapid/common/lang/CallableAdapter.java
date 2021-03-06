/**
 * 
 */
package com.jrapid.common.lang;

import com.jrapid.common.able.Adaptable;
import com.jrapid.common.logger.CachedLogger;

import java.util.concurrent.Callable;


/**
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年7月31日 上午12:43:07
 */
public class CallableAdapter<T> extends CachedLogger implements Adaptable<Callable<T>, Runnable>, Runnable {

    final Callable<T> task;

    public CallableAdapter(Callable<T> task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            task.call();
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Override
    public Runnable forNew(final Callable<T> old) {
        return new Runnable() {

            @Override
            public void run() {
                try {
                    old.call();
                } catch (Exception e) {
                    logger.error("", e);
                }

            }
        };
    }

}
