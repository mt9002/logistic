package com.api.domain.services.deliverydeposit;

import com.api.app.dto.DeliveryDepositDTO;
import com.api.app.dto.Response;
import com.api.domain.interfaces.incoming.IDeliveryDepositService;
import com.api.domain.interfaces.outgoing.deliverydeposit.IDeliveryDepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryDepositService implements IDeliveryDepositService{

    private final IDeliveryDepositRepository iDeliveryDepositRepository;
    
    @Autowired
    public DeliveryDepositService(IDeliveryDepositRepository iDeliveryDepositRepository){
        this.iDeliveryDepositRepository = iDeliveryDepositRepository;
    }
    
    @Override
    public Response createDeliveryDeposit(DeliveryDepositDTO dto){
        var response = iDeliveryDepositRepository.createDeliveryDeposit(dto);
        return response;
    }
    @Override
    public Response getByIdDeliveryDeposit(Long id){
        var response = iDeliveryDepositRepository.getByIdDeliveryDeposit(id);
        return response;
    }
    
    @Override
    public Response updateDeliveryDeposit(Long id, DeliveryDepositDTO dto){
        var response = iDeliveryDepositRepository.updateDeliveryDeposit(id, dto);
        return response;
    }
    
    @Override
    public Response deleteDeliveryDeposit(Long id){
        var response = iDeliveryDepositRepository.deleteDeliveryDeposit(id);
        return response;
    }
}
