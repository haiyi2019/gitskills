package com.kingstar.managementinfo;

import com.kingstar.managementinfo.dao.ClassesDao;
import com.kingstar.managementinfo.dao.entity.Classes;
import com.kingstar.managementinfo.service.ClassesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description ClassDAO测试类
 *
 */
@SpringBootTest
public class TestClassDAO {

    @Autowired
    private ClassesDao classesDao;

    /**
     * @description 测试按班级ID查询
     */
    @Test
    public void testFindClassesById(){
        Classes result = classesDao.findClassesById(1);
        System.out.println(result);
    }

    /**
     * @description 测试按ID删除
     */
    @Test
    public void testDeleteById(){
        classesDao.deleteById(7);
    }

    /**
     * @description 测试更新
     */
    @Test
    public void testUpdate(){
        classesDao.update();
    }

    /**
     * @description 测试查询count(*)
     */
    @Test
    public void testCountAll(){
        Integer count = classesDao.countAll();
        System.out.println(count);
    }
}
