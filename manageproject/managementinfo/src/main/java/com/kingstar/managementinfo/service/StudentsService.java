package com.kingstar.managementinfo.service;

import com.kingstar.managementinfo.dao.entity.Students;

import java.util.List;

public interface StudentService {
    Students save(Students students);
    Students update(Students students);
    void delete(int id);
    Students findStudentsById(int id);
    List<Students> findStudentsByName(String name);
}
