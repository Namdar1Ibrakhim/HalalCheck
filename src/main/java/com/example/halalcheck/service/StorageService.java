//package com.example.halalcheck.service;
//
//import com.example.halalcheck.entity.ImageData;
//import com.example.halalcheck.entity.Product;
//import com.example.halalcheck.repository.ProductRepository;
//import com.example.halalcheck.repository.StorageRepository;
//import com.example.halalcheck.util.ImageUtils;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.awt.*;
//import java.io.IOException;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class StorageService {
//
//    private final StorageRepository repository;
//    private final ProductRepository productRepository;
//
//    public String uploadImage(MultipartFile file) throws IOException {
//        ImageData imageData = repository.save(ImageData.builder()
//                .name(file.getOriginalFilename())
//                .type(file.getContentType())
//                .imageData(ImageUtils.compressImage(file.getBytes())).build());
//        Product product = productRepository.findById((long)1).get();
//        product.setImage(imageData);
//
//        if (imageData != null) {
//            return "file uploaded successfully : " + file.getOriginalFilename();
//        }
//        return null;
//    }
//
//    public byte[] downloadImage(String fileName) {
//        Optional<ImageData> dbImageData = repository.findByName(fileName);
//        byte[]
//                images = ImageUtils.decompressImage(dbImageData.get().getImageData());
//        return images;
//    }
//}