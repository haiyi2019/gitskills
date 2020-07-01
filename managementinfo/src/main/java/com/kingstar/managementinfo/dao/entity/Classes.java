package com.kingstar.managementinfo.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;

/**
 * @className: Classes
 * @description: 这是班级类，映射数据库对应classes表
 */
@Entity
@Table(name = "Classes")

@ApiIgnore
public class Classes {
    /**班级ID**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    /**班级名**/
    @Column(name="name")
    private String name;
    /**班主任**/
    @Column(name="mentor")
    private String mentor;
    /**学生人数**/
    @Column(name="stuNum")
    private int stuNum;

    /**
     * @description
     * @return 返回学生人数
     */
//    public int getStuNum() {
//        return stuNum;
//    }
//
//    /**
//     *
//     * @param stuNum
//     */
//    public void setStuNum(int stuNum) {
//        this.stuNum = stuNum;
//    }

    /**
     *
     * @return 返回班主任姓名
     */
    public String getMentor() {
        return mentor;
    }

    /**
     *
     * @param mentor
     */
    public void setMentor(String mentor) {
        this.mentor = mentor;
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
     * @description Classes类空参构造器
     */
    public Classes() {
        super();
    }


    /**
     *
     * @param id
     * @param name
     * @param mentor
     * @param stuNum
     */
    public Classes(int id, String name, String mentor,int stuNum) {
        this.id = id;
        this.name = name;
        this.mentor = mentor;
        this.stuNum=stuNum;
    }

    /**
     *
     * @return toString()方法
     */
    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mentor='" + mentor + '\'' +
                ", stuNum=" + stuNum +
                '}';
    }
}
