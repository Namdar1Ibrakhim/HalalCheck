//package com.example.halalcheck.controller;
//
//import com.example.halalcheck.entity.Company;
//import com.example.halalcheck.entity.Product;
//import com.example.halalcheck.repository.CompanyRepository;
//import com.example.halalcheck.repository.ProductRepository;
//import com.example.halalcheck.service.ImageService;
//import com.example.halalcheck.service.StorageService;
//import com.example.halalcheck.util.MinioProperties;
//import io.minio.GetObjectArgs;
//import io.minio.MinioClient;
//import io.minio.errors.*;
//import io.swagger.v3.oas.annotations.Operation;
//import jakarta.persistence.EntityNotFoundException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//@RestController
//@RequestMapping("/images")
//@Transactional
//public class ImageController {
//
//    @Autowired
//    private StorageService service;
//
//    @PostMapping("/upload-image")
//    public ResponseEntity<?> uploadImage(@RequestParam("image")
//                                                 MultipartFile file) throws Exception {
//        String uploadImage = service.uploadImage(file);
//
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(uploadImage);
//    }
//
//    @GetMapping("/download-image/{id}")
//    public ResponseEntity<?> downloadImage(@PathVariable("id") String
//                                                   fileName) {
//        byte[] imageData = service.downloadImage(fileName);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/png"))
//                .body(imageData);
//    }
//}