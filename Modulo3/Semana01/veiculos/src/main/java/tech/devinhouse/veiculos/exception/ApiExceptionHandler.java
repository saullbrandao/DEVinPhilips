package tech.devinhouse.veiculos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RegistroExistenteException.class)
    public ResponseEntity<Object> handleRegistroExistenteException(RegistroExistenteException e) {
        Map<String, String> retorno = new HashMap<>();
        retorno.put("erro", "Registro já cadastrado!");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(retorno);
    }

    @ExceptionHandler(RegistroNaoEncontradoException.class)
    public ResponseEntity<Object> handleRegistroNaoEncontradoException(RegistroNaoEncontradoException e) {
        Map<String, String> retorno = new HashMap<>();
        retorno.put("erro", "Registro não encontrado!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(retorno);
    }

    @ExceptionHandler(ExclusaoVeiculoComMultasException.class)
    public ResponseEntity<Object> handleExclusaoVeiculoComMultasException(ExclusaoVeiculoComMultasException e) {
        Map<String, String> retorno = new HashMap<>();
        retorno.put("erro", "Veículo possui multas e não pode ser excluído!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(retorno);
    }
}
