
package com.api.domain.interfaces.outgoing.mapper;

import com.api.app.dto.DispatchDTO;
import com.api.domain.models.Dispatch;

public interface IDispatchMapper {
    Dispatch DtoToEntity(DispatchDTO dispatchDTO); 
}
