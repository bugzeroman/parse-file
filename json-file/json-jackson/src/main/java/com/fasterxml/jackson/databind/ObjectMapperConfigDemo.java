package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.entity.Person;

/**
 * ObjectMapper高级配置使用示例
 *
 */
public class ObjectMapperConfigDemo {
    public static void main(String[] args) throws Exception {
        readValueWithString();
    }

    /**
     * 从JSON字符串数组解析Java对象
     */
    public static void readValueWithString() throws Exception {
        // 其中Person没有定义sex属性
        String personStr = "{\r\n" + "  \"age\" : 18,\r\n" + "  \"sex\" : 1,\r\n" + "  \"name\" : \"yuwen\"\r\n" + "}";
        ObjectMapper mapper = new ObjectMapper();
        // 忽略对象中不存在的属性，而不是抛出异常
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Person person = mapper.readValue(personStr, Person.class);
        System.out.println(person);
    }
}
