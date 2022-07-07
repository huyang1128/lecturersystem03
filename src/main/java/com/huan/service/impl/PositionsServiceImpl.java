package com.huan.service.impl;


import org.springframework.stereotype.Service;
import org.apache.commons.collections.CollectionUtils;
import com.huan.domain.Positions;
import com.huan.domain.PositionsExample;
import com.huan.service.PositionsService;
import com.huan.repository.PositionsRepository;
import org.apache.commons.lang3.StringUtils;
import java.util.List;
import java.util.Objects;
import com.ctsi.ssdc.service.impl.StrengthenBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.ctsi.ssdc.model.PageResult;
import org.springframework.data.domain.Pageable;
import com.github.pagehelper.PageHelper;
/**
 * Service Implementation for managing Positions.
 *
 * @author ctsi-biyi-generator
 *
 */
@Service
public class PositionsServiceImpl 
	extends StrengthenBaseServiceImpl<PositionsRepository, Positions, Integer, PositionsExample> 
	implements PositionsService {

    @Autowired
    PositionsRepository positionsRepository;


    /**
    * GET  /positionss : get the positionss firstStringBaseColumn.
    */
    @Override
    public PageResult<Positions> findFirstStringColumn(String pName,Pageable pageable){
        String str = pName;
        if (Objects.nonNull(pageable)) {
            PageHelper.startPage(pageable.getPageNumber() + 1, pageable.getPageSize());
        }
        PositionsExample positionsExample = new PositionsExample();
        String orderBy = getPageOrderBy(pageable);
        if(StringUtils.isNotEmpty(orderBy)) {
            positionsExample.setOrderByClause(orderBy);
        }
        if (StringUtils.isEmpty(str)){
            positionsExample.createCriteria();
        } else{
            positionsExample.createCriteria().andPNameLike("%" + str +"%");
        }
        List<Positions>  data = positionsRepository.selectByExample(positionsExample);

        long count = 0L;
        if (CollectionUtils.isNotEmpty(data)){
            count = positionsRepository.countByExample(positionsExample);
        }
        return new PageResult<Positions>(data,count,count);
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
