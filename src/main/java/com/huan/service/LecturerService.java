package com.huan.service;


import com.ctsi.ssdc.model.PageResult;
import org.springframework.data.domain.Pageable;

import com.huan.domain.Lecturer;
import com.huan.domain.LecturerExample;
import com.ctsi.ssdc.service.StrengthenBaseService;

/**
 * Service Interface for managing Lecturer.
 *
 * @author ctsi-biyi-generator
 *
 */
public interface LecturerService 
	extends StrengthenBaseService<Lecturer, Integer, LecturerExample>{


    /**
    * GET  /lecturers : get the lecturers firstStringBaseColumn.
    */
    PageResult<Lecturer> findFirstStringColumn(String lecName ,Pageable pageable);

}
