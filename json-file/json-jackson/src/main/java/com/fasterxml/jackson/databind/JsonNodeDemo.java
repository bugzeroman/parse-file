package com.fasterxml.jackson.databind;

/**
 * ObjectMapper将JSON解析为基于"树模型"的JsonNode对象
 *
 */
public class JsonNodeDemo {
    public static void main(String[] args) throws Exception {
        String personStr = "{\r\n" + "  \"age\" : 18,\r\n" + "  \"name\" : \"yuwen\"\r\n" + "}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(personStr);
        String name = jsonNode.get("name").asText();
        System.out.println(name);
    }
}
