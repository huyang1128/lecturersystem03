package com.huan.repository;

import com.huan.domain.Positions;
import com.huan.domain.PositionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 * @author ctsi-biyi-generator
*/
@Mapper
public interface PositionsRepository extends com.ctsi.ssdc.repository.BaseRepository<Positions, Integer, PositionsExample> {
    @Override
    long countByExample(PositionsExample example);

    @Override
    int deleteByExample(PositionsExample example);

    @Override
    int deleteByPrimaryKey(Integer pId);

    @Options(useGeneratedKeys=true, keyProperty="pId")
    @Override
    int insert(Positions record);

    @Options(useGeneratedKeys=true, keyProperty="pId")
    @Override
    int insertSelective(Positions record);

    @Override
    List<Positions> selectByExample(PositionsExample example);

    @Override
    Positions selectByPrimaryKey(Integer pId);

    @Override
    int updateByExampleSelective(@Param("record") Positions record, @Param("example") PositionsExample example);

    @Override
    int updateByExample(@Param("record") Positions record, @Param("example") PositionsExample example);

    @Override
    int updateByPrimaryKeySelective(Positions record);

    @Override
    int updateByPrimaryKey(Positions record);
}