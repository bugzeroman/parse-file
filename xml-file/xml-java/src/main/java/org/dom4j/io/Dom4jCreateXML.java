package org.dom4j.io;

import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 创建XML文件，转换成String输出，或者输出到文件，输出的同时可以格式化XML
 *
 */
public class Dom4jCreateXML {

    public static void main(String[] args) throws Exception {
        Document document = createDocument();

        String str = getDocumentString(document);
        System.out.println(str);

        writeDocument(document);
    }

    public static Document createDocument() {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("root");

        Element author1 = root.addElement("author").addAttribute("name", "James").addAttribute("location", "UK")
                .addText("James Strachan");

        Element author2 = root.addElement("author").addAttribute("name", "Bob").addAttribute("location", "US")
                .addText("Bob McWhirter");

        return document;
    }

    public static String getDocumentString(Document document) {
        String str = document.asXML();
        return str;
    }

    public static void writeDocument(Document document) throws Exception {
        // 写入文件
        System.out.println("---write to file output.xml---");
        FileWriter fileWriter = new FileWriter("output.xml");
        XMLWriter writer = new XMLWriter(fileWriter);
        writer.write(document);
        writer.close();

        // 漂亮格式化后，写入到系统标准输出
        System.out.println("---Pretty print the document to System.out---");
        OutputFormat format = OutputFormat.createPrettyPrint();
        writer = new XMLWriter(System.out, format);
        writer.write(document);
        writer.close();

        // 紧凑格式化后，写入到系统标准输出
        System.out.println("---Compact format to System.out---");
        format = OutputFormat.createCompactFormat();
        writer = new XMLWriter(System.out, format);
        writer.write(document);
        writer.close();
    }
}