package io.pragra.learning.productmanager;

import io.pragra.learning.productmanager.Dao.ProductDao;
import io.pragra.learning.productmanager.Dao.ReviewDao;
import io.pragra.learning.productmanager.Entity.Product;
import io.pragra.learning.productmanager.Entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ProductManagerApplication {

    private ProductDao productDao;
    private ReviewDao reviewDao;


    public ProductManagerApplication(ProductDao productDao, ReviewDao reviewDao) {
        this.productDao = productDao;
        this.reviewDao = reviewDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductManagerApplication.class, args);
    }



    @Bean
    CommandLineRunner runner(ProductDao productDao){
        return args -> {
//            Product phoneEver = Product.builder().name("Iphone 16").
//    description("New fastest Iphone")
//            .cost(1500.00)
//                    .build();
//           Product product = productDao.saveProduct(phoneEver);
//
//            System.out.println("Saved Product = " + product);

            Review review = Review.builder()
                    .review("Good Phone")
                    .reviewDate(new Date()).build();

            reviewDao.addReview(1020,review);

        };
    }
}



