package com.javaj2eefsd.workshop.api;

import com.javaj2eefsd.workshop.model.BankAccount;
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
public class BankAccountApiController implements BankAccountApi {

    private static final Logger log = LoggerFactory.getLogger(BankAccountApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BankAccountApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addBankAccount(@ApiParam(value = "Bank Account object that needs to be added to the store" ,required=true )  @Valid @RequestBody BankAccount body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteBankAccount(@ApiParam(value = "Bank Account id to delete",required=true) @PathVariable("bankAccountId") String bankAccountId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BankAccount> getBankAccountById(@ApiParam(value = "ID of bank account to return",required=true) @PathVariable("bankAccountId") String bankAccountId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BankAccount>(objectMapper.readValue("{  \"bankAccountId\" : \"bankAccountId\",  \"accountType\" : \"accountType\",  \"bankName\" : \"bankName\",  \"accountNumber\" : 0.80082819046101150206595775671303272247314453125,  \"accountHolderName\" : \"accountHolderName\",  \"ifscCode\" : \"ifscCode\"}", BankAccount.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BankAccount>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BankAccount>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<BankAccount>> getBankAccountsList() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<BankAccount>>(objectMapper.readValue("[ {  \"bankAccountId\" : \"bankAccountId\",  \"accountType\" : \"accountType\",  \"bankName\" : \"bankName\",  \"accountNumber\" : 0.80082819046101150206595775671303272247314453125,  \"accountHolderName\" : \"accountHolderName\",  \"ifscCode\" : \"ifscCode\"}, {  \"bankAccountId\" : \"bankAccountId\",  \"accountType\" : \"accountType\",  \"bankName\" : \"bankName\",  \"accountNumber\" : 0.80082819046101150206595775671303272247314453125,  \"accountHolderName\" : \"accountHolderName\",  \"ifscCode\" : \"ifscCode\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<BankAccount>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<BankAccount>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
