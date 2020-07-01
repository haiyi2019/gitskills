package com.kingstar.managementinfo.service;

import com.kingstar.managementinfo.dao.ClassesDao;
import com.kingstar.managementinfo.dao.entity.Classes;
import com.kingstar.managementinfo.dao.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @className ClassServiceImp
 * @description  班级数据处理实现接口类
 * @author :haiyi_zq
 */
@Service
public class ClassServiceImp implements ClassesService {
    /**申明Classes数据访问对象接口**/
    @Autowired
    ClassesDao classesDao;
    /**Classes集合**/
    private List<Classes> list;

    /**
     *
     * @param page 页码
     * @param pagesize 当前页最大显示多少条信息记录
     * @return  List<Classes>
     */
    @Override
    public List<Classes> findAll(Integer page,Integer pagesize) {
        classesDao.update();
        List<Classes> all = classesDao.findAll();
        if(all.size()<=pagesize)
        {
            return all;
        }
        else
        {
            list=new ArrayList<Classes>();
            for(int i=(page-1)*pagesize;i<Math.min(all.size(),page*pagesize);i++)
            {
                list.add(all.get(i));
            }
            return list;
        }
    }

    /**
     *
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        classesDao.deleteById(id);
    }

    /**
     *
     * @param classes
     * 所添加数据信息
     */
    @Override
    public void save(Classes classes) {
        classesDao.save(classes);
        classesDao.update(classes.getId());
    }

    /**
     *
     * @param classes
     * 所更新数据信息
     */
    @Override
    public void update(Classes classes) {
        classesDao.save(classes);
        classesDao.update(classes.getId());
    }

    /**
     *
     * @param id
     * 所查询数据信息
     */
    @Override
    public Classes findClassesById(Integer id) {
        return classesDao.findClassesById(id);
    }

    /**
     *
     * @return 当前班级查询数据信息
     */
    @Override
    public Integer count() {
        return classesDao.countAll();
    }
}
