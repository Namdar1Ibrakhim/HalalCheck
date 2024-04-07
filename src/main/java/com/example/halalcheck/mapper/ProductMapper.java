package com.example.halalcheck.mapper;

import com.example.halalcheck.dto.response.ProductResponseDto;
import com.example.halalcheck.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper extends Mappable<Product, ProductResponseDto>{

//    @Mapping(target = "imageId", expression = "java(mapToImage(product))")
//    ProductResponseDto toDto(Product product);
//
//    default Long mapToImage(Product product){
//        return product.getImage().getId();
//    }

}
