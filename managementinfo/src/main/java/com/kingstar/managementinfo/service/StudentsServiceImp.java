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

@Service
public class StudentsServiceImp implements StudentsService {

    @Autowired
    StudentsDao studentsDao;

    private List<Students> list;
    @Override
    public Students save(Students students) {
        return studentsDao.save(students);
    }

    @Override
    public Students update(Students students) {

            return studentsDao.save(students);
    }

    @Override
    public void delete(int id) {
        studentsDao.deleteById(id);
    }

    @Override
    public Students findStudentsById(int id) {
        return studentsDao.findStudentsById(id);
    }

    @Override
    public List<Students> findStudentsByName(String name) {
        return studentsDao.findStudentsByName(name);
    }

    @Override
    public List<Students> findAll() {
        return studentsDao.findAll();
    }

    @Override
    public List<Students> findStudentsByClassId(Integer classId) {
        return studentsDao.findStudentsByClassId(classId);
    }

    @Override
    public Integer count() {
        return studentsDao.countAll();
    }

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
