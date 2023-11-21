package com.example.springboot03.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot03.entity.TestUser;

/**
 * 直接继承BaseMapper
 * 可以省略xml的编写
 * 当然也可以通过xml自定义sq|查询。不要忘记写自定义方法就好
 * <p>
 * 自定义 Mapper 接口，就是 dao 接口
 * 1. 实现BaseMapper
 * 2. 指定实体类（泛型）
 * <p>
 * BaseMapper 是 mybatisplus 框架中的对象，定义了 17 个操作方法（CRUD）
 *
 * @version 1.0
 * @author: MaiZi
 * @date: 2023/11/20 01:01
 */

public interface UserMapper extends BaseMapper<TestUser> {
}
