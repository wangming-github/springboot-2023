package com.example.springboot04.mapper;

import com.example.springboot04.pojo.Major;
import com.example.springboot04.pojo.Student;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2023/11/20 04:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentDaoTest {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private MajorMapper majorMapper;

    @Resource
    private DataSource dataSource;


    @Before
    public void before() throws SQLException {
        System.out.println("数据源:" + dataSource.getConnection());
    }


    @Test
    public void findAllTest() {
        List<Student> all = studentMapper.selectAll();
        all.forEach(System.out::println);
    }

    @Test
    public void insert() {
        Major major = new Major();
        major.setMname("计算机科学与技术");
        System.out.println((majorMapper.insert(major) == 1 ? "major插入成功" : "major插入失败"));

        Student student = new Student();
        student.setBirthday(new Date());
        student.setName("张三");
        student.setPhonenum("123123123");
        student.setMid(1);
        System.out.println((studentMapper.insert(student) == 1 ? "student插入成功" : "student插入失败"));
    }

    @Test
    public void delete() {
        int count = studentMapper.deleteByPrimaryKey(8L);
        System.out.println((count == 1 ? "删除成功" : "删除失败"));
    }

    @Test
    public void testUpdate() {

        Student student = new Student();
        student.setId(6);
        student.setBirthday(new Date());
        student.setName("张三丰");
        student.setPhonenum("123123123");
        student.setMid(11);
        int count = studentMapper.updateByPrimaryKey(student);
        System.out.println((count == 1 ? "更新成功" : "更新失败"));
    }


}