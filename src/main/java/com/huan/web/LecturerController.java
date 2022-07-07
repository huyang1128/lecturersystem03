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
import com.huan.service.LecturerService;
import com.huan.domain.Lecturer;

import com.ctsi.ssdc.exception.BadRequestAlertException;
import com.ctsi.ssdc.model.PageResult;
import com.ctsi.ssdc.util.HeaderUtil;
import com.ctsi.ssdc.util.ResponseUtil;


/**
 * REST controller for managing Lecturer.
 *
 * @author ctsi-biyi-generator
 *
 */
@Api(value = "/api",tags = {"lecturer-controller"})
@RestController
@RequestMapping("/api")
public class LecturerController {

    private final Logger log = LoggerFactory.getLogger(LecturerController.class);

    private static final String ENTITY_NAME = "lecturer";

    private final LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @InitBinder   
    public void initBinder(WebDataBinder binder) {   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
        dateFormat.setLenient(true);   
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    } 
   
    /**
     * POST  /lecturers : Create a new lecturer.
     *
     * @param lecturer the lecturer to create
     * @return the ResponseEntity with status 201 (Created) and with body the new lecturer,
     * or with status 400 (Bad Request) if the lecturer has already an lecId
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body",dataType = "Lecturer",name = "lecturer",value = "the lecturer to create")
    })
    @ApiOperation(value = "POST  /lecturers : create a new lecturer.",
        notes = "POST  /lecturers : create a new lecturer.",httpMethod = "POST")
    @PostMapping("/lecturers")
    public ResponseEntity<Lecturer> createLecturer(@RequestBody Lecturer lecturer) throws URISyntaxException {
        log.debug("REST request to save Lecturer : {}", lecturer);
        if (lecturer.getLecId() != null) {
            throw new BadRequestAlertException("A new lecturer cannot already have an lecId", ENTITY_NAME, "idexists");
        }
        Lecturer result = lecturerService.insert(lecturer);
        return ResponseEntity.created(new URI("/api/lecturers" + "/" +result.getLecId() ))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getLecId().toString()))
            .body(result);
    }
	
    /**
     * PUT  /lecturers : Updates an existing lecturer.
     *
     * @param lecturer the lecturer to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated lecturer,
     * or with status 400 (Bad Request) if the lecturer is not valid,
     * or with status 500 (Internal Server Error) if the lecturer couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body",dataType = "Lecturer",
        name = "lecturer",value = "the lecturer to update")
    })
    @ApiOperation(value = "PUT  /lecturers : updates an existing lecturer.",
        notes = "PUT  /lecturers : updates an existing lecturer.",httpMethod = "PUT")
    @PutMapping("/lecturers")
    public ResponseEntity<Lecturer> updateLecturer(@RequestBody Lecturer lecturer) throws URISyntaxException {
        log.debug("REST request to update Lecturer : {}", lecturer);
	    if (lecturer.getLecId() == null) {
	    	return createLecturer(lecturer);
	    }
        Lecturer result = lecturerService.update(lecturer);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, result.getLecId().toString()))
            .body(result);
    }

    /**
     * GET  /lecturers/:lecId : get the "lecId" lecturer.
     *
     * @param lecId the id of the lecturer to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the lecturer, or with status 404 (Not Found)
     */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path",dataType = "INTEGER",name = "lecId",
        value = "the lecId of the lecturer to retrieve")
    })
    @ApiOperation(value = "GET  /lecturers/lecId : get the lecId lecturer.",
        notes = "GET  /lecturers/lecId : get the lecId lecturer.",httpMethod = "GET")
    @GetMapping("/lecturers/{lecId}")
    public ResponseEntity<Lecturer> getLecturer(@PathVariable Integer lecId) {
        log.debug("REST request to get Lecturer : {}", lecId);
        Lecturer lecturer = lecturerService.findOne(lecId);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(lecturer));
    }

    /**
    * GET  /lecturers : get the lecturers firstStringBaseColumn.
    *
    * @return the ResponseEntity with status 200 (OK) and the list of lecturers in body
    */
    @ApiOperation(value = "GET  /lecturers : get the lecturers firstStringBaseColumn.",
                notes = "GET  /lecturers : get the lecturers firstStringBaseColumn.",httpMethod = "GET")
    @GetMapping("/lecturers")
    public PageResult<Lecturer> getLecturersList(String lecName ,Pageable pageable) {
        log.debug("REST request to get LecturersList");
        return lecturerService.findFirstStringColumn(lecName ,pageable);
    }
	
    /**
     * DELETE  /lecturers/:lecId : delete the "lecId" lecturer.
     *
     * @param lecId the id of the lecturer to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path",dataType = "INTEGER",
            name = "lecId",value = "the lecId of the lecturer to delete")
    })
    @ApiOperation(value = "DELETE  /lecturers/lecId : delete the lecId lecturer.",
        notes = "DELETE  /lecturers/lecId : delete the lecId lecturer.",httpMethod = "DELETE")
    @DeleteMapping("/lecturers/{lecId}")
    public ResponseEntity<Void> deleteLecturer(@PathVariable Integer lecId) {
        log.debug("REST request to delete Lecturer : {}", lecId);
        lecturerService.delete(lecId);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, lecId.toString())).build();
    }
    
}
