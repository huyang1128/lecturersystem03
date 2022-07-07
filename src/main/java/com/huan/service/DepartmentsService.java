package com.huan.service;


import com.ctsi.ssdc.model.PageResult;
import org.springframework.data.domain.Pageable;

import com.huan.domain.Departments;
import com.huan.domain.DepartmentsExample;
import com.ctsi.ssdc.service.StrengthenBaseService;

/**
 * Service Interface for managing Departments.
 *
 * @author ctsi-biyi-generator
 *
 */
public interface DepartmentsService 
	extends StrengthenBaseService<Departments, Integer, DepartmentsExample>{


    /**
    * GET  /departmentss : get the departmentss firstStringBaseColumn.
    */
    PageResult<Departments> findFirstStringColumn(String dName ,Pageable pageable);

}
