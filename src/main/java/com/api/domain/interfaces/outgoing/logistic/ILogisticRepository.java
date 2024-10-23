package com.api.domain.interfaces.outgoing.logistic;

import com.api.app.dto.LogisticDTO;
import com.api.app.dto.Response;
import com.api.domain.models.Logistic;

public interface ILogisticRepository {
   public Response createLogistic(Logistic logistic);
   public Response updateLogistic(Long id, LogisticDTO logisticDTO);
   public Response deleteLogistic(Long id);
   public Response getByIdLogistic(Long id);
}
