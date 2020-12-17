package javax.xml.bind;

import java.io.File;

/**
 * 使用JAXBContext上下文对象，通过实体对象直接生成XML，以及把XML直接解析成对应的实体类实例
 *
 */
public class JAXBContextParseXML {
    public static final String FILE_NAME = "src/main/resources/person.xml";

    public static void main(String[] args) throws Exception {
        java2XML();
        xml2java();
    }

    /**
     * 通过实体对象直接生成XML
     */
    public static void java2XML() throws Exception {
        Person person = new Person("yuwen", "男", "南京");

        File file = new File(FILE_NAME);
        // 根据Person类生成上下文对象
        JAXBContext jc = JAXBContext.newInstance(Person.class);
        // 从上下文中获取Marshaller对象，用于把bean转换为xml
        Marshaller ma = jc.createMarshaller();
        // 以下是为生成xml做的一些配置
        // 格式化输出，即按标签自动换行，否则就是一行输出
        ma.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // 设置编码（默认编码就是utf-8）
        ma.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        // 是否省略xml头信息，默认不省略（false）
        ma.setProperty(Marshaller.JAXB_FRAGMENT, false);

        // 编组，把Person对象转换为xml
        ma.marshal(person, file);
        System.out.println("generateXML=" + file.getName());
    }

    /**
     * 把XML直接解析成对应的实体类实例
     */
    public static void xml2java() throws Exception {
        // 从上下文中获取Unmarshaller对象
        JAXBContext jc = JAXBContext.newInstance(Person.class);
        Unmarshaller uma = jc.createUnmarshaller();

        // 把XML文件解析为Person对象
        File file = new File(FILE_NAME);
        Person person = (Person) uma.unmarshal(file);
        System.out.println(person);
    }
}
