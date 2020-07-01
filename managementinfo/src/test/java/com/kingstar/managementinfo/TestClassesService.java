package com.kingstar.managementinfo;

import com.kingstar.managementinfo.dao.entity.Classes;
import com.kingstar.managementinfo.service.ClassesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description ClassesService 接口测试类
 * @author :haiyi_zq
 */
@SpringBootTest
public class TestClassesService {
    @Autowired
    private ClassesService classesService;

    /**
     * @description 测试按页查询
     */
    @Test
    public void testFindAll(){
        List<Classes> all = classesService.findAll(1, 8);
        System.out.println(all);
    }

    /**
     * @description 测试按ID删除
     */
    @Test
    public void testDeleteById(){
        classesService.deleteById(6);
    }

    /**
     * @description 测试添加一条信息
     */
    @Test
    public void testSave(){
        Classes classes = new Classes(6, "电气工程", "LTeacher", 0);
        classesService.save(classes);

    }

    /**
     * @description 测试更新
     */
    @Test
    public void  testUpdate(){
        Classes classes = new Classes(6, "电气工程", "NTeacher", 0);
       classesService.update(classes);
    }

    /**
     * @description测试按班级查询
     */
    @Test
    public void testFindClassesById(){
        classesService.findClassesById(1);
    }

    /**
     * @description
     */
    @Test
    public void testCount(){
        Integer count = classesService.count();
        System.out.println(count);
    }
}
