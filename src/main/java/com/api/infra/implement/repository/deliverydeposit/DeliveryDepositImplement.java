package com.api.infra.implement.repository.deliverydeposit;

import com.api.app.dto.DeliveryDepositDTO;
import com.api.app.dto.Response;
import com.api.domain.interfaces.outgoing.deliverydeposit.IDeliveryDepositRepository;
import com.api.domain.interfaces.outgoing.jpaORM.IDeliveryDepositORM;
import com.api.domain.interfaces.outgoing.mapper.IDeliveryDepositMapper;
import com.api.domain.models.deposit.DeliveryDeposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryDepositImplement implements IDeliveryDepositRepository {
    
    private final IDeliveryDepositORM iDeliveryDepositORM;
    private final IDeliveryDepositMapper iDeliveryDepositMapper; 

    @Autowired
    public DeliveryDepositImplement(IDeliveryDepositORM iDeliveryDepositORM, IDeliveryDepositMapper iDeliveryDepositMapper) {
        this.iDeliveryDepositORM = iDeliveryDepositORM;
        this.iDeliveryDepositMapper = iDeliveryDepositMapper;
    }

    @Override
    public Response createDeliveryDeposit(DeliveryDepositDTO dto) {
        try {
            DeliveryDeposit dDEntity = iDeliveryDepositMapper.createMapper(dto);
            iDeliveryDepositORM.save(dDEntity);
            return new Response(
                "DeliveryDeposit creado",
                HttpStatus.OK.value(),
                true,
                null);
        } catch (Exception e) {
            return new Response(
                "DeliveryDeposit no creado "+ e,
                HttpStatus.OK.value(),
                false,
                null);
        }
    }
    
    @Override
    public Response getByIdDeliveryDeposit(Long id){
        try {
            var logistic = iDeliveryDepositORM.findById(id);
            System.out.println(logistic);
            if (logistic.isEmpty()) {
                throw new RuntimeException("ID inválido o no econtrado");
            }
            return new Response(
                "DeliveryDeposit encontrado",
                    HttpStatus.OK.value(),
                true,
                logistic);    
        } catch (RuntimeException e) {
            return new Response(
                "DeliveryDeposit no encontrado, "+ e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                false,
                null);
        }
    }

    @Override
    public Response updateDeliveryDeposit(Long id, DeliveryDepositDTO dto) {
        
        try {
            DeliveryDeposit existingDeliveryDeposit = iDeliveryDepositORM.findById(id)
                .orElseThrow(() -> new RuntimeException("DeliveryDeposit not found"));
            
            DeliveryDeposit updateDeliveryDeposit = iDeliveryDepositMapper.updateMapper(dto, existingDeliveryDeposit);
            
            iDeliveryDepositORM.save(updateDeliveryDeposit);
            return new Response(
                "DeliveryDeposit actualizada  ",
                HttpStatus.OK.value(),
                true,
                null);    
        } catch (RuntimeException e) {
            return new Response(
                "DeliveryDeposit no actualizada, "+ e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                false,
                null);
        }
    }

    @Override
    public Response deleteDeliveryDeposit(Long id) {
        
        try {
            iDeliveryDepositORM.deleteById(id);
            return new Response(
                "DeliveryDeposit eliminada  ",
                HttpStatus.OK.value(),
                true,
                null);    
        } catch (RuntimeException e) {
            return new Response(
                "DeliveryDeposit no encontrado, "+ e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                false,
                null);
        }
    }
}
