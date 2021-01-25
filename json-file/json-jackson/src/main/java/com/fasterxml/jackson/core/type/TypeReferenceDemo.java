package com.fasterxml.jackson.core.type;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.entity.Person;

/**
 * 使用TypeReference将JSON字符串数组转成泛型List
 *
 */
public class TypeReferenceDemo {
    public static void main(String[] args) throws Exception {
        String personsStr = "[ {\r\n" + "  \"age\" : 18,\r\n" + "  \"name\" : \"yuwen\"\r\n" + "}, {\r\n"
                + "  \"age\" : 28,\r\n" + "  \"name\" : \"bob\"\r\n" + "} ]";
        ObjectMapper mapper = new ObjectMapper();
        List<Person> persons = mapper.readValue(personsStr, new TypeReference<List<Person>>() {
        });
        System.out.println(persons);
    }
}
