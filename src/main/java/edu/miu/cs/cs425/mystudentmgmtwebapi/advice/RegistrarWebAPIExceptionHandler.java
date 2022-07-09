package edu.miu.cs.cs425.mystudentmgmtwebapi.advice;


import edu.miu.cs.cs425.mystudentmgmtwebapi.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RegistrarWebAPIExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(StudentNotFoundException.class)
    public Map<String,String> handleWebApiException(StudentNotFoundException studentNotFoundException){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", studentNotFoundException.getMessage());
        return errorMap;
    }


}
