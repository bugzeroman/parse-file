package javax.xml.bind.annotation;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 指定XML转换时的日期格式
 *
 */
public class DateAdapter extends XmlAdapter<String, Date> {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date unmarshal(String date) throws Exception {
        return SDF.parse(date);
    }

    @Override
    public String marshal(Date date) throws Exception {
        return SDF.format(date);
    }
}