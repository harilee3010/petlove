package com.stc.petlove.services.dichvu;

import com.stc.petlove.dtos.dichvu.DichVuDTO;
import com.stc.petlove.entities.DichVu;

public interface DichVuService {
    DichVu getDichVu(String id);
    DichVu create(DichVuDTO DTO);
    DichVu update(String id, DichVuDTO DTO);
    DichVu delete(String id);
}
