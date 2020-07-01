package com.kingstar.managementinfo.service;

import com.kingstar.managementinfo.dao.entity.Classes;

import java.util.List;

/**
 * @interfaceName: ClassesServices
 * @description: 这是班级类数据处理接口
 */
public interface ClassesService {
    /**
     * @description 按页查询
     * @param page 页码
     * @param pagesize 当前页最大显示多少条信息记录
     * @return Classes类的集合
     */
    List<Classes> findAll(Integer page,Integer pagesize);

    /**
     * @description 按班级id删除班级信息
     * @param id
     */
    void deleteById(Integer id);

    /**
     *
     * @param classes
     * 所添加信息记录
     */
    void save(Classes classes);

    /**
     *
     * @param classes
     *  所更新信息记录
     */
    void update(Classes classes);

    /**
     *
     * @param id
     * @return 所查询信息记录
     */
    Classes findClassesById(Integer id);

    /**
     *
     * @return 当前数据表记录数
     */
    Integer count();
}
