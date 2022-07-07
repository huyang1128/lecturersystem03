package com.huan.service;


import com.ctsi.ssdc.model.PageResult;
import org.springframework.data.domain.Pageable;

import com.huan.domain.Manager;
import com.huan.domain.ManagerExample;
import com.ctsi.ssdc.service.StrengthenBaseService;

/**
 * Service Interface for managing Manager.
 *
 * @author ctsi-biyi-generator
 *
 */
public interface ManagerService 
	extends StrengthenBaseService<Manager, Integer, ManagerExample>{


    /**
    * GET  /managers : get the managers firstStringBaseColumn.
    */
    PageResult<Manager> findFirstStringColumn(String mAccount ,Pageable pageable);

}
