package com.stc.petlove.controllers;

import com.stc.petlove.dtos.taikhoan.TaiKhoanDTO;
import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.services.taikhoan.TaiKhoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api/v1/tai-khoan")
public class TaiKhoanController {
    private final TaiKhoanService taiKhoanService;

    public TaiKhoanController(TaiKhoanService taiKhoanService) {
        this.taiKhoanService = taiKhoanService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaiKhoan> getTaiKhoan(@PathVariable String id) {
        return new ResponseEntity<>(taiKhoanService.getTaiKhoan(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaiKhoan> create(@RequestBody TaiKhoanDTO DTO) {
        return new ResponseEntity<>(taiKhoanService.create(DTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaiKhoan> update(@PathVariable String id, @Valid @RequestBody TaiKhoanDTO DTO) {
        return new ResponseEntity<>(taiKhoanService.update(id, DTO), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaiKhoan> delete(@PathVariable String id) {
        return new ResponseEntity<>(taiKhoanService.delete(id), HttpStatus.OK);
    }
}

