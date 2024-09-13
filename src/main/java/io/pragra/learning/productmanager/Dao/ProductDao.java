package io.pragra.learning.productmanager.Dao;
import io.pragra.learning.productmanager.Entity.Product;
//import io.pragra.learning.productmanager.config.SqlConstant;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//import java.util.Random;

@Repository
public class ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product saveProduct(Product product){
      String sql = "INSERT INTO PRODUCT VALUES(?, ?, ?, ?)";
        //for sequence
        Integer integer = jdbcTemplate.queryForObject("Select next value for product_id_seq", Integer.class);
        product.setId(integer);
        int update = jdbcTemplate.update(sql, product.getId(), product.getName(),product.getDescription(), product.getCost());
        return product;
        //product.setId(new Random().nextInt());

//        Integer integer = jdbcTemplate.queryForObject(SqlConstant.GET_PRODUCT_SEQ, Integer.class);
//        product.setId(integer);
//        int update = jdbcTemplate.update(SqlConstant.CREATE_PRODUCT_SQL, product.getId(), product.getName(),product.getDescription(), product.getCost());
//        return product;
    }

//    public Product updateProductName(String newName, int id){
//        jdbcTemplate.update(SqlConstant.UPDATE_PRODUCT_NAME_SQL, new Object[]{newName, id});
//        return jdbcTemplate.queryForObject(SqlConstant.READ_PRODUCT_BY_ID_SQL, new Object[]{id}, new int[]{1} ,Product.class);
//    }
}
