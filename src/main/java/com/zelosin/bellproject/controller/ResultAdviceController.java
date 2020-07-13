package com.zelosin.bellproject.controller;

import com.zelosin.bellproject.view.DataView;
import com.zelosin.bellproject.view.ErrorView;
import com.zelosin.bellproject.view.ResultView;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Контроллер-обработчик возвращаемого значения
 */
@ControllerAdvice
public class ResultAdviceController implements ResponseBodyAdvice {

    /**
     * Проверка поддержки
     * @param methodParameter параметры метода
     * @param aClass класс
     * @return логическое значение
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    /**
     * Запись данных в тело ответа
     * @param returnValue данные, которые вернул контроллер
     * @param methodParameter метод параметра
     * @param mediaType тип данных
     * @param aClass класс
     * @param serverHttpRequest запрос
     * @param serverHttpResponse ответ
     * @return данные, которые будут записаны в тело ответа
     */
    @Override
    public Object beforeBodyWrite(Object returnValue,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse)
    {
        if(returnValue == null){
            return new ResultView("success");
        }
        else if((returnValue instanceof ErrorView) || (returnValue instanceof ResultView)){
            return returnValue;
        }
        else {
            return new DataView(returnValue);
        }
    }
}
