package com.kingstar.managementinfo.controller;

import com.kingstar.managementinfo.dao.entity.Classes;
import com.kingstar.managementinfo.dao.entity.Students;
import com.kingstar.managementinfo.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    @PostMapping("/add1")
    public  Classes add(Classes classes){
        return  classesService.save(classes);
    }

    @PostMapping("/update1")
    public Classes update(Classes classes){
        return classesService.save(classes);
    }

    @PostMapping("del1/{id}")
    public String delete(@PathVariable int id)
    {
        classesService.deleteById(id);
        return "delete success!";
    }
    @GetMapping("findById1")
    public String findClassesById(int id)
    {
        Classes classes = classesService.findClassesById(id);
        if(classes!=null)
            return classes.toString();
        return "未查到班级！";
    }
    @GetMapping("/query1")
    public List<Classes> findAll()
    {
        return classesService.findAll();
    }


}
