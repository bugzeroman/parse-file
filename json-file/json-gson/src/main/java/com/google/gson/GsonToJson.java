package com.google.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.entity.Animal;
import com.google.gson.entity.Person;
import com.google.gson.reflect.TypeToken;

/**
 * 序列化 Java对象为 JSON字符串，使用toJson()方法
 *
 */
public class GsonToJson {
    public static void main(String[] args) {
        // convertBasicTypeToJson();
        // convertPersonToJson();
        // convertListToJson();

        convertGenericsToJson();
        convertGenericsToJsonWithType();
    }

    /**
     * 把基本类型序列化为JSON
     */
    public static void convertBasicTypeToJson() {
        Gson gson = new Gson();
        System.out.println(gson.toJson(18));
        System.out.println(gson.toJson("JAVA思想"));
        System.out.println(gson.toJson(new Integer(28)));
        int[] values = { 18, 28 };
        System.out.println(gson.toJson(values));
    }

    /**
     * 把复杂类型Person序列化为JSON
     */
    public static void convertPersonToJson() {
        Person person = new Person();
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println(json);
    }

    /**
     * 把集合类型List序列化为JSON
     */
    public static void convertListToJson() {
        List<String> list = new ArrayList<>();
        list.add("好好学习");
        list.add("天天向上");
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }

    /**
     * 把泛型序列化为JSON，不指定Type,也能正常输出
     */
    public static void convertGenericsToJson() {
        Animal<Person> animal = new Animal<>();
        Person person = new Person();
        animal.set(person);

        Gson gson = new Gson();
        String json = gson.toJson(animal);
        System.out.println(json);
    }

    /**
     * 把泛型序列化为JSON，指定Type 
     */
    public static void convertGenericsToJsonWithType() {
        Animal<Person> animal = new Animal<>();
        Person person = new Person();
        animal.set(person);

        Gson gson = new Gson();
        Type type = new TypeToken<Animal<Person>>() {
        }.getType();
        String json = gson.toJson(animal, type);
        System.out.println(json);
    }
}
