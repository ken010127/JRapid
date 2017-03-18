package com.jrapid.common.convert.primitive;


import com.jrapid.common.convert.ConvertException;
import com.jrapid.common.convert.ObjectConverter;
import com.jrapid.common.convert.TypeConverter;

import static com.jrapid.common.StringPool.Symbol.*;

/**
 * 
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年7月28日 下午11:11:20
 */
public class BooleanConverter extends ObjectConverter<Boolean> implements TypeConverter<Boolean> {

    public BooleanConverter() {
        register(Boolean.class);
        register(boolean.class);
    }

    @Override
    public Boolean toConvert(String value) {
        return convert(value.trim());
    }

    @Override
    public String fromConvert(Boolean value) {
        return String.valueOf(value);
    }

    public Boolean toConvert(Object value) {
        if (value.getClass() == Boolean.class) {
            return (Boolean) value;
        }

        String stringValue = value.toString().trim();
        return convert(stringValue);
    }

    private Boolean convert(String value) {
        if (value.equalsIgnoreCase(YES) || value.equalsIgnoreCase(Y) || value.equalsIgnoreCase(TRUE)
                || value.equalsIgnoreCase(ON) || value.equalsIgnoreCase(ONE)) {
            return Boolean.TRUE;
        }
        if (value.equalsIgnoreCase(NO) || value.equalsIgnoreCase(N) || value.equalsIgnoreCase(FALSE)
                || value.equalsIgnoreCase(OFF) || value.equalsIgnoreCase(ZERO)) {
            return Boolean.FALSE;
        }

        throw new ConvertException(value);
    }

}
