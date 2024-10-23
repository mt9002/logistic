package com.api.app.controllers;

import com.api.app.dto.DispatchDTO;
import com.api.app.dto.Response;
import com.api.domain.interfaces.incoming.IDispatchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Dispatch")
public class DispatchController {

    private final IDispatchService iDispatchService;

    @Autowired
    public DispatchController(IDispatchService iDispatchService) {
        this.iDispatchService = iDispatchService;
    }

    @PostMapping("/create")
    public Response createDispatch(@Valid @RequestBody DispatchDTO dto) {
        var response = iDispatchService.createDispatch(dto);
        return response;
    }

    @GetMapping("/getById")
    public Response getByIdDispatch(@RequestParam(value = "id") Long id) {
        var response = iDispatchService.getByIdDispatch(id);
        return response;
    }

    @DeleteMapping("/delete")
    public Response deleteDispatch(@RequestParam(value = "id") Long id) {
        var response = iDispatchService.deleteDispatch(id);
        return response;
    }
}
