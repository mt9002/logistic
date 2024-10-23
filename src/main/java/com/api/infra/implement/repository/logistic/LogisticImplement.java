package com.api.infra.implement.repository.logistic;

import com.api.domain.interfaces.outgoing.jpaORM.ILogisticORM;
import com.api.domain.models.Logistic;
import com.api.app.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import com.api.domain.interfaces.outgoing.logistic.ILogisticRepository;
import com.api.domain.interfaces.outgoing.mapper.ILogisticMapper;
import com.api.app.dto.LogisticDTO;

@Repository
public class LogisticImplement implements ILogisticRepository {

    private final ILogisticORM iLogisticORM;
    private final ILogisticMapper iLogisticMapper;

    @Autowired
    public LogisticImplement(ILogisticORM iLogisticORM, ILogisticMapper iLogisticMapper) {
        this.iLogisticORM = iLogisticORM;
        this.iLogisticMapper = iLogisticMapper;
    }

    @Override
    public Response createLogistic(Logistic logistic) {
        try {

            iLogisticORM.save(logistic);

            return new Response(
                    "Logistic creado",
                    HttpStatus.OK.value(),
                    true,
                    null);
        } catch (RuntimeException e) {
            return new Response(
                    "Logistic no creado " + e,
                    HttpStatus.BAD_REQUEST.value(),
                    false,
                    null);
        } catch (Exception e) {
            return new Response(
                    "Error interno: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    false,
                    null);
        }
    }

    @Override
    public Response getByIdLogistic(Long id
    ) {
        try {
            Logistic logistic = iLogisticORM.findById(id)
                    .orElseThrow(() -> new RuntimeException("ID inválido o no encontrado"));

            return new Response(
                    "Logistic encontrado",
                    HttpStatus.OK.value(),
                    true,
                    logistic);
        } catch (RuntimeException e) {
            return new Response(
                    "Logistic no encontrado, " + e.getMessage(),
                    HttpStatus.NOT_FOUND.value(),
                    false,
                    null);
        }
    }

    @Override
    public Response updateLogistic(Long id, LogisticDTO logisticDTO
    ) {

        try {
            Logistic existingLogistic = iLogisticORM.findById(id)
                    .orElseThrow(() -> new RuntimeException("Logistic not found"));

            Logistic updateLogistic = iLogisticMapper.updateMapper(logisticDTO, existingLogistic);

            iLogisticORM.save(updateLogistic);
            return new Response(
                    "Logistic actualizada  ",
                    HttpStatus.OK.value(),
                    true,
                    null);
        } catch (RuntimeException e) {
            return new Response(
                    "Logistic no actualizada, " + e.getMessage(),
                    HttpStatus.NOT_FOUND.value(),
                    false,
                    null);
        }
    }

    @Override
    public Response deleteLogistic(Long id) {

        try {
            iLogisticORM.deleteById(id);
            return new Response(
                    "Logistic eliminada",
                    HttpStatus.OK.value(),
                    true,
                    null);
        } catch (RuntimeException e) {
            return new Response(
                    "Logistic no eliminado, " + e.getMessage(),
                    HttpStatus.NOT_FOUND.value(),
                    false,
                    null);
        }
    }

}
