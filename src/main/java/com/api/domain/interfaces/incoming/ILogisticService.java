package com.api.domain.interfaces.incoming;

import com.api.app.dto.LogisticDTO;
import com.api.app.dto.Response;

public interface ILogisticService {
    public Response createLogistic(LogisticDTO dto);
    public Response getByIdLogistic(Long id);
    public Response updateLogistic(Long id, LogisticDTO dto);
    public Response deleteLogistic(Long id);
}
