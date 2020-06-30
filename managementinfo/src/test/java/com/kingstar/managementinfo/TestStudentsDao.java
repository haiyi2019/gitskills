package com.kingstar.managementinfo;

import com.kingstar.managementinfo.dao.StudentsDao;
import com.kingstar.managementinfo.dao.entity.Students;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description StudentsDAO接口测试类
 */
@SpringBootTest
public class TestStudentsDao {
    @Autowired
    StudentsDao studentsDao;

    /**
     * @description 测试按id方式查询
     */
    @Test
    public void testFindStudentsById(){
        Students stu = studentsDao.findStudentsById(1);
        System.out.println(stu);
    }
    /**
     * @description 测试按name方式查询
     */
    @Test
    public void testFindStudentsByName(){
        List<Students> stuList = studentsDao.findStudentsByName("hhb");
        System.out.println(stuList);
    }

    /**
     * @description 测试按id方式删除
     */
    @Test
    public void testDeleteById(){
        studentsDao.deleteById(12);
    }
    /**
     * @description 测试按classId方式查询
     */
    @Test
    public void testFindStudentsByClassId(){
        List<Students> stu = studentsDao.findStudentsByClassId(1);
        System.out.println(stu);
    }
    /**
     * @description 测试count(*)
     */
    @Test
    public void testCountAll(){
        Integer count = studentsDao.countAll();
        System.out.println(count);
    }
    /**
     * @description 测试查询所有信息
     */
    @Test
    public void testFindAll(){
        List<Students> all = studentsDao.findAll();
        System.out.println(all);
    }

    /**
     * @description 测试更新class_name字段属性值
     */
    @Test
    public void testUpdate(){
        studentsDao.update();
    }
}
