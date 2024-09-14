package io.pragra.learning.productmanager.Dao;
import io.pragra.learning.productmanager.Config.sqlConstant;
import io.pragra.learning.productmanager.Entity.Product;
//import io.pragra.learning.productmanager.config.SqlConstant;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

//import java.util.Random;

@Repository
public class ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product saveProduct(Product product){
    /*  String sql = "INSERT INTO PRODUCT VALUES(?, ?, ?, ?)";
        //for sequence
        Integer integer = jdbcTemplate.queryForObject("Select next value for product_id_seq", Integer.class);
        product.setId(integer);
        int update = jdbcTemplate.update(sql, product.getId(), product.getName(),product.getDescription(), product.getCost());
        return product;
        //product.setId(new Random().nextInt());*/

        Integer integer = jdbcTemplate.queryForObject(sqlConstant.GET_PRODUCT_SEQ, Integer.class);
        product.setId(integer);
        int update = jdbcTemplate.update(sqlConstant.CREATE_PRODUCT_SQL, product.getId(), product.getProductName(),product.getDescription(), product.getCost());

        return product;
    }

    public Product updateProductName(String newName, int id){
        jdbcTemplate.update(sqlConstant.UPDATE_PRODUCT_NAME_SQL, new Object[]{newName, id});
        return jdbcTemplate.queryForObject(sqlConstant.READ_PRODUCT_BY_ID_SQL, new Object[]{id}, new int[]{Types.INTEGER} ,new BeanPropertyRowMapper<>(Product.class));
    }// we can also write 4 instead of types integer because integer value is 4

public List<Product> getAllProduct(){
return jdbcTemplate.query(sqlConstant.READ_PRODUCT_SQL, new BeanPropertyRowMapper<>(Product.class));
}
}
