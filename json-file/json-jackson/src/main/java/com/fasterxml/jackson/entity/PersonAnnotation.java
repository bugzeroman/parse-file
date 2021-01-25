package com.fasterxml.jackson.entity;

import java.util.Date;

/**
 * 演示Jackson注解使用方法的Java Bean
 *
 */
// 用于过滤多个字段
// @JsonIgnoreProperties(value = { "birthday", "sex" })
public class PersonAnnotation {

    private String name = "bob";

    private Date birthday = new Date();

    private int sex = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    // 用于过滤单个字段
    // @JsonIgnore
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PersonAnnotation [name=" + name + ", birthday=" + birthday + ", sex=" + sex + "]";
    }
}
