package com.google.gson;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import com.google.gson.entity.Animal;
import com.google.gson.entity.Person;
import com.google.gson.reflect.TypeToken;

/**
 * 反序列化 JSON字符串为Java对象，使用fromJson()方法
 *
 */
public class GsonFromJson {
    public static void main(String[] args) {
        // convertJsonToBasicType();
        // convertJsonToPerson();
        // convertJsonToList();
        // convertJsonToGenerics();
        convertJsonToGenericsWithType();
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

    /**
     * 把JSON反序列化为集合类型对象List
     */
    public static void convertJsonToList() {
        String json = "[\"好好学习\",\"天天向上\"]";
        Gson gson = new Gson();
        List<String> list = gson.fromJson(json, List.class);
        System.out.println(list);
    }

    /**
     * 把JSON反序列化为泛型，没有使用Type参数，获取Person的时候会报错
     */
    public static void convertJsonToGenerics() {
        String json = "{\"value\":{\"age\":18,\"name\":\"王小二\"}}";
        Gson gson = new Gson();
        Animal<Person> animal = gson.fromJson(json, Animal.class);
        System.out.println(animal);

        // 获取Person的时候会报错
        Person person = animal.get();
        System.out.println(person);
    }

    /**
     * 把JSON反序列化为泛型，使用Type参数
     */
    public static void convertJsonToGenericsWithType() {
        String json = "{\"value\":{\"age\":18,\"name\":\"王小二\"}}";
        Gson gson = new Gson();
        Type type = new TypeToken<Animal<Person>>() {
        }.getType();
        Animal<Person> animal = gson.fromJson(json, type);
        System.out.println(animal);

        // 获取Person的时候会报错
        Person person = animal.get();
        System.out.println(person);
    }
}
