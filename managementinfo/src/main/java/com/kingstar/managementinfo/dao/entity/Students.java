package com.kingstar.managementinfo.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;

/**
 * @className: Students
 * @description: 这是学生类，映射数据库对应students数据表
 */
@Entity
@Table(name = "Students")

public class Students {
    /**学生ID**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    /**学生姓名**/
    @Column(name = "name")
    private String name;
    /**班级ID**/
    @Column(name = "classId")
    private Integer classId;
    /**年龄**/
    @Column
    private Integer age;
    /**性别**/
    @Column
    private String sex;
    /**班级名**/
    @Column(name = "className")
    private String className;

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param classId
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     *
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     *
     * @return className
     */
    public String getClassName() {
        return className;
    }

    /**
     *
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     *
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }



    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return classId
     */
    public int getClassId() {
        return classId;
    }

    /**
     *
     * @param classId
     */
    public void setClassId(int classId) {
        this.classId = classId;
    }

    /**
     * @description Stduents空参构造器
     */
    public Students() {
    }

    /**
     *
     * @param id
     * @param name
     * @param classId
     * @param age
     * @param sex
     * @param className
     */
    public Students(Integer id, String name, Integer classId, Integer age, String sex, String className) {
        this.id = id;
        this.name = name;
        this.classId = classId;
        this.age = age;
        this.sex = sex;
        this.className = className;
    }

    /**
     *
     * @return toString()
     */
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
