package com.kingstar.managementinfo.dao;

import com.kingstar.managementinfo.dao.entity.Classes;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

/**
 * @interfaceName: ClassesDao
 * @description: 这是班级类数据访问对象接口
 */
@Repository
public interface ClassesDao extends JpaRepository<Classes,Integer> {

    /**
     *
     * @param id 班级id
     * @description 根据id,查询班级信息
     * @return  Classes对象
     */
    Classes findClassesById(Integer id);

    /**
     *
     * @param id 班级id
     * @description 根据id,删除班级信息
     */
    void deleteById(Integer id);

    /**
     * @description 更新classes数据表中字段stu_num值，根据数据表students人数确定classes各个班级人数
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value="update classes c  set c.stu_num=(select count(*) from students s where s.class_id=c.id)",nativeQuery =true)
    void update();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value="update classes c  set c.stu_num=(select count(*) from students s where s.class_id=c.id) where c.id=?1",nativeQuery =true)
    void update(Integer id);
    /**
     *
     * @return 返回当前classes数据表中多少条记录
     */
    @Query("select count(c) from Classes  c")
    Integer countAll();
}
