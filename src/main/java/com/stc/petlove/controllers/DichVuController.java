package com.stc.petlove.controllers;

import com.stc.petlove.dtos.dichvu.DichVuDTO;
import com.stc.petlove.entities.DichVu;
import com.stc.petlove.services.dichvu.DichVuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/dich-vu")
public class DichVuController {
    private final DichVuService dichVuService;

    public DichVuController(DichVuService dichVuService) {
        this.dichVuService = dichVuService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DichVu> getDichVu(@PathVariable String id){
        return new ResponseEntity<>(dichVuService.getDichVu(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DichVu> create(@RequestBody DichVuDTO DTO){
        return new ResponseEntity<>(dichVuService.create(DTO),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DichVu> update(@PathVariable String id,@Valid @RequestBody DichVuDTO DTO){
        return new ResponseEntity<>(dichVuService.update(id, DTO),HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DichVu> delete(@PathVariable String id){
        return new ResponseEntity<>(dichVuService.delete(id),HttpStatus.OK);
    }
}
