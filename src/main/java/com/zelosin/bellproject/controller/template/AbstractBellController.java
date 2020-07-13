package com.zelosin.bellproject.controller.template;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.service.template.BellService;
import com.zelosin.bellproject.util.Transfer;
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
     */
    @PostMapping("/save")
    @JsonView({Transfer.ResultView.class})
    public void saveElement( @Validated(Transfer.Save.class) @RequestBody D d){
        bellService.save(d);
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
     */
    @PostMapping("/update")
    @JsonView({Transfer.ResultView.class})
    public void updateElement(@Validated(Transfer.Update.class) @RequestBody D d) {
        bellService.update(d);
    }
}