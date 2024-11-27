package com.sush.academia_iiitb.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NoStudentFound extends RuntimeException {
    private final String msg;
}