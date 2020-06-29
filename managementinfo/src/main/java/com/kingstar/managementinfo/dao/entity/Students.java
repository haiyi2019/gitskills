package com.kingstar.managementinfo.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "Students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "classId")
    private Integer classId;
    @Column
    private Integer age;
    @Column
    private String sex;
    @Column(name = "className")
    private String className;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public Students() {
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

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }


    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classId=" + classId +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
