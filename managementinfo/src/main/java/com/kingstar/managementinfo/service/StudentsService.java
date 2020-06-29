package com.kingstar.managementinfo.service;

import com.kingstar.managementinfo.dao.entity.Students;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentsService {
    Students save(Students students);
    Students update(Students students);
    void delete(int id);
    Students findStudentsById(int id);
    List<Students> findStudentsByName(String name);
    List<Students>  findAll(Integer page, int pageSize);
    List<Students> findAll();
    List<Students> findStudentsByClassId(Integer classId);
    Integer count();
}
