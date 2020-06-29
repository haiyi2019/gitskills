package com.kingstar.managementinfo.service;

import com.kingstar.managementinfo.dao.StudentsDao;
import com.kingstar.managementinfo.dao.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImp implements StudentService{

    @Autowired
    StudentsDao studentsDao;
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
}
