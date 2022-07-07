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
import com.huan.service.PositionsService;
import com.huan.domain.Positions;

import com.ctsi.ssdc.exception.BadRequestAlertException;
import com.ctsi.ssdc.model.PageResult;
import com.ctsi.ssdc.util.HeaderUtil;
import com.ctsi.ssdc.util.ResponseUtil;


/**
 * REST controller for managing Positions.
 *
 * @author ctsi-biyi-generator
 *
 */
@Api(value = "/api",tags = {"positions-controller"})
@RestController
@RequestMapping("/api")
public class PositionsController {

    private final Logger log = LoggerFactory.getLogger(PositionsController.class);

    private static final String ENTITY_NAME = "positions";

    private final PositionsService positionsService;

    public PositionsController(PositionsService positionsService) {
        this.positionsService = positionsService;
    }

    @InitBinder   
    public void initBinder(WebDataBinder binder) {   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
        dateFormat.setLenient(true);   
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    } 
   
    /**
     * POST  /positionss : Create a new positions.
     *
     * @param positions the positions to create
     * @return the ResponseEntity with status 201 (Created) and with body the new positions,
     * or with status 400 (Bad Request) if the positions has already an pId
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body",dataType = "Positions",name = "positions",value = "the positions to create")
    })
    @ApiOperation(value = "POST  /positionss : create a new positions.",
        notes = "POST  /positionss : create a new positions.",httpMethod = "POST")
    @PostMapping("/positionss")
    public ResponseEntity<Positions> createPositions(@RequestBody Positions positions) throws URISyntaxException {
        log.debug("REST request to save Positions : {}", positions);
        if (positions.getPId() != null) {
            throw new BadRequestAlertException("A new positions cannot already have an pId", ENTITY_NAME, "idexists");
        }
        Positions result = positionsService.insert(positions);
        return ResponseEntity.created(new URI("/api/positionss" + "/" +result.getPId() ))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getPId().toString()))
            .body(result);
    }
	
    /**
     * PUT  /positionss : Updates an existing positions.
     *
     * @param positions the positions to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated positions,
     * or with status 400 (Bad Request) if the positions is not valid,
     * or with status 500 (Internal Server Error) if the positions couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body",dataType = "Positions",
        name = "positions",value = "the positions to update")
    })
    @ApiOperation(value = "PUT  /positionss : updates an existing positions.",
        notes = "PUT  /positionss : updates an existing positions.",httpMethod = "PUT")
    @PutMapping("/positionss")
    public ResponseEntity<Positions> updatePositions(@RequestBody Positions positions) throws URISyntaxException {
        log.debug("REST request to update Positions : {}", positions);
	    if (positions.getPId() == null) {
	    	return createPositions(positions);
	    }
        Positions result = positionsService.update(positions);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, result.getPId().toString()))
            .body(result);
    }

    /**
     * GET  /positionss/:pId : get the "pId" positions.
     *
     * @param pId the id of the positions to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the positions, or with status 404 (Not Found)
     */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path",dataType = "INTEGER",name = "pId",
        value = "the pId of the positions to retrieve")
    })
    @ApiOperation(value = "GET  /positionss/pId : get the pId positions.",
        notes = "GET  /positionss/pId : get the pId positions.",httpMethod = "GET")
    @GetMapping("/positionss/{pId}")
    public ResponseEntity<Positions> getPositions(@PathVariable Integer pId) {
        log.debug("REST request to get Positions : {}", pId);
        Positions positions = positionsService.findOne(pId);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(positions));
    }

    /**
    * GET  /positionss : get the positionss firstStringBaseColumn.
    *
    * @return the ResponseEntity with status 200 (OK) and the list of positionss in body
    */
    @ApiOperation(value = "GET  /positionss : get the positionss firstStringBaseColumn.",
                notes = "GET  /positionss : get the positionss firstStringBaseColumn.",httpMethod = "GET")
    @GetMapping("/positionss")
    public PageResult<Positions> getPositionssList(String pName ,Pageable pageable) {
        log.debug("REST request to get PositionssList");
        return positionsService.findFirstStringColumn(pName ,pageable);
    }
	
    /**
     * DELETE  /positionss/:pId : delete the "pId" positions.
     *
     * @param pId the id of the positions to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path",dataType = "INTEGER",
            name = "pId",value = "the pId of the positions to delete")
    })
    @ApiOperation(value = "DELETE  /positionss/pId : delete the pId positions.",
        notes = "DELETE  /positionss/pId : delete the pId positions.",httpMethod = "DELETE")
    @DeleteMapping("/positionss/{pId}")
    public ResponseEntity<Void> deletePositions(@PathVariable Integer pId) {
        log.debug("REST request to delete Positions : {}", pId);
        positionsService.delete(pId);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, pId.toString())).build();
    }
    
}
