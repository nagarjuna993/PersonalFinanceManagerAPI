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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaj2eefsd.workshop.model.Income;
import com.javaj2eefsd.workshop.service.IncomeService;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

@Controller
@CrossOrigin(origins = { "*" })
public class IncomeApiController implements IncomeApi {

    private static final Logger log = LoggerFactory.getLogger(IncomeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    IncomeService incomeServiceImpl;

    @org.springframework.beans.factory.annotation.Autowired
    public IncomeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addIncome(
    		@ApiParam(value = "Income object that needs to be added to the store" ,required=true )  @Valid @RequestBody Income body)
    		throws Exception {
    	
        final String accept = request.getHeader("Accept");
        
        if (accept != null && accept.contains("application/json")) {
            try {
            	incomeServiceImpl.createIncome(body);
            }
            catch (final IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (final Exception e) {
            	log.error(e.getMessage());
            	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        	return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }
        
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteIncome(
    		@ApiParam(value = "Income id to delete",required=true) @PathVariable("incomeId") String incomeId)
    		throws Exception {
    	
        final String accept = request.getHeader("Accept");
        
        try {
        	incomeServiceImpl.deleteIncome(incomeId);
        }
        catch (final IOException e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (final Exception e) {
        	log.error(e.getMessage());
        	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<Income>> getIncomeByKey(
    		@ApiParam(value = "Key to search for income",required=true) @PathVariable("incomeKey") String incomeKey)
    		throws Exception {
    	
        final String accept = request.getHeader("Accept");
        List<Income> incomeList = null;
        
        if (accept != null && accept.contains("application/json")) {
        	try {
                Optional.ofNullable(incomeKey).orElseThrow(() -> new IOException("search key is null"));
                incomeList = incomeServiceImpl.searchIncome(incomeKey);
            }
            catch (final IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (final Exception e) {
            	log.error(e.getMessage());
            	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        	return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }

        return new ResponseEntity<>(incomeList, HttpStatus.OK);
    }

    public ResponseEntity<List<Income>> getIncomeList() throws Exception {
    	
        final String accept = request.getHeader("Accept");
        List<Income> incomeList = null;
        
        if (accept != null && accept.contains("application/json")) {
        	try {
        		//TODO: add user model instead of hard coding
                final String userId = "1";
                incomeList = incomeServiceImpl.getIncomeAll(userId);
                Optional.ofNullable(incomeList)
                        .orElseThrow(() -> new InternalError("HttpStatusINTERNAL_SERVER_ERROR"));
            }
            catch (final IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (final Exception e) {
            	log.error(e.getMessage());
            	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        	return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }

        return new ResponseEntity<>(incomeList, HttpStatus.OK);
    }

    public ResponseEntity<Void> updateIncome(
    		@ApiParam(value = "Income object that needs to be updated to the store" ,required=true )  @Valid @RequestBody Income body)
    		throws Exception {
    	
        final String accept = request.getHeader("Accept");
        
        if (accept != null && accept.contains("application/json")) {
            try {
            	incomeServiceImpl.updateIncome(body);
            }
            catch (final IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (final Exception e) {
            	log.error(e.getMessage());
            	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        	return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
