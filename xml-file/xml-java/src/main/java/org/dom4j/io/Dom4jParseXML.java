package org.dom4j.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.w3c.dom.Book;

/**
 * 用DOM4J方式解析XML文件
 *
 */
public class Dom4jParseXML {

    public static void main(String[] args) throws Exception {
        String fileName = "src/main/resources/books.xml";
        List<Book> books = getBooks(fileName);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static List<Book> getBooks(String fileName) throws Exception {
        SAXReader reader = new SAXReader();
        File file = new File(fileName);
        Document document = reader.read(file);

        Element bookstore = document.getRootElement();
        Iterator<Element> bookElements = bookstore.elementIterator();

        List<Book> books = new ArrayList<Book>();
        while (bookElements.hasNext()) {
            Element bookElement = bookElements.next();
            // 获取Book的id属性值
            Book book = getBookByElement(bookElement);
            // 获取Book的name等其他元素的属性值
            generateBookDetail(bookElement, book);

            books.add(book);
        }
        return books;
    }

    public static Book getBookByElement(Element bookElement) {
        Book book = new Book();
        // 遍历bookElement的属性,获取id属性的值
        List<Attribute> attributes = bookElement.attributes();
        for (Attribute attribute : attributes) {
            if (attribute.getName().equals("id")) {
                String id = attribute.getValue();
                book.setId(Integer.parseInt(id));
            }
        }
        return book;
    }

    public static void generateBookDetail(Element bookElement, Book book) {
        // 获取Book标签下的请他标签的值
        Iterator<Element> details = bookElement.elementIterator();
        while (details.hasNext()) {
            Element child = details.next();
            String nodeName = child.getName();
            String nodeValue = child.getStringValue();
            if (nodeName.equals("name")) {
                book.setName(nodeValue);
            } else if (nodeName.equals("author")) {
                book.setAuthor(nodeValue);
            } else if (nodeName.equals("year")) {
                book.setYear(Integer.parseInt(nodeValue));
            } else if (nodeName.equals("price")) {
                book.setPrice(Double.parseDouble(nodeValue));
            }
        }
    }
}