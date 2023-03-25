package org.example.controller.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String mensagem;
    private String exception;

    public ErrorResponse( String exception) {
        this.exception = exception;
    }
}