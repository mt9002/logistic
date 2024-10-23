package com.api.domain.interfaces.incoming;

import com.api.app.dto.DispatchDTO;
import com.api.app.dto.Response;

public interface IDispatchService {
    Response createDispatch(DispatchDTO dto);
    Response getByIdDispatch(Long id);
    Response updateDispatch(Long id, DispatchDTO dto);
    Response deleteDispatch(Long id);
}
