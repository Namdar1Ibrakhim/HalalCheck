//package com.example.halalcheck.service.impl;
//
//import com.example.halalcheck.exception.ImageUploadException;
//import com.example.halalcheck.service.ImageService;
//import com.example.halalcheck.util.MinioProperties;
//import io.minio.*;
//import io.minio.errors.*;
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//public class ImageServiceImpl implements ImageService {
//
//    private final MinioClient minioClient;
//    private final MinioProperties minioProperties;
//
//    @Override
//    @Transactional
//    public String upload(MultipartFile file) {
//        try {
//            createBucket();
//        }catch (Exception e){
//            throw  new ImageUploadException("Image upload failed: " + e.getMessage());
//        }
//        if(file.isEmpty() || file.getOriginalFilename() == null){
//            throw new ImageUploadException("Image must have name.");
//        }
//        String fileName = generateFileName(file);
//        InputStream inputStream;
//        try {
//            inputStream = file.getInputStream();
//        }catch (Exception e){
//            throw  new ImageUploadException("Image upload failed: " + e.getMessage());
//        }
//        saveImage(inputStream, fileName);
//        return fileName;
//    }
//
//    @Override
//    public InputStream get(String fileName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
//        InputStream inputStream = minioClient.getObject(
//                GetObjectArgs.builder()
//                        .bucket(minioProperties.getBucket())
//                        .object(fileName)
//                        .build()
//        );
//        return inputStream;
//
//    }
//
//
//    @SneakyThrows
//    private void createBucket() {
//        boolean found = minioClient.bucketExists(BucketExistsArgs.builder()
//                .bucket(minioProperties.getBucket())
//                .build());
//        if (!found) {
//            minioClient.makeBucket(MakeBucketArgs.builder()
//                    .bucket(minioProperties.getBucket())
//                    .build());
//        }
//    }
//
//    private String generateFileName(final MultipartFile file){
//        String extension = getExtension(file);
//        return UUID.randomUUID() + "." + extension;
//    }
//
//    private String getExtension(final MultipartFile file) {
//        return file.getOriginalFilename()
//                .substring(file.getOriginalFilename().lastIndexOf(".") + 1);
//    }
//
//    @SneakyThrows
//    private void saveImage(final InputStream inputStream,
//                           final String fileName) {
//        minioClient.putObject(PutObjectArgs.builder()
//                .stream(inputStream, inputStream.available(), -1)
//                .bucket(minioProperties.getBucket())
//                .object(fileName)
//                .build());
//    }
//
//}