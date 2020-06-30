package com.kingstar.managementinfo;

import com.kingstar.managementinfo.dao.entity.Students;
import com.kingstar.managementinfo.service.StudentsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.PublicKey;
import java.util.List;

@SpringBootTest
public class TestStudentsServices {
    @Autowired
    private StudentsService studentsService;

    /**
     * @description 测试添加一条信息
     */
    @Test
    public void testSave(){
        Students students = new Students(13, "lisi", 3, 23, "男", "");
        Students stu = studentsService.save(students);
        System.out.println(stu);
    }

    /**
     * @description 更新一条信息
     */
    @Test
    public void testUpdate(){
        Students students = new Students(13, "wangwu", 3, 23, "男", "");
        studentsService.update(students);
    }

    /**
     *@description 删除一条信息
     */
    @Test
    public void testDelete(){
        studentsService.delete(13);
    }
    /**
     * @description 按id方式查询一条信息
     */
    @Test
    public void testFindStudentsById(){
        Students stu = studentsService.findStudentsById(1);
        System.out.println(stu);
    }
    /**
     *@description 按name方式查询信息
     */
    @Test
    public void testFindStudentsByName(){
        List<Students> all = studentsService.findStudentsByName("aa");
        System.out.println(all);
    }

    /**
     * @description 按页方式查询信息
     */
    @Test
    public void testFindAll(){
        List<Students> all = studentsService.findAll(1, 8);
        System.out.println(all);
    }
    /**
     * @description 按班级id方式查询信息
     */
    @Test
    public void testFindStudentsByClassId(){
        List<Students> all = studentsService.findStudentsByClassId(2);
        System.out.println(all);
    }

    /**
     * @description 测试count(*)
     */
    @Test
    public void testCount(){
        Integer count = studentsService.count();
        System.out.println(count);
    }
}
