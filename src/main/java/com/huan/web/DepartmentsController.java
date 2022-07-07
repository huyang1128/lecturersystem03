package com.huan.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.lang.Integer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.huan.service.DepartmentsService;
import com.huan.domain.Departments;

import com.ctsi.ssdc.exception.BadRequestAlertException;
import com.ctsi.ssdc.model.PageResult;
import com.ctsi.ssdc.util.HeaderUtil;
import com.ctsi.ssdc.util.ResponseUtil;


/**
 * REST controller for managing Departments.
 *
 * @author ctsi-biyi-generator
 *
 */
@Api(value = "/api",tags = {"departments-controller"})
@RestController
@RequestMapping("/api")
public class DepartmentsController {

    private final Logger log = LoggerFactory.getLogger(DepartmentsController.class);

    private static final String ENTITY_NAME = "departments";

    private final DepartmentsService departmentsService;

    public DepartmentsController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @InitBinder   
    public void initBinder(WebDataBinder binder) {   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
        dateFormat.setLenient(true);   
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    } 
   
    /**
     * POST  /departmentss : Create a new departments.
     *
     * @param departments the departments to create
     * @return the ResponseEntity with status 201 (Created) and with body the new departments,
     * or with status 400 (Bad Request) if the departments has already an dId
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body",dataType = "Departments",name = "departments",value = "the departments to create")
    })
    @ApiOperation(value = "POST  /departmentss : create a new departments.",
        notes = "POST  /departmentss : create a new departments.",httpMethod = "POST")
    @PostMapping("/departmentss")
    public ResponseEntity<Departments> createDepartments(@RequestBody Departments departments) throws URISyntaxException {
        log.debug("REST request to save Departments : {}", departments);
        if (departments.getDId() != null) {
            throw new BadRequestAlertException("A new departments cannot already have an dId", ENTITY_NAME, "idexists");
        }
        Departments result = departmentsService.insert(departments);
        return ResponseEntity.created(new URI("/api/departmentss" + "/" +result.getDId() ))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getDId().toString()))
            .body(result);
    }
	
    /**
     * PUT  /departmentss : Updates an existing departments.
     *
     * @param departments the departments to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated departments,
     * or with status 400 (Bad Request) if the departments is not valid,
     * or with status 500 (Internal Server Error) if the departments couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body",dataType = "Departments",
        name = "departments",value = "the departments to update")
    })
    @ApiOperation(value = "PUT  /departmentss : updates an existing departments.",
        notes = "PUT  /departmentss : updates an existing departments.",httpMethod = "PUT")
    @PutMapping("/departmentss")
    public ResponseEntity<Departments> updateDepartments(@RequestBody Departments departments) throws URISyntaxException {
        log.debug("REST request to update Departments : {}", departments);
	    if (departments.getDId() == null) {
	    	return createDepartments(departments);
	    }
        Departments result = departmentsService.update(departments);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, result.getDId().toString()))
            .body(result);
    }

    /**
     * GET  /departmentss/:dId : get the "dId" departments.
     *
     * @param dId the id of the departments to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the departments, or with status 404 (Not Found)
     */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path",dataType = "INTEGER",name = "dId",
        value = "the dId of the departments to retrieve")
    })
    @ApiOperation(value = "GET  /departmentss/dId : get the dId departments.",
        notes = "GET  /departmentss/dId : get the dId departments.",httpMethod = "GET")
    @GetMapping("/departmentss/{dId}")
    public ResponseEntity<Departments> getDepartments(@PathVariable Integer dId) {
        log.debug("REST request to get Departments : {}", dId);
        Departments departments = departmentsService.findOne(dId);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(departments));
    }

    /**
    * GET  /departmentss : get the departmentss firstStringBaseColumn.
    *
    * @return the ResponseEntity with status 200 (OK) and the list of departmentss in body
    */
    @ApiOperation(value = "GET  /departmentss : get the departmentss firstStringBaseColumn.",
                notes = "GET  /departmentss : get the departmentss firstStringBaseColumn.",httpMethod = "GET")
    @GetMapping("/departmentss")
    public PageResult<Departments> getDepartmentssList(String dName ,Pageable pageable) {
        log.debug("REST request to get DepartmentssList");
        return departmentsService.findFirstStringColumn(dName ,pageable);
    }
	
    /**
     * DELETE  /departmentss/:dId : delete the "dId" departments.
     *
     * @param dId the id of the departments to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path",dataType = "INTEGER",
            name = "dId",value = "the dId of the departments to delete")
    })
    @ApiOperation(value = "DELETE  /departmentss/dId : delete the dId departments.",
        notes = "DELETE  /departmentss/dId : delete the dId departments.",httpMethod = "DELETE")
    @DeleteMapping("/departmentss/{dId}")
    public ResponseEntity<Void> deleteDepartments(@PathVariable Integer dId) {
        log.debug("REST request to delete Departments : {}", dId);
        departmentsService.delete(dId);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, dId.toString())).build();
    }
    
}
