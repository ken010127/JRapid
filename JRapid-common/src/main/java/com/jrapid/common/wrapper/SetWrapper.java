/**
 * 
 */
package com.jrapid.common.wrapper;

import com.jrapid.common.CollectionUtil;

import java.util.Set;


/**
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年9月15日 上午2:19:17
 */
public class SetWrapper<T> {

    private Set<T> set;

    public SetWrapper() {
        set = CollectionUtil.createHashSet();
    }

    public SetWrapper(Set<T> set) {
        this.set = set;
    }

    public SetWrapper<T> set(T value) {
        set.add(value);
        return this;
    }

    public SetWrapper<T> remove(T value) {
        set.remove(value);
        return this;
    }

    public SetWrapper<T> remove(int index) {
        set.remove(index);
        return this;
    }

    public SetWrapper<T> clear() {
        set.clear();
        return this;
    }

    public Set<T> getList() {
        return set;
    }

}
