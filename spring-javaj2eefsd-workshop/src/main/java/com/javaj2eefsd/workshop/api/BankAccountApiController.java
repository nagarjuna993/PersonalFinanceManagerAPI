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
import com.javaj2eefsd.workshop.model.BankAccount;
import com.javaj2eefsd.workshop.service.BankAccountService;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

@Controller
public class BankAccountApiController implements BankAccountApi {

    private static final Logger log = LoggerFactory.getLogger(BankAccountApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    BankAccountService bankAccountServiceImpl;

    @org.springframework.beans.factory.annotation.Autowired
    public BankAccountApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addBankAccount(
    		@ApiParam(value = "Bank Account object that needs to be added to the store" ,required=true )  @Valid @RequestBody BankAccount body)
    		throws Exception {
    	
        final String accept = request.getHeader("Accept");
        
        if (accept != null && accept.contains("application/json")) {
            try {
            	bankAccountServiceImpl.createBankAccount(body);
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

    public ResponseEntity<Void> deleteBankAccount(
    		@ApiParam(value = "Bank Account id to delete",required=true) @PathVariable("bankAccountId") String bankAccountId)
    		throws Exception {
    	
        final String accept = request.getHeader("Accept");
        
        try {
        	bankAccountServiceImpl.deleteBankAccount(bankAccountId);
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

    public ResponseEntity<List<BankAccount>> getBankAccountByKey(
    		@ApiParam(value = "Key to search for Bank Accounts",required=true) @PathVariable("bankAccountKey") String bankAccountKey)
    		throws Exception {
        final String accept = request.getHeader("Accept");
        List<BankAccount> bankAccountList = null;
        
        if (accept != null && accept.contains("application/json")) {
        	try {
                Optional.ofNullable(bankAccountKey).orElseThrow(() -> new IOException("search key is null"));
                bankAccountList = bankAccountServiceImpl.searchBankAccount(bankAccountKey);
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

        return new ResponseEntity<>(bankAccountList, HttpStatus.OK);
    }

    public ResponseEntity<List<BankAccount>> getBankAccountsList() throws Exception {
    	
    	final String accept = request.getHeader("Accept");
        List<BankAccount> bankAccountList = null;
        
        if (accept != null && accept.contains("application/json")) {
        	try {
        		//TODO: add user model instead of hard coding
                final String userId = "1";
                bankAccountList = bankAccountServiceImpl.getBankAccountAll(userId);
                Optional.ofNullable(bankAccountList)
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

        return new ResponseEntity<>(bankAccountList, HttpStatus.OK);
    }

}
