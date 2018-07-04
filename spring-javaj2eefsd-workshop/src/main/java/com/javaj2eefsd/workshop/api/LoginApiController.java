package com.javaj2eefsd.workshop.api;

import com.javaj2eefsd.workshop.model.Registeruser;
import com.javaj2eefsd.workshop.model.UserDetail;
import com.javaj2eefsd.workshop.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
public class LoginApiController implements LoginApi {

    private static final Logger log = LoggerFactory.getLogger(LoginApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public LoginApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    
    @Autowired
       LoginService loginserviceObj; 
    public ResponseEntity<UserDetail> loginUser(@ApiParam(value = "User needs to be authenticated. Password must be encrypted." ,required=true )  @Valid @RequestBody UserDetail body) throws Exception {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	loginserviceObj.getLogin(body);
            	 return new ResponseEntity<UserDetail>(HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserDetail>(HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (Exception e) {
                log.error("unknown exception",e);
                return new ResponseEntity<UserDetail>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            
           
        }
        
        return new ResponseEntity<UserDetail>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

}
