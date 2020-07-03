package com.zelosin.bellproject.controller.template;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.dao.transfer.Transfer;
import com.zelosin.bellproject.service.template.BellService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.Map;

public interface BellController<Q> {

    Map getElementById(@PathVariable("id") int id);
    Map updateElement(@Validated(Transfer.Update.class)  @RequestBody Q q);
    Map saveElement( @Validated(Transfer.Save.class) @RequestBody Q q);
    Map getElementList();

}
