package com.usian.entity;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

public class Emp {
    @Id
    private Integer id;
    private String eid;
    private String name;
    private Integer age;
    private Date birthday;
    @Transient
    private Date starttime;
    @Transient
    private Date endtime;

    public Emp() {
        super();
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", eid='" + eid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Emp(Integer id, String eid, String name, Integer age, Date birthday, Date starttime, Date endtime) {
        this.id = id;
        this.eid = eid;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.starttime = starttime;
        this.endtime = endtime;
    }
}
