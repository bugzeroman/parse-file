package com.fasterxml.jackson.custom;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.entity.Person;

/**
 * 使用自定义序列化类生成JSON字符串
 *
 */
public class CustomSerializerDemo {
    public static void main(String[] args) throws Exception {
        writeValueAsString();
    }

    /**
     * 把Java对象序列化为JSON字符串
     */
    public static void writeValueAsString() throws Exception {
        Person person = new Person();

        // 将自定义序列化类注册到ObjectMapper的 Module中
        SimpleModule module = new SimpleModule("CustomSerializer", new Version(1, 0, 0, null, null, null));
        module.addSerializer(Person.class, new CustomSerializer());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);

        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        String personStr = writer.writeValueAsString(person);
        System.out.println(personStr);
    }
}
