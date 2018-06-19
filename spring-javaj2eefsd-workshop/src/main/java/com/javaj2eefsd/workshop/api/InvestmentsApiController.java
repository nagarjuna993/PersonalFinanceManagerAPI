package com.javaj2eefsd.workshop.api;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaj2eefsd.workshop.model.Investments;
import com.javaj2eefsd.workshop.service.InvestmentsService;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

@Controller
public class InvestmentsApiController implements InvestmentsApi {

    private static final Logger log = LoggerFactory.getLogger(InvestmentsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    InvestmentsService investmentsServiceImpl;

    @org.springframework.beans.factory.annotation.Autowired
    public InvestmentsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addInvestments(
    		@ApiParam(value = "Investments object that needs to be added to the store" ,required=true )  @Valid @RequestBody Investments body)
    		throws Exception {
    	
        final String accept = request.getHeader("Accept");
        
        if (accept != null && accept.contains("application/json")) {
            try {
            	investmentsServiceImpl.createInvestments(body);
            }
            catch (final IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        	return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteInvestments(
    		@ApiParam(value = "Investments id to delete",required=true) @PathVariable("investmentsId") String investmentsId)
    		throws Exception {
        
    	final String accept = request.getHeader("Accept");
        
        try {
        	investmentsServiceImpl.deleteInvestments(investmentsId);
        }
        catch (final IOException e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<Investments>> getInvestmentsByKey(
    		@ApiParam(value = "ID of investments to return",required=true) @PathVariable("investmentsKey") String investmentsKey)
    		throws Exception {
    	
        String accept = request.getHeader("Accept");
        List<Investments> investmentsList = null;
        
        if (accept != null && accept.contains("application/json")) {
        	try {
                Optional.ofNullable(investmentsKey).orElseThrow(() -> new IOException("search key is null"));
                investmentsList = investmentsServiceImpl.searchInvestments(investmentsKey);
            }
            catch (final IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        	return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }

        return new ResponseEntity<>(investmentsList, HttpStatus.OK);
    }

    public ResponseEntity<List<Investments>> getInvestmentsList() throws Exception {
        
    	String accept = request.getHeader("Accept");
        List<Investments> investmentsList = null;
        
        if (accept != null && accept.contains("application/json")) {
        	try {
        		//TODO: add user model instead of hard coding
                final String userId = "1";
                investmentsList = investmentsServiceImpl.getInvestmentsAll(userId);
                Optional.ofNullable(investmentsList)
                        .orElseThrow(() -> new InternalError("HttpStatusINTERNAL_SERVER_ERROR"));
            }
            catch (final IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        	return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }

        return new ResponseEntity<>(investmentsList, HttpStatus.OK);
    }

    public ResponseEntity<Void> updateInvestments(
    		@ApiParam(value = "Investments object that needs to be updated to the store" ,required=true )  @Valid @RequestBody Investments body)
    		throws Exception {
    	
        final String accept = request.getHeader("Accept");
        
        if (accept != null && accept.contains("application/json")) {
            try {
            	investmentsServiceImpl.updateInvestments(body);
            }
            catch (final IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        	return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
