package javax.xml.bind;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
    private int id;

    private String name;

    private String gender;

    private String addr;

    public Person() {
    }

    public Person(String name, String gender, String addr) {
        this.name = name;
        this.gender = gender;
        this.addr = addr;
    }

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    @XmlElement
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddr() {
        return addr;
    }

    @XmlElement
    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", gender=" + gender + ", addr=" + addr + "]";
    }
}
