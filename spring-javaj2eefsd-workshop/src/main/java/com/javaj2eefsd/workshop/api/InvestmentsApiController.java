package com.javaj2eefsd.workshop.api;

import com.javaj2eefsd.workshop.model.Investments;
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
public class InvestmentsApiController implements InvestmentsApi {

    private static final Logger log = LoggerFactory.getLogger(InvestmentsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public InvestmentsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addInvestments(@ApiParam(value = "Investments object that needs to be added to the store" ,required=true )  @Valid @RequestBody Investments body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteInvestments(@ApiParam(value = "Investments id to delete",required=true) @PathVariable("investmentsId") String investmentsId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Investments>> getInvestmentsByKey(@ApiParam(value = "ID of investments to return",required=true) @PathVariable("investmentsKey") String investmentsKey) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Investments>>(objectMapper.readValue("[ {  \"investmentsAmount\" : 0.8008281904610115,  \"investmentsDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"investmentsId\" : \"investmentsId\",  \"investmentsType\" : \"investmentsType\"}, {  \"investmentsAmount\" : 0.8008281904610115,  \"investmentsDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"investmentsId\" : \"investmentsId\",  \"investmentsType\" : \"investmentsType\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Investments>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Investments>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Investments>> getInvestmentsList() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Investments>>(objectMapper.readValue("[ {  \"investmentsAmount\" : 0.8008281904610115,  \"investmentsDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"investmentsId\" : \"investmentsId\",  \"investmentsType\" : \"investmentsType\"}, {  \"investmentsAmount\" : 0.8008281904610115,  \"investmentsDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"investmentsId\" : \"investmentsId\",  \"investmentsType\" : \"investmentsType\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Investments>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Investments>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateInvestments(@ApiParam(value = "Investments object that needs to be updated to the store" ,required=true )  @Valid @RequestBody Investments body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
