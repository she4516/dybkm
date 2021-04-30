package com.zsl.dybkm.common.domain;

import com.zsl.dybkm.exception.BizAssertException;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * 自定义断言
 */
public class BizAssert {

    public BizAssert() {
        super();
    }

    /**
     * 功能描述:
     * 〈校验结果是否为true〉
     *
     * @params : [expression, message, value]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:27
     */
    public static void isTrue(boolean expression, String message, Object value) {
        if (expression == false) {
            throw new BizAssertException(message + value);
        }
    }

    /**
     * 功能描述:
     * 〈校验结果是否为true〉
     *
     * @params : [expression, message, value]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:27
     */
    public static void isTrue(boolean expression, String message, long value) {
        if (expression == false) {
            throw new BizAssertException(message + value);
        }
    }

    /**
     * 功能描述:
     * 〈校验结果是否为true〉
     *
     * @params : [expression, message, value]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:27
     */
    public static void isTrue(boolean expression, String message, double value) {
        if (expression == false) {
            throw new BizAssertException(message + value);
        }
    }

    /**
     * 功能描述:
     * 〈校验结果是否为true〉
     *
     * @params : [expression, message, value]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:27
     */
    public static void isTrue(boolean expression, String message) {
        if (expression == false) {
            throw new BizAssertException(message);
        }
    }

    /**
     * 功能描述:
     * 〈校验结果是否为true〉
     *
     * @params : [expression, message, value]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:27
     */
    public static void isTrue(boolean expression) {
        if (expression == false) {
            throw new BizAssertException("The validated expression is false");
        }
    }

    /**
     * 功能描述:
     * 〈校验结果是否为true〉
     *
     * @params : [expression, message, value]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:27
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new BizAssertException(message);
        }
    }

    /**
     * 功能描述:
     * 〈校验对象object是否为空〉
     *
     * @params : [object]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:29
     */
    public static void notNull(Object object) {
        if (object == null) {
            throw new BizAssertException("The validated object is null");
        }
    }

    /**
     * 功能描述:
     * 〈校验数组是否为空〉
     *
     * @params : [array, message]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:30
     */
    public static void notEmpty(Object[] array, String message) {
        if (array == null || array.length == 0) {
            throw new BizAssertException(message);
        }
    }

    /**
     * 功能描述:
     * 〈校验数组是否为空〉
     *
     * @params : [array, message]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:30
     */
    public static void notEmpty(Object[] array) {
        if (array == null || array.length == 0) {
            throw new BizAssertException("The validated array is empty");
        }
    }

    /**
     * 功能描述:
     * 〈校验集合是否为空〉
     *
     * @params : [collection, message]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:32
     */
    public static void notEmpty(Collection collection, String message) {
        if (collection == null || collection.size() == 0) {
            throw new BizAssertException(message);
        }
    }

    /**
     * 功能描述:
     * 〈校验集合是否为空〉
     *
     * @params : [collection]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:32
     */
    public static void notEmpty(Collection collection) {
        if (collection == null || collection.size() == 0) {
            throw new BizAssertException("The validated collection is empty");
        }
    }

    /**
     * 功能描述:
     * 〈校验map集合是否为空〉
     *
     * @params : [map, message]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:33
     */
    public static void notEmpty(Map map, String message) {
        if (map == null || map.size() == 0) {
            throw new BizAssertException(message);
        }
    }

    /**
     * 功能描述:
     * 〈校验map集合是否为空〉
     *
     * @params : [map]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:33
     */
    public static void notEmpty(Map map) {
        if (map == null || map.size() == 0) {
            throw new BizAssertException("The validated map is empty");
        }
    }

    /**
     * 功能描述:
     * 〈校验字符串是否为空〉
     *
     * @params : [string, message]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:33
     */
    public static void notEmpty(String string, String message) {
        if (string == null || string.length() == 0) {
            throw new BizAssertException(message);
        }
    }

    /**
     * 功能描述:
     * 〈校验字符串是否为空〉
     *
     * @params : [string]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:34
     */
    public static void notEmpty(String string) {
        if (string == null || string.length() == 0) {
            throw new BizAssertException("The validated string is empty");
        }
    }

    /**
     * 功能描述:
     * 〈校验数组array的每一个元素都不为空〉
     *
     * @params : [array, message]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:35
     */
    public static void noNullElements(Object[] array, String message) {
        notNull(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new BizAssertException(message);
            }
        }
    }

    /**
     * 功能描述:
     * 〈校验数组的每一个元素都不为空〉
     *
     * @params : [array]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:36
     */
    public static void noNullElements(Object[] array) {
        notNull(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new BizAssertException("The validated array contains null element at index: " + i);
            }
        }
    }

    /**
     * 功能描述:
     * 〈校验集合的每个元素都不为空〉
     *
     * @params : [collection, message]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:36
     */
    public static void noNullElements(Collection collection, String message) {
        notNull(collection);
        for (Iterator it = collection.iterator(); it.hasNext();) {
            if (it.next() == null) {
                throw new BizAssertException(message);
            }
        }
    }

    /**
     * 功能描述:
     * 〈校验集合中的每个元素都不为空〉
     *
     * @params : [collection]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:37
     */
    public static void noNullElements(Collection collection) {
        notNull(collection);
        int i = 0;
        for (Iterator it = collection.iterator(); it.hasNext(); i++) {
            if (it.next() == null) {
                throw new BizAssertException("The validated collection contains null element at index: " + i);
            }
        }
    }

    /**
     * 功能描述:
     * 〈校验集合中的每个元素都是clazz类型〉
     *
     * @params : [collection, clazz, message]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:38
     */
    public static void allElementsOfType(Collection collection, Class clazz, String message) {
        notNull(collection);
        notNull(clazz);
        for (Iterator it = collection.iterator(); it.hasNext(); ) {
            if (clazz.isInstance(it.next()) == false) {
                throw new BizAssertException(message);
            }
        }
    }

    /**
     * 功能描述:
     * 〈校验集合中的每个元素都是clazz的类型〉
     *
     * @params : [collection, clazz]
     * @return : void
     * @author : cwl
     * @date : 2019/6/4 15:38
     */
    public static void allElementsOfType(Collection collection, Class clazz) {
        notNull(collection);
        notNull(clazz);
        int i = 0;
        for (Iterator it = collection.iterator(); it.hasNext(); i++) {
            if (clazz.isInstance(it.next()) == false) {
                throw new BizAssertException("The validated collection contains an element not of type "
                        + clazz.getName() + " at index: " + i);
            }
        }
    }
}
