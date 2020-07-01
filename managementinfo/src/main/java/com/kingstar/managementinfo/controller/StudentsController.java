package com.kingstar.managementinfo.controller;

import com.kingstar.managementinfo.dao.entity.Students;
import com.kingstar.managementinfo.service.StudentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * @className StudentsController
 * @description controller层
 * @author :haiyi_zq
 */
@Api(tags = "学生管理相关接口",value = "提供用户相关的Rest API")
@RestController
@RequestMapping("/s")
public class StudentsController {
    /**申明Students类数据处理对象接口**/
    @Autowired
    private StudentsService studentsService;

    /**
     * @description 添加一条数据
     * @param students
     */
    @ApiOperation("新增一条信息接口")
    @PostMapping("/add")
    public void add(Students students)
    {
        studentsService.save(students);
    }
    /**
     * @description 删除一条数据
     * @param id
     * @return String
     */
    @ApiOperation("删除一条信息接口")
    @DeleteMapping("del/{id}")
    public String delete(@PathVariable int id)
    {

        studentsService.delete(id);
        return "delete success!";
    }

    /**
     * @description 更新一条数据
     * @param students

     */
    @ApiOperation("更新一条信息接口")
    @PutMapping("/update")
    public void update(Students students)
    {
         studentsService.update(students);
    }

    /**
     * @description 根据学生id查询学生信息
     * @param id
     * @return String
     */
    @ApiOperation("根据Id查询信息接口")
    @GetMapping("findById")
    public String findStudentById(int id)
    {
        Students stu = studentsService.findStudentsById(id);
        if(stu!=null)
            return stu.toString();
        return "未查到此人！";
    }
    /**
     * @descripton 根据学生姓名查询学生信息
     * @param name
     * @return List<Students>
     */
    @ApiOperation("根据学生姓名查询信息接口")
    @GetMapping("/findByName")
    public List<Students> findStudentsByName(String name)
    {
        return studentsService.findStudentsByName(name);
    }

    /**
     * @descripton 根据班级id查询学生信息
     * @param classId
     * @return String
     */
    @ApiOperation("根据班级Id查询信息接口")
    @GetMapping("findByClassId")
    public String findStudentsByClassId(Integer classId)
    {
        System.out.println(classId);
        List<Students> studentsList = studentsService.findStudentsByClassId(classId);
        if(studentsList!=null)
            return studentsList.toString();
        return "未查到！";
    }

    /**
     * @description 按页查询
     * @param page 当前页码
     * @return
     */
    @ApiOperation("按页查询信息接口")
    @GetMapping("/query")
    public List<Students> findByPage(int page,int pageSize)
    {

        return studentsService.findAll(page,pageSize);
    }

    /**
     * @description 查询数据表记录数
     * @return int
     */
    @ApiOperation("查询数据表记录数接口")
    @GetMapping("/count")
    public Integer count(){
        return studentsService.count();
    }
 }
