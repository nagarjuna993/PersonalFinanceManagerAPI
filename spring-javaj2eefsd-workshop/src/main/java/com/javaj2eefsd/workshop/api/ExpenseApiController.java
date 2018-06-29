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
import com.javaj2eefsd.workshop.model.Expense;
import com.javaj2eefsd.workshop.service.IExpenseService;
import io.swagger.annotations.ApiParam;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")
/***
 * @author sathsubramanian This is ExpenseApiController this class connect with expense module end point who where calld
 *         in webservice give the response for create ,update.delete,retrieve and search the expense details.
 */
@Controller
@CrossOrigin(origins = { "*" })
public class ExpenseApiController implements ExpenseApi {

    private static final Logger log = LoggerFactory.getLogger(ExpenseApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    // object for expense service
    @Autowired
    IExpenseService expenseServiceImpl;

    @org.springframework.beans.factory.annotation.Autowired
    public ExpenseApiController(final ObjectMapper objectMapper, final HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    /***
     * addExpense method help to create new expense getting data from front end and call the expense service to create
     * new expense data in db
     */
    @Override
    public ResponseEntity<Void> addExpense(
            @ApiParam(value = "Expense object that needs to be added to the store", required = true) @Valid @RequestBody final Expense body)
            throws Exception {
        final String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                expenseServiceImpl.expenseCreatePost(body);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            catch (final IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * deleteExpense method help to delete expense data based on user inputs and this only soft deleted the expense data
     * and call the expense service to delete the data in db
     */
    @Override
    public ResponseEntity<Void> deleteExpense(
            @ApiParam(value = "Expense id to delete", required = true) @PathVariable("expenseId") final String expenseId)
            throws Exception {
        final String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                expenseServiceImpl.expenseDeleteDelete(expenseId);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            catch (final IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * getExpenseByKey this method used to search the expense data based on user inputs and call the expense service to
     * retrieve the data in db
     */
    @Override
    public ResponseEntity<List<Expense>> getExpenseByKey(
            @ApiParam(value = "ID of expense to return", required = true) @PathVariable("expenseKey") final String expenseKey)
            throws Exception {
        final String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                Optional.ofNullable(expenseKey).orElseThrow(() -> new IOException("search key is null"));
                final List<Expense> searchList = expenseServiceImpl.expenseSearchGet(expenseKey);
                return new ResponseEntity<>(searchList, HttpStatus.OK);
            }
            catch (final IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /***
     * getExpenseList this method used to get the login user expense data and non-deleted data and call the expense
     * service to retrieve the expense data
     */
    @Override
    public ResponseEntity<List<Expense>> getExpenseList(
            @ApiParam(value = "ID of expense to return", required = true) @PathVariable("id") final String id)
            throws Exception {
        final String accept = request.getHeader("Accept");
        List<Expense> expenceList = null;
        if (accept != null && accept.contains("application/json")) {
            try {
                expenceList = expenseServiceImpl.expenseAllGet(id);
                return new ResponseEntity<>(expenceList, (HttpStatus.OK));
            }
            catch (final IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(expenceList, (HttpStatus.BAD_REQUEST));
    }

    /***
     * updateExpense is used to update the expense data based on user action and call the expense service to update the
     * expense data
     */
    @Override
    public ResponseEntity<Void> updateExpense(
            @ApiParam(value = "Expense object that needs to be updated to the store", required = true) @Valid @RequestBody final Expense body)
            throws Exception {
        final String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                expenseServiceImpl.expenseUpdatePost(body);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            catch (final Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
