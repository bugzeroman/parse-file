package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.databind.JsonNode;

public class XmlMapperDemo {
    public static void main(String[] args) throws Exception {
        // convertXML2JSON();
        // convertXML2JSONWithRoot();
        getXML2JSONTarget();
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
        String xml = "<data xmlns=\"urn:ietf:params:xml:ns:netconf:base:1.0\">\r\n"
                + "  <bgp xmlns=\"http://www.huawei.com/netconf/vrp/huawei-bgp\">\r\n" + "    <bgpcomm>\r\n"
                + "      <bgpSite>\r\n" + "        <bgpEnable>false</bgpEnable>\r\n" + "      </bgpSite>\r\n"
                + "    </bgpcomm>\r\n" + "  </bgp>\r\n" + "</data>";
        String format = "<temp>%s</temp>";
        String newXml = String.format(format, xml);
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode node = xmlMapper.readTree(newXml.getBytes());
        System.out.println(xml);
        System.out.println(newXml);
        System.out.println(node.toPrettyString());
    }

    /**
     * 将XML转换为JSON后，获取指定的部分。
     */
    public static void getXML2JSONTarget() throws Exception {
        String xml = "<hello>\r\n" + "  <capabilities>\r\n" + "    <capability>1.0</capability>\r\n"
                + "    <capability>1.1</capability>\r\n" + "  </capabilities>\r\n" + "</hello>";

        XmlMapper xmlMapper = new XmlMapper();
        // 第一次解析后去掉了hello标签
        JsonNode node = xmlMapper.readTree(xml.getBytes());
        System.out.println(xml);
        System.out.println(node.toPrettyString());
        // 第二次解析后去掉了capabilities标签
        JsonNode childNOde = node.get("capabilities");
        System.out.println(childNOde);
    }
}
