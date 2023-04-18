package com.stc.petlove.dtos.taikhoan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoanDTO {
    private String name;
    private String email;
    private String password;
    private String dienThoai;
    private List<String> roles = new ArrayList<>();
}
