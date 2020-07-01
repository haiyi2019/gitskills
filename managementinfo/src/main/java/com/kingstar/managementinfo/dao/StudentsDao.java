package com.kingstar.managementinfo.dao;

import com.kingstar.managementinfo.dao.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
/**
 * @interfaceName: StudentsDao
 * @description: 这是学生类数据访问对象接口
 */
@Repository
public interface StudentsDao extends JpaRepository<Students,Integer> {

    /**
     *
     * @param id  学生id
     * @description 根据id 查询学生信息
     * @return  Students类对象
     */
    Students findStudentsById(int id);

    /**
     *
     * @param name 学生姓名
     * @description 根据学生姓名查询学生信息
     * @return  Students对象集合
     */
    @Query(value ="select stu from Students stu where stu.name=?1")
    List<Students> findStudentsByName(String name);

    /**
     *
     * @param id
     * @description 根据id 删除学生信息
     */
    void deleteById(int id);

    /**
     *
     * @param classId 班级id
     * @description 根据班级id查询学生信息
     * @return  Students对象集合
     */
    @Query(value="select stu from Students stu where stu.classId=?1")
    List<Students> findStudentsByClassId(Integer classId);

    /**
     * @description 查询数据表students中记录
     * @return  count
     */
    @Query(value="select count(stu) from Students stu")
    Integer countAll();

    /**
     * @description 查询数据表students所有信息
     * @return
     */
    @Query(value="select s.id,s.name,s.class_id,s.class_name,s.age,s.sex from students s",nativeQuery = true)
    List<Students> findAll();

    /**
     * @description 更新students数据表中字段class_name值，根据数据表classes中id和name确定students表中学生所在班级
     *
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true,value="update students s  set s.class_name=(select c.name from classes c where c.id=s.class_id)")
    void update();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true,value="update students s set s.class_name=(select c.name from classes c where c.id=?1) where s.id=?2")
    void update(Integer class_id,Integer id);
}
