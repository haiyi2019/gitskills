package com.kingstar.managementinfo.service;

import com.kingstar.managementinfo.dao.entity.Classes;

import java.util.List;

public interface ClassesService {
    List<Classes> findAll();
    void deleteById(Integer id);
    Classes save(Classes classes);
    Classes update(Classes classes);
}
