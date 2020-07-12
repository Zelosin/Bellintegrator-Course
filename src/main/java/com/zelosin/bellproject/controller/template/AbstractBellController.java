package com.zelosin.bellproject.controller.template;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.service.template.BellService;
import com.zelosin.bellproject.util.Transfer;
import com.zelosin.bellproject.view.ResultView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Абстрактный контроллер
 * @param <F>  Объект-фильтр
 * @param <D>  DTO
 * @param <E>  Entity
 */
@RestController
public abstract class AbstractBellController<F, D, E>{
    protected final BellService<F, D, E> bellService;

    protected AbstractBellController(BellService<F, D, E> bellService) {
        this.bellService = bellService;
    }

    /**
     * Получение объекта по идентификатору
     * @param id  идентификатор объекта
     * @return  DTO
     */
    @GetMapping("/{id}")
    @JsonView(Transfer.DetailView.class)
    public Object getElementById(@PathVariable("id") int id){
        return bellService.findById(id);
    }

    /**
     * Сохранение объекта
     * @param d  DTO объекта
     * @return  результат сохранения в виде DTO
     */
    @PostMapping("/save")
    public ResponseEntity<Object> saveElement( @Validated(Transfer.Save.class) @RequestBody D d){
        bellService.save(d);
        return new ResponseEntity<>(new ResultView("success"), HttpStatus.OK);
    }

    /**
     * Получение списка объектов по фильтру
     * @param f  DTO фильтра
     * @return  список объектов
     */
    @PostMapping("/list")
    @JsonView(Transfer.ListView.class)
    public Object getElementList(@Validated(Transfer.Filter.class) @RequestBody F f){
        return bellService.getList(f);
    }

    /**
     * Обновление данных об элементе
     * @param d  DTO объекта
     * @return  результат обновления
     */
    @PostMapping("/update")
    public ResponseEntity<Object> updateElement(@Validated(Transfer.Update.class) @RequestBody D d) {
        bellService.update(d);
        return new ResponseEntity<>(new ResultView("success"), HttpStatus.OK);
    }
}