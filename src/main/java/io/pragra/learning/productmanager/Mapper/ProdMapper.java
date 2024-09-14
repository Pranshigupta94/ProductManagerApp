package io.pragra.learning.productmanager.Mapper;

import io.pragra.learning.productmanager.Entity.Product;
import org.springframework.jdbc.core.RowMapper;


import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProdMapper implements RowMapper<Product> {


    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setProductName(rs.getString("NAME"));
        product.setCost(rs.getDouble("COST"));
        product.setDescription(rs.getString("DESCRIPTION"));

        return product;

    }
}
