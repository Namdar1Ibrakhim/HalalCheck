package com.example.halalcheck.controller;

import com.example.halalcheck.dto.response.AdditivesResponseDto;
import com.example.halalcheck.enums.Status;
import com.example.halalcheck.service.AdditivesService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/additives")
public class AdditivesController {

    private final AdditivesService additivesService;

    @Operation(summary = "Get all additives", description = "Get all additives")
    @GetMapping("/getAll")
    public ResponseEntity<List<AdditivesResponseDto>> getAll(){
        return ResponseEntity.ok(additivesService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<AdditivesResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(additivesService.getById(id));
    }

    @GetMapping("/getByStatus")
    public ResponseEntity<List<AdditivesResponseDto>> getByStatus(@RequestParam Status status){
        return ResponseEntity.ok(additivesService.getByStatus(status));
    }
    

}
