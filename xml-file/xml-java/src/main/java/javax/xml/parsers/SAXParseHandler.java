package javax.xml.parsers;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 用SAX方式解析XML文件时需要的handler
 */
public class SAXParseHandler extends DefaultHandler {
    // 存放解析到的book数组
    private List<Book> books;
    // 存放当前解析的book
    private Book book;
    // 存放当前节点值
    private String content = null;

    /**
     * 开始解析XML文件时调用此方法
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("开始解析XML文件");
        books = new ArrayList<Book>();
    }

    /** 
     * 完成解析XML文件时调用此方法
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("完成解析XML文件");
    }

    /**
     * 开始解析节点时调用此方法
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        super.startElement(uri, localName, qName, attributes);

        // 当节点名为book时,获取book的属性id
        if (qName.equals("book")) {
            book = new Book();
            String id = attributes.getValue("id");
            book.setId(Integer.parseInt(id));
        }

    }

    /**
     *完成解析节点时调用此方法
     *
     *@param qName 节点名
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        super.endElement(uri, localName, qName);
        if (qName.equals("name")) {
            book.setName(content);
        } else if (qName.equals("author")) {
            book.setAuthor(content);
        } else if (qName.equals("year")) {
            book.setYear(Integer.parseInt(content));
        } else if (qName.equals("price")) {
            book.setPrice(Double.parseDouble(content));
        } else if (qName.equals("book")) {
            // 当结束当前book解析时,将该book添加到数组后置为空，方便下一次book赋值
            books.add(book);
            book = null;
        }
    }

    /** 
     * 此方法用来获取节点的值
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        super.characters(ch, start, length);
        // 将节点的内容保存到content,以便在完成解析节点时调用此方法,
        // 根据节点名称把content赋给Book的相应字段
        content = new String(ch, start, length);
    }

    public List<Book> getBooks() {
        return books;
    }
}