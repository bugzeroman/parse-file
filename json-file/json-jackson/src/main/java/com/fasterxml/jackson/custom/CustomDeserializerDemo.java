package com.fasterxml.jackson.custom;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.entity.Person;

/**
 * 使用自定义反序列化类解析JSON字符串
 *
 */
public class CustomDeserializerDemo {
    public static void main(String[] args) throws Exception {
        readValueWithString();
    }

    /**
     * 从JSON字符串解析为Java对象
     */
    public static void readValueWithString() throws Exception {
        String personStr = "{\r\n" + "  \"age\" : 18,\r\n" + "  \"name\" : \"yuwen\"\r\n" + "}";
        // 将自定义反序列化类注册到ObjectMapper的 Module 中
        SimpleModule module = new SimpleModule("CustomDeserializer", new Version(1, 0, 0, null, null, null));
        module.addDeserializer(Person.class, new CustomDeserializer());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);

        Person person = mapper.readValue(personStr, Person.class);
        System.out.println(person);
    }
}
