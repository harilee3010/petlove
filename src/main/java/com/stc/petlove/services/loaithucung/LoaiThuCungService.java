package com.stc.petlove.services.loaithucung;

import com.stc.petlove.dtos.loaithucung.LoaiThuCungDTO;
import com.stc.petlove.entities.LoaiThuCung;
import org.springframework.util.ObjectUtils;

public  interface LoaiThuCungService {

    LoaiThuCung getLoaiThuCung(String id);

    LoaiThuCung createLoaiThuCung(LoaiThuCungDTO DTO);

    LoaiThuCung updateLoaiThuCung(String id, LoaiThuCungDTO DTO);

    LoaiThuCung delete(String id);
}
