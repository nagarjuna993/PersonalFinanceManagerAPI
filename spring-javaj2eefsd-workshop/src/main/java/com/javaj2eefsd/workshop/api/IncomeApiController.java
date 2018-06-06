package com.javaj2eefsd.workshop.api;

import com.javaj2eefsd.workshop.model.Income;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

@Controller
public class IncomeApiController implements IncomeApi {

    private static final Logger log = LoggerFactory.getLogger(IncomeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public IncomeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addIncome(@ApiParam(value = "Income object that needs to be added to the store" ,required=true )  @Valid @RequestBody Income body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteIncome(@ApiParam(value = "Income id to delete",required=true) @PathVariable("incomeId") String incomeId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Income>> getIncomeByKey(@ApiParam(value = "ID of income to return",required=true) @PathVariable("incomeKey") String incomeKey) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Income>>(objectMapper.readValue("[ {  \"incomeId\" : \"incomeId\",  \"incomeType\" : \"incomeType\",  \"incomeAmount\" : 0.8008281904610115,  \"incomeDate\" : \"2000-01-23T04:56:07.000+00:00\"}, {  \"incomeId\" : \"incomeId\",  \"incomeType\" : \"incomeType\",  \"incomeAmount\" : 0.8008281904610115,  \"incomeDate\" : \"2000-01-23T04:56:07.000+00:00\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Income>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Income>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Income>> getIncomeList() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Income>>(objectMapper.readValue("[ {  \"incomeId\" : \"incomeId\",  \"incomeType\" : \"incomeType\",  \"incomeAmount\" : 0.8008281904610115,  \"incomeDate\" : \"2000-01-23T04:56:07.000+00:00\"}, {  \"incomeId\" : \"incomeId\",  \"incomeType\" : \"incomeType\",  \"incomeAmount\" : 0.8008281904610115,  \"incomeDate\" : \"2000-01-23T04:56:07.000+00:00\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Income>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Income>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateIncome(@ApiParam(value = "Income object that needs to be updated to the store" ,required=true )  @Valid @RequestBody Income body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
