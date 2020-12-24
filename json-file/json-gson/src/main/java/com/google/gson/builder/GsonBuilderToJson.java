package com.google.gson.builder;

import java.lang.reflect.Modifier;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.entity.Person;

/**
 * 使用GsonBuilder自定义序列化Java对象的行为
 *
 */
public class GsonBuilderToJson {
    public static void main(String[] args) {
        // prettyPrinting();
        // serializeNulls();
        excludeFieldsWithModifiers();
        excludeFieldsWithoutExposeAnnotation();
    }

    /**
     * 设置漂亮的JSON格式,可以比较设置前后的打印结果
     */
    public static void prettyPrinting() {
        Person person = new Person();
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println("----no pretty printing----");
        System.out.println(json);
        // 设置漂亮的JSON格式
        Gson gsonNew = new GsonBuilder().setPrettyPrinting().create();
        String jsonNew = gsonNew.toJson(person);
        System.out.println("----pretty printing----");
        System.out.println(jsonNew);
    }

    /**
     * 默认序列化的时候会忽略 null值的字段，现在设置不忽略null
     */
    public static void serializeNulls() {
        Person person = new Person();
        person.setName(null);
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println("----no serialize Nulls----");
        System.out.println(json);

        Gson gsonNew = new GsonBuilder().serializeNulls().create();
        String jsonNew = gsonNew.toJson(person);
        System.out.println("----serialize Nulls----");
        System.out.println(jsonNew);
    }

    /**
     *通过 Java修饰符,指定参与序列化和反序列化的字段,默认transient和static关键字指定的字段不参与
     */
    public static void excludeFieldsWithModifiers() {
        Person person = new Person();
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println("----default exclude fields with modifiers----");
        System.out.println(json);

        Gson gsonNew = new GsonBuilder().excludeFieldsWithModifiers(Modifier.STATIC, Modifier.VOLATILE).create();
        String jsonNew = gsonNew.toJson(person);
        System.out.println("----specified exclude fields with modifiers----");
        System.out.println(jsonNew);
    }

    /**
     *通过注解,指定参与序列化和反序列化的字段,只有加了@Expose注解的字段才会参与
     */
    public static void excludeFieldsWithoutExposeAnnotation() {
        Person person = new Person();
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println("----no exclude fields without expose annotation----");
        System.out.println(json);

        Gson gsonNew = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String jsonNew = gsonNew.toJson(person);
        System.out.println("----exclude fields without expose annotation----");
        System.out.println(jsonNew);
    }
}
