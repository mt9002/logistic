package com.api.infra.implement.repository.dispatch;

import com.api.app.dto.DispatchDTO;
import com.api.app.dto.Response;
import com.api.domain.interfaces.outgoing.dispatch.IDispatchRepository;
import com.api.domain.interfaces.outgoing.jpaORM.IDispatchORM;
import com.api.domain.models.Dispatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
public class DispatchImplement implements IDispatchRepository {

    private final IDispatchORM iDispatchORM;

    @Autowired
    public DispatchImplement(IDispatchORM iDispatchORM) {
        this.iDispatchORM = iDispatchORM;
    }

    @Override
    public Response createDispatch(Dispatch dispatch) {

        try {
            iDispatchORM.save(dispatch);
            return new Response(
                    "Dispatch creado",
                    HttpStatus.OK.value(),
                    true,
                    null
            );
        } catch (Exception e) {
            return new Response(
                    "Dispatch no creado" + e,
                    HttpStatus.BAD_REQUEST.value(),
                    false,
                    null
            );
        }
    }

    @Override
    public Response<Dispatch> getByIdDispatch(Long id) {
        try {
            var dispatch = iDispatchORM.findById(id);

            if (dispatch.isEmpty()) {
                throw new RuntimeException("ID inválido o no econtrado");
            }
            return new Response(
                    "Dispatch encontrado",
                    HttpStatus.OK.value(),
                    true,
                    dispatch.get());
        } catch (RuntimeException e) {
            return new Response(
                    "Dispatch no encontrado, " + e.getMessage(),
                    HttpStatus.NOT_FOUND.value(),
                    false,
                    null);
        }
    }

    @Override
    public Response updateDispatch(Long id, DispatchDTO dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Response deleteDispatch(Long id) {

        try {
            iDispatchORM.deleteById(id);
            return new Response(
                    "Dispatch eliminada",
                    HttpStatus.OK.value(),
                    true,
                    null);
        } catch (RuntimeException e) {
            return new Response(
                    "Dispatch no eliminado, " + e.getMessage(),
                    HttpStatus.NOT_FOUND.value(),
                    false,
                    null);
        }
    }

}
