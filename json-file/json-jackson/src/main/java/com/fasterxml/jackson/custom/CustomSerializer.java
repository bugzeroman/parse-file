package com.fasterxml.jackson.custom;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.entity.Person;

/**
 * 自定义序列化工具类
 *
 */
public class CustomSerializer extends StdSerializer<Person> {
    private static final long serialVersionUID = -5503139590001362290L;

    protected CustomSerializer(Class<Person> t) {
        super(t);
    }

    public CustomSerializer() {
        this(null);
    }

    @Override
    public void serialize(Person value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        // 这里只序列化了name字段，并且修改了字段值
        gen.writeStringField("name", value.getName() + "_custom");
        gen.writeEndObject();
    }
}
