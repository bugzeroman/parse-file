package org.dom4j.io;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

/**
 * Dom4j从各种输入解析Document的方法
 */
public class Dom4jParseXML2Document {
    public static void main(String[] args) throws Exception {
        createDocumentFromFile();
        createDocumentFromString();
        createDocumentFromDefault();
    }

    /**
     * 使用文件名构建Document
     */
    public static void createDocumentFromFile() throws DocumentException {
        String fileName = "src/main/resources/books.xml";
        SAXReader reader = new SAXReader();
        File file = new File(fileName);
        // read方式支持多种重载的参数，比如URL、InputStream等
        Document document = reader.read(file);
    }

    /**
     * 使用字符串构建Document
     */
    public static void createDocumentFromString() throws DocumentException {
        String text = "<person> <name>James</name> </person>";
        Document document = DocumentHelper.parseText(text);
    }

    /**
     * 构建一个默认的空的Document
     */
    public static void createDocumentFromDefault() {
        Document document = DocumentHelper.createDocument();
    }
}
