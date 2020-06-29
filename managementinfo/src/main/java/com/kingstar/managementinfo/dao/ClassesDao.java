package com.kingstar.managementinfo.dao;

import com.kingstar.managementinfo.dao.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Repository
public interface ClassesDao extends JpaRepository<Classes,Integer> {
    Classes findClassesById(Integer id);
    void deleteById(Integer id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value="update classes c  set c.stu_num=(select count(*) from students s where s.class_id=c.id)",nativeQuery =true)
    void update();
}
