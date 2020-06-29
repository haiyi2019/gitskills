package com.kingstar.managementinfo.service;

import com.kingstar.managementinfo.dao.ClassesDao;
import com.kingstar.managementinfo.dao.entity.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImp implements ClassesService {
    @Autowired
    ClassesDao classesDao;
    @Override
    public List<Classes> findAll() {

        classesDao.update();
        return classesDao.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        classesDao.deleteById(id);
    }

    @Override
    public Classes save(Classes classes) {
        return classesDao.save(classes);
    }

    @Override
    public Classes update(Classes classes) {
        return classesDao.save(classes);
    }
}
