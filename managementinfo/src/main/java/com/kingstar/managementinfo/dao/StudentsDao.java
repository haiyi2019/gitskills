package com.kingstar.managementinfo.dao;

import com.kingstar.managementinfo.dao.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface StudentsDao extends JpaRepository<Students,Integer> {

//    @Query(name="findStudentsById",nativeQuery = true,value="select * from students where id=?")
    Students findStudentsById(int id);

    @Query(value ="select stu from Students stu where stu.name=?1")
    List<Students> findStudentsByName(String name);

    void deleteById(int id);

    @Query(value="select stu from Students stu where stu.classId=?1")
    List<Students> findStudentsByClassId(Integer classId);

    @Query(value="select count(stu) from Students stu")
    Integer countAll();

    @Query(value="select s.id,s.name,s.class_id,s.class_name,s.age,s.sex from students s",nativeQuery = true)
    List<Students> findAll();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true,value="update students s  set s.class_name=(select c.name from classes c where c.id=s.class_id)")
    void update();
}
