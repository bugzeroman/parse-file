package javax.xml.bind.annotation;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXB;

/**
 * 使用JAXB的静态方法（推荐），增加了更多高级注解的使用
 *
 */
public class JAXBAnnotationParseXML {
    public static final String FILE_NAME = "src/main/resources/PersonAnnotation.xml";

    public static void main(String[] args) throws Exception {
        generateXML();
        generateBean();
    }

    /**
     * 通过实体对象直接生成XML
     */
    public static void generateXML() throws Exception {
        PersonAnnotation person = generatePerson();
        File file = new File(FILE_NAME);
        JAXB.marshal(person, file);
        System.out.println("generateXML=" + file.getAbsolutePath());
    }

    public static PersonAnnotation generatePerson() {
        int id = 1;
        String name = "yuwen";
        String gender = "male";
        String addr = "changzhou";

        Calendar calendar = Calendar.getInstance();
        calendar.set(1989, Calendar.JUNE, 30);
        Date birthDay = calendar.getTime();
        List<Hobby> hobbies = new ArrayList<>(2);
        hobbies.add(new Hobby("read"));
        hobbies.add(new Hobby("running"));
        List<String> favourites = new ArrayList<>(2);
        favourites.add("apple");
        favourites.add("game");
        PersonAnnotation person = new PersonAnnotation(id, name, gender, addr, birthDay, hobbies, favourites);
        return person;
    }

    /**
     * 把XML直接解析成对应的实体类实例
     */
    public static void generateBean() throws Exception {
        File file = new File(FILE_NAME);
        PersonAnnotation PersonAnnotation = JAXB.unmarshal(file, PersonAnnotation.class);
        System.out.println(PersonAnnotation);
    }
}
