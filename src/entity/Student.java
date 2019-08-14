package entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private int age;
    private Address address;

    @DateTimeFormat(pattern="yyyy-MM-dd") // 格式化：前台传递来的数据，将前台传递来的数据固定位yyyy-MM-dd
    private Date birthday;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
