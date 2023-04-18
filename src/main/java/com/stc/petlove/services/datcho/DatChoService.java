package com.stc.petlove.services.datcho;

import com.stc.petlove.dtos.datcho.DatChoDTO;
import com.stc.petlove.entities.DatCho;

public interface DatChoService {
    DatCho getDatCho(String id);
    DatCho create(DatChoDTO DTO);
    DatCho update(String id, DatChoDTO DTO);
    DatCho delete(String id);
}
