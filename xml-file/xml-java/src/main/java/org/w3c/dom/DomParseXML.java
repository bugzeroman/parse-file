package org.w3c.dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * 用DOM方式解析xml文件,使用JDK提供的类库
 */
public class DomParseXML {

    public static void main(String args[]) throws Exception {
        String fileName = "src/main/resources/books.xml";

        Document document = getDocument(fileName);

        List<Book> books = getBooks(document);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static Document getDocument(String fileName) throws ParserConfigurationException, SAXException, IOException {
        // 工厂类可以设置很多XML解析参数
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // 将给定URI的内容解析为一个 XML文档,并返回Document对象
        Document document = builder.parse(fileName);
        return document;
    }

    public static List<Book> getBooks(Document document) throws Exception {

        // 按文档顺序返回在文档中，具有book标签的所有Node
        NodeList bookNodes = document.getElementsByTagName("book");

        // 用于保存解析后的Book对象
        List<Book> books = new ArrayList<Book>();
        // 遍历具有book标签的所有Node
        for (int i = 0; i < bookNodes.getLength(); i++) {
            // 获取第i个book结点
            Node node = bookNodes.item(i);
            // 获取第i个book的所有属性
            NamedNodeMap namedNodeMap = node.getAttributes();
            // 获取已知名为id的属性值
            String id = namedNodeMap.getNamedItem("id").getTextContent();
            Book book = new Book();
            book.setId(Integer.parseInt(id));

            // 获取book结点的子节点,包含了text类型的换行
            NodeList childNodes = node.getChildNodes();

            // 按照顺序将book里面的属性加入数组
            ArrayList<String> contents = new ArrayList<>();
            // 这里由于偶数行是text类型无用节点，所以只取1,3,5,7节点
            for (int j = 1; j < childNodes.getLength(); j += 2) {
                Node childNode = childNodes.item(j);
                String content = childNode.getFirstChild().getTextContent();
                contents.add(content);
            }

            // 将数组中的内容按照顺序写入对象
            book.setName(contents.get(0));
            book.setAuthor(contents.get(1));
            book.setYear(Integer.parseInt(contents.get(2)));
            book.setPrice(Double.parseDouble(contents.get(3)));

            // 将解析好的book加入返回列表
            books.add(book);
        }

        return books;
    }
}