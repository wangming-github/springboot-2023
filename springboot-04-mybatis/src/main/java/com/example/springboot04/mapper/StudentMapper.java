package com.example.springboot04.mapper;

import com.example.springboot04.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author maizi
 * @description 针对表【student】的数据库操作Mapper
 * @createDate 2023-11-20 04:50:48
 * @Entity com.example.springboot04.domain.Student
 */
@Mapper
public interface StudentMapper {


    //查询所有学生信息
    List<Student> selectAll();

    //根据主键删除学生信息
    int deleteByPrimaryKey(Long id);

    //插入学生信息
    int insert(Student record);

    //插入选择性学生信息
    int insertSelective(Student record);

    //根据主键查询学生信息
    Student selectByPrimaryKey(Long id);

    //根据主键选择性更新学生信息
    int updateByPrimaryKeySelective(Student record);

    //根据主键更新学生信息
    int updateByPrimaryKey(Student record);


}
