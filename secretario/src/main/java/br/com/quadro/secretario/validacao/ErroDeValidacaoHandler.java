package br.com.quadro.secretario.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
    @Autowired
    private MessageSource messageSource;

    public List<ErroDto> handle(MethodArgumentNotValidException exception){
        List<ErroDto> dtos = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e ->{String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
        ErroDto erro = new ErroDto(e.getField(),mensagem);
        dtos.add(erro);});
        return dtos;
    }
}
