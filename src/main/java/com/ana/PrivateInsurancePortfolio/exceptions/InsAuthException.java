package com.ana.PrivateInsurancePortfolio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InsAuthException extends RuntimeException {

    public InsAuthException(String message){
        super(message);
    }
}
