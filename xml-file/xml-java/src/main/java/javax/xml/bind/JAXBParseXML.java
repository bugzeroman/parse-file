package javax.xml.bind;

import java.io.File;

/**
 * 通过实体对象直接生成XML，以及把XML直接解析成对应的实体类实例
 *
 */
public class JAXBParseXML {
    public static final String FILE_NAME = "src/main/resources/person.xml";

    public static void main(String[] args) throws Exception {
        generateXML();
        generateBean();
    }

    /**
     * 通过实体对象直接生成XML
     */
    public static void generateXML() throws Exception {
        Person person = new Person("yuwen", "男", "南京");

        File file = new File(FILE_NAME);
        JAXBContext jc = null;
        // 根据Person类生成上下文对象
        jc = JAXBContext.newInstance(Person.class);
        // 从上下文中获取Marshaller对象，用作将bean编组(转换)为xml
        Marshaller ma = jc.createMarshaller();
        // 以下是为生成xml做的一些配置
        // 格式化输出，即按标签自动换行，否则就是一行输出
        ma.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // 设置编码（默认编码就是utf-8）
        ma.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        // 是否省略xml头信息，默认不省略（false）
        ma.setProperty(Marshaller.JAXB_FRAGMENT, false);

        // 编组
        ma.marshal(person, file);
    }

    /**
     * 把XML直接解析成对应的实体类实例
     */
    public static void generateBean() throws Exception {
        File file = new File(FILE_NAME);
        JAXBContext jc = null;
        jc = JAXBContext.newInstance(Person.class);
        Unmarshaller uma = jc.createUnmarshaller();
        Person person = (Person) uma.unmarshal(file);
        System.out.println(person);
    }
}
