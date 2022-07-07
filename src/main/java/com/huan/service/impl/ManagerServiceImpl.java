package com.huan.service.impl;


import org.springframework.stereotype.Service;
import org.apache.commons.collections.CollectionUtils;
import com.huan.domain.Manager;
import com.huan.domain.ManagerExample;
import com.huan.service.ManagerService;
import com.huan.repository.ManagerRepository;
import org.apache.commons.lang3.StringUtils;
import java.util.List;
import java.util.Objects;
import com.ctsi.ssdc.service.impl.StrengthenBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.ctsi.ssdc.model.PageResult;
import org.springframework.data.domain.Pageable;
import com.github.pagehelper.PageHelper;
/**
 * Service Implementation for managing Manager.
 *
 * @author ctsi-biyi-generator
 *
 */
@Service
public class ManagerServiceImpl 
	extends StrengthenBaseServiceImpl<ManagerRepository, Manager, Integer, ManagerExample> 
	implements ManagerService {

    @Autowired
    ManagerRepository managerRepository;


    /**
    * GET  /managers : get the managers firstStringBaseColumn.
    */
    @Override
    public PageResult<Manager> findFirstStringColumn(String mAccount,Pageable pageable){
        String str = mAccount;
        if (Objects.nonNull(pageable)) {
            PageHelper.startPage(pageable.getPageNumber() + 1, pageable.getPageSize());
        }
        ManagerExample managerExample = new ManagerExample();
        String orderBy = getPageOrderBy(pageable);
        if(StringUtils.isNotEmpty(orderBy)) {
            managerExample.setOrderByClause(orderBy);
        }
        if (StringUtils.isEmpty(str)){
            managerExample.createCriteria();
        } else{
            managerExample.createCriteria().andMAccountLike("%" + str +"%");
        }
        List<Manager>  data = managerRepository.selectByExample(managerExample);

        long count = 0L;
        if (CollectionUtils.isNotEmpty(data)){
            count = managerRepository.countByExample(managerExample);
        }
        return new PageResult<Manager>(data,count,count);
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
