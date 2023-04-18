package com.stc.petlove.controllers;


import com.stc.petlove.dtos.loaithucung.LoaiThuCungDTO;
import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.services.loaithucung.LoaiThuCungService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api/v1/thu-cung")
public class LoaiThuCungController {

    private final LoaiThuCungService loaiThuCungService;

    public LoaiThuCungController(LoaiThuCungService loaiThuCungService) {
        this.loaiThuCungService = loaiThuCungService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoaiThuCung> getLoaiThuCung(@PathVariable String id) { return new ResponseEntity<>(loaiThuCungService.getLoaiThuCung(id),HttpStatus.OK);}

    @PostMapping
    public ResponseEntity<LoaiThuCung> create(@RequestBody LoaiThuCungDTO DTO){
        return new ResponseEntity<>(loaiThuCungService.createLoaiThuCung(DTO),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoaiThuCung> update (@PathVariable String id, @Valid @RequestBody LoaiThuCungDTO DTO){
        return new ResponseEntity<>(loaiThuCungService.updateLoaiThuCung(id,DTO),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<LoaiThuCung> delete(@PathVariable String id){
        return new ResponseEntity<>(loaiThuCungService.delete(id),HttpStatus.OK);
    }

}
