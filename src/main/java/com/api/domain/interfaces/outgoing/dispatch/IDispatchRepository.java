package com.api.domain.interfaces.outgoing.dispatch;

import com.api.app.dto.DispatchDTO;
import com.api.app.dto.Response;
import com.api.domain.models.Dispatch;

public interface IDispatchRepository {
    Response createDispatch(Dispatch dispatch);
    Response getByIdDispatch(Long id);
    Response updateDispatch(Long id, DispatchDTO dto);
    Response deleteDispatch(Long id);
}
