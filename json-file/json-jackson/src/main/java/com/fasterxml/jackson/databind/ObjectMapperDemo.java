package com.fasterxml.jackson.databind;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.entity.Person;

/**
 * Jackson序列化和反序列化示例
 *
 */
public class ObjectMapperDemo {
    public static void main(String[] args) throws Exception {
        // writeValueAsString();
        writeListAsString();
        // readValueWithString();
    }

    /**
     * 把Java对象序列化为JSON字符串
     */
    public static void writeValueAsString() throws Exception {
        Person person = new Person();
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        String personStr = writer.writeValueAsString(person);
        System.out.println(personStr);
    }

    /**
     * 把Java对象数组序列化为JSON字符串
     */
    public static void writeListAsString() throws Exception {
        Person person1 = new Person();
        person1.setName("yuwen");
        Person person2 = new Person();
        person2.setName("bob");
        List<Person> persons = Arrays.asList(person1, person2);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        String personsStr = writer.writeValueAsString(persons);
        System.out.println(personsStr);
    }

    /**
     * 从JSON字符串解析为Java对象
     */
    public static void readValueWithString() throws Exception {
        String personStr = "{\r\n" + "  \"age\" : 18,\r\n" + "  \"name\" : \"yuwen\"\r\n" + "}";
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(personStr, Person.class);
        System.out.println(person);
    }
}
