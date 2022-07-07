package com.huan.web;

import com.ctsi.ssdc.exception.BadRequestAlertException;
import com.ctsi.ssdc.model.PageResult;
import com.ctsi.ssdc.util.HeaderUtil;
import com.ctsi.ssdc.util.ResponseUtil;
import com.huan.domain.Manager;
import com.huan.service.ManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;


/**
 * REST controller for managing Manager.
 *
 * @author ctsi-biyi-generator
 *
 */
@Api(value = "/api",tags = {"manager-controller"})
@RestController
@RequestMapping("/api")
public class ManagerController {

    private final Logger log = LoggerFactory.getLogger(ManagerController.class);

    private static final String ENTITY_NAME = "manager";

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @InitBinder   
    public void initBinder(WebDataBinder binder) {   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
        dateFormat.setLenient(true);   
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    } 
   
    /**
     * POST  /managers : Create a new manager.
     *
     * @param manager the manager to create
     * @return the ResponseEntity with status 201 (Created) and with body the new manager,
     * or with status 400 (Bad Request) if the manager has already an mId
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body",dataType = "Manager",name = "manager",value = "the manager to create")
    })
    @ApiOperation(value = "POST  /managers : create a new manager.",
        notes = "POST  /managers : create a new manager.",httpMethod = "POST")
    @PostMapping("/managers")
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) throws URISyntaxException {
        log.debug("REST request to save Manager : {}", manager);
        if (manager.getMId() != null) {
            throw new BadRequestAlertException("A new manager cannot already have an mId", ENTITY_NAME, "idexists");
        }
        Manager result = managerService.insert(manager);
        return ResponseEntity.created(new URI("/api/managers" + "/" +result.getMId() ))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getMId().toString()))
            .body(result);
    }
	
    /**
     * PUT  /managers : Updates an existing manager.
     *
     * @param manager the manager to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated manager,
     * or with status 400 (Bad Request) if the manager is not valid,
     * or with status 500 (Internal Server Error) if the manager couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body",dataType = "Manager",
        name = "manager",value = "the manager to update")
    })
    @ApiOperation(value = "PUT  /managers : updates an existing manager.",
        notes = "PUT  /managers : updates an existing manager.",httpMethod = "PUT")
    @PutMapping("/managers")
    public ResponseEntity<Manager> updateManager(@RequestBody Manager manager) throws URISyntaxException {
        log.debug("REST request to update Manager : {}", manager);
	    if (manager.getMId() == null) {
	    	return createManager(manager);
	    }
        Manager result = managerService.update(manager);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, result.getMId().toString()))
            .body(result);
    }

    /**
     * GET  /managers/:mId : get the "mId" manager.
     *
     * @param mId the id of the manager to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the manager, or with status 404 (Not Found)
     */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path",dataType = "INTEGER",name = "mId",
        value = "the mId of the manager to retrieve")
    })
    @ApiOperation(value = "GET  /managers/mId : get the mId manager.",
        notes = "GET  /managers/mId : get the mId manager.",httpMethod = "GET")
    @GetMapping("/managers/{mId}")
    public ResponseEntity<Manager> getManager(@PathVariable Integer mId) {
        log.debug("REST request to get Manager : {}", mId);
        Manager manager = managerService.findOne(mId);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(manager));
    }

    /**
    * GET  /managers : get the managers firstStringBaseColumn.
    *
    * @return the ResponseEntity with status 200 (OK) and the list of managers in body
    */
    @ApiOperation(value = "GET  /managers : get the managers firstStringBaseColumn.",
                notes = "GET  /managers : get the managers firstStringBaseColumn.",httpMethod = "GET")
    @GetMapping("/managers")
    public PageResult<Manager> getManagersList(String mAccount ,Pageable pageable) {
        log.debug("REST request to get ManagersList");
        return managerService.findFirstStringColumn(mAccount ,pageable);
    }
	
    /**
     * DELETE  /managers/:mId : delete the "mId" manager.
     *
     * @param mId the id of the manager to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path",dataType = "INTEGER",
            name = "mId",value = "the mId of the manager to delete")
    })
    @ApiOperation(value = "DELETE  /managers/mId : delete the mId manager.",
        notes = "DELETE  /managers/mId : delete the mId manager.",httpMethod = "DELETE")
    @DeleteMapping("/managers/{mId}")
    public ResponseEntity<Void> deleteManager(@PathVariable Integer mId) {
        log.debug("REST request to delete Manager : {}", mId);
        managerService.delete(mId);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, mId.toString())).build();
    }
    
}
