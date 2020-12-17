package javax.xml.bind;

import java.io.File;

/**
 * 使用JAXB的静态方法（推荐），通过实体对象直接生成XML，以及把XML直接解析成对应的实体类实例
 *
 */
public class JAXBParseXML {
    public static final String FILE_NAME = "src/main/resources/person.xml";

    public static void main(String[] args) throws Exception {
        java2XML();
        xml2Java();
    }

    /**
     * 通过实体对象直接生成XML
     */
    public static void java2XML() throws Exception {
        Person person = new Person("yuwen", "男", "南京");
        File file = new File(FILE_NAME);
        // 输出到文件
        JAXB.marshal(person, file);
        System.out.println("generateXML=" + file.getAbsolutePath());
        // 输出到控制台
        JAXB.marshal(person, System.out);
    }

    /**
     * 把XML直接解析成对应的实体类实例
     */
    public static void xml2Java() throws Exception {
        File file = new File(FILE_NAME);
        Person person = JAXB.unmarshal(file, Person.class);
        System.out.println(person);
    }
}
