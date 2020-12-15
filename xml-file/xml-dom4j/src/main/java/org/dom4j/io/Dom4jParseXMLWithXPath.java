package org.dom4j.io;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;

/**
 * 使用XPath过滤解析到的Document
 *
 */
public class Dom4jParseXMLWithXPath {

    public static void main(String[] args) throws Exception {
        Document document = createDocumentFromFile();
        parseXMLWithXPath(document);
    }

    public static void parseXMLWithXPath(Document document) {
        List<Node> list = document.selectNodes("/bookstore/book");
        list.forEach(System.out::println);
        // Node node = document.selectSingleNode("//foo/bar/author");
        // String name = node.valueOf("@name");
    }

    /**
     * 使用文件名构建Document
     */
    public static Document createDocumentFromFile() throws Exception {
        String fileName = "src/main/resources/books.xml";
        SAXReader reader = new SAXReader();
        File file = new File(fileName);
        // read方式支持多种重载的参数，比如URL、InputStream等
        Document document = reader.read(file);
        return document;
    }
}
