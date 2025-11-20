package com.ncu.college.authenticationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncu.college.authenticationservice.dto.SignupDto;
import com.ncu.college.authenticationservice.dto.ReturnDto;
import com.ncu.college.authenticationservice.dto.AuthDto;
import com.ncu.college.authenticationservice.service.authenticationservice;
import org.springframework.web.bind.annotation.RequestParam;

    
@RequestMapping("/auth")
@RestController
public class AuthController 
{
    authenticationservice _authenticationservice;

    @Autowired
    AuthController(authenticationservice authenticationservice)
    {
        this._authenticationservice = authenticationservice;
    }


    @PostMapping("/signup")
    public ResponseEntity<ReturnDto> SignUp(@RequestBody SignupDto cred) 
    {
        ReturnDto response = new ReturnDto();
        boolean isSuccess = _authenticationservice.SignUp(cred, response);
        if(isSuccess)
        {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(response);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> Authenticate(@RequestBody AuthDto cred) 
    {
        boolean isAuthenticated = _authenticationservice.Authenticate(cred);
        if (isAuthenticated) {
            return ResponseEntity.ok("Authentication successful");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
    }

}