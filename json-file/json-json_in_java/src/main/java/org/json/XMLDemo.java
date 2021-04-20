package org.json;

public class XMLDemo {
    public static void main(String[] args) {
        convertXML2JSONWithRoot();
    }

    /**
     * 将XML转换为JSON，不通过中间的POJO类型,解析时带头部。
     */
    public static void convertXML2JSONWithRoot() {
        String xml = "<hello message-id=\"105\">\r\n" + "  <capabilities >\r\n" + "    <capability>1.0</capability>\r\n"
                + "    <capability>1.1</capability>\r\n" + "  </capabilities>\r\n" + "</hello>";
        // 将xml转为json
        JSONObject xmlJSONObj = XML.toJSONObject(xml);
        // 设置缩进
        String json = xmlJSONObj.toString(4);
        // 输出格式化后的json
        System.out.println(json);
    }
}
