package com.stc.petlove.controllers;


import com.stc.petlove.dtos.datcho.DatChoDTO;
import com.stc.petlove.entities.DatCho;
import com.stc.petlove.services.datcho.DatChoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/dat-cho")
public class DatChoController {

    private final DatChoService datChoService;

    public DatChoController(DatChoService datChoService) {
        this.datChoService = datChoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatCho> getDatCho(@PathVariable String id){
        return new ResponseEntity<>(datChoService.getDatCho(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DatCho> create(@RequestBody DatChoDTO DTO){
        return new ResponseEntity<>(datChoService.create(DTO),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DatCho> update(@PathVariable String id, @Valid @RequestBody DatChoDTO DTO){
        return new ResponseEntity<>(datChoService.update(id, DTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DatCho> delete(@PathVariable String id){
        return new ResponseEntity<>(datChoService.delete(id),HttpStatus.OK);
    }
}
