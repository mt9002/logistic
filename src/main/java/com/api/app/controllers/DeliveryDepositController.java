package com.api.app.controllers;

import com.api.app.dto.DeliveryDepositDTO;
import com.api.app.dto.Response;
import com.api.domain.interfaces.incoming.IDeliveryDepositService;
import jakarta.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/DeliveryDeposit")
public class DeliveryDepositController {
    private final IDeliveryDepositService iDeliveryDepositService;
    
    @Autowired
    public DeliveryDepositController(IDeliveryDepositService iDeliveryDepositService){
        this.iDeliveryDepositService = iDeliveryDepositService;
    }

    @PostMapping("/create")
    public Response createDeliveryDeposit(@Valid @RequestBody DeliveryDepositDTO dto){ 
        var response = iDeliveryDepositService.createDeliveryDeposit(dto);
        return response;
    }

    @GetMapping("/getById")
    public Response getByIdDeliveryDeposit(@RequestParam(value = "id") Long id){
        var response = iDeliveryDepositService.getByIdDeliveryDeposit(id);
        return response;
    }
    
    @PutMapping("/update")
    public Response updateDeliveryDeposit(@RequestParam(value = "id") Long id, @RequestBody DeliveryDepositDTO dto) {
        var response = iDeliveryDepositService.updateDeliveryDeposit(id, dto);
        return response;}

    @DeleteMapping("/delete")
    public Response deleteDeliveryDeposit(@RequestParam(value = "id") Long id) {
        var response = iDeliveryDepositService.deleteDeliveryDeposit(id);
        return response;
}

}

