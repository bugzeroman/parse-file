package com.fasterxml.jackson.custom;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.entity.Person;

/**
 * 自定义反序列化工具类
 *
 */
public class CustomDeserializer extends StdDeserializer<Person> {

    private static final long serialVersionUID = 161647207661665798L;

    protected CustomDeserializer(Class<?> vc) {
        super(vc);
    }

    public CustomDeserializer() {
        this(null);
    }

    /**
     * 通过JsonNode把JSON读取到一个树形结构中，
     * 然后通过 JsonNode的get方法将对应字段读取出来，
     * 然后生成新的Java对象，并返回。
     */
    @Override
    public Person deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        Person person = new Person();
        int age = (Integer) ((IntNode) node.get("age")).numberValue();
        String name = node.get("name").asText();
        // 自定义解析过程可以对数据进行修改
        name = name + "_custom";
        person.setAge(age);
        person.setName(name);
        return person;
    }
}
