package com.huan.repository;

import com.huan.domain.Lecturer;
import com.huan.domain.LecturerExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 * @author ctsi-biyi-generator
*/
@Mapper
public interface LecturerRepository extends com.ctsi.ssdc.repository.BaseRepository<Lecturer, Integer, LecturerExample> {
    @Override
    long countByExample(LecturerExample example);

    @Override
    int deleteByExample(LecturerExample example);

    @Override
    int deleteByPrimaryKey(Integer lecId);

    @Options(useGeneratedKeys=true, keyProperty="lecId")
    @Override
    int insert(Lecturer record);

    @Options(useGeneratedKeys=true, keyProperty="lecId")
    @Override
    int insertSelective(Lecturer record);

    @Override
    List<Lecturer> selectByExample(LecturerExample example);

    @Override
    Lecturer selectByPrimaryKey(Integer lecId);

    @Override
    int updateByExampleSelective(@Param("record") Lecturer record, @Param("example") LecturerExample example);

    @Override
    int updateByExample(@Param("record") Lecturer record, @Param("example") LecturerExample example);

    @Override
    int updateByPrimaryKeySelective(Lecturer record);

    @Override
    int updateByPrimaryKey(Lecturer record);
}