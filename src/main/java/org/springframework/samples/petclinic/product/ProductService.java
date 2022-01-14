package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        List<Product> pList = productRepository.findAll();
        return pList;
    }

    public List<Product> getProductsCheaperThan(double price) {
        List<Product> res = productRepository.findByPriceLessThan(price);
        return res;
    }

    public ProductType getProductType(String typeName) {
        ProductType pt = productRepository.findProductType(typeName);
        return pt;
    }

    public Product save(Product p){
        return productRepository.save(p);
    }

    public List<ProductType> getAllProductTypes(){
        return productRepository.findAllProductTypes();
    }

    
}
