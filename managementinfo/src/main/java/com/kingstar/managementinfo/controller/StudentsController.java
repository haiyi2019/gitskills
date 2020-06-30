package com.kingstar.managementinfo.controller;

import com.kingstar.managementinfo.dao.entity.Students;
import com.kingstar.managementinfo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;


    @PostMapping("/add")
    public void save(Students students)
    {

        studentsService.save(students);
    }

    @PostMapping("/update")
    public Students update(Students students)
    {
        return studentsService.update(students);
    }

    @PostMapping("del/{id}")
    public String delete(@PathVariable int id)
    {

        studentsService.delete(id);
        return "delete success!";
    }
    @GetMapping("/findByName")
    public List<Students> findStudentsByName(String name)
    {
        return studentsService.findStudentsByName(name);
    }
    @GetMapping("findById")
    public String findStudentById(int id)
    {
        Students stu = studentsService.findStudentsById(id);
        if(stu!=null)
            return stu.toString();
        return "未查到此人！";
    }

    @GetMapping("findByClassId")
    public String findStudentsByClassId(Integer classId)
    {
        System.out.println(classId);
        List<Students> studentsList = studentsService.findStudentsByClassId(classId);
        if(studentsList!=null)
            return studentsList.toString();
        return "未查到！";
    }
//
//    @GetMapping("/query1")
//    public List<Students> findByPage(Integer page, HttpServletResponse response)
//    {
//        response.setHeader("Access-Control-Allow-Origin","*");
//        if(page==null ||page<=0)
//        {
//            page=0;
//        }else
//        {
//            page=1;
//        }
//        return studentsService.findAll(page,2);
//    }
    @GetMapping("/query")
    public List<Students> findByPage(Integer page)
    {
        return studentsService.findAll(page,8);
    }
//    @GetMapping("/query")
//    public List<Students> findAll()
//    {
//        return studentsService.findAll();
//    }
    @GetMapping("/count")
    public Integer count(){
        return studentsService.count();
    }
 }
