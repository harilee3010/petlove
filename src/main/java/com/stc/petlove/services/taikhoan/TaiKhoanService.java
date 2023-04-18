package com.stc.petlove.services.taikhoan;

import com.stc.petlove.dtos.taikhoan.TaiKhoanDTO;
import com.stc.petlove.entities.TaiKhoan;

public interface TaiKhoanService {
    TaiKhoan getTaiKhoan(String id);
    TaiKhoan create(TaiKhoanDTO DTO);
    TaiKhoan update(String id,TaiKhoanDTO DTO);
    TaiKhoan delete(String id);
}
