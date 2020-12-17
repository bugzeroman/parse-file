package javax.xml.bind.annotation;

/**
 * 一个人可以有多个兴趣爱好
 *
 */

@XmlRootElement(name = "hobby")
public class Hobby {

    private String hoobyName;

    public Hobby() {
    }

    public Hobby(String hoobyName) {
        super();
        this.hoobyName = hoobyName;
    }

    // @XmlElement必须加到get方法上面，或者不加也行
    @XmlElement
    public String getHoobyName() {
        return hoobyName;
    }

    public void setHoobyName(String hoobyName) {
        this.hoobyName = hoobyName;
    }

    @Override
    public String toString() {
        return "Hobby [hoobyName=" + hoobyName + "]";
    }
}
