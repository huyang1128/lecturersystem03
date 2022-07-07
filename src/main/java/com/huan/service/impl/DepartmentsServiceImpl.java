package com.huan.service.impl;


import org.springframework.stereotype.Service;
import org.apache.commons.collections.CollectionUtils;
import com.huan.domain.Departments;
import com.huan.domain.DepartmentsExample;
import com.huan.service.DepartmentsService;
import com.huan.repository.DepartmentsRepository;
import org.apache.commons.lang3.StringUtils;
import java.util.List;
import java.util.Objects;
import com.ctsi.ssdc.service.impl.StrengthenBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.ctsi.ssdc.model.PageResult;
import org.springframework.data.domain.Pageable;
import com.github.pagehelper.PageHelper;
/**
 * Service Implementation for managing Departments.
 *
 * @author ctsi-biyi-generator
 *
 */
@Service
public class DepartmentsServiceImpl 
	extends StrengthenBaseServiceImpl<DepartmentsRepository, Departments, Integer, DepartmentsExample> 
	implements DepartmentsService {

    @Autowired
    DepartmentsRepository departmentsRepository;


    /**
    * GET  /departmentss : get the departmentss firstStringBaseColumn.
    */
    @Override
    public PageResult<Departments> findFirstStringColumn(String dName,Pageable pageable){
        String str = dName;
        if (Objects.nonNull(pageable)) {
            PageHelper.startPage(pageable.getPageNumber() + 1, pageable.getPageSize());
        }
        DepartmentsExample departmentsExample = new DepartmentsExample();
        String orderBy = getPageOrderBy(pageable);
        if(StringUtils.isNotEmpty(orderBy)) {
            departmentsExample.setOrderByClause(orderBy);
        }
        if (StringUtils.isEmpty(str)){
            departmentsExample.createCriteria();
        } else{
            departmentsExample.createCriteria().andDNameLike("%" + str +"%");
        }
        List<Departments>  data = departmentsRepository.selectByExample(departmentsExample);

        long count = 0L;
        if (CollectionUtils.isNotEmpty(data)){
            count = departmentsRepository.countByExample(departmentsExample);
        }
        return new PageResult<Departments>(data,count,count);
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
