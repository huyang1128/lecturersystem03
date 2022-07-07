package com.huan.repository;

import com.huan.domain.Manager;
import com.huan.domain.ManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 * @author ctsi-biyi-generator
*/
@Mapper
public interface ManagerRepository extends com.ctsi.ssdc.repository.BaseRepository<Manager, Integer, ManagerExample> {
    @Override
    long countByExample(ManagerExample example);

    @Override
    int deleteByExample(ManagerExample example);

    @Override
    int deleteByPrimaryKey(Integer mId);

    @Options(useGeneratedKeys=true, keyProperty="mId")
    @Override
    int insert(Manager record);

    @Options(useGeneratedKeys=true, keyProperty="mId")
    @Override
    int insertSelective(Manager record);

    @Override
    List<Manager> selectByExample(ManagerExample example);

    @Override
    Manager selectByPrimaryKey(Integer mId);

    @Override
    int updateByExampleSelective(@Param("record") Manager record, @Param("example") ManagerExample example);

    @Override
    int updateByExample(@Param("record") Manager record, @Param("example") ManagerExample example);

    @Override
    int updateByPrimaryKeySelective(Manager record);

    @Override
    int updateByPrimaryKey(Manager record);
}