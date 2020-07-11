package com.zelosin.bellproject.controller.template;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.service.template.BellService;
import com.zelosin.bellproject.util.Transfer;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;


@RestController
public abstract class AbstractBellController<F, D, E>{
    protected final BellService<F, D, E> bellService;

    protected AbstractBellController(BellService<F, D, E> bellService) {
        this.bellService = bellService;
    }

    @GetMapping("/{id}")
    @JsonView(Transfer.DetailView.class)
    public Map getElementById(@PathVariable("id") int id){
        return Collections.singletonMap("data", bellService.findById(id));
    }

    @PostMapping("/save")
    public Map saveElement( @Validated(Transfer.Save.class) @RequestBody D d){
        bellService.save(d);
        return Collections.singletonMap("result", "success");
    }

    @PostMapping("/list")
    @JsonView(Transfer.ListView.class)
    public Map getElementList(@Validated(Transfer.Filter.class) @RequestBody F f){
        return Collections.singletonMap("data", bellService.getList(f));
    }

    @PostMapping("/update")
    public Map updateElement(@Validated(Transfer.Update.class) @RequestBody D d) {
        bellService.update(d);
        return Collections.singletonMap("result", "success");
    }
}
