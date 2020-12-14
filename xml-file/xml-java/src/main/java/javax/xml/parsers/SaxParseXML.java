package javax.xml.parsers;

import java.util.List;

import org.w3c.dom.Book;

/**
 * 用SAX方式解析XML文件，使用JDK提供的类库
 */
public class SaxParseXML {

    public static void main(String[] args) throws Exception {
        String fileName = "src/main/resources/books.xml";
        List<Book> books = getBooks(fileName);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static List<Book> getBooks(String fileName) throws Exception {
        // SAXParserFactory可以设置XML解析参数
        SAXParserFactory sParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = sParserFactory.newSAXParser();

        SAXParseHandler handler = new SAXParseHandler();
        // SAXParser解析XML文件时需要配合SAXParseHandler使用
        parser.parse(fileName, handler);
        // 从自定义的解析类SAXParseHandler中取出解析结果
        return handler.getBooks();
    }

}
