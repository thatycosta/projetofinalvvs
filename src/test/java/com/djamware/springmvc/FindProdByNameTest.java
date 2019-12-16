package com.djamware.springmvc;

import com.djamware.springmvc.models.Product;
import org.junit.Test;
import com.djamware.springmvc.repositories.ProductRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FindProdByNameTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void findByProdNameTest(){
        Product product = new Product("iphone", "smartphone", "https://http2.mlstatic.com/iphone-11-pro-max-256gb-D_NQ_NP_927091-MLB32426469625_102019-F.jpg", 498.90);
        productRepository.save(product);

        Product found = productRepository.findByProdName(product.getProdName());

        assertThat(found.getProdName()).isEqualTo(product.getProdName());
    }

}
