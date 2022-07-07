package com.huan.service.impl;


import org.springframework.stereotype.Service;
import org.apache.commons.collections.CollectionUtils;
import com.huan.domain.Lecturer;
import com.huan.domain.LecturerExample;
import com.huan.service.LecturerService;
import com.huan.repository.LecturerRepository;
import org.apache.commons.lang3.StringUtils;
import java.util.List;
import java.util.Objects;
import com.ctsi.ssdc.service.impl.StrengthenBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.ctsi.ssdc.model.PageResult;
import org.springframework.data.domain.Pageable;
import com.github.pagehelper.PageHelper;
/**
 * Service Implementation for managing Lecturer.
 *
 * @author ctsi-biyi-generator
 *
 */
@Service
public class LecturerServiceImpl 
	extends StrengthenBaseServiceImpl<LecturerRepository, Lecturer, Integer, LecturerExample> 
	implements LecturerService {

    @Autowired
    LecturerRepository lecturerRepository;


    /**
    * GET  /lecturers : get the lecturers firstStringBaseColumn.
    */
    @Override
    public PageResult<Lecturer> findFirstStringColumn(String lecName,Pageable pageable){
        String str = lecName;
        if (Objects.nonNull(pageable)) {
            PageHelper.startPage(pageable.getPageNumber() + 1, pageable.getPageSize());
        }
        LecturerExample lecturerExample = new LecturerExample();
        String orderBy = getPageOrderBy(pageable);
        if(StringUtils.isNotEmpty(orderBy)) {
            lecturerExample.setOrderByClause(orderBy);
        }
        if (StringUtils.isEmpty(str)){
            lecturerExample.createCriteria();
        } else{
            lecturerExample.createCriteria().andLecNameLike("%" + str +"%");
        }
        List<Lecturer>  data = lecturerRepository.selectByExample(lecturerExample);

        long count = 0L;
        if (CollectionUtils.isNotEmpty(data)){
            count = lecturerRepository.countByExample(lecturerExample);
        }
        return new PageResult<Lecturer>(data,count,count);
    }
    private String getPageOrderBy(Pageable page) {
        if(page!= null && page.getSort() != null) {
            StringBuilder sb = new StringBuilder();
            page.getSort().forEach(sort -> sb.append(sort.getProperty())
            .append(" ").append(sort.getDirection()).append(","));
            if(sb.length() > 1) {
                return (sb.substring(0,sb.length()-1));
             }
        }
        return null;
    }
}
