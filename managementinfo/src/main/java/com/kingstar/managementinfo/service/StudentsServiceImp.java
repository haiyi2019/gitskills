package com.kingstar.managementinfo.service;

import com.kingstar.managementinfo.dao.StudentsDao;
import com.kingstar.managementinfo.dao.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @className StudentsServiceImp
 * @description  学生数据处理实现接口类
 * @author :haiyi_zq
 */
@Service
public class StudentsServiceImp implements StudentsService {

    /**申明Students数据访问对象接口**/
    @Autowired
    StudentsDao studentsDao;

    /**申明List<Students>**/
    private List<Students> list;

    /**
     * 所添加学生信息
     * @param students
     */
    @Override
    public void save(Students students) {
        studentsDao.save(students);
        studentsDao.update(students.getClassId(), students.getId());

    }

    /**
     *
     * @param students
     * 所更新的学生信息
     */
    @Override
    public void update(Students students) {
        studentsDao.save(students);
        studentsDao.update(students.getClassId(), students.getId());
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        studentsDao.deleteById(id);
    }

    /**
     *
     * @param id
     * @return Students
     */
    @Override
    public Students findStudentsById(int id) {
        return studentsDao.findStudentsById(id);
    }

    /**
     *
     * @param name 学生姓名
     * @return List<Students>
     */
    @Override
    public List<Students> findStudentsByName(String name) {
        return studentsDao.findStudentsByName(name);
    }

    /**
     *
     * @return List<Students>
     */
    @Override
    public List<Students> findAll() {
        return studentsDao.findAll();
    }

    /**
     *
     * @param classId
     * @return List<Students>
     */
    @Override
    public List<Students> findStudentsByClassId(Integer classId) {
        return studentsDao.findStudentsByClassId(classId);
    }

    /**
     *
     * @return 当前学生信息表记录数
     */
    @Override
    public Integer count() {
        return studentsDao.countAll();
    }

    /**
     *
     * @param page 页码
     * @param pageSize 当前页最大显示多少条信息记录
     * @return List<Students>
     */
    @Override
    public List<Students> findAll(Integer page, int pageSize) {
        studentsDao.update();
        List<Students> all = studentsDao.findAll();
        if(all.size()<=pageSize)
        {
            return all;
        }
        else
        {
            list=new ArrayList<Students>();
            for(int i=(page-1)*pageSize;i<Math.min(all.size(),page*pageSize);i++)
            {
                list.add(all.get(i));
            }
            return list;
        }
    }

}
