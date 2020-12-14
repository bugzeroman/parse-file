package org.jdom2.input;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.w3c.dom.Book;

/**
 * 用JDOM方式解析xml文件
 */
public class JdomParseXML {

    public static void main(String[] args) throws Exception {
        String fileName = "src/main/resources/books.xml";
        List<Book> books = getBooks(fileName);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static List<Book> getBooks(String fileName) throws Exception {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(new FileInputStream(fileName));
        // 获取根节点bookstore
        Element bookstore = document.getRootElement();
        // 获取根节点的子节点，返回子节点的数组
        List<Element> bookElements = bookstore.getChildren();
        List<Book> books = new ArrayList<Book>();
        for (Element bookElement : bookElements) {
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
        List<Attribute> bookAttributes = bookElement.getAttributes();
        for (Attribute attribute : bookAttributes) {
            if (attribute.getName().equals("id")) {
                String id = attribute.getValue();
                book.setId(Integer.parseInt(id));
            }
        }
        return book;
    }

    public static void generateBookDetail(Element bookElement, Book book) {
        // 获取Book标签下的其它标签的值
        List<Element> children = bookElement.getChildren();
        for (Element child : children) {
            String nodeName = child.getName();
            String nodeValue = child.getValue();
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