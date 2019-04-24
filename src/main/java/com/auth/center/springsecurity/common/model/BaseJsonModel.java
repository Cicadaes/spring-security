package com.auth.center.springsecurity.common.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 
 * ClassName: BaseJsonModel <br/>
 * Function: json model基类，用于json返回格式的封装. <br/>
 * <p>
 * <b>SerializerFeature</b> 属性含义如下所示：</br>
 * <ul>
 * <li>QuoteFieldNames :输出key时是否使用双引号,默认为true</li>
 * <li>UseSingleQuotes : 使用单引号而不是双引号,默认为false</li>
 * <li>WriteMapNullValue : 是否输出值为null的字段,默认为false</li>
 * <li>WriteEnumUsingToString : Enum输出name()或者original,默认为false</li>
 * <li>UseISO8601DateFormat : Date使用ISO8601格式输出，默认为false</li>
 * <li>WriteNullListAsEmpty : List字段如果为null,输出为[],而非null</li>
 * <li>WriteNullStringAsEmpty : 字符类型字段如果为null,输出为”“,而非null</li>
 * <li>WriteNullNumberAsZero : 数值字段如果为null,输出为0,而非null</li>
 * <li>WriteNullBooleanAsFalse : Boolean字段如果为null,输出为false,而非null</li>
 * <li>SkipTransientField : 如果是true，类中的Get方法对应的Field是transient，序列化时将会被忽略。默认为true</li>
 * <li>SortField : 按字段名称排序后输出。默认为false</li>
 * <li>WriteTabAsSpecial : 把\t做转义输出，默认为false</li>
 * <li>PrettyFormat : 结果是否格式化,默认为false</li>
 * <li>WriteClassName : 序列化时写入类型信息，默认为false。反序列化是需用到</li>
 * <li>DisableCircularReferenceDetect : 消除对同一对象循环引用的问题，默认为false</li>
 * <li>WriteSlashAsSpecial : 对斜杠’/’进行转义</li>
 * <li>BrowserCompatible : 将中文都会序列化为XXXX格式，字节数会多一些，但是能兼容IE 6，默认为false</li></li>
 * <li>WriteDateUseDateFormat : 全局修改日期格式,默认为false。JSON.DEFFAULT_DATE_FORMAT = “yyyy-MM-dd”;JSON.toJSONString(obj,
 * SerializerFeature.WriteDateUseDateFormat)</li>
 * <li>DisableCheckSpecialChar : 一个对象的字符串属性中如果有特殊字符如双引号，将会在转成json时带有反斜杠转移符。如果不需要转义，可以使用这个属性。默认为false</li>
 * <li>NotWriteRootClassName : 含义</li>
 * <li>BeanToArray : 将对象转为array输出</li>
 * <li>WriteNonStringKeyAsString : 含义</li>
 * <li>NotWriteDefaultValue : 含义</li>
 * <li>BrowserSecure : 含义</li>
 * <li>IgnoreNonFieldGetter : 含义</li>
 * <li>WriteEnumUsingName : 含义</li>
 * 
 * </ul>
 * date: 2017年10月20日 上午10:36:46 <br/>
 *
 * @author wuyuegang
 * @version
 * @since JDK 1.8
 */
public abstract class BaseJsonModel
{
    
    private static final long serialVersionUID = -7532190300864165247L;
    
    private transient SerializerFeature[] features = new SerializerFeature[3];
    
    public BaseJsonModel()
    {
        features[0] = SerializerFeature.QuoteFieldNames;
        features[1] = SerializerFeature.WriteMapNullValue;
        features[2] = SerializerFeature.WriteNullStringAsEmpty;
    }
    
    @Override
    public String toString()
    {
        return JSON.toJSONString(this, features);
    }
    
    public String toString(SerializeFilter... filters)
    {
        if (filters == null)
        {
            return JSON.toJSONString(this, features);
        }
        return JSON.toJSONString(this, filters, features);
    }

}
