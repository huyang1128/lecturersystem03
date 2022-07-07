package com.huan.repository;

import com.huan.domain.Departments;
import com.huan.domain.DepartmentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 * @author ctsi-biyi-generator
*/
@Mapper
public interface DepartmentsRepository extends com.ctsi.ssdc.repository.BaseRepository<Departments, Integer, DepartmentsExample> {
    @Override
    long countByExample(DepartmentsExample example);

    @Override
    int deleteByExample(DepartmentsExample example);

    @Override
    int deleteByPrimaryKey(Integer dId);

    @Options(useGeneratedKeys=true, keyProperty="dId")
    @Override
    int insert(Departments record);

    @Options(useGeneratedKeys=true, keyProperty="dId")
    @Override
    int insertSelective(Departments record);

    @Override
    List<Departments> selectByExample(DepartmentsExample example);

    @Override
    Departments selectByPrimaryKey(Integer dId);

    @Override
    int updateByExampleSelective(@Param("record") Departments record, @Param("example") DepartmentsExample example);

    @Override
    int updateByExample(@Param("record") Departments record, @Param("example") DepartmentsExample example);

    @Override
    int updateByPrimaryKeySelective(Departments record);

    @Override
    int updateByPrimaryKey(Departments record);
}