package com.google.gson;

import java.util.Arrays;

import com.google.gson.entity.Person;

/**
 * 反序列化 JSON字符串为Java对象，使用fromJson()方法
 *
 */
public class GsonFromJson {
    public static void main(String[] args) {
        convertJsonToBasicType();
        convertJsonToPerson();
    }

    /**
     * 把JSON反序列化为简单类型对象
     */
    public static void convertJsonToBasicType() {
        Gson gson = new Gson();
        int one = gson.fromJson("1", int.class);
        Integer two = gson.fromJson("2", Integer.class);
        Boolean flag = gson.fromJson("false", Boolean.class);
        String str = gson.fromJson("\"王小川\"", String.class);
        String[] anotherStr = gson.fromJson("[\"JAVA思想\",\"王小川\"]", String[].class);

        System.out.println(one);
        System.out.println(two);
        System.out.println(flag);
        System.out.println(str);
        System.out.println(Arrays.toString(anotherStr));
    }

    /**
     * 把JSON反序列化为复杂类型对象Person
     */
    public static void convertJsonToPerson() {
        String personJson = "{\"age\":28,\"name\":\"王小川\"}\r\n";
        Gson gson = new Gson();
        Person person = gson.fromJson(personJson, Person.class);
        System.out.println(person);
    }
}
