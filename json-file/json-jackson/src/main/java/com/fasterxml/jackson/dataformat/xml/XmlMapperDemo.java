package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.databind.JsonNode;

public class XmlMapperDemo {
    public static void main(String[] args) throws Exception {
        // convertXML2JSON();
        // convertXML2JSONWithRoot();
        // getXML2JSONTarget();
        getXML2JSONFindValue();
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

    /**
     * 将XML转换为JSON后，获取指定的部分的值。
     */
    public static void getXML2JSONFindValue() throws Exception {
        String xml = "<rpc-reply xmlns=\"urn:ietf:params:xml:ns:netconf:base:1.0\" message-id=\"8\">\r\n"
                + "  <rpc-error>\r\n" + "    <error-type>application</error-type>\r\n"
                + "    <error-tag>operation-failed</error-tag>\r\n" + "    <error-severity>error</error-severity>\r\n"
                + "    <error-path xmlns:nc=\"urn:ietf:params:xml:ns:netconf:base:1.0\"\r\n"
                + "                xmlns:bgp=\"http://www.huawei.com/netconf/vrp/huawei-bgp\">/nc:rpc/nc:edit-config/nc:config/bgp:bgp/bgp:bgpcomm/bgp:bgpSite</error-path>\r\n"
                + "    <error-message xml:lang=\"en\">BGP is already running. The AS is 65505.</error-message>\r\n"
                + "    <error-info xmlns:nc-ext=\"urn:huawei:yang:huawei-ietf-netconf-ext\">\r\n"
                + "      <nc-ext:error-info-code>431</nc-ext:error-info-code>\r\n" + "      <nc-ext:error-paras>\r\n"
                + "        <nc-ext:error-para>65505</nc-ext:error-para>\r\n" + "      </nc-ext:error-paras>\r\n"
                + "    </error-info>\r\n" + "  </rpc-error>\r\n" + "</rpc-reply>";

        XmlMapper xmlMapper = new XmlMapper();
        // 第一次解析后去掉了rpc-reply标签
        JsonNode node = xmlMapper.readTree(xml.getBytes());
        System.out.println(xml);
        System.out.println(node.toPrettyString());
        // 第二次解析后获得error-message标签
        JsonNode childNOde = node.findValue("error-message");
        System.out.println(childNOde.toString());
        // 第三次解析后取得error-message的文本值（key为空白，对应文本值，不带其他参数）
        System.out.println(childNOde.findValue(""));
    }
}
