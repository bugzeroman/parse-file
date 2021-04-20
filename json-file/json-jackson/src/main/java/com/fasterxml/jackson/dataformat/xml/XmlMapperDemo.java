package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.databind.JsonNode;

public class XmlMapperDemo {
    public static void main(String[] args) throws Exception {
        // convertXML2JSON();
        convertXML2JSONWithRoot();
    }

    /**
     * 将XML转换为JSON，不通过中间的POJO类型,
     * 但是输出报文缺少了头部hello。
     */
    public static void convertXML2JSON() throws Exception {
        String xml = "<hello>\r\n" + "  <capabilities>\r\n" + "    <capability>1.0</capability>\r\n"
                + "    <capability>1.1</capability>\r\n" + "  </capabilities>\r\n" + "</hello>";

        XmlMapper xmlMapper = new XmlMapper();
        JsonNode node = xmlMapper.readTree(xml.getBytes());
        System.out.println(xml);
        System.out.println(node.toPrettyString());
    }

    /**
     * 将XML转换为JSON，不通过中间的POJO类型,
     * 通过添加一个头部给解析器消耗，
     * 补全缺少的头部。
     */
    public static void convertXML2JSONWithRoot() throws Exception {
        String xml = "<hello message-id=\"105\">\r\n" + "  <capabilities >\r\n" + "    <capability>1.0</capability>\r\n"
                + "    <capability>1.1</capability>\r\n" + "  </capabilities>\r\n" + "</hello>";
        String format = "<temp>%s</temp>";
        String newXml = xml.format(format, xml);
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode node = xmlMapper.readTree(newXml.getBytes());
        System.out.println(xml);
        System.out.println(newXml);
        System.out.println(node.toPrettyString());
    }
}
