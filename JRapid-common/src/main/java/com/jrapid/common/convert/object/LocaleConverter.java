package com.jrapid.common.convert.object;

import com.jrapid.common.convert.ObjectConverter;
import com.jrapid.common.convert.TypeConverter;
import com.jrapid.common.i18n.LocaleUtil;

import java.util.Locale;


/**
 * 
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年9月19日 下午4:18:05
 */
public class LocaleConverter extends ObjectConverter<Locale> implements TypeConverter<Locale> {

    public LocaleConverter() {
        register(Locale.class);
    }

    @Override
    public Locale toConvert(String value) {
        return LocaleUtil.parseLocale(value);
    }

    @Override
    public String fromConvert(Locale value) {
        return String.valueOf(value);
    }

    public Locale toConvert(Object value) {
        if (value.getClass() == Locale.class) {
            return (Locale) value;
        }

        return LocaleUtil.parseLocale(value.toString());
    }

}
