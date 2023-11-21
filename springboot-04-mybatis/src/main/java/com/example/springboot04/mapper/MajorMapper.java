package com.example.springboot04.mapper;

import com.example.springboot04.pojo.Major;
import org.apache.ibatis.annotations.Mapper;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2023/11/20 04:53
 */
@Mapper
public interface MajorMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);

}
