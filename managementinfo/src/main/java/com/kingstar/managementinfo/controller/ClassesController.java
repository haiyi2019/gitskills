package com.kingstar.managementinfo.controller;

import com.kingstar.managementinfo.dao.entity.Classes;
import com.kingstar.managementinfo.dao.entity.Students;
import com.kingstar.managementinfo.service.ClassesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @className ClassesController
 * @description controller层
 * @author :haiyi_zq
 */
@Api(tags = "班级管理相关接口",value = "提供用户相关的Rest API")
@RestController
@RequestMapping("/c")
public class ClassesController {
    /**申明Classes类数据处理对象接口**/
    @Autowired
    private ClassesService classesService;

    /**
     * @description 给classes数据表添加一条数据
     * @param classes
     */
    @ApiOperation("新增班级接口")
    @PostMapping("/add")
    public  void add(Classes classes){
         classesService.save(classes);
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
        classesService.deleteById(id);
        System.out.println(id);
        return "delete success!";
    }

    /**
     * @description 更新一条数据
     * @param classes

     */
    @ApiOperation("更新一条信息接口")
    @PutMapping("/update")
    public void update(Classes classes){

        classesService.save(classes);
    }

    /**
     * @description 所查询班级数据信息
     * @param id
     * @return String
     */
    @ApiOperation("按ID查询一条信息接口")
    @GetMapping("findById")
    public String findClassesById(int id)
    {
        Classes classes = classesService.findClassesById(id);
        if(classes!=null)
            return classes.toString();
        return "未查到班级！";
    }

    /**
     * @description 按页查询
     * @param page 当前页码
     * @return List<Classes>
     */
    @ApiOperation("按页查询信息接口")
    @GetMapping("/query")
    public List<Classes> findAll(int page,int pageSize)
    {
        return classesService.findAll(page,pageSize);
    }

    /**
     * @description 查询数据表记录数
     * @return int
     */
    @ApiOperation("查询所有记录数接口")
    @GetMapping("/count")
    public  Integer count(){
        return classesService.count();
    }
}
