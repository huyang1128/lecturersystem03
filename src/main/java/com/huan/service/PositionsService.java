package com.huan.service;


import com.ctsi.ssdc.model.PageResult;
import org.springframework.data.domain.Pageable;

import com.huan.domain.Positions;
import com.huan.domain.PositionsExample;
import com.ctsi.ssdc.service.StrengthenBaseService;

/**
 * Service Interface for managing Positions.
 *
 * @author ctsi-biyi-generator
 *
 */
public interface PositionsService 
	extends StrengthenBaseService<Positions, Integer, PositionsExample>{


    /**
    * GET  /positionss : get the positionss firstStringBaseColumn.
    */
    PageResult<Positions> findFirstStringColumn(String pName ,Pageable pageable);

}
