package com.example.hello.service;

import com.example.hello.dto.ProductDto;
import com.example.hello.dto.ProductResponseDto;


// ProductDAOImpl에서 구현한 기능을 서비스 인터페이스에서 호출해 결과값을 가져오는 작업을 수행하도록 설계
public interface ProductService {
    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}