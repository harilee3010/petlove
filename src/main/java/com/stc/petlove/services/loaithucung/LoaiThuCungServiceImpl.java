package com.stc.petlove.services.loaithucung;

import com.stc.petlove.dtos.loaithucung.LoaiThuCungDTO;
import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.exceptions.InvalidException;
import com.stc.petlove.exceptions.NotFoundException;
import com.stc.petlove.repositories.LoaiThuCungRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
public class LoaiThuCungServiceImpl implements LoaiThuCungService{

    public final LoaiThuCungRepository loaiThuCungRepository;

    public LoaiThuCungServiceImpl(LoaiThuCungRepository loaiThuCungRepository) {
        this.loaiThuCungRepository = loaiThuCungRepository;
    }

    @Override
    public LoaiThuCung getLoaiThuCung(String id) {
        return loaiThuCungRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Loai thú cưng có mã id là %s không tồn tại",id)));
    }

    @Override
    public LoaiThuCung createLoaiThuCung(LoaiThuCungDTO DTO) {
        if (ObjectUtils.isEmpty(DTO.getMaLoaiThuCung())){
            throw new InvalidException("Mã loại không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(DTO.getTenLoaiThuCung())){
            throw new InvalidException("Tên loại thú cưng không được bỏ trống");

        }
        if(loaiThuCungRepository.kiemtraMaLoaiThuCung(DTO.getMaLoaiThuCung().trim().toUpperCase())){
            throw new InvalidException(String.format("Đã tồn tại loại thú cưng có mã là %s",DTO.getMaLoaiThuCung()));
        }

        LoaiThuCung loaiThuCung = new LoaiThuCung();
        loaiThuCung.setMaLoaiThuCung(DTO.getMaLoaiThuCung().trim().toUpperCase());
        loaiThuCung.setTenLoaiThuCung(DTO.getTenLoaiThuCung());
        loaiThuCungRepository.save(loaiThuCung);
        return loaiThuCung;
    }

    @Override
    public LoaiThuCung updateLoaiThuCung(String id, LoaiThuCungDTO DTO) {
        LoaiThuCung loaiThuCung = getLoaiThuCung(id);
        if (ObjectUtils.isEmpty(DTO.getMaLoaiThuCung())) {
            throw new InvalidException("Mã loại thú cưng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(DTO.getTenLoaiThuCung())) {
            throw new InvalidException("Tên loại thú cưng không được bỏ trống");
        }
        if (!loaiThuCung.getMaLoaiThuCung().equalsIgnoreCase(DTO.getMaLoaiThuCung().trim()) && loaiThuCungRepository.kiemtraMaLoaiThuCung(DTO.getMaLoaiThuCung().trim().toUpperCase())) {
            throw new InvalidException(String.format("Loại thú cưng có mã %s đã tồn tại", DTO.getMaLoaiThuCung()));
        }
        loaiThuCung.setMaLoaiThuCung(DTO.getMaLoaiThuCung().trim());
        loaiThuCung.setTenLoaiThuCung(DTO.getTenLoaiThuCung());
        loaiThuCungRepository.save(loaiThuCung);
        return loaiThuCung;
    }

    @Override
    public LoaiThuCung delete(String id) {
        LoaiThuCung loaiThuCung = getLoaiThuCung(id);
        loaiThuCungRepository.delete(loaiThuCung);
        return null;
    }


}
