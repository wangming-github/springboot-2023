package com.example.springboot03.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.springboot03.entity.TestUser;
import com.example.springboot03.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <==    Columns: id, username, age, tel, create_time, update_time, version
 * <==        Row: 1, 张三, 18, 180, null, null, null
 * <==        Row: 2, 李四, 20, 137, null, null, null
 * <==        Row: 3, 王五, 22, 138, null, null, null
 * <p>
 * MySQL语句执行顺序
 * 1、from
 * 2、where (or 最后执行)
 * 3、group by
 * 4、having
 * 5、DISTINCT
 * 6、order by
 * 7、limit
 *
 * @version 1.0
 * @author: MaiZi
 * @date: 2023/11/20 01:51
 */
@Service
public class Service_条件查询 {


    @Resource
    private UserMapper userMapper;


    public List<TestUser> 查询所有() {
        return userMapper.selectList(null);
    }

    /**
     * 条件用 Map 进行封装
     * “name” -> “张三”
     * “age” -> 20
     */
    public void 条件用Map进行封装() {
        // 封装条件
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("username", "张三");
        hashMap.put("age", 18);
        //查询
        QueryWrapper<TestUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(hashMap);
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    /**
     * eq("列名", 值) -> 列名 = 值
     */
    public void 条件用列名等于值() {
        QueryWrapper<TestUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "张三");
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    /**
     * eq("列名", 值) -> 列名 = 值
     * ne("列名", 值) -> 列名 != 值
     * gt("age", 20) -> age > 20
     * ge("age", 20) -> age >= 20
     * lt("age", 20) -> age < 20
     * le("age", 21) -> age <= 21
     */
    public void 条件用列名不等于OR大于小于小于等于等() {
        LambdaQueryWrapper<TestUser> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.eq(TestUser::getAge, 18);
        //        lambdaQueryWrapper.ne(User_::getAge, 18);
        //        lambdaQueryWrapper.gt(User_::getAge, 18);
        //        lambdaQueryWrapper.ge(User_::getAge, 18);
        //        lambdaQueryWrapper.lt(User_::getAge, 18);
        //        lambdaQueryWrapper.le(User_::getAge, 18);
        userMapper.selectList(lambdaQueryWrapper).forEach(System.out::println);
    }


    /**
     * between("age", 18, 25) -> age BETWEEN 18 AND 25 ，年龄在18到25之间
     * notBetween就是不在18到25之间
     */
    public void 条件用年龄在或不在18到25之间() {
        LambdaQueryWrapper<TestUser> wrapper = Wrappers.lambdaQuery();
        wrapper.between(TestUser::getAge, 18, 25);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }


    /**
     * like 匹配值 -> "%值%" 模糊查询
     * notLike 模糊查询不匹配"%值%"
     */
    public void 模糊查询like或notLike() {
        LambdaQueryWrapper<TestUser> wrapper = Wrappers.lambdaQuery();
        wrapper.like(TestUser::getUsername, "张");
//        wrapper.notLike(User_::getUsername, "张");
        userMapper.selectList(wrapper).forEach(System.out::println);
    }


    public void 模糊查询左边界匹配或右边界匹配() {
        LambdaQueryWrapper<TestUser> wrapper = Wrappers.lambdaQuery();
        wrapper.likeLeft(TestUser::getUsername, "张");
//        wrapper.likeRight(User_::getUsername, "张");
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    public void 空值查询或非空值查询() {
        LambdaQueryWrapper<TestUser> wrapper = Wrappers.lambdaQuery();
        wrapper.isNull(TestUser::getUsername);
//        wrapper.isNotNull(User_::getUsername);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    /**
     * in
     * in("name", "张三", "李四") -> name in ("张三", "李四") 姓名是张三或李四的用户
     * <p>
     * notIn
     * notIn("name", "张三", "李四") -> name not in ("张三", "李四") 姓名不是张三或
     */
    public void 姓名是张三或李四的用户或者姓名不是张三或李四的用户() {
        LambdaQueryWrapper<TestUser> wrapper = Wrappers.lambdaQuery();
        wrapper.in(TestUser::getUsername, "张三", "李四");
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    /**
     * inSql、notInSql
     * SELECT id,username,age,tel,create_time,update_time,version FROM user_test1 WHERE (age IN (select age from user_test1 where id = 1))
     */
    public void 在SQL语句的查询结果中进行查询() {
        LambdaQueryWrapper<TestUser> wrapper = Wrappers.lambdaQuery();
        wrapper.inSql(TestUser::getAge, "select age from user_test1 where id = 1");
        userMapper.selectList(wrapper).forEach(System.out::println);
    }


    public void 分组() {
        LambdaQueryWrapper<TestUser> wrapper = Wrappers.lambdaQuery();
        wrapper.groupBy(TestUser::getUsername);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    //    orderBy、orderByAsc、orderByDesc
    public void 排序() {
        LambdaQueryWrapper<TestUser> wrapper = Wrappers.lambdaQuery();

        // 是否必须， 是否正序，列名
        // ORDER BY age DESC,username ASC
        wrapper.orderBy(true, false, TestUser::getAge)
                .orderBy(true, true, TestUser::getUsername);
        //ORDER BY username ASC,age ASC
//        wrapper.orderByAsc(User_::getUsername, User_::getAge);
        // ORDER BY username DESC,age DESC
//        wrapper.orderByDesc(User_::getUsername, User_::getAge);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }


    public void 或者OR并且() {

        LambdaQueryWrapper<TestUser> queryWrapper = new LambdaQueryWrapper<>();

        // 示例1
        // WHERE (username = ? AND (id = ?))
        queryWrapper.eq(TestUser::getUsername, "张三");
        queryWrapper.and((tmpWrapper) -> tmpWrapper.eq(TestUser::getId, 1));

        // 示例2
        // WHERE (username = ? OR id = ?)
        queryWrapper.eq(TestUser::getUsername, "张三").or().eq(TestUser::getId, 1);

        // 示例3
        // WHERE (id <> 1 AND (tel = 180 OR tel = 184))
        queryWrapper.ne(TestUser::getId, 1);
        queryWrapper.and((tmpWrapper) -> tmpWrapper.eq(TestUser::getTel, 180).or().eq(TestUser::getTel, 184));
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }


    public void 存在或者不存在() {
        LambdaQueryWrapper<TestUser> wrapper = new LambdaQueryWrapper<>();

        // 存在
        // WHERE (EXISTS (select age from user_test1 where id = 1))
        wrapper.exists("select age from user_test1 where id = 1");

        // 不存在
        // WHERE (NOT EXISTS (select age from user_test1 where id = 1))
        wrapper.notExists("select age from user_test1 where id = 1");
        userMapper.selectList(wrapper).forEach(System.out::println);
    }
}
