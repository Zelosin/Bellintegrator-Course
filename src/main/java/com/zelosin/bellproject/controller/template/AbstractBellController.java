package com.zelosin.bellproject.controller.template;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.dao.transfer.Transfer;
import com.zelosin.bellproject.service.template.BellService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;


@RestController
public abstract class AbstractBellController<Q> implements BellController<Q>{
    protected final BellService<Q> bellService;

    protected AbstractBellController(BellService<Q> bellService) {
        this.bellService = bellService;
    }

    @Override
    @GetMapping("/{id}")
    @JsonView(Transfer.DetailView.class)
    public Map getElementById(@PathVariable("id") int id){
        return Collections.singletonMap("data", bellService.findById(id));
    }

    @Override
    @PostMapping("/save")
    public Map saveElement( @Validated(Transfer.Save.class) @RequestBody Q q){
        bellService.save(q);
        return Collections.singletonMap("result", "success");
    }

    @Override
    @PostMapping("/list")
    @JsonView(Transfer.ListView.class)
    public Map getElementList(){
        return Collections.singletonMap("data", bellService.getList());
    }
}
