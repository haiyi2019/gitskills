package com.kingstar.managementinfo.controller;

import com.kingstar.managementinfo.dao.entity.Classes;
import com.kingstar.managementinfo.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    @GetMapping("/query1")
    public List<Classes> findAll()
    {
        return classesService.findAll();
    }
}
