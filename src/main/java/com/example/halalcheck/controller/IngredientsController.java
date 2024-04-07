package com.example.halalcheck.controller;

import com.example.halalcheck.dto.response.ECategoryResponseDto;
import com.example.halalcheck.dto.response.IngredientsResponseDto;
import com.example.halalcheck.enums.Status;
import com.example.halalcheck.service.IngredientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ingredients")
public class IngredientsController {

    private final IngredientsService ingredientsService;

    @GetMapping("/getAll")
    public ResponseEntity<List<IngredientsResponseDto>> getAll(){
        return ResponseEntity.ok(ingredientsService.getAll());
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<IngredientsResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(ingredientsService.getById(id));
    }
    @GetMapping("/getByStatus")
    public ResponseEntity<List<IngredientsResponseDto>> getById(@RequestParam Status status){
        return ResponseEntity.ok(ingredientsService.getByStatus(status));
    }

}
