package com.google.gson;

import com.google.gson.entity.Person;

/**
 * 序列化 Java对象为 JSON字符串，使用toJson()方法
 *
 */
public class GsonToJson {
    public static void main(String[] args) {
        convertBasicTypeToJson();
        convertPersonToJson();
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
}
