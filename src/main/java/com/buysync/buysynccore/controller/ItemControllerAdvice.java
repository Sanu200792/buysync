package com.buysync.buysynccore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ItemControllerAdvice implements ProblemHandling {

    @Override
    public ResponseEntity<Problem> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, NativeWebRequest request) {
        BindingResult result = ex.getBindingResult();
        Map<String, String> fieldErrors = result.getFieldErrors().stream()
                .collect(Collectors.toMap(f -> f.getField(), f -> f.getDefaultMessage()));
        Problem problem = Problem.builder()
                .withTitle("Input Validation failed")
                .with("message", "Validation failed for the input data")
                .withStatus(Status.BAD_REQUEST)
                .with("violations", fieldErrors)
                .build();
        return create(ex, problem, request);
    }

}
