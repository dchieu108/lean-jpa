package com.vn.devmaster.services.repositiory;

import com.vn.devmaster.services.entites.Student;
import com.vn.devmaster.services.projection.IStudentPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepositiory  extends JpaRepository<Student,Integer>{
    // tìm kiếm sinh viên theo địa chỉ
    @Query(value = "select s from Student s where s.address like concat('%',:address,'%') ")
    List<Student> findByAddress(@Param("address") String address);

     //tìm sinh viên có điểm cao nhất
//    @Query(value = "SELECT s FROM Student s WHERE s.point = (SELECT MAX(point) FROM Student)")
//    List<Student> findByPoint(@Param("point") String point);


    // tìm sinh viên có điểm bé hơn 5
//    @Query(value = "SELECT s FROM Student s WHERE s.point < ?5 ")
//    List<Student> findByPoint1(  String point);
    List<Student> findAllByAddress(String address);
    @Query(value = "SELECT concat(s.last_name,'',s.first_name)as name,\n" +
            "       s.address        address,\n" +
            "       c.name           clazzName,\n" +
            "       s2.name          subjectName,\n" +
            "       ss.point         point\n" +
            "FROM student s\n" +
            "    left join clazz c on s.clazz_id=c.id\n" +
            "    left join student_subject ss on c.id = ss.id_student\n" +
            "    left join subject s2 on s2.id = ss.id_student\n" +
            "where s.id =:id", nativeQuery = true)
    List<IStudentPoint> findStudentById(@Param("id") int id);
}
