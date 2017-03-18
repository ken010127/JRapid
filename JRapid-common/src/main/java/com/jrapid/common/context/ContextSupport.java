/**
 * 
 */
package com.jrapid.common.context;

import com.jrapid.common.CollectionUtil;

import java.util.Collection;
import java.util.Map;


/**
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年8月31日 下午10:41:40
 */
public class ContextSupport<K, V> implements Context<K, V> {

    private Map<K, V> map = CollectionUtil.createHashMap();

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public Context<K, V> set(K key, V value) {
        map.put(key, value);

        return this;
    }

    @Override
    public Collection<V> values() {
        return map.values();
    }

}
