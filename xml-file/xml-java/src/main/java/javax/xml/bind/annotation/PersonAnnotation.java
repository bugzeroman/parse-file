package javax.xml.bind.annotation;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 演示注解使用的类
 *
 */
@XmlRootElement(name = "human")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class PersonAnnotation {
    private int id;

    private String name;

    private String gender;

    private String addr;

    private Date birthDay;

    private List<Hobby> hobbies;

    private List<String> favourites;

    public PersonAnnotation() {
    }

    public PersonAnnotation(int id, String name, String gender, String addr, Date birthDay, List<Hobby> hobbies,
            List<String> favourites) {
        super();
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.addr = addr;
        this.birthDay = birthDay;
        this.hobbies = hobbies;
        this.favourites = favourites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    // @XmlElement等注解必须加到get方法上面，其中@XmlElement可选
    @XmlElementWrapper(name = "hobbiesWrapper")
    // @XmlElement
    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<String> favourites) {
        this.favourites = favourites;
    }

    @Override
    public String toString() {
        return "PersonAnnotation [id=" + id + ", name=" + name + ", gender=" + gender + ", addr=" + addr + ", birthDay="
                + birthDay + ", hobbies=" + hobbies + ", favourites=" + favourites + "]";
    }
}