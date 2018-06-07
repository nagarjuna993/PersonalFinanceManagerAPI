package com.javaj2eefsd.workshop.api;

import com.javaj2eefsd.workshop.model.UserCurrency;
import com.javaj2eefsd.workshop.model.UserPassword;
import com.javaj2eefsd.workshop.model.UserSettingsByEmailId;
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
public class UserSettingsApiController implements UserSettingsApi {

    private static final Logger log = LoggerFactory.getLogger(UserSettingsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserSettingsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<UserSettingsByEmailId> userCurrencyUpdate(@ApiParam(value = "User Profile Settings - Change Currency." ,required=true )  @Valid @RequestBody UserCurrency body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UserSettingsByEmailId>(objectMapper.readValue("{  \"password\" : \"password\",  \"emailId\" : \"emailId\",  \"currency\" : \"currency\"}", UserSettingsByEmailId.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserSettingsByEmailId>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserSettingsByEmailId>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UserSettingsByEmailId> userPasswordUpdate(@ApiParam(value = "User Profile Settings - Change Password." ,required=true )  @Valid @RequestBody UserPassword body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UserSettingsByEmailId>(objectMapper.readValue("{  \"password\" : \"password\",  \"emailId\" : \"emailId\",  \"currency\" : \"currency\"}", UserSettingsByEmailId.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserSettingsByEmailId>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserSettingsByEmailId>(HttpStatus.NOT_IMPLEMENTED);
    }

}