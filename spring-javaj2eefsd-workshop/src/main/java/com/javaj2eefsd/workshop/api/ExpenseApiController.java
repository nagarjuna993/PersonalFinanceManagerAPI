package com.javaj2eefsd.workshop.api;

import com.javaj2eefsd.workshop.model.Expense;
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
public class ExpenseApiController implements ExpenseApi {

    private static final Logger log = LoggerFactory.getLogger(ExpenseApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ExpenseApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addExpense(@ApiParam(value = "Expense object that needs to be added to the store" ,required=true )  @Valid @RequestBody Expense body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteExpense(@ApiParam(value = "Expense id to delete",required=true) @PathVariable("expenseId") String expenseId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Expense>> getExpenseByKey(@ApiParam(value = "ID of expense to return",required=true) @PathVariable("expenseKey") String expenseKey) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Expense>>(objectMapper.readValue("[ {  \"create_by\" : \"create_by\",  \"login_id\" : \"login_id\",  \"expenseAmount\" : 0.8008281904610115,  \"expenseType\" : \"expenseType\",  \"expense_name\" : \"expense_name\",  \"expenseId\" : \"expenseId\",  \"created_date\" : \"2000-01-23T04:56:07.000+00:00\",  \"updated_date\" : \"2000-01-23T04:56:07.000+00:00\",  \"upd_by\" : \"upd_by\",  \"expenseDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"is_delete\" : true}, {  \"create_by\" : \"create_by\",  \"login_id\" : \"login_id\",  \"expenseAmount\" : 0.8008281904610115,  \"expenseType\" : \"expenseType\",  \"expense_name\" : \"expense_name\",  \"expenseId\" : \"expenseId\",  \"created_date\" : \"2000-01-23T04:56:07.000+00:00\",  \"updated_date\" : \"2000-01-23T04:56:07.000+00:00\",  \"upd_by\" : \"upd_by\",  \"expenseDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"is_delete\" : true} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Expense>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Expense>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Expense>> getExpenseList() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Expense>>(objectMapper.readValue("[ {  \"create_by\" : \"create_by\",  \"login_id\" : \"login_id\",  \"expenseAmount\" : 0.8008281904610115,  \"expenseType\" : \"expenseType\",  \"expense_name\" : \"expense_name\",  \"expenseId\" : \"expenseId\",  \"created_date\" : \"2000-01-23T04:56:07.000+00:00\",  \"updated_date\" : \"2000-01-23T04:56:07.000+00:00\",  \"upd_by\" : \"upd_by\",  \"expenseDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"is_delete\" : true}, {  \"create_by\" : \"create_by\",  \"login_id\" : \"login_id\",  \"expenseAmount\" : 0.8008281904610115,  \"expenseType\" : \"expenseType\",  \"expense_name\" : \"expense_name\",  \"expenseId\" : \"expenseId\",  \"created_date\" : \"2000-01-23T04:56:07.000+00:00\",  \"updated_date\" : \"2000-01-23T04:56:07.000+00:00\",  \"upd_by\" : \"upd_by\",  \"expenseDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"is_delete\" : true} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Expense>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Expense>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateExpense(@ApiParam(value = "Expense object that needs to be updated to the store" ,required=true )  @Valid @RequestBody Expense body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
