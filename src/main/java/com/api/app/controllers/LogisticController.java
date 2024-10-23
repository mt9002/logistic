package com.api.app.controllers;

import com.api.app.dto.LogisticDTO;
import com.api.app.dto.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.api.domain.interfaces.incoming.ILogisticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/logistic")
@Validated
public class LogisticController {

    private final ILogisticService iLandService;

    @Autowired
    public LogisticController(ILogisticService iLandService) {
        this.iLandService = iLandService;
    }
    
    @Operation(security = @SecurityRequirement(name = "bearer-key"))
    @PostMapping("/create")
    public Response createLogistic(@Valid @RequestBody LogisticDTO dto) {
        System.out.println(dto);
        var response = iLandService.createLogistic(dto);
        return response;
    }
    
    @Operation(security = @SecurityRequirement(name = "bearer-key"))
    @GetMapping("/getById")
    public Response getByIdLogistic(@RequestParam(value = "id") Long id) {
        var response = iLandService.getByIdLogistic(id);
        return response;
    }

    @PutMapping("/update")
    public Response updateLogisticDelivery(@RequestParam(value = "id") Long id, @RequestBody LogisticDTO dto) {
        var response = iLandService.updateLogistic(id, dto);
        return response;
    }

    @DeleteMapping("/delete")
    public Response deleteLogisticDelivery(@RequestParam(value = "id") Long id) {
        Response<?> response = iLandService.deleteLogistic(id);
        return response;
    }
}
