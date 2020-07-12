package com.zelosin.bellproject.aspect;

import com.zelosin.bellproject.view.DataView;
import com.zelosin.bellproject.view.ErrorView;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Аспек-обработчик констроллера, который оборачивает данные в нужную форму
 */
@Aspect
@Service
public class TransferAspect {

    /**
     * @param joinPoint  точка присоединения аспекта
     * @return  обернутые данные
     * @throws Throwable  ошибка присоединения аспекта
     */
    @Around("execution(* com.zelosin.bellproject.controller..*(..) )")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object returnValue = joinPoint.proceed();
        if((returnValue instanceof ResponseEntity) || (returnValue instanceof ErrorView)){
            return returnValue;
        }
        else {
            return new ResponseEntity<>(new DataView(returnValue), HttpStatus.OK);
        }
    }
}