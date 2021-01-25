package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.entity.PersonAnnotation;

/**
 * 演示Jackson注解使用方法
 *
 */
public class ObjectMapperAnnotationDemo {
    public static void main(String[] args) throws Exception {
        // writeValueAsStringWithAnnotation();
        writeValueAsStringWithSetDateFormat();
    }

    /**
     * 使用@JsonFormat注解指定输出日期格式
     */
    public static void writeValueAsStringWithAnnotation() throws Exception {
        PersonAnnotation person = new PersonAnnotation();
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        String personStr = writer.writeValueAsString(person);
        System.out.println(personStr);
    }

    /**
     * 使用setDateFormat指定输出日期格式
     */
    public static void writeValueAsStringWithSetDateFormat() throws Exception {
        PersonAnnotation person = new PersonAnnotation();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(StdDateFormat.getDateTimeInstance());
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        String personStr = writer.writeValueAsString(person);
        System.out.println(personStr);
    }
}
