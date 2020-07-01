package com.kingstar.managementinfo.service;

import com.kingstar.managementinfo.dao.entity.Students;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @interfaceName: StudentsServices
 * @description: 这是学生类数据处理接口
 */
public interface StudentsService {
    /**
     *
     * @param students
     * 所添加的学生信息
     */
    void save(Students students);

    /**
     *
     * @param students
     * 所更新的学生信息
     */
    void update(Students students);
    /**
     *
     * @param id
     */
    void delete(int id);

    /**
     *
     * @param id
     * @return 根据id所查询的学生信息
     */
    Students findStudentsById(int id);

    /**
     *
     * @param name
     * @return 根据name所查询的学生信息
     */
    List<Students> findStudentsByName(String name);

    /**
     * @description 按页查询
     * @param page 页码
     * @param pageSize 当前页最大显示多少条信息记录
     * @return List<Students>
     */
    List<Students>  findAll(Integer page, int pageSize);

    /**
     * @description 查询所有信息
     * @return List<Students>
     */
    List<Students> findAll();

    /**
     *
     * @param classId
     * @return List<Students>
     */
    List<Students> findStudentsByClassId(Integer classId);

    /**
     *
     * @return 当前查询学生数据信息
     */
    Integer count();

}
